package dio.ProjetoBancoDeQuestoes.BancoQuestoes.repository;

import dio.ProjetoBancoDeQuestoes.BancoQuestoes.model.Questao;
import dio.ProjetoBancoDeQuestoes.BancoQuestoes.services.exceptions.CamposObrigatoriosException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {
        default void salvarQ(@RequestBody Questao questao){ // podemos fazer isso e utilizar diretamente o metodo save, no QuestaoController
        if(questao.getPergunta() == null){
            throw new CamposObrigatoriosException("{PERGUNTA}");
        }
        if(questao.getResposta() == null){
            throw  new CamposObrigatoriosException("{RESPOSTA}");
        }
        save(questao);
    }


    List<Questao> findByPerguntaContaining(@Param("pergunta")String pergunta);
 /*
 Ou podemos utilizar apenas:
 List<Questao> findBypergunta(String pergunta);
 é reconhecido automaticamente pelo JPA, findByNomeParametroPresenteEmQuestao(tipo e nome parametro)
  */
}
