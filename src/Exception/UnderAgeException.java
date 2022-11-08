package Exception;

public class UnderAgeException extends RuntimeException {
    public UnderAgeException(){
        super("Você não é velho o suficiente para este conteúdo!");
    }


}
