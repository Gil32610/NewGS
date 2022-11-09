package Store;
import Functions.*;
import Person.Developer;
import Person.User;
import LinkedList.SinglyLinkedList;
import java.util.Scanner;
import static java.lang.Character.toLowerCase;

public class GameSotp {
    public static void main(String[] args) {
        SinglyLinkedList<User> customerList = new SinglyLinkedList<>();
        SinglyLinkedList<Developer> devList = new SinglyLinkedList<>();
        Scanner s = new Scanner(System.in);
        int intOption;
        char option;
        System.out.println("Deseja fazer um registro como Developer?(S/N)");
        option = toLowerCase(s.next().charAt(0));
        switch (option) {
            case 's':
                System.out.println("Prosseguindo registro como developer!");
                devList.addFirst(Functions.registerConsole(true));
                break;
            case 'n':
                System.out.println("Prosseguindo registro como cliente!");
                customerList.addFirst(Functions.registerConsole(false));
                break;
        }
        intOption = Login.loginChoice();
        if(intOption == 1){
            Login.login(devList);
        }else if(intOption == 2){
            Login.login(customerList);
        }
    }
}