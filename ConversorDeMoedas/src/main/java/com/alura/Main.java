package com.alura;

import com.alura.model.ConversorMoeda;
import com.alura.model.Moedas;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ConversorMoeda conversorMoeda = new ConversorMoeda();
        Moedas moedas= new Moedas();
        String moedaQueTenho;
        String moedaQueQuero;
        double valorMoedaQueTenho;
        int continuar = 0;
        while (continuar != 1){
            System.out.println(moedas.sugestaoDeMoedas());
            System.out.println("Informe o nome da moeda que você tem:");
            moedaQueTenho = scanner.next();
            System.out.println("Informe o valor da moeda que você tem:");
            valorMoedaQueTenho = scanner.nextDouble();
            System.out.println("Informe o nome da moeda que você deseja:");
            moedaQueQuero = scanner.next();
            conversorMoeda.converterMoeda(moedaQueTenho, valorMoedaQueTenho, moedaQueQuero);
            System.out.println("Digite 1 para sair");
            continuar = scanner.nextInt();
        }



    }
}
