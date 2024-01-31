package dio.ProjetoBancoDeQuestoes.BancoQuestoes.services.exceptions;

import java.util.Date;

public class ResponseError {
    private Date timestamp = new Date(); // momento em que ocorrer a exceção
    private String status = "error";  // campos customizado, qual é o tipo da exceção
    private int statusCode = 400; // campo que indica o erro
    private String error; // mensagem apresentada ao usuario quando ocorre a exceção

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

