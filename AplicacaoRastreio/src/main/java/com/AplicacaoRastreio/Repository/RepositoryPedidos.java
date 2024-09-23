package com.AplicacaoRastreio.Repository;

import com.AplicacaoRastreio.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interface repositorio de Pedido que extende JpaRepository
 * */
@Repository
public interface RepositoryPedidos extends JpaRepository<Pedido, Long> {

    /**
     * Função que retorna os Pedidos de mesmo numero de pedido;
     * @param numeroPedido utilizado na pesquisa
     * @return retorna uma List de {@link Pedido}
     * */
    List<Pedido> findByNumeroPedido(String numeroPedido);

    /**
     * Função que retorna os Pedidos que contiverem o valor passado pela variavel numeroPedido;
     * @param numeroPedido utilizado na pesquisa
     * @return retorna uma List de {@link Pedido}
     * */
    List<Pedido> findByNumeroPedidoContaining(String numeroPedido);

    /**
     * Função que retorna os Pedidos que estiverem no setor passado pela variavel nomeSetor;
     * @param nomeSetor utilizado na pesquisa
     * @return retorna uma List de {@link Pedido}
     * */
    List<Pedido> findByNomeSetor(String nomeSetor);
    /**
     * Função que retorna um {@link Pedido} que tenha o numero de pedido e nome do setor iguais aos passados pelas variaveis
     * @param numeroPedido utilizado na pesquisa
     * @param nomeSetor utilizado na pesquisa
     * @return retorna um {@link Pedido}
     * */
    Pedido findByNumeroPedidoAndNomeSetor(String numeroPedido, String nomeSetor);
}
