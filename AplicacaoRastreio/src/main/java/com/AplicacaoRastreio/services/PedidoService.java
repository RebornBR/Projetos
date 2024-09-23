package com.AplicacaoRastreio.services;

import com.AplicacaoRastreio.Model.ChaveDeAcesso;
import com.AplicacaoRastreio.Model.Pedido;
import com.AplicacaoRastreio.Repository.RepositoryChaveDeAcesso;
import com.AplicacaoRastreio.Repository.RepositoryPedidos;
import com.AplicacaoRastreio.services.exceptions.BusinessException;
import com.AplicacaoRastreio.services.exceptions.CamposObrigatoriosException;
import com.AplicacaoRastreio.services.relatorioService.Relatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsável por todos os métodos que iremos usar no nosso sistema de pedidos.
 */
@Service
public class PedidoService {

    @Autowired
    RepositoryPedidos repositoryPedidos;
    @Autowired
    Relatorio relatorio;
    @Autowired
    RepositoryChaveDeAcesso repositoryChaveDeAcesso;

    /**
     * Função que retorna uma exception personalizada que indica que existem campos(parametros) que estão vazios ou brancos
     * @see CamposObrigatoriosException
     * @param valorParaVerificar variavel que recebe o valor que será verificado
     * @throws CamposObrigatoriosException retorna se o valor verificado for nulo
    */
    private void verificarCampo(String valorParaVerificar ){
        if(valorParaVerificar.isBlank() || valorParaVerificar.isEmpty()){
            throw new CamposObrigatoriosException();
        }
    }

    /**
     * Função que verifica a senha de acesso para utilização de todas as outras funções
     * @param senhaParaAcesso variavel recebe a senha de acesso que será vefificada
     * @throws BusinessException retorna se não existir a senha no banco de dados
     */
    private void validarAcesso(String senhaParaAcesso){
        ChaveDeAcesso chaveDeAcesso = repositoryChaveDeAcesso.findBySenha(senhaParaAcesso);
        if(chaveDeAcesso == null){
            throw new BusinessException("Senha incorreta, você não tem permissão para acessar essa funcionalidade!");
        }
    }

    /**
     * Função que cria uma senha para acesso
     * @param senhaChaveAcesso variavel que recebe a senha que será criada e armazenada no banco de dados
     * @return String informando que a senha foi criada com sucesso
     * */
    public String criarChaveAcesso(String senhaChaveAcesso){
        verificarCampo(senhaChaveAcesso);
        ChaveDeAcesso chaveDeAcesso = new ChaveDeAcesso();
        chaveDeAcesso.setSenha(senhaChaveAcesso);
        repositoryChaveDeAcesso.save(chaveDeAcesso);
        return "Senha criada com sucesso";
    }

    /**
     * Função que altera a senha de uma chave de acesso anteriormente criada
     * @param antigaChaveAcesso variavel utilizada para buscar a senha no banco de dados
     * @param novaChaveAcesso variavel utilizada para atualizar a senha da chave de acesso antiga
     * @exception BusinessException é retornada caso não exista a senha passada pela variável antigaChaveAcesso
     * @return String informando que a senha foi atualizada com sucesso
    * */
    public String modificarChaveAcesso(String antigaChaveAcesso, String novaChaveAcesso){
        verificarCampo(antigaChaveAcesso);
        verificarCampo(novaChaveAcesso);
        ChaveDeAcesso chaveDeAcesso;
        chaveDeAcesso = repositoryChaveDeAcesso.findBySenha(antigaChaveAcesso);
        if(chaveDeAcesso != null) {
            chaveDeAcesso.setSenha(novaChaveAcesso);
            repositoryChaveDeAcesso.save(chaveDeAcesso);
            return "Senha atualizada com sucesso";
        }else {
            throw new BusinessException("SENHA NÃO EXISTE");
        }
    }

    /**
     * Função responsável pela criação de um pedido no banco de dados e criação de um pdf com as informações do pedido gerado, PDF com o seguinte nome "relatorioCriacaoPedido.pdf"
     * @param informacoesPedido variavel que recebe as informações do pedido
     * @param senhaDeAcesso variavel que será utilizada na função {@link PedidoService#validarAcesso(String)}
     * @see Relatorio#gerarPdfDeCriacaoDePedido(Pedido, String, String)
     * @exception CamposObrigatoriosException retornado através do metodo {@link PedidoService#verificarCampo(String)} caso alguma variável seja vazia ou branca.
     * @exception BusinessException retornado através do metodo {@link PedidoService#validarAcesso(String)} caso a senha de acesso seja incorreta
     * @return é retornado o {@link Pedido} que foi gerado
     * */
    public Pedido criarPedido(String informacoesPedido, String senhaDeAcesso){
        verificarCampo(senhaDeAcesso);
        validarAcesso(senhaDeAcesso);
        verificarCampo(informacoesPedido);
        Pedido pedido = new Pedido();
        pedido.setInformacoesDoPedido(informacoesPedido);
        pedido.setNumeroPedido(String.valueOf(LocalDateTime.now()));
        pedido.setStatus("EM PRODUÇÃO");
        pedido.setNomeSetor("ESTOQUE");
        pedido.setDataEntrada(LocalDate.now());
        pedido.setDataSaida(null);
        relatorio.gerarPdfDeCriacaoDePedido(pedido,"DE CRIAÇÃO DE PEDIDO", "relatorioCriacaoPedido");
        repositoryPedidos.save(pedido);
        return pedido;
    }
    /**
     * Função responsável por atualizar a data de saida do pedido de um setor
     * @param numeroPedido numero do pedido ao qual vai atualizar a saída do setor
     * @param nomeSetor nome do setor que o pedido dará saída
     * <br><br/> Ambos parametros serão utilizados no método {@link RepositoryPedidos#findByNumeroPedidoAndNomeSetor(String, String)}
     * <br/>
     * @param senhaDeAcesso variavel que será utilizada na função {@link PedidoService#validarAcesso(String)}
     * @exception CamposObrigatoriosException retornado através do metodo {@link PedidoService#verificarCampo(String)} caso alguma variável seja vazia ou branca.
     * @exception BusinessException é retornado caso não exista um pedido com o numero e o nome do setor passados na função - também é retornado atraves da função {@link PedidoService#validarAcesso(String)} caso
     a senha de acesso seja incorreta.
     * */
    public void pedidoSaidaDoSetor(String numeroPedido, String nomeSetor, String senhaDeAcesso){
        verificarCampo(senhaDeAcesso);
        validarAcesso(senhaDeAcesso);
        verificarCampo(numeroPedido);
        verificarCampo(nomeSetor);
        Pedido pedido;
        nomeSetor = nomeSetor.toUpperCase();
        pedido = repositoryPedidos.findByNumeroPedidoAndNomeSetor(numeroPedido, nomeSetor);
        if (pedido!=null){
            pedido.setDataSaida(LocalDate.now());
            repositoryPedidos.save(pedido);
        }else {
            throw new BusinessException("Número de pedido: '" + numeroPedido + "', não foi encontrado no setor: " + nomeSetor );}
    }

    /**
     * Função responsável por criar a entrada de um pedido em um novo setor.
     * <br/>É primeiro verificado se o setor ao qual o pedido deve dá entrada é válido e se o mesmo já deu entrada no setor.<br/> Após isso
     * é verificado se o pedido existe, isto é, se existe o mesmo número de pedido presente no setor de estoque, caso exista, a entrada do pedido em um novo setor será gerada
     * @param numeroPedido numero do pedido ao qual deseja realizar a entrada em um novo setor
     * @param nomeSetorQueDeuEntrada nome do setor que o pedido dará entrada
     * <br/> Ambos parametros serão utilizados no método {@link RepositoryPedidos#findByNumeroPedidoAndNomeSetor(String, String)}
     * @param senhaDeAcesso variavel que será utilizada na função {@link PedidoService#validarAcesso(String)}
     * @exception CamposObrigatoriosException retornado através do metodo {@link PedidoService#verificarCampo(String)} caso alguma variável seja vazia ou branca.
     * @exception BusinessException é retornado caso já exista um pedido que deu entrada no setor passado atraves da variavel 'nomeSetorQueDeuEntrada' <br>-também é retornado caso não seja achado um pedido com o numero passado atraves da variavel 'numeroPedido' <br>- também é retornado atraves da função {@link PedidoService#validarAcesso(String)} caso
     a senha de acesso seja incorreta.
     * */
    public void pedidoEntradaNoSetor(String numeroPedido, String nomeSetorQueDeuEntrada, String senhaDeAcesso){
        verificarCampo(senhaDeAcesso);
        validarAcesso(senhaDeAcesso);
        verificarCampo(numeroPedido);
        verificarCampo(nomeSetorQueDeuEntrada);
        Pedido pedido;
        nomeSetorQueDeuEntrada = nomeSetorQueDeuEntrada.toUpperCase();
        switch (nomeSetorQueDeuEntrada){
            case "CORTE", "ESTAMPA" ,"EXPEDICAO", "EXPEDIÇÃO", "ENTREGA":{
                break;
            }
            case "SILLIK":{
                nomeSetorQueDeuEntrada = "ESTAMPA";
                break;
            }
            default:{throw new BusinessException("Setores disponíveis: CORTE, SILLIK(ESTAMPA), EXPEDIÇÃO, ENTREGA");}
        }
        pedido = repositoryPedidos.findByNumeroPedidoAndNomeSetor(numeroPedido, nomeSetorQueDeuEntrada);
        if(pedido!=null){
            throw new BusinessException("Pedido: '" + numeroPedido + "', já deu entrada no setor de: "+nomeSetorQueDeuEntrada);
        }
        pedido = repositoryPedidos.findByNumeroPedidoAndNomeSetor(numeroPedido,"ESTOQUE");
        if (pedido!=null){
            Pedido pedidoOutroSetor = new Pedido();
            pedidoOutroSetor.setNumeroPedido(pedido.getNumeroPedido());
            pedidoOutroSetor.setInformacoesDoPedido(pedido.getInformacoesDoPedido());
            pedidoOutroSetor.setStatus(pedido.getStatus());
            pedidoOutroSetor.setNomeSetor(nomeSetorQueDeuEntrada.toUpperCase());
            pedidoOutroSetor.setDataEntrada(LocalDate.now());
            repositoryPedidos.save(pedidoOutroSetor);
        }else {
            throw new BusinessException("Pedido: '" + numeroPedido + "', não foi encontrado" );}
    }

    /**
     * Função que atualiza o status de um pedido
     * <br><br/>
     * OBSERVAÇÃO: SÓ É POSSIVEL ATUALIZAR O STATUS DE UM PEDIDO QUE ESTÁ NO SETOR DE ENTREGA;
     * <br><br/>
     * @param numeroPedido numero do pedido ao qual deseja realizar a atualização de status
     * @param status deve ser passado o status atual do pedido
     * @param senhaDeAcesso variavel que será utilizada na função {@link PedidoService#validarAcesso(String)}
     * @exception CamposObrigatoriosException retornado através do metodo {@link PedidoService#verificarCampo(String)} caso alguma variável seja vazia ou branca.
     * @exception BusinessException retornado quando for solicitado a atualização de status de um pedido(numeroPedido) que não está no setor de entrega <br>- também é retornado atraves da função {@link PedidoService#validarAcesso(String)} casoa senha de acesso seja incorreta.
     * */
    public void atualizarStatus(String numeroPedido, String status, String senhaDeAcesso){
        verificarCampo(senhaDeAcesso);
        validarAcesso(senhaDeAcesso);
        verificarCampo(numeroPedido);
        verificarCampo(status);
        Pedido pedido;
        pedido = repositoryPedidos.findByNumeroPedidoAndNomeSetor(numeroPedido, "ENTREGA");
        if(pedido==null){
            throw new BusinessException("Pedido: '" + numeroPedido + "', não existe ou ainda não passou pelo setor de entrega");
        }else {
            pedido.setStatus(status.toUpperCase());
            pedido.setDataSaida(LocalDate.now());
            repositoryPedidos.save(pedido);
        }
    }

    /**
     * Função que busca e retorna os Pedidos de mesmo numero de pedido atraves do metodo {@link RepositoryPedidos#findByNumeroPedido(String)} e gera um pdf dessa lista atraves do metodo {@link Relatorio#gerarPdfRelatorio(List, String, String)}
     * pdf gerado com o seguinte nome "relatorioPedido.pdf"
     * @param numeroPedido recebe o numero do pedido a ser pesquisado
     * @param senhaDeAcesso variavel que será utilizada na função {@link PedidoService#validarAcesso(String)}
     *  @exception CamposObrigatoriosException retornado através do metodo {@link PedidoService#verificarCampo(String)} caso alguma variável seja vazia ou branca.
     * @exception BusinessException retornado atraves da função {@link PedidoService#validarAcesso(String)} caso a senha de acesso seja incorreta.
     * @return List de {@link Pedido}
     * */
    public List<Pedido> buscarPorNumeroPedido(String numeroPedido, String senhaDeAcesso){
        verificarCampo(senhaDeAcesso);
        validarAcesso(senhaDeAcesso);
        verificarCampo(numeroPedido);
        List<Pedido> pedidoList = repositoryPedidos.findByNumeroPedido(numeroPedido);
        relatorio.gerarPdfRelatorio(pedidoList,"DO PEDIDO", "relatorioPedido" );
        return pedidoList;
    }

    /**
     * Função que busca e retorna os Pedidos cujo numero de pedido contiver o valor passado atraves da variavel numeroPedido atraves do metodo {@link RepositoryPedidos#findByNumeroPedido(String)} e gera um pdf dessa lista atraves do metodo {@link Relatorio#gerarPdfRelatorio(List, String, String)}
     * pdf gerado com o seguinte nome "relatorioPedidos.pdf"
     * @param numeroPedido recebe o numero de pedido a ser pesquisado
     * @param senhaDeAcesso variavel que será utilizada na função {@link PedidoService#validarAcesso(String)}
     * @exception CamposObrigatoriosException retornado através do metodo {@link PedidoService#verificarCampo(String)} caso alguma variável seja vazia ou branca.
     * @exception BusinessException retornado atraves da função {@link PedidoService#validarAcesso(String)} caso a senha de acesso seja incorreta.
     * @return List de {@link Pedido}
     * */
    public List<Pedido> buscarPorContainNumeroPedido(String numeroPedido, String senhaDeAcesso){
        verificarCampo(senhaDeAcesso);
        validarAcesso(senhaDeAcesso);
        verificarCampo(numeroPedido);
        List<Pedido> pedidoList;
        pedidoList=repositoryPedidos.findByNumeroPedidoContaining(numeroPedido);
        relatorio.gerarPdfRelatorio(pedidoList,"DOS PEDIDOS", "relatorioPedidos" );
        Collections.sort(pedidoList);
        return pedidoList;
    }

    /**
     * Função que busca e retorna os Pedidos que estão no setor passado atraves da variavel nomeSetor atraves do metodo {@link RepositoryPedidos#findByNumeroPedido(String)} e gera um pdf dessa lista atraves do metodo {@link Relatorio#gerarPdfRelatorio(List, String, String)}
     * pdf gerado com o seguinte nome "relatorioPedidosNoSetor.pdf"
     * @param nomeSetor recebe o nome do setor a ser pesquisado
     * @param senhaDeAcesso variavel que será utilizada na função {@link PedidoService#validarAcesso(String)}
     * @exception CamposObrigatoriosException retornado através do metodo {@link PedidoService#verificarCampo(String)} caso alguma variável seja vazia ou branca.
     * @exception BusinessException retornado atraves da função {@link PedidoService#validarAcesso(String)} caso a senha de acesso seja incorreta.
     * @return List de {@link Pedido}
     * */
    public List<Pedido> buscarPorNomeSetor(String nomeSetor, String senhaDeAcesso){
        verificarCampo(senhaDeAcesso);
        validarAcesso(senhaDeAcesso);
        nomeSetor = nomeSetor.toUpperCase();
        verificarCampo(nomeSetor);
        List<Pedido> pedidoList =  repositoryPedidos.findByNomeSetor(nomeSetor);
        relatorio.gerarPdfRelatorio(pedidoList,"DE PEDIDOS NO SETOR "+nomeSetor, "relatorioPedidosNoSetor" );
        return pedidoList;
    }

    /**
     * Função que permite o download dos pdf gerados através dos metodos {@link Relatorio#gerarPdfDeCriacaoDePedido(Pedido, String, String)} e {@link Relatorio#gerarPdfRelatorio(List, String, String)}
     * @param nomeArquivo nome do arquivo que será baixado
     * @param senhaDeAcesso variavel que será utilizada na função {@link PedidoService#validarAcesso(String)}
     * @exception CamposObrigatoriosException retornado através do metodo {@link PedidoService#verificarCampo(String)} caso alguma variável seja vazia ou branca.
     * @exception BusinessException retornado atraves da função {@link PedidoService#validarAcesso(String)} caso a senha de acesso seja incorreta.
     * @throws FileNotFoundException -
     * @return ResponseEntity.ok
    */
    public ResponseEntity<InputStreamResource> baixarArquivo(String nomeArquivo, String senhaDeAcesso) throws FileNotFoundException {
        verificarCampo(senhaDeAcesso);
        validarAcesso(senhaDeAcesso);
        String filePath = "AplicacaoRastreio\\src\\main\\resources\\relatorios\\"+nomeArquivo+".pdf";
        File file = new File(filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length())
                .body(resource);
    }

}
