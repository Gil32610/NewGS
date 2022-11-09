package Functions;

import LinkedList.SinglyLinkedList;
import LinkedList.SinglyListNode;

import java.util.Scanner;

public class Login {
    public static int loginChoice(){
        Scanner s = new Scanner(System.in);
        int option;
        System.out.println("Deseja acessar sua conta?\nDigite [1] se voce é Developer\n" +
                "Digite [2] se voce é um cliente\nDigite [0] Para sair do Login");
        option = s.nextInt();
        switch(option){
            case 1 :
                return 1;
            case 2 :
                return 2;
            case 0 :
                System.out.println("Programa Encerrado!");
                break;
            default:
                System.out.println("Por favor escolha uma das opcoes do menu");
                loginChoice();
        }
        return -1;
    }
    public static void login(SinglyLinkedList list){
        Scanner s = new Scanner(System.in);
        String user,password;
        SinglyListNode userNode;
        System.out.println("Qual o seu usuario?");
        user = s.nextLine();
        userNode = Functions.searchUser(user,list);
        if(userNode == null){
            System.out.println("Tente Novamente");
            login(list);
        }else{
            //passwordCheck(userNode);
        }
    }
 /*   public static boolean passwordCheck(SinglyListNode node){

        if(node.getValue().ge == null){
            System.out.println("Senha errada ou não encontra no nosso sistema\nTente Novamente!");

        }
    }*/
}

