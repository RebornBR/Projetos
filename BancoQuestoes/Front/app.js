 const formulario = document.querySelector("form");
 const iPergunta = document.querySelector(".pergunta").value
 const iResposta = document.querySelector(".resposta").value;
const ids = 0;


function cadastraQuestoes(){
    fetch("http://localhost:8080/bancoquestao", 
    {
        headers:{
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            id: ids.value  ,
            pergunta: iPergunta.value,
            Resposta: iResposta.value
        }) 
    })
    .then(function (res){console.log(res)})
    .catch(function (res){console.log(res)})
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    cadastraQuestoes();
});

