package UI;

import java.util.Scanner;

public class Ui {
    private final Scanner sc = new Scanner(System.in);

    public String readCommand() {
        return sc.nextLine();
    }

    public void show(String msg) {
        System.out.println(msg);
    }

    public void showError(String msg) {
        System.out.println("Error: " + msg);
    }

    public void showWelcome() {
        System.out.println("Hello! I'm John");
        System.out.println("How may I assist you?");
    }

    public void showLine() {
        System.out.println("===================================================");
    }
}
