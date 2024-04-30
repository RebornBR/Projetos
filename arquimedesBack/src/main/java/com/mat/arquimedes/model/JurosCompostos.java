package com.mat.arquimedes.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JurosCompostos {
    double valorAplicado; double taxaJuros; int tempoAplicacao; double resultado;

    public JurosCompostos() {
    }

    public JurosCompostos(double valorAplicado, double taxaJuros, int tempoAplicacao, double resultado) {
        this.valorAplicado = valorAplicado;
        this.taxaJuros = taxaJuros;
        this.tempoAplicacao = tempoAplicacao;
        this.resultado = resultado;
    }

    public JurosCompostos calcularJurosComposto(double valorAplicado, double taxaJuros, int tempoAplicacao){
        double valorFinal;
        taxaJuros = taxaJuros /100;
        valorFinal = valorAplicado * Math.pow((1 + taxaJuros), tempoAplicacao);
        return new JurosCompostos(valorAplicado, taxaJuros, tempoAplicacao, valorFinal);
    }

    @Override
    public String toString() {
        return "JurosCompostos{" +
                "valorAplicado=" + getValorAplicado() +
                ", taxaJuros=" + getTaxaJuros() +
                ", tempoAplicacao=" + getTempoAplicacao() +
                ", resultado=" + getResultado() +
                '}';
    }
}
