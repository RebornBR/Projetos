package com.mat.arquimedes.model;

import com.mat.arquimedes.services.exceptions.BusinessException;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class OperacoesBasicas {
    String operacao; double num1; double num2; double resultado;

    public OperacoesBasicas() {
    }

    public OperacoesBasicas(String operacao, double num1, double num2, double resultado) {
        this.operacao = operacao;
        this.num1 = num1;
        this.num2 = num2;
        this.resultado = resultado;
    }

    public OperacoesBasicas calcularOperacoesBasicas(String operacao, double num1, double num2){
        double resultadoOperacoesBasicas;
        operacao = operacao.toLowerCase();
        switch (operacao){
            case "som", "somar", "soma", "plus":{
                resultadoOperacoesBasicas = num1 + num2;
                break;
            }
            case "sub", "subtracao", "subtrair", "menos":{
                resultadoOperacoesBasicas = num1 - num2;
                break;
            }
            case "mul", "multiplicar", "multiplicacao", "vezes":{
                resultadoOperacoesBasicas = num1 * num2;
                break;
            }
            case "div", "divisao", "dividir", "divisoes":{
                if(num2 == 0){
                    throw new BusinessException("Dividir por 0 -> Operação inexistente");
                }
                resultadoOperacoesBasicas = num1 / num2;
                break;
            }
            default:
                throw new BusinessException("Nenhuma operação com o nome '" +operacao+ "' foi encontrada. {operacao} deve ser substituído por soma, subtracao, divisao, multiplicacao ou alguma das outras opções informadas no readme da API");
        }
        OperacoesBasicas operacoesBasicas = new  OperacoesBasicas(operacao, num1, num2, resultadoOperacoesBasicas);
        return operacoesBasicas;
    }

    @Override
    public String toString() {
        return "OperacoesBasicas{" +
                "operacao='" + getOperacao() + '\'' +
                ", num1=" + getNum1() +
                ", num2=" + getNum2() +
                ", resultado=" + getResultado() +
                '}';
    }
}
