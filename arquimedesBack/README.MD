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

><code>{
    <br>
    "valorDescobrir": "hipotenusa",
    <br>
    "catetoOuHipotenusa": 9,
    <br>
    "catetoC": 12,
    <br>
    "resultado": 15
    <br>
}</code>

Nesse exemplo o que precisamos descobrir é a hipotenusa, ou seja, não sabemos o valor da hipotenusa. Nesse exemplo <code> {catetoOuHipotenusa} </code> representa o valor de um cateto e o resultado é o valor doque precisamos descobrir(<code>{valorDescobrir}</code>) ou seja, é o valor da hipotenusa.
<br><br>

<li><h2>Descobrir Cateto:</h2>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/teoremaDePitagoras/cateto/cateto-ou-Hipotenusa=15/catetoC=9">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/teoremaDePitagoras/cateto/cateto-ou-Hipotenusa=15/catetoC=9</a><br>
Retorno: 

><code>{
    <br>
    "valorDescobrir": "cateto",
    <br>
    "catetoOuHipotenusa": 15,
    <br>
    "catetoC": 9,
    <br>
    "resultado": 12
    <br>
}</code>

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

><code>{
    <br>
    "identificador": "hipotenusa",<br>
    "valorDoIdentificador": 30,<br>
    "angulo": 60,<br>
    "seno": 0.866,<br>
    "cosseno": 0.5,<br>
    "catetoOposto": 25.98,<br>
    "catetoAdjacente": 15,<br>
    "hipotenusa": 30<br>
}
}</code>
<br><br>

<li><h2>Identificador Cateto Oposto:</h2>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/catetoOposto=30/angulo=30">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/catetoOposto=30/angulo=30</a><br>
Retorno: 

><code>{
    <br>
     "identificador": "catetooposto",<br>
    "valorDoIdentificador": 30,<br>
    "angulo": 30,<br>
    "seno": 0.5,<br>
    "cosseno": 0.866,<br>
    "catetoOposto": 30,<br>
    "catetoAdjacente": 51.96,<br>
    "hipotenusa": 60<br>
}</code>
<br><br>

<li><h2>Identificador Cateto Adjacente:</h2>
<a href="https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/catetoadjacente=30/angulo=60">https://arquimedesback.onrender.com/arquimedesMatematica/operacao/trigonometria/catetoadjacente=30/angulo=60</a><br>
Retorno: 

><code>{
    <br>
    "identificador": "catetoadjacente",<br>
    "valorDoIdentificador": 30,<br>
    "angulo": 60,<br>
    "seno": 0.866,<br>
    "cosseno": 0.5,<br>
    "catetoOposto": 51.96,<br>
    "catetoAdjacente": 30,<br>
    "hipotenusa": 60<br>
}</code>
<br><br>

<li> Equação de segundo grau
<li> Progressão Aritmética 
<li> Progressão Geometrica 
<li> Exponencial 
<li> Fatorial  
<li> Media 
<li> Juros Compostos 
<li> Números aleatórios 
<li> Conversor de moedas 
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
