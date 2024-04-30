package com.mat.arquimedes.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ProgressaoGeometrica {
    double primeiroTermo; int quantidadeTermos; double razao; double termoGeralPG; double somaTermosPG;

    public ProgressaoGeometrica() {
    }

    public ProgressaoGeometrica(double primeiroTermo, int quantidadeTermos, double razao, double termoGeralPG, double somaTermosPG) {
        this.primeiroTermo = primeiroTermo;
        this.quantidadeTermos = quantidadeTermos;
        this.razao = razao;
        this.termoGeralPG = termoGeralPG;
        this.somaTermosPG = somaTermosPG;
    }

    public ProgressaoGeometrica calcularProgressaoGeometrica(double primeiroTermo, int quantidadeTermos, double razao){
        double termoGeralPG;
        double somaTermosPG;
        termoGeralPG = primeiroTermo * (Math.pow(razao, quantidadeTermos - 1));
        somaTermosPG = primeiroTermo * (Math.pow(razao, quantidadeTermos) - 1) ;
        double somaTermosPGFinal = somaTermosPG / (razao - 1);

        return new ProgressaoGeometrica(primeiroTermo, quantidadeTermos, razao, termoGeralPG, somaTermosPGFinal);
    }
    @Override
    public String toString() {
        return "ProgressaoGeometrica{" +
                "primeiroTermo=" + getPrimeiroTermo() +
                ", quantidadeTermos=" + getQuantidadeTermos() +
                ", razao=" + getRazao() +
                ", termoGeralPG=" + getTermoGeralPG() +
                ", somaTermosPG=" + getSomaTermosPG() +
                '}';
    }
}
