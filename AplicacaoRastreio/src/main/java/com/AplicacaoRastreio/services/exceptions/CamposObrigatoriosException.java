package com.AplicacaoRastreio.services.exceptions;

/** EXCEPTION PERSONALIZADA
 * */
public class CamposObrigatoriosException extends BusinessException {

    /**
     *Usada para ser declarada quando tiver campos vazios
     */
    public CamposObrigatoriosException() {
        super("Um ou mais campos obrigatórios estão vazios(empty) ou em branco(blank).");
    }
}
