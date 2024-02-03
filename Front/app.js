const formulario = document.querySelector("form");
let iPergunta;
let iResposta;
formulario.addEventListener('focusin', function () {
    document.body.classList.add('blur-background');
});

formulario.addEventListener('focusout', function () {
    document.body.classList.remove('blur-background');
});

function limparCampo(tag){
    campo = document.querySelector(tag);
    campo.value = "";
    }


function cadastraQuestoes(){
    iPergunta = document.querySelector(".pergunta").value;
    iResposta = document.querySelector(".resposta").value;
    if(iPergunta == ""){

        alert("Pergunta não pode ser vazia ");

    }else if(iResposta == ""){
        
        alert("Resposta não pode ser vazia ");

    }else{
    alert(`Pergunta: ${iPergunta} // Resposta: ${iResposta}  foi enviada e salva no banco de dados.`)
    fetch("http://localhost:8080/bancoquestao/salvar",
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
    .then(function (res){console.log(res)})
    .catch(function (res){console.log(res)})
}
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    cadastraQuestoes();
    limparCampo(".pergunta");
    limparCampo(".resposta");
});
