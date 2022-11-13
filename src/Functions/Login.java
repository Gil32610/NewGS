package Functions;

import LinkedList.SinglyLinkedList;
import LinkedList.SinglyListNode;
import Person.User;

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
        boolean passwordCheckFlag;
        SinglyListNode userNode;
        System.out.println("Qual o seu usuario?");
        user = s.nextLine();
        userNode = list.search(user);
        if(userNode == null){
            System.out.println("Tente Novamente");
            login(list);
        }else{
            System.out.println("Qual a sua Senha?");
            password = s.nextLine();
            passwordCheckFlag = passwordCheck(userNode,password);
            if(passwordCheckFlag){
                System.out.println("Senha Correta");
                // Menu especifico login
            }else{
                // Retornar pro menu inicial
            }
        }
    }
    public static boolean passwordCheck(SinglyListNode<User> node,String password){
        Scanner s = new Scanner(System.in);
        int tryCount = 3;
        while(tryCount != 0){
            if(password.equals(node.getValue().getPassword())){
                return true;
            }else{
                System.out.println("Senha incorreta,\nTente Novamente!");
                if (tryCount == 1){
                    System.out.println("Você só tem mais " + (tryCount) + " tentativa");
                }else{
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

