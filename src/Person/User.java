package Person;

import LinkedList.*;

import java.rmi.server.UID;

import Exception.InsufficientFundsException;
import Game.*;

public class User extends Person {
    private String email;
    private String username;
    private String password;
    private Double wallet;
    private SinglyLinkedList<Game> gameList;

    public User(String email, String fullName) {
        super(fullName);
        this.email = email;
    }

    public User(String cpf, String fullName, String nationality, String email, String username,
            Integer age, String password) {
        super(cpf, fullName, nationality, age);
        this.email = email;
        this.username = username;
        this.gameList = new SinglyLinkedList<>();
        this.wallet = 0.0;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void addGame(Game g) {
        this.gameList.addLast(g);
    }

    public double getWallet() {
        return this.wallet;
    }

    public void setWallet(double value) {
        this.wallet += value;
    }

    public void buyContent(Double value) throws InsufficientFundsException {
        if (!(wallet - value < 0)) {
            this.wallet -= value;
        } else {
            throw new InsufficientFundsException();
        }
    }

    @Override
    public boolean equals(Object u) {
        if (u instanceof User) {
            User aUser = (User) u;
            return this.email.equals(aUser.email);
        } else {
            return false;
        }
    }

}
