package Functions.Register;

import Person.Developer;
import Person.User;

import java.util.Scanner;

public class RegisterUser implements RegisterStrategy {
    public User registerConsole() {
        Scanner s = new Scanner(System.in);
        String fullName, email, nationality, cpf, username, password;
        Integer age;
        User user;

        System.out.println("Informe o seu nome completo: ");
        fullName = s.nextLine();
        System.out.println("Informe a sua nacionalidade: ");
        nationality = s.nextLine();
        System.out.println("Informe o seu CPF, apenas os numeros: ");
        cpf = s.nextLine();

        int cpfSize = cpf.length();

        while (cpfSize !=11){
            System.out.println("CPF inválido! Digite novamente");
            cpf = s.nextLine();
            cpfSize = cpf.length();
        }
        System.out.println("Informe o seu email:");
        email = s.nextLine();

        System.out.println("Informe a sua idade: ");
        age = Integer.parseInt(s.nextLine());
        while (age < 0) {
            System.out.println("Idade inválida! Digite novamente: ");
            age = Integer.parseInt(s.nextLine());
        }

        System.out.println("Informe o nome de usuário desejado: ");
        username = s.nextLine();
        System.out.println("Informe a senha desejada: ");
        password = s.nextLine();
        System.out.println();
        System.out.println("Cadastro realizado com sucesso");
        System.out.println();

        return user = new User(cpf, fullName, nationality, email, username, age, password);
        }
    }

