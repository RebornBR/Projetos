package com.mat.arquimedes.services.api;

import com.google.gson.Gson;
import com.mat.arquimedes.model.record.CambioMoedaRecord;
import com.mat.arquimedes.services.exceptions.BusinessException;
import jakarta.validation.constraints.Null;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {
    String moedaQueTenho;
    String moedaQueQuero;
    String endereco;
    protected CambioMoedaRecord informacaoCambioMoeda(String moedaQueTenho, String moedaQueQuero) throws IOException, InterruptedException {
        this.moedaQueTenho = moedaQueTenho.toUpperCase();
        this.moedaQueQuero = moedaQueQuero.toUpperCase();
        if (!(moedaQueTenho.length() == 3) || !(moedaQueQuero.length() == 3)) {
            throw new BusinessException("Você precisa usar a sigla da moeda como parametro. Por exemplo: Real(BRL), Dolar(USD). Moedas que você passou[" + "'" + moedaQueTenho + "'," + "'" + moedaQueQuero + "']");
        }
            endereco = "https://v6.exchangerate-api.com/v6/25a38b952e41e3814c74513d/pair/" + moedaQueTenho + "/" + moedaQueQuero + "/";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            String json = response.body();
            CambioMoedaRecord cambioMoedaRecord = gson.fromJson(json, CambioMoedaRecord.class);
            if(cambioMoedaRecord.conversion_rate() == null || cambioMoedaRecord.base_code() == null || cambioMoedaRecord.target_code() == null ){
                throw new BusinessException("Alguma sigla de moeda que você passou é desconhecida, por favor verifique a sigla das moedas. Moedas que você passou[" + "'" + moedaQueTenho + "'," + "'" + moedaQueQuero + "']");
            }
        return cambioMoedaRecord;
    }
}
