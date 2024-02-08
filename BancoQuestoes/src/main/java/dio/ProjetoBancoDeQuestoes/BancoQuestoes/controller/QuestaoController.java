package dio.ProjetoBancoDeQuestoes.BancoQuestoes.controller;

import dio.ProjetoBancoDeQuestoes.BancoQuestoes.model.Questao;
import dio.ProjetoBancoDeQuestoes.BancoQuestoes.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*" )
@RequestMapping( "/bancoquestao")
public class QuestaoController {

    @Autowired
    private QuestaoRepository Qrepository;
    @PostMapping("/salvar")
    public void salvarQuestao(@RequestBody Questao questao){
        /*
        podemos usar o if aqui mesmo para verificação de null e retorno da exception, e utilizar diretamente o metodo save que extend o JpaRepository, em vez da criação de um método dentro do QuestaoRepository
        *  */
        Qrepository.salvarQ(questao);
    }
    @GetMapping("/obterquestao")
    public List<Questao> listaQuestoes(@RequestParam String pergunta ){
        return (List<Questao>) Qrepository.findByPerguntaContaining(pergunta);
    }
}
