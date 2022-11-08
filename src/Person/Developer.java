package Person;

import java.util.Scanner;
import LinkedList.*;
import Studio.Publisher;
import Game.*;

public class Developer extends Person {

    private String username;
    private String password;

    public Developer(String fullname, String nationality, String username, String password) {

        super(fullname, nationality);
        this.username = username;
        this.password = password;
    }

    public void sendGamePublisher(Publisher p) {
        Scanner s = new Scanner(System.in);
        String gameTitle, genre;
        AgeRating ageRating = AgeRating.L;
        Integer releaseDate;
        double price;
        Game g;
        System.out.println("Informe ");
        gameTitle = s.nextLine();
        System.out.println("Informe ");
        genre = s.nextLine();
        age();
        ageRating = rating(Integer.parseInt(s.nextLine()));
        System.out.println("Informe ");
        releaseDate = Integer.parseInt(s.nextLine());
        System.out.println("Informe ");
        price = Double.parseDouble(s.nextLine());
        g = new Game(gameTitle, ageRating, genre, releaseDate, price);
        p.addGame(g);
    }

    private AgeRating rating(int i) {

        switch (i) {
            case 1:
                return AgeRating.L;
            case 2:
                return AgeRating.M10;
            case 3:
                return AgeRating.M12;

            case 4:
                return AgeRating.M14;
            case 5:
                return AgeRating.M16;
            case 6:
                return AgeRating.M18;
            default:
                return null;

        }
    }

    private void age() {
        System.out.println("1- classificação livre\n" + "2- Não recomendado para menores de 10 anos\n"
                + "3 - Não recomendado para menores de 12 anos\n" + "4 - Não recomendado para menores de 14 anos\n"
                + "5 - Não recomendado para menores de 16 anos\n" + "6 - Não recomendado para menores de 18 anos");

    }

}
