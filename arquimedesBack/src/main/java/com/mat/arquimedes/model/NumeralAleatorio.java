package com.mat.arquimedes.model;

import com.mat.arquimedes.services.exceptions.BusinessException;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Component
public class NumeralAleatorio {
    int intervaloInicial; int intervaloFinal; int qtdNumeros; List<Integer> numerosGerados;

    public NumeralAleatorio() {
    }

    public NumeralAleatorio(int intervaloInicial, int intervaloFinal, int qtdNumeros, List<Integer> numerosGerados) {
        this.intervaloInicial = intervaloInicial;
        this.intervaloFinal = intervaloFinal;
        this.qtdNumeros = qtdNumeros;
        this.numerosGerados = numerosGerados;
    }

    public NumeralAleatorio gerarNumeralAleatorio(int intervaloInicial, int intervaloFinal, int qtdNumeros) {
        int contadorNumeralAleatorio = 1;
        int numAleatorio;
        List<Integer> listaDeNumeros = new ArrayList<>();
        if(intervaloFinal >= qtdNumeros){
            intervaloFinal +=1; // sem ele, caso o intervalo seja entrea 1 e 10, o 10 nunca será chamado. ou seja, será chamado entre 1 e 9
            numAleatorio = ThreadLocalRandom.current().nextInt(intervaloInicial, intervaloFinal);

            while (contadorNumeralAleatorio <= qtdNumeros) {
                boolean contem = listaDeNumeros.contains(numAleatorio);
                if (contem == true){
                    numAleatorio = ThreadLocalRandom.current().nextInt(intervaloInicial, intervaloFinal);
                }else {
                    listaDeNumeros.add(numAleatorio);
                    contadorNumeralAleatorio++;
                }
            }

        } else {
            throw new BusinessException("Intervalo final é menor que a quantidade de números requisitados");
        }
        NumeralAleatorio numeralAleatorio = new NumeralAleatorio(intervaloInicial, intervaloFinal, qtdNumeros, listaDeNumeros);
        return numeralAleatorio;
    }

    @Override
    public String toString() {
        return "NumeralAleatorio{" +
                "intervaloInicial=" + getIntervaloInicial() +
                ", intervaloFinal=" + getIntervaloFinal() +
                ", qtdNumeros=" + getQtdNumeros() +
                ", numerosGerados=" + getQtdNumeros() +
                '}';
    }
}
