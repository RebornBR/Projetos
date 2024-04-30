package com.mat.arquimedes.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Fatorial {
    int numeroFatorial;
    long resultado;

    public Fatorial() {
    }

    public Fatorial(int numeroFatorial, long resultado) {
        this.numeroFatorial = numeroFatorial;
        this.resultado = resultado;
    }
    public Fatorial calcularFatorial(int numeroFatorial){
        long fatorResultado = 1;
        for (int contador = 1; contador <= numeroFatorial; contador++ ){ // 1x1; 1x2 = 2; 2x3 = 6; 6x4 = 24; 24x5 = 120
            fatorResultado  = fatorResultado * contador;
        }
        return new Fatorial(numeroFatorial, fatorResultado);
    }

    @Override
    public String toString() {
        return "Fatorial{" +
                "numeroFatorial=" + getNumeroFatorial() +
                ", resultado=" + getResultado() +
                '}';
    }
}
