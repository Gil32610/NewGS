package Functions;

import Person.User;
import Person.Developer;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public static int loginChoice() {
        Scanner s = new Scanner(System.in);
        int option;
        System.out.println("Deseja acessar sua conta?\nDigite [1] se voce é Developer\n" +
                "Digite [2] se voce é um cliente\nDigite [0] Para sair do Login");
        option = s.nextInt();
        switch (option) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 0:
                System.out.println("Programa Encerrado!");
                break;
            default:
                System.out.println("Por favor escolha uma das opcoes do menu");
                loginChoice();
        }
        return -1;
    }

    public static User login(ArrayList<User> list) {

        if (list.isEmpty()) {
            return null;
        } else {
            Scanner s = new Scanner(System.in);
            String email;
            String password;
            System.out.println("Informe o email:");
            email = s.nextLine();
            User aUser = new User(email, null);

            if (!list.contains(aUser)) {
                return null;
            }
            aUser = list.get(list.indexOf(aUser));
            System.out.println("Informe a senha:");
            password = s.nextLine();
            if (passwordCheck(aUser, password)) {
                return aUser;
            }
            return null;
        }
    }

    public static boolean passwordCheck(User aUser, String password) {
        Scanner s = new Scanner(System.in);
        int tryCount = 3;

        while (tryCount != 0) {
            if (password.equals(aUser.getPassword())) {
                return true;
            } else {
                System.out.println("Senha incorreta,\nTente Novamente!");
                if (tryCount == 1) {
                    System.out.println("Você só tem mais " + (tryCount) + " tentativa");
                } else {
                    System.out.println("Você só tem mais " + (tryCount) + " tentativas");
                }
                tryCount--;
                password = s.nextLine();
            }
        }
        System.out.println("Numero de tentativas maxima Atingida");
        return false;

    }
}
