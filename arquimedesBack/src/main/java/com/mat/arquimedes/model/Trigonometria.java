package com.mat.arquimedes.model;

import com.mat.arquimedes.services.exceptions.BusinessException;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Component
public class Trigonometria {
    String identificador;
    double valorDoIdentificador;
    int angulo;
    double seno;
    double cosseno;
    double catetoOposto;
    double catetoAdjacente;
    double hipotenusa;

    public Trigonometria() {
    }

    public Trigonometria(String identificador, double valorDoIdentificador, int angulo, double seno, double cosseno, double catetoOposto, double catetoAdjacente, double hipotenusa) {
        this.identificador = identificador;
        this.valorDoIdentificador = valorDoIdentificador;
        this.angulo = angulo;
        this.seno = seno;
        this.cosseno = cosseno;
        this.catetoOposto = catetoOposto;
        this.catetoAdjacente = catetoAdjacente;
        this.hipotenusa = hipotenusa;
    }
    public Trigonometria calcularTrigonometriaSenoCoseno(String identificador, double valorDoIdentificador, int angulo){
        identificador = identificador.toLowerCase();
        double seno;
        double cosseno;
        double catetoOposto;
        double catetoAdjacente;
        double hipotenusa;
        switch (angulo){
            case 30:{
                seno = 0.5;
                cosseno = 0.866;
                break;
            }
            case 45:{
                seno = 0.707;
                cosseno = 0.707;
                break;
            }
            case 60:{
                seno = 0.866;
                cosseno = 0.5 ;
                break;
            }
            default:  throw new BusinessException("Angulo precisa ser de 30, 45 ou 60");
        }

        if (Objects.equals(identificador, "hipotenusa")){
            hipotenusa = valorDoIdentificador;
            catetoOposto = hipotenusa * seno;
            catetoAdjacente = hipotenusa * cosseno;
        }else if(Objects.equals(identificador, "catetooposto")) {
            catetoOposto = valorDoIdentificador;
            hipotenusa = catetoOposto / seno;
            catetoAdjacente = hipotenusa * cosseno;
        } else if (Objects.equals(identificador, "catetoadjacente")) {
            catetoAdjacente = valorDoIdentificador;
            hipotenusa = catetoAdjacente / cosseno;
            catetoOposto = hipotenusa * seno;
        }else {
            throw new BusinessException("{identificador} deve ser substituído por hipotenusa, catetooposto ou catetoadjacente. Se houver dúvidas, por favor, confira o readme da API ");
        }
        return new Trigonometria(identificador, valorDoIdentificador, angulo, seno, cosseno, catetoOposto, catetoAdjacente, hipotenusa);

    }

    @Override
    public String toString() {
        return "Trigonometria{" +
                "identificador='" + getIdentificador() + '\'' +
                ", valor=" + getValorDoIdentificador() +
                ", angulo=" + getAngulo() +
                ", seno=" + getSeno() +
                ", cosseno=" + getCosseno() +
                ", catetoOposto=" + getCatetoOposto() +
                ", catetoAdjacente=" + getCatetoAdjacente() +
                ", hipotenusa=" + getHipotenusa() +
                '}';
    }
}
