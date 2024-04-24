package com.alura.model;

import com.alura.services.ExchangeRateApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoeda extends  ExchangeRateApi{
    private String nomeMoedaQueTenho;
    private String nomeMoedaQueQuero;
    private double taxaDeCambio;

    public ConversorMoeda() {

    }

    protected ConversorMoeda(ConversorMoedaRecord conversorMoedaRecord) {
        this.nomeMoedaQueTenho = conversorMoedaRecord.base_code();
        this.nomeMoedaQueQuero = conversorMoedaRecord.target_code();
        this.taxaDeCambio = conversorMoedaRecord.conversion_rate();
    }
    public double getTaxaDeCambio() {
        return taxaDeCambio;
    }
    public String getNomeMoedaQueTenho() {
        return nomeMoedaQueTenho;
    }
    public String getNomeMoedaQueQuero() {
        return nomeMoedaQueQuero;
    }

    public String converterMoeda(String moedaQueTenho, double valorQueTenhoDaMoedaQueTenho ,  String moedaQueQuero  ) throws IOException, InterruptedException {
        ConversorMoeda conversorMoeda = new ConversorMoeda(taxaDeConversaoDessaMoedaParaEssaMoeda(moedaQueTenho, moedaQueQuero));
        return conversorMoeda + "\n" + "Valor em " + moedaQueQuero + " é = " + valorQueTenhoDaMoedaQueTenho * conversorMoeda.getTaxaDeCambio();
    }

    @Override
    public String toString() {
        return """
                Nome da moeda base: %s
                Nome da moeda para câmbio: %s
                Taxa de conversão: %f
                """.formatted(getNomeMoedaQueTenho(), getNomeMoedaQueQuero(), getTaxaDeCambio()) + "\n";
    }
}
