package com.AplicacaoRastreio.Model;

import jakarta.persistence.*;

/**
 * Entidade que modela a tabela de chave de acesso
 * */
@Entity
@Table(name = "chave_acesso")
public class ChaveDeAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String senha;

    /**
     * Permite obter o id de um objeto ChaveDeAcesso
     * @return id
      */
    public String getId() {
        return id;
    }

    /**
     * Permite alterar o id de um objeto ChaveDeAcesso
     * @param idNovo utilizado para alterar o id
     */
    public void setId(String idNovo) {
        this.id = idNovo;
    }

    /***
     *  Permite obter a senha de um objeto ChaveDeAcesso
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /***
     * Permite alterar a senha de um objeto ChaveDeAcesso
     * @param senhaNova utilizado para alterar a senha
     */
    public void setSenha(String senhaNova) {
        this.senha = senhaNova;
    }
}
