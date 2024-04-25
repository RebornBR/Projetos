package com.alura.model;

import com.alura.services.ExchangeRateApi;

import java.io.IOException;

public class ConversorMoeda extends  ExchangeRateApi{
    private String nomeMoedaQueTenho;
    private String nomeMoedaQueQuero;
    private double taxaDeCambio;

    public ConversorMoeda() {
        //construtor vazio
    }

    protected ConversorMoeda(CambioMoedaRecord cambioMoedaRecord) { // construtor que recebe um CambioMoedaRecord
        this.nomeMoedaQueTenho = cambioMoedaRecord.base_code();
        this.nomeMoedaQueQuero = cambioMoedaRecord.target_code();
        this.taxaDeCambio = cambioMoedaRecord.conversion_rate();
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

    public void converterMoeda(String moedaQueTenho, double valorQueTenhoDaMoedaQueTenho ,  String moedaQueQuero  ) throws IOException, InterruptedException {
        moedaQueTenho = moedaQueTenho.toUpperCase();
        moedaQueQuero = moedaQueQuero.toUpperCase();
        try {
            ConversorMoeda conversorMoeda = new ConversorMoeda(informacaoCambioMoeda(moedaQueTenho, moedaQueQuero));
            Double valorMoedaConvertido = valorQueTenhoDaMoedaQueTenho * conversorMoeda.getTaxaDeCambio();
            System.out.println(valorQueTenhoDaMoedaQueTenho + " " + moedaQueTenho.toUpperCase() + " em " + moedaQueQuero.toUpperCase() + " é = " + valorMoedaConvertido);
        }catch (NullPointerException e) {
            System.out.println("Sigla da moeda não foi reconhecida, por favor confira. " + moedaQueTenho + " " +  moedaQueQuero );
        }
    }

    public void informacaoTaxaDeConversao(String moedaQueTenho, String moedaQueQuero) throws IOException, InterruptedException {
        moedaQueTenho = moedaQueTenho.toUpperCase();
        moedaQueQuero = moedaQueQuero.toUpperCase();
        try {
            ConversorMoeda conversorMoeda = new ConversorMoeda(informacaoCambioMoeda(moedaQueTenho, moedaQueQuero));
            System.out.println(conversorMoeda); // retorna nosso objeto no SOUT, ou seja, será retornado seu toString
        }catch (NullPointerException e) {
            System.out.println("Sigla da moeda não foi reconhecida, por favor confira. " + moedaQueTenho + " " +  moedaQueQuero );
        }
    }

    @Override
    public String toString() {
        return """
                Nome da moeda base: %s
                Nome da moeda para câmbio: %s
                Taxa de conversão: %f  (Ou seja, 1 %s equivale a %f %s)
                """.formatted(getNomeMoedaQueTenho(), getNomeMoedaQueQuero(), getTaxaDeCambio(), getNomeMoedaQueTenho(),getTaxaDeCambio(), getNomeMoedaQueQuero() ) + "\n";
    }
}
