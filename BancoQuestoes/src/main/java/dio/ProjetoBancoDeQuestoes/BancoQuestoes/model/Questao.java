package dio.ProjetoBancoDeQuestoes.BancoQuestoes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tabela_Questoes")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column(length = 5000, nullable = false)
    private String pergunta;

    @Column(length = 500 , nullable = false)
    private  String resposta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Questao{" +
                "id=" + id +
                ", pergunta='" + pergunta + '\'' +
                ", resposta='" + resposta + '\'' +
                '}';
    }
}
