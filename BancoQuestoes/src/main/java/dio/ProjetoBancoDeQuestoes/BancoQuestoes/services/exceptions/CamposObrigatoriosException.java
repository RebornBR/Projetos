package dio.ProjetoBancoDeQuestoes.BancoQuestoes.services.exceptions;

import dio.ProjetoBancoDeQuestoes.BancoQuestoes.model.Questao;
import dio.ProjetoBancoDeQuestoes.BancoQuestoes.services.exceptions.BusinessException;

public class CamposObrigatoriosException extends BusinessException {
    public CamposObrigatoriosException(String campo) { // recebemos um parametro campo
        super("O seguinte campo: %s. É obrigatório", campo);
    }
}
