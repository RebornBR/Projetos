package com.mat.arquimedes.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Component
public class Media {
    List<Double> numeros;
    double resultado;

    public Media() {
    }

    public Media(List<Double> numeros, double resultado) {
        this.numeros = numeros;
        this.resultado = resultado;
    }

    public Media calcularMedia(List<Double> numeros){
        double total = 0;
        for (Double num : numeros){
            total += num;
        }
        double media = total / numeros.size();
        return new Media(numeros, media);
    }

    @Override
    public String toString() {
        return "Media{" +
                "numeros=" + getNumeros() +
                ", resultado=" + getResultado() +
                '}';
    }
}
