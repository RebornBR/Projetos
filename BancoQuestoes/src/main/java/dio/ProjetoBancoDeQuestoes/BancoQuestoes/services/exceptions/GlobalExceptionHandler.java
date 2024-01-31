package dio.ProjetoBancoDeQuestoes.BancoQuestoes.services.exceptions;
import javax.annotation.Resource;

import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// aqui é onde fica todas as nossas excpetions
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Resource // precisamos inserir dependencia no pom, conferir pom
    private MessageSource messageSource; // pega mensagens de origens das execeçoes executadas
    private HttpHeaders headers(){ //O método headers() retorna um objeto do tipo Headers;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // como nossa mensagem sera retornada, o conteudo será um JSON
        return headers;
    }
    private ResponseError responseError(String message, HttpStatus statusCode){ //O método responseError() retorna o corpo do erro da aplicação;
        ResponseError responseError = new ResponseError(); // estamos criando um novo ResponseError
        responseError.setStatus("error"); // usando o método do ResponseError
        responseError.setError(message); // usando o método do ResponseError
        responseError.setStatusCode(statusCode.value()); // usando o método do ResponseError
        return responseError;
    }
    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) { // O método handleGeneral() intercepta as exceções do sistema e verifica se é uma exceção genérica ou de negócio;
        if (e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request); // O método handleBusinessException() que recebe um BusinessException é destinado a criar um ResponseEntity contendo o nosso ResponseError devidamente estruturado.
            // verifica se é um BusinessException, se for faz o request e monta o response entity
        } else { // se nao for, retornar um erro/mensagem mais generica
            String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
            ResponseError error = responseError(message,HttpStatus.INTERNAL_SERVER_ERROR);
            return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }
    @ExceptionHandler({BusinessException.class}) // nossa class BusinessException
    // Response Entitiy criado pelo handleBusinessException
    //Toda exceção de negócio vai retornar uma resposta HTTP com status code 409 - CONFLICT, pois consideramos exceções de negócio como conflitos de fluxo
    private ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request) {
        ResponseError error = responseError(e.getMessage(),HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }
}