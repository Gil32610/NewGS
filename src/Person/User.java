package Person;

import LinkedList.*;
import Exception.InsufficientFundsException;
import Game.*;

public class User extends Person {
    private String email;
    private String username;
    private Integer age;
    private Double wallet;
    private SinglyLinkedList<Game> gameList;

    public User(String cpf, String fullname, String nationality, String email, String username, Integer age) {
        super(cpf, fullname, nationality);
        this.email = email;
        this.username = username;
        this.age = age;
        this.gameList = new SinglyLinkedList<>();
        this.wallet = 0.0;

    }

    public void addGame(Game g) {
        this.gameList.addLast(g);
    }

    public void addFunds(Double value) {
        this.wallet += value;
    }

    public void buyContent(Double value) throws InsufficientFundsException {
        if (!(wallet - value < 0)) {
            this.wallet -= value;
        }else{
            throw new InsufficientFundsException();
        }
    }

}
