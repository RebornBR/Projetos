package com.AplicacaoRastreio.services.relatorioService;

/**
 * interface utilizada na classe {@link Relatorio}
 */
public interface RelatorioI {

    /**
     * Metodo que gera o cabeçalho do arquivo pdf
     */
    public void gerarCabecalho();
    /**
     * Metodo que gera o corpo do arquivo pdf
     */
    public void gerarCorpo();
}
