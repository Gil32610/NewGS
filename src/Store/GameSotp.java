package Store;

import Functions.*;
import Person.Developer;
import Person.User;
import Studio.Publisher;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;
import static java.lang.Character.toLowerCase;
import java.util.ArrayList;

public class GameSotp {
    public static void main(String[] args) {
        ArrayList<User> customerList = new ArrayList<>();
        ArrayList<User> devList = new ArrayList<>();
        Publisher standard = new Publisher("SPM");
        Scanner s = new Scanner(System.in);
        int intOption;
        do {
            options();
            intOption = Integer.parseInt(s.nextLine());
            switch (intOption) {
                case 1:
                Register(customerList, false);
                    break;
                case 2:
                Register(devList, true);
                    break;
                case 3:
                intOption = Login.loginChoice();
                if (intOption == 1) {
                    Login.login(devList);
                } else if (intOption == 2) {
                    Login.login(customerList);
                }
                    break;
                case 4:
                Functions.showCatalog(standard);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (intOption != 0);

        intOption = Login.loginChoice();
        if (intOption == 1) {
            Login.login(devList);
        } else if (intOption == 2) {
            Login.login(customerList);
        }
        System.out.println("Acabou esta porra");
    }

    public static void Register(ArrayList<User> list, boolean flag) {
        list.add(Functions.registerConsole(flag));
    }

    public static void options() {
        System.out.println("1 - Registrar como cliente");
        System.out.println("2 - Registrar como desenvolvedor");
        System.out.println("3 - Login");
        System.out.println("4 - Ver catálogo");
        System.out.println("0 - Encerrar");
    }

    public static void content(Publisher p){
        Functions.showCatalog(p);
    }

}