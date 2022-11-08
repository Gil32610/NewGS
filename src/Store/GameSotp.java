package Store;

import Person.*;
import LinkedList.*;
import Game.*;
import java.util.Scanner;
import Game.AgeRating;

public class GameSotp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String fullname, email, nationality, cpf, username;
        Integer age;
        Game g;
        User user;
        AgeRating aRating;
        int op, i;

        System.out.println("Informe o nome completo: ");
        fullname = s.nextLine();
        System.out.println("Informe a nacionalidade: ");
        nationality = s.nextLine();
        System.out.println("Informe o CPF: ");
        cpf = s.nextLine();
        System.out.println("Informe o email:");
        email = s.nextLine();
        System.out.println("Informe o nome de usuário: ");
        username = s.nextLine();
        System.out.println("Informe a idade: ");
        age = Integer.parseInt(s.nextLine());
        while (age < 0) {
            System.out.println("Idade inválida! Digite novamente:");
            age = Integer.parseInt(s.nextLine());
        }
        user = new User(cpf, fullname, nationality, email, username, age);

    }

}
