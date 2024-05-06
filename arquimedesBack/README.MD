<h1 align= "center">Documentação API Arquimedes</h1>
<div align="center"> 
<h3><a href="">Clique aqui para acessar o site do Arquimedes(em desenvolvimento)</a></h3>
</div>
Aqui você pode baixar ou clonar a versão com funcionamento local da API, isso significa que ela funcionará na porta 8080(localhost:8080)
Para uso da API remota vc deve utilizar o seguinte prefixo na url:
<br>
<code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao</code>
<br> O prefixo deve ser seguido com o nome da operacao e seus respectivos parametros/valores, confira abaixo as operações disponíveis e suas URLs:

<code> </code> 

  > [!IMPORTANTE]
> Sempre utilize " . " para valores de pontos flutuantes(double), isto é, não utilize <code>2,555</code> utilize <code>2.555</code>

<br>
Operações disponiveis:
<ul>

<h1><li> Operações básicas(soma, divisão, multiplicação)</h1>
URL para operação basica:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/{operacao}/numeroUm={numeroUm}/numeroDois={numeroDois}</code> 
<br><br>
<li> String double <code> {operacao} </code> 
<li> double <code> {numeroUm} </code> 
<li> double <code> {numeroDois} </code> 
<br><br>
Subsititua o valor presente de {operacao} por:
<br> <code> "som", "somar", "soma", "plus"</code> para somar os dois números
<br> <code> "sub", "subtracao", "subtrair", "menos" </code> para subtrair <code> numeroUm </code> - <code> numeroDois</code>  
<br> <code> "mul", "multiplicar", "multiplicacao", "vezes" </code> para multiplicar <code> numeroUm </code> x <code> numeroDois </code> 
<br> <code> "div", "divisao", "dividir", "divisoes" </code> para dividir <code> numeroUm </code> / <code> numeroDois </code> 
<br>
<h3>Exemplos:</h3>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/som/numeroUm=2/numeroDois=2"><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/som/numeroUm=2/numeroDois=2</code> </a>
<br>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/sub/numeroUm=3/numeroDois=2"><br><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/sub/numeroUm=3/numeroDois=2</code></a>
<br>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/mul/numeroUm=4/numeroDois=2"><br><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/mul/numeroUm=4/numeroDois=2</code></a>
<br>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/div/numeroUm=8/numeroDois=2"><br><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/div/numeroUm=8/numeroDois=2</code></a>
<br><br>


<h1><li> Teorema de pitágoras</h1>
URL para teorema de pitágoras:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/teoremaDePitagoras/{valorDescobrir}/cateto-ou-Hipotenusa={catetoOuHipotenusa}/catetoC={catetoC}</code>
<br><br>
<li>String <code>{valorDescobrir}</code>
<li>double <code>{catetoOuHipotenusa} </code> 
<li>double <code> {catetoC} </code> 
<br><br>
Substitua os valores da seguinte forma:
<br> <code>{valorDescobrir}</code> deve ser substituido pelo que precisamos descobrir no teorema, ou seja, deve ser substituido por <code> hipotenusa </code> ou <code> cateto </code> e <code> {catetoOuHipotenusa} </code> deve ser substituido pelo valor númerico e representa um cateto ou uma hipotenusa, se precisamos descobrir qual o valor da hipotenusa, <code> {catetoOuHipotenusa} </code> representa o valor de um cateto e se precisamos descobrir o valor do cateto <code> {catetoOuHipotenusa} </code> representa o valor de uma hipotenusa.
<br>
<h3>Exemplos:</h3>

<li><h2>Descobrir Hipotenusa:</h2>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/teoremaDePitagoras/hipotenusa/cateto-ou-Hipotenusa=9/catetoC=12">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/teoremaDePitagoras/hipotenusa/cateto-ou-Hipotenusa=9/catetoC=12</a><br>
Retorno: 

```json
{
    "valorDescobrir": "hipotenusa",
    "catetoOuHipotenusa": 9,
    "catetoC": 12,
    "resultado": 15
}
```

Nesse exemplo o que precisamos descobrir é a hipotenusa, ou seja, não sabemos o valor da hipotenusa. Nesse exemplo <code> {catetoOuHipotenusa} </code> representa o valor de um cateto e o resultado é o valor doque precisamos descobrir(<code>{valorDescobrir}</code>) ou seja, é o valor da hipotenusa.
<br>

<li><h2>Descobrir Cateto:</h2>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/teoremaDePitagoras/cateto/cateto-ou-Hipotenusa=15/catetoC=9">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/teoremaDePitagoras/cateto/cateto-ou-Hipotenusa=15/catetoC=9</a><br>
Retorno: 

```json
{
    "valorDescobrir": "cateto",
    "catetoOuHipotenusa": 15,
    "catetoC": 9,
    "resultado": 12
}
```

Nesse exemplo o que precisamos descobrir é o cateto, ou seja, não sabemos o valor do cateto. Nesse exemplo <code> {catetoOuHipotenusa} </code> representa o valor de uma hipotenusa e o resultado é o valor doque precisamos descobrir(<code>{valorDescobrir}</code>) ou seja, é o valor do cateto.
<br><br>


<h1><li> Trigonometria</h1>
URL para trigonometria:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/{identificador}={valorDoIdentificador}/angulo={angulo}</code>
<br><br>
<li>String <code>{identificador}</code>
<li>double <code>{valorDoIdentificador} </code> 
<li>int <code> {angulo} </code>
<br><br>

Substitua os valores da seguinte forma:
<br><code>{identificador}</code> deve ser substituido por <code> hipotenusa </code>, <code> catetooposto </code> ou <code> catetoadjacente </code>. <code>{valorDoIdentificador}</code> deve ser substituido pelo valor númerico de <code>{identificador}</code>, ou seja, representa o valor de uma hipotenusa, cateto oposto ou cateto adjacente. O <code>{angulo}</code> deve ser substituido por 30, 45 ou 60.
<br>
<h3>Exemplos:</h3>

<li><h2>Identificador Hipotenusa:</h2>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/hipotenusa=30/angulo=60">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/hipotenusa=30/angulo=60</a><br>
Retorno: 

```json
{
    "identificador": "hipotenusa",
    "valorDoIdentificador": 30,
    "angulo": 60,
    "seno": 0.866,
    "cosseno": 0.5,
    "catetoOposto": 25.98,
    "catetoAdjacente": 15,
    "hipotenusa": 30<
}
```

<li><h2>Identificador Cateto Oposto:</h2>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/catetoOposto=30/angulo=30">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/catetoOposto=30/angulo=30</a><br>
Retorno: 

```json
{
    "identificador": "catetooposto",
    "valorDoIdentificador": 30,
    "angulo": 30,
    "seno": 0.5,
    "cosseno": 0.866,
    "catetoOposto": 30,
    "catetoAdjacente": 51.96,
    "hipotenusa": 60
}
```

<li><h2>Identificador Cateto Adjacente:</h2>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/catetoadjacente=30/angulo=60">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/catetoadjacente=30/angulo=60</a><br>
Retorno: 

```json
{
    "identificador": "catetoadjacente",
    "valorDoIdentificador": 30,
    "angulo": 60,
    "seno": 0.866,
    "cosseno": 0.5,
    "catetoOposto": 51.96,
    "catetoAdjacente": 30,
    "hipotenusa": 60
}
```
<br><br>

<h1><li> Equação de segundo grau</h1>
URL para equação de segundo grau:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/equacaoSegundoGrau/a={a}/b={b}/c={c}</code>
<br><br>

<li>double <code>{a}</code>
<li>double <code>{b} </code> 
<li>double<code> {c} </code>
<br><br>

Substitua os valores da seguinte forma:
<br> 
<code>{a}</code>, <code>{b}</code> e <code>{c}</code> representam os valores de [a, b, c] da equação, ou seja, substitua pelos equivalentes.<br>
> Caso a equação não possua uma solução para <code>x1</code> ou <code>x2</code>, ou seja, se a equação não tiver uma solução real, seus valore(s) serão <code>"NaN"</code>
<br>

<h3>Exemplos:</h3>

Equação com solução real:
<a href ="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/equacaoSegundoGrau/a=1/b=-1/c=-12
">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/equacaoSegundoGrau/a=1/b=-1/c=-12</a><br>
Retorno:

```json
{
    "a": 1,
    "b": -1,
    "c": -12,
    "delta": 49,
    "x1": 4,
    "x2": -3
}
```
Equação sem solução real:<br>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/equacaoSegundoGrau/a=2/b=3/c=3">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/equacaoSegundoGrau/a=2/b=3/c=3</a><br>
Retorno:

```json
{
    "a": 2,
    "b": 3,
    "c": 3,
    "delta": -15,
    "x1": "NaN",
    "x2": "NaN"
}
```
<br><br>

<h1><li> Progressão Aritmética & Progressão Geometrica</h1>
URL para progressão aritmética:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/progressaoAritmetica/primeiroTermo={primeiroTermo}/qtdTermos={qtdTermos}/razao={razao}</code><br>
URL para progressão geometrica:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/progressaoGeometrica/primeiroTermo={primeiroTermo}/qtdTermos={qtdTermos}/razao={razao}</code>
<br><br>

<li>double <code>{primeiroTermo}</code>
<li>int <code>{qtdTermos} </code> 
<li>double<code> {razao} </code>
<br><br>

Substitua os valores da seguinte forma:
<br> 
Substitua <code>{primeiroTermo}</code> pelo primeiro termo da sequência. 
<br>Substitua <code>{qtdTermos}</code> pelo termo que você deseja saber, em outras palvras, se você deseja saber qual é o número(termo) que está na posição 300 de uma sequencia, substitua <code>{qtdTermos}</code> por ele.<br>
Subsitua <code>{razao}</code> pela razão da sequência. 
<br>
<h3>Exemplos:</h3>
Progressão aritmética:<br>
Qual é o décimo termo dessa sequência(2, 4, 6, 8.....) ?<br>
<a href= "https://arquimedesback.onrender.com/arquimedesMatematica/operacao/progressaoAritmetica/primeiroTermo=2/qtdTermos=10/razao=2">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/progressaoAritmetica/primeiroTermo=2/qtdTermos=10/razao=2</a><br>
Retorno:(<code>termoGeral</code> representa o valor do ultimo termo, o termo ao qual procuramos, nesse caso, o décimo)

```json
{
    "primeiroTermo": 2,
    "quantidadeTermos": 10,
    "razao": 2,
    "termoGeral": 20,
    "somaTermos": 110
}
```
<br>
Progressão geometrica:<br>
Qual é o décimo termo dessa sequência(2, 4, 8, 16.....) ?<br>
<a href= "https://arquimedesback.onrender.com/arquimedesMatematica/operacao/progressaoGeometrica/primeiroTermo=2/qtdTermos=10/razao=2">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/progressaoGeometrica/primeiroTermo=2/qtdTermos=10/razao=2</a><br>
Retorno:(<code>termoGeral</code> representa o valor do ultimo termo, o termo ao qual procuramos, nesse caso, o décimo)

```json
{
    "primeiroTermo": 2,
    "quantidadeTermos": 10,
    "razao": 2,
    "termoGeralPG": 1024,
    "somaTermosPG": 2046
}
```
<br><br>

<h1><li> Fatorial</h1>
URL para Fatorial:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/fatorial/numeroFatorial={nFatorial}</code>
<br><br>
<li>int <code>{fatorial}</code>
<br><br>
Substitua os valores da seguinte forma:
<br> 
Substitua <code>{nFatorial}</code> pelo número que você deseja saber o fatorial.
<br>

<h3>Exemplos:</h3>
<a href= "https://arquimedesback.onrender.com/arquimedesMatematica/operacao/fatorial/numeroFatorial=5">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/fatorial/numeroFatorial=5}</a><br>
Retorno:

```json
{
    "numeroFatorial": 5,
    "resultado": 120
}
```
<br><br>

<h1><li> Exponencial</h1>
URL para Exponencial:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/exponencial/base={base}/expoente={expoente}</code>
<br><br>
<li>int <code>{base}</code>
<li>int <code>{base}</code>
<br><br>
Substitua os valores da seguinte forma:
<br>
se você deseja elevar, por exemplo, 2 elevado a 5. <code>{base}</code> será 2 e <code>{expoente}</code> será 5.
<br>
<h3>Exemplos:</h3><br>
3 elevado a 5:
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/exponencial/base=3/expoente=5">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/exponencial/base=3/expoente=5</a><br>
Retorno:

```json
{
    "base": 3,
    "expoente": 5,
    "resultado": 243
}
```
<br><br>
<h1><li> Media</h1>
URL para media:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/media/listNumeros={listaNum}</code>
<br><br>
<li>List < Double > <code> {listaNum} </code>
<br><br>
Substitua os valores da seguinte forma:
<br>
<code> {listaNum} </code> deve ser substituído por uma lista de números separados por vírgula, por exemplo, <code>2.3, 3, 5.7, 5</code>.
<br>
<h3>Exemplos:</h3><br>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/media/listNumeros=2.5,2.5,0,5">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/media/listNumeros=2.5,2.5,0,5</a><br>
Retorno:

```json
{
    "numeros": [
        2.5,
        2.5,
        0,
        5
    ],
    "resultado": 2.5
}
```

<br><br>
<h1><li> Juros compostos:</h1>
URL para juros compostos:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/jurosCompostos/valor={vAplicado}/juros={juros}/tempo={tempo}</code>
<br><br>
<li>double <code>{vAplicado}</code>
<li>double<code>{juros} </code> 
<li>int<code> {tempo} </code>
<br>
Substitua os valores da seguinte forma:
<br>
<code>{vAplicado}</code> pelo montante aplicado, o quanto foi pego. <br>
<code>{juros}</code> pela taxa de juros, seja ela mensal ou anual.<br>
<code> {tempo} </code> pela quantidade de meses ou anos.
<h3>Exemplos:</h3><br>
Valor aplicado: 500<br>
Juros: 5% ao mês<br>
Tempo: 12 meses<br>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/jurosCompostos/valor=500/juros=5/tempo=12
">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/jurosCompostos/valor=500/juros=5/tempo=12</a><br>
Retorno:

```json
{
    "valorAplicado": 500,
    "taxaJuros": 0.05,
    "tempoAplicacao": 12,
    "resultado": 897.9281630110651
}
```
<br>
Valor aplicado: 500<br>
Juros: 60% ao ano<br>
Tempo: 2 anos<br>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/jurosCompostos/valor=500/juros=60/tempo=2
">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/jurosCompostos/valor=500/juros=60/tempo=2</a><br>
Retorno:<br>

```json
{
    "valorAplicado": 500,
    "taxaJuros": 0.6,
    "tempoAplicacao": 2,
    "resultado": 1280.0000000000002
}
```
<br><br>
<h1><li> Números aleatorios</h1>
URL para Números aleatorios:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/numerosAleatorios/quantidadeNumeros={qtdNumeros}/IntervaloIncial={intervaloInicial}/IntervaloFinal={intervaloFinal}</code>
<br><br>
<li>int<code>{qtdNumeros}</code>
<li>int<code>{intervaloInicial} </code> 
<li>int<code> {intervaloFinal} </code><br>
Substitua os valores da seguinte forma:<br>
<code>{qtdNumeros}</code> pela quantidade de números que você deseja gerar. <br>
<code>{intervaloInicial} </code> & <code> {intervaloFinal} </code> determinam o intervalo de números que será gerado os números aleatorios, por exemplo, 5-50, será gerados números entre 5 e 50
<h3>Exemplos:</h3><br>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/numerosAleatorios/quantidadeNumeros=20/IntervaloIncial=1/IntervaloFinal=20">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/numerosAleatorios/quantidadeNumeros=20/IntervaloIncial=1/IntervaloFinal=20</a><br>
Retorno:

```json
{
    "intervaloInicial": 1,
    "intervaloFinal": 21,
    "qtdNumeros": 20,
    "numerosGerados": [
        7,
        17,
        12,
        6,
        15,
        20,
        4,
        1,
        18,
        11,
        14,
        8,
        16,
        2,
        3,
        13,
        10,
        5,
        9,
        19
    ]
}
```

<a href= "https://arquimedesback.onrender.com/arquimedesMatematica/operacao/numerosAleatorios/quantidadeNumeros=20/IntervaloIncial=1/IntervaloFinal=100 ">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/numerosAleatorios/quantidadeNumeros=20/IntervaloIncial=1/IntervaloFinal=100 </a><br>
Retorno:

```json
{
    "intervaloInicial": 1,
    "intervaloFinal": 101,
    "qtdNumeros": 20,
    "numerosGerados": [
        15,
        90,
        84,
        66,
        17,
        27,
        61,
        46,
        14,
        21,
        50,
        36,
        80,
        54,
        100,
        76,
        81,
        31,
        24,
        16
    ]
}
```
<br><br>

<h1><li> Conversor de moedas:</h1>
URL para conversor de moedas:
<br ><code>https://arquimedesback.onrender.com/arquimedesMatematica/operacao/conversorMoedas/moedaQueTenho={moedaQueTenho}/valorQueTenhoMoedaQueTenho={valorQueTenhoMoedaQueTenho}/moedaQueQuero={moedaQueQuero}}</code>
<br><br>
<li>String<code>{moedaQueTenhos}</code>
<li>double<code> {valorQueTenhoMoedaQueTenho} </code>
<li>String<code>{moedaQueQuero} </code> 
<br>
Substitua os valores da seguinte forma:
<br>
String<code>{moedaQueTenhos}</code> Substitua pela sigla da moeda que você tem<br>
double<code> {valorQueTenhoMoedaQueTenhos} </code> Substitua pelo valor, o quanto você tem da moeda que você tem<br>
String<code>{moedaQueQuero} </code> Substitua pela sigla da moeda que você deseja
<h3>Exemplos:</h3><br>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/conversorMoedas/moedaQueTenho=BRL/valorQueTenhoMoedaQueTenho=1000/moedaQueQuero=USD
">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/conversorMoedas/moedaQueTenho=BRL/valorQueTenhoMoedaQueTenho=1000/moedaQueQuero=USD</a><br>
Retorno:

```json
{
    "nomeMoedaQueTenho": "BRL",
    "nomeMoedaQueQuero": "USD",
    "valorQueTenhoMoedaQueTenho": 1000,
    "taxaDeCambio": 0.1962,
    "resultado": 196.20000000000002
}
```

</ul>

<h3 align="left">Tecnologias utilizadas:</h3>
<div align="center"> 
<img src="https://img.shields.io/badge/Java-000000?style=for-the-badge&logo=openjdk&logoColor=white">
<img src="https://img.shields.io/badge/javascript-000000.svg?style=for-the-badge&logo=javascript&logoColor=white">
<img src="https://img.shields.io/badge/css3-000000.svg?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/HTML-000000?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/Vercel-000000?style=for-the-badge&logo=vercel&logoColor=white">
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white">
<img src="https://img.shields.io/badge/Visual_Studio-000000?style=for-the-badge&logo=visual%20studio&logoColor=white">
</div> <br><br>

<div align ="center">
<h3>Autor</h3>

|  |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/86569104?v=4" width=115><br><sub>Rodrigo Santos</sub>](https://github.com/RebornBR) |   |
| :---: | :---: | :---: |

<h3>Colaborador</h3>

|  |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/90629181?v=4" width=115><br><sub>Thaís Correia</sub>](https://github.com/ThataCorreia) |   |
| :---: | :---: | :---: |
</div>
