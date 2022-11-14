package Functions;

import Game.Game;
import Game.ageRating;
import LinkedList.SinglyLinkedList;
import LinkedList.SinglyListNode;
import Person.Developer;
import Person.User;
import Studio.Publisher;
import java.util.ArrayList;

import java.util.Scanner;

public class Functions {
    public static User registerConsole(boolean flag) {
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
            return dev = new Developer(cpf, fullName, nationality, email, username, age, password);
        } else {
            return user = new User(cpf, fullName, nationality, email, username, age, password);
        }
    }

    public static void developGame(ArrayList<Game> list) {
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
        System.out.println("Informe o ano de lançamento: ");
        releaseDate = Integer.parseInt(s.nextLine());
        System.out.println("Informe o preço");
        price = Double.parseDouble(s.nextLine());
        g = new Game(gameTitle, ageRating, genre, releaseDate, price);
        list.add(g);
    }

    public void sendGamePublisher(Publisher p, Game g) {
        p.addGame(g);
    }

    // acessa vetor de enum com indice
    private static ageRating rating(int i) {
        return ageRating.values()[i];
    }

    private static void age() {
        System.out.println("1- classificação livre\n" + "2- Não recomendado para menores de 10 anos\n"
                + "3 - Não recomendado para menores de 12 anos\n" + "4 - Não recomendado para menores de 14 anos\n"
                + "5 - Não recomendado para menores de 16 anos\n" + "6 - Não recomendado para menores de 18 anos");

    }

    // método de busca já implementado na classe linkedlist
    // Reaproveitando método de busca
    protected static <T> SinglyListNode<T> searchUser(T content, SinglyLinkedList<T> list) {
        SinglyListNode<T> auxHead = list.getHead();

        while (auxHead != null) {
            if (content.equals(auxHead.getValue())) {
                return auxHead;
            }
            auxHead = auxHead.getNext();
        }
        System.out.println("Usuario não foi encontrado");
        return null;
    }

    public static void showCatalog(Publisher p) {

        if (p.getReleasedGames().isEmpty()) {
            System.out.println("No games released yet!");
        } else {
            SinglyListNode<Game> current = p.getReleasedGames().getHead();
            while (current != null) {
                System.out.println(current.getValue());
            }
        }
    }

    public static void developerFunctions(Developer dev) {

    }

    public static void userFunctions(User u) {

    }

}
