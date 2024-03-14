package store.ojuara.pedidoapi.shared.exception;

public class PedidoException extends RuntimeException{

    private Integer status;

    public Integer status() {
        return this.status;
    }

    public PedidoException(String message){
        super(message);
    }

    public PedidoException(Integer status, String message){
        super(message);
        this.status = status;
    }
}
