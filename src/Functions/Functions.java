package Functions;

import Game.Game;
import Game.ageRating;
import LinkedList.SinglyLinkedList;
import LinkedList.SinglyListNode;
import Person.Developer;
import Person.User;
import Studio.Publisher;

import java.util.Scanner;

public class Functions {
    public static <T> T registerConsole(boolean flag) {
        Scanner s = new Scanner(System.in);
        String fullName, email, nationality, cpf, username, password;
        Integer age;
        User user;
        Developer dev;

        System.out.println("Informe o seu nome completo: ");
        fullName = s.nextLine();
        System.out.println("Informe a sua nacionalidade: ");
        nationality = s.nextLine();
        System.out.println("Informe o seu CPF: ");
        cpf = s.nextLine();
        System.out.println("Informe o seu email:");
        email = s.nextLine();
        System.out.println("Informe a sua idade: ");
        age = Integer.parseInt(s.nextLine());
        System.out.println("Informe o nome de usuário desejado: ");
        username = s.nextLine();
        System.out.println("Informe a senha desejada: ");
        password = s.nextLine();
        while (age < 0) {
            System.out.println("Idade inválida! Digite novamente:");
            age = Integer.parseInt(s.nextLine());
        }
        if (flag) {
            return (T) (dev = new Developer(cpf, fullName, nationality, email, username, age, password));
        } else {
            return (T) (user = new User(cpf, fullName, nationality, email, username, age, password));
        }
    }

    public void sendGamePublisher(Publisher p) {
        Scanner s = new Scanner(System.in);
        String gameTitle, genre;
        ageRating ageRating;
        Integer releaseDate;
        double price;
        Game g;
        System.out.println("Informe o titulo do seu jogo");
        gameTitle = s.nextLine();
        System.out.println("Informe o Genero do seu jogo");
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

    private ageRating rating(int i) {
                return ageRating.values()[i];
    }

    private void age() {
        System.out.println("1- classificação livre\n" + "2- Não recomendado para menores de 10 anos\n"
                + "3 - Não recomendado para menores de 12 anos\n" + "4 - Não recomendado para menores de 14 anos\n"
                + "5 - Não recomendado para menores de 16 anos\n" + "6 - Não recomendado para menores de 18 anos");

    }

    protected static SinglyListNode searchUser(String string, SinglyLinkedList list) {
        SinglyListNode<User> auxHead = list.getHead();
        String Value;
        Value = auxHead.getValue().getPassword();

        while (auxHead != null) {
            if (string.equals(auxHead.getValue())) {
                return auxHead;
            }
            auxHead = auxHead.getNext();
        }
        System.out.println("Usuario nao foi encontrado");
        return null;
    }

    public void showCatalog(Publisher p) {

        if (p.getReleasedGames().isEmpty()) {
            System.out.println("No games released yet!");
        } else {
            SinglyListNode<Game> current = p.getReleasedGames().getHead();
            while (current != null) {
                System.out.println(current.getValue());
            }
        }
    }

}
