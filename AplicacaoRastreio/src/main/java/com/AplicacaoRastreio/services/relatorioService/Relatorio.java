package com.AplicacaoRastreio.services.relatorioService;

import com.AplicacaoRastreio.Model.Pedido;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

/**
 * Classe responsavel pela criação de pdf dos pedidos
 */
@Service
public class Relatorio implements RelatorioI {

    private Document documentPdf;
    private Pedido pedido;
    private String nomeRelatorio;
    private String nomeArquivo;

    /**
     * Função que gera um pdf para a criação de um pedido
     * @param pedido recebe um {@link Pedido} cujos atributos serão utilizados na construção do pdf
     * @param nomeRelatorio nome que vai encabeçar(será o titulo) do pdf gerado
     * @param nomeArquivo será o nome do arquivo gerado
     * @throws RuntimeException - executada se houver um FileNotFoundException
     */
    public void gerarPdfDeCriacaoDePedido(Pedido pedido, String nomeRelatorio, String nomeArquivo){
        this.pedido = pedido;
        this.nomeArquivo = nomeArquivo + ".pdf";
        this.nomeRelatorio = nomeRelatorio;
        this.documentPdf = new Document();
        try {
            PdfWriter.getInstance(this.documentPdf,new FileOutputStream("AplicacaoRastreio\\src\\main\\resources\\relatorios\\" + this.nomeArquivo));
            documentPdf.open();
            gerarCabecalho();
            gerarCorpo();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        documentPdf.close();
    }

    /**
     * Função que gera um pdf para relatorios de pedidos
     * @param pedidos recebe uma List de {@link Pedido} cujos atributos serão utilizados na construção do pdf
     * @param nomeRelatorio nome que vai encabeçar(será o titulo) do pdf gerado
     * @param nomeArquivo será o nome do arquivo gerado
     * @throws RuntimeException - executada se houver um FileNotFoundException
     */
    public void gerarPdfRelatorio(List<Pedido> pedidos, String nomeRelatorio, String nomeArquivo){
        this.nomeArquivo = nomeArquivo + ".pdf";
        this.nomeRelatorio = nomeRelatorio;
        this.documentPdf = new Document();
        try {
            PdfWriter.getInstance(this.documentPdf,new FileOutputStream("AplicacaoRastreio\\src\\main\\resources\\relatorios\\" + this.nomeArquivo));
            documentPdf.open();
            gerarCabecalho();
            for (Pedido p : pedidos){
                this.pedido = p;
                gerarCorpo();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        documentPdf.close();
    }

    @Override
    public void gerarCabecalho() {
        Paragraph titulo = new Paragraph();
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.add(new Chunk(
                "RELATÓRIO " + this.nomeRelatorio,
                new Font(Font.HELVETICA,24)
        ));
        this.documentPdf.add(titulo);
        this.documentPdf.add(new Paragraph(" "));

        Paragraph data = new Paragraph();
        data.setAlignment(Element.ALIGN_CENTER);
        data.add(new Chunk(String.valueOf(LocalDate.now())));
        this.documentPdf.add(data);
        this.documentPdf.add(new Paragraph(" "));
        this.documentPdf.add(new Paragraph(" "));

    }

    @Override
    public void gerarCorpo() {
        this.documentPdf.add(new Paragraph(" "));
        Paragraph identificacaoPedido = new Paragraph();
        identificacaoPedido.setAlignment(Element.ALIGN_CENTER);
        identificacaoPedido.add(new Chunk("NÚMERO DO PEDIDO: " + this.pedido.getNumeroPedido(), new Font(Font.BOLD, 16)));
        this.documentPdf.add(identificacaoPedido);
        Paragraph fimSessao = new Paragraph("------------------------------------------------------------------");
        fimSessao.setAlignment(Element.ALIGN_CENTER);
        this.documentPdf.add(fimSessao);
        Paragraph informacoesPedido = new Paragraph();
        informacoesPedido.setAlignment(Element.ALIGN_LEFT);
        informacoesPedido.add(new Chunk("Informações do pedido: " + pedido.getInformacoesDoPedido(), new Font(Font.BOLD, 14)));
        this.documentPdf.add(informacoesPedido);

        Paragraph setor = new Paragraph();
        setor.setAlignment(Element.ALIGN_LEFT);
        setor.add(new Chunk("Setor: " + pedido.getNomeSetor(), new Font(Font.BOLD, 14)));
        this.documentPdf.add(setor);

        Paragraph dataEntrada= new Paragraph();
        dataEntrada.setAlignment(Element.ALIGN_LEFT);
        dataEntrada.add(new Chunk("Data de entrada: " + pedido.getDataEntrada(), new Font(Font.BOLD, 14)));
        this.documentPdf.add(dataEntrada);

        Paragraph dataSaida = new Paragraph();
        dataSaida.setAlignment(Element.ALIGN_LEFT);
        dataSaida.add(new Chunk("Data de saída: " + pedido.getDataSaida(), new Font(Font.BOLD, 14)));
        this.documentPdf.add(dataSaida);
    }

}

