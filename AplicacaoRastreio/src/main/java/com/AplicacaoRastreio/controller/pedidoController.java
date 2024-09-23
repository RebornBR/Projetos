package com.AplicacaoRastreio.controller;
import com.AplicacaoRastreio.Model.Pedido;
import com.AplicacaoRastreio.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *Classe RestController, aqui fica toda as URL de requisição para acesso as funções do sistema .
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/pedido")
public class pedidoController {
    @Autowired
    PedidoService pedidoService;
    /**
     *URL post para criação da chave de acesso através de {@link PedidoService#criarChaveAcesso(String)}
     * @param senhaChaveAcesso String
     * @return {@link PedidoService#criarChaveAcesso(String)}
     */
    @PostMapping("/chaveDeAcesso/criarChave")
    public String criarChave(@RequestParam String senhaChaveAcesso){
        return pedidoService.criarChaveAcesso(senhaChaveAcesso);
    }
    /**
     *URL put para modificação da chave de acesso através de {@link PedidoService#modificarChaveAcesso(String, String)}
     *  @param antigaChaveAcesso String
     *  @param novaChaveAcesso String
     *  @return {@link PedidoService#modificarChaveAcesso(String, String)}
     */
    @PutMapping("/chaveDeAcesso/modificarChave")
    public String modificarChave(@RequestParam String antigaChaveAcesso, String novaChaveAcesso){
        return pedidoService.modificarChaveAcesso(antigaChaveAcesso, novaChaveAcesso);
    }
    /**
     *URL post para criação de pedido atraves de {@link PedidoService#criarPedido(String, String)}
     * @param informacoesPedido String
     * @param senhaDeAcesso String
     * @return {@link PedidoService#criarPedido(String, String)}
     */
    @PostMapping("/fazerPedido")
    public Pedido CriarPedido(@RequestParam String informacoesPedido, @RequestParam String senhaDeAcesso){
        return pedidoService.criarPedido(informacoesPedido, senhaDeAcesso);
    }
    /**
     *URL get para obtenção de uma list de pedidos atraves de {@link PedidoService#buscarPorNumeroPedido(String, String)}
     * @param numeroPedido  String
     * @param senhaDeAcesso String
     * @return {@link PedidoService#buscarPorNumeroPedido(String, String)}
     */
    @GetMapping("/buscarPorNumeroPedido")
    public List<Pedido> buscarPorNumeroPedido(@RequestParam String numeroPedido, @RequestParam String senhaDeAcesso){
        return pedidoService.buscarPorNumeroPedido(numeroPedido, senhaDeAcesso);
    }
    /**
     *URL get para obtenção de uma list de pedidos atraves de {@link PedidoService#buscarPorContainNumeroPedido(String, String)}
     * @param numeroPedido  String
     * @param senhaDeAcesso String
     * @return {@link PedidoService#buscarPorContainNumeroPedido(String, String)}
     */
    @GetMapping("/buscarContainNumeroPedido")
    public List<Pedido> buscarContain(@RequestParam String numeroPedido, @RequestParam String senhaDeAcesso){
        return pedidoService.buscarPorContainNumeroPedido(numeroPedido, senhaDeAcesso);
    }
    /**
     *URL get para obtenção de uma list de pedidos atraves de {@link PedidoService#buscarPorNomeSetor(String, String)}
     * @param nomeSetor  String
     * @param senhaDeAcesso String
     * @return {@link PedidoService#buscarPorNomeSetor(String, String)}
     */
    @GetMapping("/buscarPorNomeSetor")
    public List<Pedido> buscarPorSetor(@RequestParam String nomeSetor, @RequestParam String senhaDeAcesso){
        return pedidoService.buscarPorNomeSetor(nomeSetor, senhaDeAcesso);
    }
    /**
     *URL get para download de um pdf atraves de {@link PedidoService#baixarArquivo(String, String)} utilizado para baixar o pdf 
     * de criação de um pedido. PDF gerado no metodo {@link PedidoService#criarPedido(String, String)}
     * @param senhaDeAcesso String
     * @throws FileNotFoundException Quando não encontrar o arquivo passado na variavel "nomeArquivo" do metodo {@link PedidoService#baixarArquivo(String, String)}
     * @return {@link PedidoService#baixarArquivo(String, String)}
     */
    @GetMapping("/download/criacaoPedido")
    public ResponseEntity<InputStreamResource> downloadCriacaoPedido(@RequestParam String senhaDeAcesso) throws FileNotFoundException {
       return pedidoService.baixarArquivo("relatorioCriacaoPedido", senhaDeAcesso);
    }
    /**
     *URL get para download de um pdf atraves de {@link PedidoService#baixarArquivo(String, String)} utilizado para baixar o pdf de pedidos gerados
     * atraves do metodo {@link PedidoService#buscarPorNumeroPedido(String, String)}
     * @param senhaDeAcesso String
     * @throws FileNotFoundException Quando não encontrar o arquivo passado na variavel "nomeArquivo" do metodo {@link PedidoService#baixarArquivo(String, String)}
     * @return {@link PedidoService#baixarArquivo(String, String)}
     */
    @GetMapping("/download/relatorioPedido")
    public ResponseEntity<InputStreamResource> downloadRelatorioPedido(@RequestParam String senhaDeAcesso) throws FileNotFoundException {
        return pedidoService.baixarArquivo("relatorioPedido", senhaDeAcesso);
    }
    /**
     *URL get para download de um pdf atraves de {@link PedidoService#baixarArquivo(String, String)} utilizado para baixar o pdf de pedidos gerados
     * pelo metodo {@link PedidoService#buscarPorContainNumeroPedido(String, String)}
     * @param senhaDeAcesso String
     * @throws FileNotFoundException Quando não encontrar o arquivo passado na variavel "nomeArquivo" do metodo {@link PedidoService#baixarArquivo(String, String)}
     * @return {@link PedidoService#baixarArquivo(String, String)}
     */
    @GetMapping("/download/relatorioPedidos")
    public ResponseEntity<InputStreamResource> downloadRelatorioPedidos(@RequestParam String senhaDeAcesso) throws FileNotFoundException {
        return pedidoService.baixarArquivo("relatorioPedidos", senhaDeAcesso);
    }
    /**
     *URL get para download de um pdf atraves de {@link PedidoService#baixarArquivo(String, String)} utilizado para baixar o pdf de pedidos gerados
     * pelo metodo {@link PedidoService#buscarPorNomeSetor(String, String)}
     * @param senhaDeAcesso String
     * @throws FileNotFoundException Quando não encontrar o arquivo passado na variavel "nomeArquivo" do metodo {@link PedidoService#baixarArquivo(String, String)}
     * @return {@link PedidoService#baixarArquivo(String, String)}
     */
    @GetMapping("/download/relatorioPedidosNoSetor")
    public ResponseEntity<InputStreamResource> downloadRelatorioPedidosSetor(@RequestParam String senhaDeAcesso) throws FileNotFoundException {
        return pedidoService.baixarArquivo("relatorioPedidosNoSetor", senhaDeAcesso);
    }
    /**
     *URL put para atualização da saida de um pedido do setor atraves do metodo {@link PedidoService#pedidoSaidaDoSetor(String, String, String)}
     * @param numeroPedido String
     * @param nomeSetor  String
     * @param senhaDeAcesso String
     */
    @PutMapping("/atualizarSaidaPedidoDoSetor")
    public void saidaSetor(@RequestParam String numeroPedido, String nomeSetor, @RequestParam String senhaDeAcesso){
        pedidoService.pedidoSaidaDoSetor(numeroPedido, nomeSetor, senhaDeAcesso);
    }
    /**
     *URL put para atualização da entrada de um pedido no setor atraves do metodo {@link PedidoService#pedidoEntradaNoSetor(String, String, String)}
     * @param numeroPedido String
     * @param nomeSetorQueDeuEntrada  String
     * @param senhaDeAcesso String
     */
    @PutMapping("/atualizarEntradaPedidoNoSetor")
    public void entradaSetor(@RequestParam String numeroPedido, String nomeSetorQueDeuEntrada, @RequestParam String senhaDeAcesso){
        pedidoService.pedidoEntradaNoSetor(numeroPedido, nomeSetorQueDeuEntrada, senhaDeAcesso);
    }
    /**
     *URL put para atualização do status de um pedido do setor atraves do metodo {@link PedidoService#atualizarStatus(String, String, String)}
     * @param numeroPedido String
     * @param status String
     * @param senhaDeAcesso String
     */
    @PutMapping("/atualizarStatus")
    public void atualizarStatus(@RequestParam String numeroPedido, String status, @RequestParam String senhaDeAcesso){
        pedidoService.atualizarStatus(numeroPedido, status, senhaDeAcesso);
    }
}
