package com.mat.arquimedes.model;

import com.mat.arquimedes.services.exceptions.BusinessException;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TeoremaDePitagoras {
    private String valorDescobrir;
    private double catetoOuHipotenusa;
    private double catetoC;
    private double resultado;

    public TeoremaDePitagoras() {
    }

    public TeoremaDePitagoras(String valorDescobrir, double catetoOuHipotenusa, double catetoC, double resultado) {
        this.valorDescobrir = valorDescobrir;
        this.catetoOuHipotenusa = catetoOuHipotenusa;
        this.catetoC = catetoC;
        this.resultado = resultado;
    }

    public TeoremaDePitagoras calcularTeoremaPitagoras(String valorDescobrir, double catetoOuHipotenusa, double catetoC){
        valorDescobrir = valorDescobrir.toLowerCase();
        double resultado;
        switch (valorDescobrir){
            case "hipotenusa":{
                double somaCatetos = Math.pow(catetoOuHipotenusa, 2) + Math.pow(catetoC, 2);
                resultado = Math.sqrt(somaCatetos);
                break;
            }
            case "cateto":{
                double somaHipotenusaCateto = Math.pow(catetoOuHipotenusa, 2) - Math.pow(catetoC, 2);
                resultado = Math.sqrt(somaHipotenusaCateto); //SQRT = RAIZ QUADRADA
                break;
            }
            default:
                throw new BusinessException("{valorDescobrir} deve ser Substituído por hipotenusa ou cateto. Se houver dúvidas, por favor, confira o readme da API");
        }
        TeoremaDePitagoras teoremaDePitagoras = new TeoremaDePitagoras(valorDescobrir, catetoOuHipotenusa, catetoC, resultado);
        return teoremaDePitagoras;
    }

    @Override
    public String toString() {
        return "TeoremaDePitagoras{" +
                "valorDescobrir='" + getValorDescobrir() + '\'' +
                ", catetoOuHipotenusa=" + getCatetoOuHipotenusa() +
                ", catetoC=" + getCatetoC()+
                ", resultado=" + getResultado() +
                '}';
    }
}
