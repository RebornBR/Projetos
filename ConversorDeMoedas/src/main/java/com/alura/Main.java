package com.alura;

import com.alura.model.ConversorMoeda;
import com.alura.model.ConversorMoedaRecord;
import com.alura.services.ExchangeRateApi;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExchangeRateApi exchangeRateApi = new ExchangeRateApi();
        ConversorMoeda conversorMoeda = new ConversorMoeda();
        System.out.println(conversorMoeda.converterMoeda("BRL", 100, "USD"));
        // implementar amanha laços de repetição(para escolha de moeda) e list do historico de conversão

    }
}
