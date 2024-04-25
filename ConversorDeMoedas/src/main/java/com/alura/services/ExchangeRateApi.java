package com.alura.services;

import com.alura.model.CambioMoedaRecord;
import com.google.gson.Gson;

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
        this.moedaQueTenho = moedaQueTenho;
        this.moedaQueQuero = moedaQueQuero;
        endereco = "https://v6.exchangerate-api.com/v6/25a38b952e41e3814c74513d/pair/" + moedaQueTenho + "/" + moedaQueQuero+ "/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        String json = response.body();
        CambioMoedaRecord cambioMoedaRecord = gson.fromJson(json, CambioMoedaRecord.class); // criando um objeto CambioMoedaRecord, que fará a leitura do json(que recebeu o response.body()) e os campos de mesmos nomes terão seus valores pegos pelo Record com atributos de mesmos nomes
        return cambioMoedaRecord;
    }
}
