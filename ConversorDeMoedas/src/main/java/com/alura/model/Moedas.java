package com.alura.model;

public class Moedas {
    public Moedas() {
    }
    public String sugestaoDeMoedas(){
       return """
                                  Sugestões de moedas:
               ==============================================================                           
               "REAL" = "BRL"                |   "PESO ARGENTINO" = "ARS"
               "PESO ARGENTINO" = "ARS"      |   "IENE" = "JPY"
               "BOLIVIANO" = "BOB"           |   "LIBRA" = "GBP"
               "PESO CHILENO" = "CLP"        |   "PESO URUGUAIO" = "UYU"
               "PESO COLOMBIANO" = "COP"     |   "DÓLAR SURINAMÊS" = "SRD"
               "DÓLAR DOS EUA" = "USD"       |   "NOVO SOL PERUANO" = "PEN"
               "DÓLAR DA GUIANA" = "GYD"     |   "GUARANÍ" = "PYG"
               "EURO" = "EUR"                |   "YUAN CHINÊS" = "CNY"
               
               !!!!! LEMBRE DE UTILIZAR APENAS AS SIGLAS DAS MOEDAS !!!!!
               ==============================================================
                 """;

    }
}
