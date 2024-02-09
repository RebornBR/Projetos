const enviarQ = document.querySelector("form");
let iPergunta; // variavel utilizada no metodo fetch post
let iResposta;// variavel utilizada no metodo fetch post

enviarQ.addEventListener('focusin', function () {
    document.body.classList.add('blur-background');
});

enviarQ.addEventListener('focusout', function () {
    document.body.classList.remove('blur-background');
});

/**
 * 
 * @param {*} tag Tag do html, que terá o value sendo limpo, isto é, ficando vazio
 */
function limparCampo(tag){
    campo = document.querySelector(tag);
    campo.value = "";
    }

    /**
     * 
     * @param {*} tag Tag do html onde será realizado a inserção de um novo texto
     * @param {*} texto O que será inserido no html
     */
function passarTextoParaHtml(tag, texto){
        let campo = document.querySelector(tag);
        campo.innerHTML = texto;
    }
    
/**
 * Função responsavel por fazer o fetch do method post
 * <Métodos de controle:> 
 * @throws Campos pergunta e resposta não podem ser vazios
 * É requisitado, é necessário, o envio de um corpo(JSON). 
 * !Os campos devem corresponder ao solicitado na api!
 */
function cadastraQuestoes(){
    iPergunta = document.querySelector(".pergunta").value;
    iResposta = document.querySelector(".resposta").value;
    iPergunta = iPergunta.toLowerCase();
    iPergunta = iPergunta.trim();
    iPergunta = iPergunta.normalize('NFD').replace(/[\u0300-\u036f]/g, '')
    
    fetch("http://localhost:8080/requestMapping/postMapping", // insera o endereço da sua api, se local, permaneça com o localHost, se na nuvem, utilize o endereço de lá
    {
        headers:{
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST", 
        body: JSON.stringify({
            pergunta: iPergunta,
            resposta: iResposta
        }) 
    })
    .then(function (res){console.log(res)}) // retorna o status
    .catch(function (res){console.log(res)})
    limparCampo(".pergunta");
    limparCampo(".resposta");
}


/**
 * Funçao responsavel por obter uma resposta(CORPO JSON) atraves da pergunta.
 */
function obterQuestoes(){
    let pergunta = document.querySelector(".pergunta").value
    pergunta = pergunta.toLowerCase();
    pergunta = pergunta.trim();
    pergunta = pergunta.normalize('NFD').replace(/[\u0300-\u036f]/g, '')
    const params = new URLSearchParams({ // transforma nosso parametro em um URL 
    pergunta // precisa ser mesmo nome que o requisitado na api
    })

    //alert(params) // efetivo para testes, compare com o back end no swagger, será o mesmo endereço composto pela url http://localhost:8080/requestMapping/getMapping? e a pergunta
    fetch(`http://localhost:8080/requestMapping/getMapping?${params}`, 
    {
        headers:{
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "GET", 
    })
    .then(response => response.json())
    .then(Questao=>{
        if(Object.keys(Questao).length == 0){
        passarTextoParaHtml("h4", `Questão não encontrada no banco de dados, adicione ou procure outra questão.`)
        }else{
            let respostaQ = JSON.stringify(Questao, ["pergunta","resposta"]); // variavel que obtem o JSON convertido em string
            passarTextoParaHtml("h4", `${respostaQ}`)
            limparCampo(".pergunta");
        }
    })
}


function obterQ(){
    obterQuestoes();
}

enviarQ.addEventListener('submit', function (event) {
    event.preventDefault();
    cadastraQuestoes();
})