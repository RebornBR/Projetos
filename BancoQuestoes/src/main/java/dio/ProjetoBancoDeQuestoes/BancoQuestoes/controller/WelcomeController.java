package dio.ProjetoBancoDeQuestoes.BancoQuestoes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping // indica que o método é um recurso http do tipo get
    public String welcome(){
        return "Bem-vindo ao Banco de Questões";
    }
}
