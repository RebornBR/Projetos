package com.mat.arquimedes.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ProgressaoAritmetica {
    double primeiroTermo; int quantidadeTermos; double razao; double termoGeral; double somaTermos;

    public ProgressaoAritmetica() {
    }

    public ProgressaoAritmetica(double primeiroTermo, int quantidadeTermos, double razao, double termoGeral, double somaTermos) {
        this.primeiroTermo = primeiroTermo;
        this.quantidadeTermos = quantidadeTermos;
        this.razao = razao;
        this.termoGeral = termoGeral;
        this.somaTermos = somaTermos;
    }
    public ProgressaoAritmetica calcularProgressaoAritmetica(double primeiroTermo, int quantidadeTermos, double razao){
        double termoGeral;
        double somaTermos;

        termoGeral = primeiroTermo + (quantidadeTermos - 1) * razao;
        somaTermos = ((primeiroTermo + termoGeral) * quantidadeTermos) / 2;
        return new ProgressaoAritmetica(primeiroTermo, quantidadeTermos, razao, termoGeral, somaTermos);
    }

    @Override
    public String toString() {
        return "ProgressaoAritmetica{" +
                "primeiroTermo=" + getPrimeiroTermo() +
                ", quantidadeTermos=" + getQuantidadeTermos() +
                ", razao=" + getRazao() +
                ", termoGeral=" + getTermoGeral() +
                ", somaTermos=" + getSomaTermos() +
                '}';
    }
}
