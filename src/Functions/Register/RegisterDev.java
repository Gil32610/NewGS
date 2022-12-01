package Functions.Register;


import Person.Developer;
import Person.User;

import java.util.Scanner;

public class RegisterDev implements RegisterStrategy {
    public User registerConsole() {
        Scanner s = new Scanner(System.in);
        String fullName, email, nationality, cpf, username, password;
        Integer age;
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

        return dev = new Developer(cpf, fullName, nationality, email, username, age, password);

    }
}
