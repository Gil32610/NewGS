package Main;

import Functions.Register.*;
import Functions.*;
import Store.*;
import Person.*;
import java.util.ArrayList;
import java.util.Scanner;
import Functions.Login;

public class Main {
    public static void main(String[] args) {
        GameSotp newGs = new GameSotp();
        Scanner s = new Scanner(System.in);
        User aUser;
        User aDev;
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
                        aUser = Login.login(newGs.getDevList());
                        if (aUser == null) {
                            System.out.println("Usuário não existe ou senha incorreta!");
                        } else {
                            Functions.developerFunctions(aUser, newGs.getStandard());
                        }

                    } else if (intOption == 2) {
                        aDev = Login.login(newGs.getUserList());
                        if (aDev == null) {
                            System.out.println("Usuário não existe ou senha incorret!");
                        } else {
                            Functions.userFunctions(aDev, newGs.getStandard());
                        }
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
        System.out.println();
        System.out.println("Bem vindo à loja GameSotp, selecione uma opção abaixo usando os numeros de 0 a 4");
        System.out.println();
        System.out.println("1 - Registrar como cliente");
        System.out.println("2 - Registrar como desenvolvedor");
        System.out.println("3 - Login");
        System.out.println("4 - Ver catálogo");
        System.out.println("0 - Encerrar");
        System.out.println();
    }

    public static void Register(ArrayList<User> list, boolean flag) {
        RegisterStrategy registro;
        if(flag){
            registro = new RegisterDev();
        }else{
            registro = new RegisterUser();
        }
        list.add(registro.registerConsole());
    }
}
