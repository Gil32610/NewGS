package Studio;

import LinkedList.*;
import Game.*;

public class Publisher {

    private SinglyLinkedList<Game> releasedGames;

    public Publisher() {
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

}
