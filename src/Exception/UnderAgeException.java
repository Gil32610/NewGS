package Exception;

public class UnderAgeException extends RuntimeException {
    public UnderAgeException(){
        super("Você não possui idade o suficiente para acessar este conteúdo!");
    }


}
