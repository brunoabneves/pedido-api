package store.ojuara.pedidoapi.shared.exception;

public class RegraDeNegocioException extends RuntimeException{

    private Integer status;

    public Integer status() {
        return this.status;
    }

    public RegraDeNegocioException(String message){
        super(message);
    }

    public RegraDeNegocioException(Integer status, String message){
        super(message);
        this.status = status;
    }
}
