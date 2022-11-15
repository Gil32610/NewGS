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
    private ArrayList<User> userList;
    private ArrayList<User> devList;
    private Publisher standard;

    public GameSotp() {
        this.userList = new ArrayList<>();
        this.devList = new ArrayList<>();
        this.standard = new Publisher("SPM");
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<User> getDevList() {
        return devList;
    }

    public void setDevList(ArrayList<User> devList) {
        this.devList = devList;
    }

    public Publisher getStandard() {
        return standard;
    }

    public void setStandard(Publisher standard) {
        this.standard = standard;
    }

}