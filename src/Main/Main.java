package Main;

import Store.*;
import Person.*;
import Game.*;
import Functions.Functions;
import Exception.*;
import java.util.ArrayList;
import java.util.Scanner;
import Functions.Login;

public class Main {
    public static void main(String[] args) {
        GameSotp newGs = new GameSotp();
        Scanner s = new Scanner(System.in);
        int intOption;
        do {
            options();
            intOption = Integer.parseInt(s.nextLine());
            switch (intOption) {
                case 1:
                    Register(newGs.getUserList(), false);
                    break;
                case 2:
                    Register(newGs.getDevList(), true);
                    break;
                case 3:
                    intOption = Login.loginChoice();
                    if (intOption == 1) {
                        Login.login(newGs.getDevList());
                    } else if (intOption == 2) {
                        Login.login(newGs.getUserList());
                    }
                    break;
                case 4:
                    Functions.showCatalog(newGs.getStandard());
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (intOption != 0);

    }

    public static void options() {
        System.out.println("1 - Registrar como cliente");
        System.out.println("2 - Registrar como desenvolvedor");
        System.out.println("3 - Login");
        System.out.println("4 - Ver catálogo");
        System.out.println("0 - Encerrar");
    }

    public static void Register(ArrayList<User> list, boolean flag) {
        list.add(Functions.registerConsole(flag));
    }
}
