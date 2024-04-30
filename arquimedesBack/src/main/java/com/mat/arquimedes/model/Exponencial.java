package com.mat.arquimedes.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Exponencial{
    int base;
    int expoente;
    double resultado;

    public Exponencial() {
    }

    public Exponencial(int base, int expoente, double resultado) {
        this.base = base;
        this.expoente = expoente;
        this.resultado = resultado;
    }

    public Exponencial CalcularExponencial(int base, int expoente){
        double resultado = Math.pow(base, expoente);
        return new Exponencial(base, expoente, resultado);
    }

    @Override
    public String toString() {
        return "Exponencial{" +
                "base=" + getBase() +
                ", expoente=" + getExpoente() +
                ", resultado=" + getResultado() +
                '}';
    }
}
