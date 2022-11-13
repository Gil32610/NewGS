package Store;

import Functions.*;
import Person.Developer;
import Person.User;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;
import static java.lang.Character.toLowerCase;
import java.util.ArrayList;

public class GameSotp {
    public static void main(String[] args) {
        ArrayList<User> customerList = new ArrayList<>();
        ArrayList<User> devList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int intOption;
        char option;
        System.out.println("Deseja fazer um registro como Developer?(S/N)");
        option = toLowerCase(s.next().charAt(0));
        switch (option) {
            case 's':
                System.out.println("Prosseguindo registro como developer!");
                devList.add(Functions.registerConsole(true));
                break;
            case 'n':
                System.out.println("Prosseguindo registro como cliente!");
                customerList.add(Functions.registerConsole(false));
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        intOption = Login.loginChoice();
        if (intOption == 1) {
            Login.login(devList);
        } else if (intOption == 2) {
            Login.login(customerList);
        }
        System.out.println("Acabou esta porra");
    }
}