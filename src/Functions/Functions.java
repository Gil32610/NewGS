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

    public static void developGame(User dev) {
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
        dev.getGameList().add(g);
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
    // Estamos utilizando ArrayList<>
    // protected static <T> SinglyListNode<T> searchUser(T content,
    // SinglyLinkedList<T> list) {
    // SinglyListNode<T> auxHead = list.getHead();

    // while (auxHead != null) {
    // if (content.equals(auxHead.getValue())) {
    // return auxHead;
    // }
    // auxHead = auxHead.getNext();
    // }
    // System.out.println("Usuario não foi encontrado");
    // return null;
    // }

    public static void showCatalog(Publisher p) {

        // if (p.getReleasedGames().isEmpty()) {
        //     System.out.println("No games released yet!");
        // } else {
        //     SinglyListNode<Game> current = p.getReleasedGames().getHead();
        //     while (current != null) {
        //         System.out.println(current.getValue());
        //     }
        // }
    }

    private static void devOptions() {
        System.out.println("1 - Desenvolver jogo");
        System.out.println("2- Enviar para publisher padrão");
        System.out.println("0 - Sair");
    }

    private static void clientOptions() {
        System.out.println("1- Comprar jogo");
        System.out.println("2 - Adicionar fundos à sua carteira");
        System.out.println("3 - Ver catálogo");
        System.out.println("0 - Sair");
    }

    public static void developerFunctions(User u, Publisher p) {
        Scanner s = new Scanner(System.in);
        String title;
        Game g;
        int op;
        do {
            devOptions();
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                    developGame(u);
                    break;
                case 2:
                    System.out.println("Informe o titulo do jogo:");
                    title = s.nextLine();
                    g = checkGame(title, u.getGameList());
                    if (g == null) {
                        System.out.println("Jogo não encontrado ou título errado!");
                    } else {
                        p.getReleasedGames().add(g);
                    }
                    break;
                case 0:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);
    }

    public static void userFunctions(User u, Publisher p) {
        Scanner s = new Scanner(System.in);
        String title;
        Game g;
        boolean affordable;
        int op;
        do {
            clientOptions();
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                    System.out.println("Informe o título do jogo:");
                    title = s.nextLine();
                    g = checkGame(title, p.getReleasedGames());
                    if (g == null) {
                        System.out.println("Jogo não existe ou ainda não foi lançado!");
                    } else {
                        affordable = checkFunds(g, u.getWallet());
                        if (affordable) {
                            u.setWallet(-g.getPrice());
                            u.getGameList().add(g);
                        } else {
                            System.out.println();
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    break;
            }

        } while (op != 0);
    }

    public static void addFunds(User u, double value) {
        u.setWallet(value);
    }

    public static Game checkGame(String title, ArrayList<Game> list) {
        Game g = new Game(title);
        if (list.contains(g)) {
            return list.get(list.indexOf(g));
        } else {
            return null;
        }

    }

    public static boolean checkFunds(Game g, double wallet) {
        if (g.getPrice() > wallet) {
            return false;
        } else {
            return true;
        }
    }

}
