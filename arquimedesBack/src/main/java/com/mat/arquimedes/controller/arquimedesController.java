package com.mat.arquimedes.controller;

import com.mat.arquimedes.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*" )
@RequestMapping( "/arquimedesMatematica/operacao/")
public class arquimedesController {

    @Autowired
    private NumeralAleatorio numeralAleatorio;
    @Autowired
    private OperacoesBasicas operacoesBasicas;
    @Autowired
    private JurosCompostos jurosCompostos;
    @Autowired
    private TeoremaDePitagoras teoremaDePitagoras;
    @Autowired
    private Fatorial fatorial;
    @Autowired
    private ProgressaoAritmetica progressaoAritmetica;
    @Autowired
    private ProgressaoGeometrica progressaoGeometrica;
    @Autowired
    private Exponencial exponencial;
    @Autowired
    private Media media;
    @Autowired
    private EquacaoSegundoGrau equacaoSegundoGrau;
    @Autowired
    private Trigonometria trigonometria;
    @Autowired ConversorMoeda conversorMoeda;


    @GetMapping("/numerosAleatorios/quantidadeNumeros={qtdNumeros}/IntervaloIncial={intervaloInicial}/IntervaloFinal={intervaloFinal}")
        public NumeralAleatorio numeralAleatorio(@PathVariable int qtdNumeros, @PathVariable int intervaloInicial, @PathVariable int intervaloFinal){
        return numeralAleatorio.gerarNumeralAleatorio(intervaloInicial,intervaloFinal, qtdNumeros);
    }

    @GetMapping("/{operacao}/numeroUm={numeroUm}/numeroDois={numeroDois}")
        public OperacoesBasicas operacoesBasicas(@PathVariable String operacao, @PathVariable double numeroUm, @PathVariable  double numeroDois){
        return operacoesBasicas.calcularOperacoesBasicas(operacao, numeroUm, numeroDois);
    }

    @GetMapping("/jurosCompostos/valor={vAplicado}/juros={juros}/tempo={tempo}")
        public JurosCompostos jurosCompostos(@PathVariable double vAplicado, @PathVariable double juros, @PathVariable int tempo){
        return jurosCompostos.calcularJurosComposto(vAplicado, juros, tempo);
    }

    @GetMapping("/teoremaDePitagoras/{valorDescobrir}/cateto-ou-Hipotenusa={catetoOuHipotenusa}/catetoC={catetoC}")
        public TeoremaDePitagoras teoremaHipotenusa(@PathVariable String valorDescobrir, @PathVariable double catetoOuHipotenusa, @PathVariable double catetoC){
        return teoremaDePitagoras.calcularTeoremaPitagoras(valorDescobrir, catetoOuHipotenusa, catetoC);
    }

    @GetMapping("/fatorial/numeroFatorial={nFatorial}")
        public Fatorial numeroFatorial(@PathVariable int nFatorial){
        return fatorial.calcularFatorial(nFatorial);
    }

    @GetMapping("/progressaoAritmetica/primeiroTermo={primeiroTermo}/qtdTermos={qtdTermos}/razao={razao}")
        public ProgressaoAritmetica progressaoAritmetica(@PathVariable double primeiroTermo, @PathVariable int qtdTermos, @PathVariable double razao){
        return progressaoAritmetica.calcularProgressaoAritmetica(primeiroTermo, qtdTermos, razao);
    }

    @GetMapping("/progressaoGeometrica/primeiroTermo={primeiroTermo}/qtdTermos={qtdTermos}/razao={razao}")
        public ProgressaoGeometrica progressaoGeometrica(@PathVariable double primeiroTermo, @PathVariable int qtdTermos, @PathVariable double razao){
        return progressaoGeometrica.calcularProgressaoGeometrica(primeiroTermo, qtdTermos, razao);
    }

    @GetMapping("/exponencial/base={base}/expoente={expoente}")
        public Exponencial exponencial(@PathVariable int base, @PathVariable int expoente){
        return exponencial.CalcularExponencial(base, expoente);
    }

    @GetMapping("/media/listNumeros={listaNum}")
        public Media calcularMedia(@PathVariable List<Double> listaNum){
        return media.calcularMedia(listaNum);
    }

    @GetMapping("/equacaoSegundoGrau/a={a}/b={b}/c={c}")
        public EquacaoSegundoGrau calcularEquacaoSegundoGrau(@PathVariable double a, @PathVariable double b, @PathVariable double c ){
        return equacaoSegundoGrau.calcularEquacaoSegundoGrau(a,b,c);
        }

    @GetMapping("/trigonometria/{identificador}={valorDoIdentificador}/angulo={angulo}")
    public Trigonometria calcularSenoCoseno(@PathVariable String identificador, @PathVariable double valorDoIdentificador, @PathVariable int angulo){
        return trigonometria.calcularTrigonometriaSenoCoseno(identificador, valorDoIdentificador, angulo);
    }

    @GetMapping("/conversorMoedas/moedaQueTenho={moedaQueTenho}/valorQueTenhoMoedaQueTenho={valorQueTenhoMoedaQueTenho}/moedaQueQuero={moedaQueQuero}")
    public ConversorMoeda converterMoeda(@PathVariable String moedaQueTenho, @PathVariable double valorQueTenhoMoedaQueTenho, @PathVariable String moedaQueQuero) throws IOException, InterruptedException {
        return conversorMoeda.converterMoeda(moedaQueTenho, valorQueTenhoMoedaQueTenho, moedaQueQuero);
    }

}