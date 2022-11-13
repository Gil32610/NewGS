package Studio;

import LinkedList.*;
import Game.*;

public class Publisher {

    private String companyName;

    private SinglyLinkedList<Game> releasedGames;

    public Publisher(String companyName) {
        this.companyName = companyName;
        this.releasedGames = new SinglyLinkedList<>();
    }

    public SinglyLinkedList<Game> getReleasedGames() {

        return releasedGames;
    }

    public void setReleasedGames(SinglyLinkedList<Game> releasedGames) {

        this.releasedGames = releasedGames;
    }

    public void showGames() {
        this.releasedGames.showGames();
    }

    public void addGame(Game g) {
        this.releasedGames.addLast(g);
    }

    public void publishGame(Game g) {
        this.releasedGames.addLast(g);
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Publisher [companyName=" + companyName + "]";
    }

}
