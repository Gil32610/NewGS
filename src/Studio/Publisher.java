package Studio;

import LinkedList.*;
import Game.*;
import java.util.ArrayList;

public class Publisher {

    private String companyName;

    private ArrayList<Game> releasedGames;

    private double balance;

    public Publisher(String companyName) {
        this.companyName = companyName;
        this.releasedGames = new ArrayList<>();
    }

    public ArrayList<Game> getReleasedGames() {

        return releasedGames;
    }

    public void setReleasedGames(ArrayList<Game> releasedGames) {

        this.releasedGames = releasedGames;
    }

    public void addGame(Game g) {
        this.releasedGames.add(g);
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    @Override
    public String toString() {
        return "Publisher [companyName=" + companyName + "]";
    }
}
