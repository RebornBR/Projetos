package com.AplicacaoRastreio.services.exceptions;

/**
 *Classe de exceção de negocios que extend RunTimeException
 */
public class BusinessException extends  RuntimeException{

    /**
     * Constroi e dispara uma exception
     * @param mensagem mensagem que você deseja exibir quando essa exceção for disparada
     */
    public BusinessException(String mensagem) { // retorna uma mensagem simples
        super(mensagem);
    }
    /**
     * Constroi e dispara uma exception
     * @param mensagem mensagem que você deseja exibir quando essa exceção for disparada
     * @param params parametros que causaram ou podem causar a exception(serão exibidos juntamente com a mensagem
     */
    public BusinessException(String mensagem, Object ... params) { // retorna uma mensagem customizada atraves do varargs
        super(String.format(mensagem, params));
    }
}

