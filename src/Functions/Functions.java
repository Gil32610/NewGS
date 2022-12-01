package Functions;

import Game.Game;
import Game.ageRating;
import Person.Developer;
import Person.User;
import Studio.Publisher;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exception.InsufficientFundsException;
import Exception.UnderAgeException;

public class Functions {

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
        try {
            ageRating = rating(Integer.parseInt(s.nextLine()));
        } catch (IndexOutOfBoundsException io) {
            System.out.println("Classificação inválida, informe valores de 0 a 5:");
            ageRating = rating(Integer.parseInt(s.nextLine()));
        } catch (NumberFormatException im) {
            System.out.println("Entrada inválida. Digite um número de 0 a 5");
            ageRating = rating(Integer.parseInt(s.nextLine()));
        }
        System.out.println("Informe o ano de lançamento: ");
        releaseDate = Integer.parseInt(s.nextLine());
        while(releaseDate < 1980 || releaseDate > 2022){

            System.out.println("Data de lançamento inválida - Insira Novamente!");
            releaseDate = Integer.parseInt(s.nextLine());
        }
        System.out.println("Informe o preço");
        price = Double.parseDouble(s.nextLine());
        while(price < 0){

            System.out.println("Preço inválido - Insira Novamente!");
            price = Integer.parseInt(s.nextLine());
        }
        g = new Game(gameTitle, ageRating, genre, releaseDate, price);
        dev.getGameList().add(g);
    }

    public static void sendGamePublisher(Publisher p, Game g) {
        p.getReleasedGames().add(g);
        System.out.println("Jogo enviado!");
    }

    // acessa vetor de enum com indice
    private static ageRating rating(int i) throws ArrayIndexOutOfBoundsException {
        return ageRating.values()[i];
    }

    private static void age() {
        System.out.println("0- classificação livre\n" + "1- Não recomendado para menores de 10 anos\n"
                + "2 - Não recomendado para menores de 12 anos\n" + "3 - Não recomendado para menores de 14 anos\n"
                + "4 - Não recomendado para menores de 16 anos\n" + "5 - Não recomendado para menores de 18 anos");

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
        // System.out.println("No games released yet!");
        // } else {
        // SinglyListNode<Game> current = p.getReleasedGames().getHead();
        // while (current != null) {
        // System.out.println(current.getValue());
        // }
        // }
        if (p.getReleasedGames().isEmpty()) {
            System.out.println("No games released yet!");
        } else {

            int publisherSize = p.getReleasedGames().size();
            ArrayList<Game> game = p.getReleasedGames();
            for (int i = 0; i < publisherSize; i++) {
                System.out.println(game.get(i));
            }
        }

    }

    private static void devOptions() {
        System.out.println("1 - Desenvolver jogo");
        System.out.println("2 - Enviar para publisher padrão");
        System.out.println("3 - Ver meus jogos");
        System.out.println("0 - Sair");
    }

    private static void clientOptions() {
        System.out.println("1 - Comprar jogo");
        System.out.println("2 - Adicionar fundos à sua carteira");
        System.out.println("3 - Ver catálogo");
        System.out.println("4 - Ver meus jogos");
        System.out.println("5 - Minha carteira");
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
                        sendGamePublisher(p, g);
                    }
                    break;
                case 3:
                    showMyList(u);
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
        double value;
        boolean affordable, ageCheck;
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
                        ageCheck = checkAge(g, u);
                        try {
                            if (!ageCheck) {
                                throw new UnderAgeException();
                            }
                        } catch (UnderAgeException ua) {
                            System.out.println(ua.getMessage());
                            break;
                        }
                        affordable = checkFunds(g, u.getWallet());
                        try {
                            if (!affordable) {
                                throw new InsufficientFundsException();
                            }
                        } catch (InsufficientFundsException is) {
                            System.out.println(is.getMessage());
                            break;
                        }
                        u.setWallet(-g.getPrice());
                        p.setBalance(g.getPrice());
                        u.getGameList().add(g);
                        g.sale();
                        System.out.println("Jogo comprado!");
                    }

                    break;
                case 2:
                    System.out.println("Informe o valor desejado:");
                    value = Double.parseDouble(s.nextLine());
                    addFunds(u, value);
                    break;
                case 3:
                    showCatalog(p);
                    break;

                case 4:
                    showMyList(u);
                    break;
                case 5:
                    myWallet(u);
                    break;
                case 0:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção não disponível!");
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

    public static boolean checkAge(Game g, User u) {
        ageRating anAge = g.getRating();
        int age = u.getAge();

        if (anAge == ageRating.L) {
            return true;
        } else if (anAge == ageRating.M10 && age >= 10) {
            return true;
        } else if (anAge == ageRating.M12 && age >= 12) {
            return true;
        } else if (anAge == ageRating.M14 && age >= 14) {
            return true;
        } else if (anAge == ageRating.M16 && age >= 16) {
            return true;
        } else if (anAge == ageRating.M18 && age >= 18) {
            return true;
        }
        return false;

    }

    public static void showMyList(User u) {
        ArrayList<Game> game = u.getGameList();
        int size = game.size();
        for (int i = 0; i < size; i++) {
            System.out.println(game.get(i));
        }
    }

    public static void myWallet(User u) {
        System.out.println("Sua carteira: " + u.getWallet());
    }

}
