package com.mat.arquimedes.model;

import com.mat.arquimedes.model.record.CambioMoedaRecord;
import com.mat.arquimedes.services.api.ExchangeRateApi;
import com.mat.arquimedes.services.exceptions.BusinessException;
import com.mat.arquimedes.services.exceptions.GlobalExceptionHandler;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Getter
@Component
public class ConversorMoeda extends ExchangeRateApi {
    private String nomeMoedaQueTenho;
    private String nomeMoedaQueQuero;
    private double valorQueTenhoMoedaQueTenho;
    private double taxaDeCambio;
    private double resultado;
    public ConversorMoeda() {
        //construtor vazio
    }
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public void setValorQueTenhoMoedaQueTenho(double valorQueTenhoMoedaQueTenho) {
        this.valorQueTenhoMoedaQueTenho = valorQueTenhoMoedaQueTenho;
    }

    protected ConversorMoeda(CambioMoedaRecord cambioMoedaRecord) {
        this.nomeMoedaQueTenho = cambioMoedaRecord.base_code();
        this.nomeMoedaQueQuero = cambioMoedaRecord.target_code();
        this.taxaDeCambio = cambioMoedaRecord.conversion_rate();
    }

    public ConversorMoeda converterMoeda(String moedaQueTenho, double valorQueTenhoDaMoedaQueTenho ,  String moedaQueQuero  ) throws IOException, InterruptedException {
        double resultado;
        ConversorMoeda conversorMoeda = new ConversorMoeda(informacaoCambioMoeda(moedaQueTenho, moedaQueQuero));
        conversorMoeda.setValorQueTenhoMoedaQueTenho(valorQueTenhoDaMoedaQueTenho);
        resultado = conversorMoeda.getTaxaDeCambio() * valorQueTenhoDaMoedaQueTenho;
        conversorMoeda.setResultado(resultado);
        return conversorMoeda;
    }

    @Override
    public String toString() {
        return "ConversorMoeda{" +
                "nomeMoedaQueTenho='" + getNomeMoedaQueTenho() + '\'' +
                ", nomeMoedaQueQuero='" + getNomeMoedaQueQuero() + '\'' +
                ", valorQueTenhoMoedaQueTenho=" + getValorQueTenhoMoedaQueTenho() +
                ", taxaDeCambio=" + getTaxaDeCambio() +
                ", resultado=" + getResultado() +
                '}';
    }
}
