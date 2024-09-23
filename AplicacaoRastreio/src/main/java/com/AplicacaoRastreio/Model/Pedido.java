package com.AplicacaoRastreio.Model;
import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidade que modela a tabela de pedidos
 * <br>Cada pedido passa por 5 setores(ESTOQUE, CORTE, ESTAMPA, EXPEDICAO, ENTREGA), isso significa que havera 5 objetos(pedido) com o mesmo numero de pedido na tabela, mas em setores diferentes.
 * Sempre que criamos um pedido ele é criado no setor de estoque.
 */
@Entity
@Table(name = "tabela_Pedidos")
public class Pedido implements Comparable<Pedido> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String numeroPedido;
    @Column(length = 5000)
    private String informacoesDoPedido;
    @Column
    private String status;
    @Column
    private String nomeSetor;
    @Column
    private LocalDate dataEntrada;
    @Column
    private LocalDate dataSaida;
    /** Metodo get
     * @return Permite obter o id pedido
     */
    public String getId() {
        return id;
    }
    /**Metodo get
     * @return Permite obter o numero de pedido
     */
    public String getNumeroPedido() {
        return numeroPedido;
    }
    /** Metodo set
     * Permite alterar o numero de pedido
     * @param numeroPedido utilizado para modificar
     */
    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    /**Metodo get
     * @return Permite obter as informações do pedido
     */
    public String getInformacoesDoPedido() {
        return informacoesDoPedido;
    }
    /**Metodo set
     * @param informacoesDoPedido  Permite alterar as informações do pedido
     */
    public void setInformacoesDoPedido(String informacoesDoPedido) {
        this.informacoesDoPedido = informacoesDoPedido;
    }
    /**Metodo get
     * @return Permite obter o status do pedido
     */
    public String getStatus() {
        return status;
    }
    /**Metodo set
     * @param status Permite alterar o status do pedido
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**Metodo get
     * @return Permite obter o nome do setor do pedido
     */
    public String getNomeSetor() {
        return nomeSetor;
    }
    /**Metodo set
     * @param nomeSetor Permite alterar o nome do setor do pedido
     */
    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
    /**Metodo get
     *@return  Permite obter a data de entrada do pedido
     */
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    /**Metodo set
     * @param dataEntrada Permite alterar a data de entrada do pedido
     */
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    /**Metodo get
     * @return Permite obter a data de saida do pedido
     */
    public LocalDate getDataSaida() {
        return dataSaida;
    }
    /**Metodo set
     *@param dataSaida  Permite alterar a data de saida do pedido
     */
    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * Responsável por ordenar uma lista de pedidos através do atributo numeroPedido
     * @return retorna os pedidos ordenados
     */
    @Override
    public int compareTo(Pedido outroPedido) {
        return this.getNumeroPedido().compareTo(outroPedido.getNumeroPedido());
    }

    @Override
    public String toString() {
        return  "Pedido:" + "\n" +
                "Numero do pedido: " + numeroPedido + "\n" +
                "Data de entrada: " + dataEntrada + "\n" +
                "Data de Saída: "+ dataSaida + "\n" +
                "Setor: " + nomeSetor +"\n" +
                "Informações do pedido: " + informacoesDoPedido + "\n" + "\n";
    }
}
