const formulario = document.querySelector("form");
function cadastraQuestoes(){
    const iPergunta = document.querySelector(".pergunta").value;
    const iResposta = document.querySelector(".resposta").value;
    alert(`Pergunta: ${iPergunta} // Resposta: ${iResposta} foi enviada ao banco de dados OU NÃO`)
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

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    cadastraQuestoes();
});

