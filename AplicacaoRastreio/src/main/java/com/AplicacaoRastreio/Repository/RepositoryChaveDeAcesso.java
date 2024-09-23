package com.AplicacaoRastreio.Repository;

import com.AplicacaoRastreio.Model.ChaveDeAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface repositorio de ChaveDeAcesso que extende JpaRepository
 * */
@Repository
public interface RepositoryChaveDeAcesso extends JpaRepository<ChaveDeAcesso, String> {
    /**
     * Função que buscr por um chave de acesso que tenha a senha passada atraves da variavel
     * @param senhaChaveAcesso será utilizado na busca por um senha no banco de dados
     * @return retorna um objeto ChaveDeAcesso
     * */
    ChaveDeAcesso findBySenha(String senhaChaveAcesso);
}
