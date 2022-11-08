package Exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(){
        super("Saldo insuficiente");
    }
}
