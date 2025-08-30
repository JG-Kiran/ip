package UI;

import java.util.Scanner;

public class Ui {
    private final Scanner sc = new Scanner(System.in);

    /**
     * Reads a line of user input from the input stream.
     *
     * @return the raw user command string (without trailing newline)
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Prints an error message in a consistent UI style.
     *
     * @param msg error text to show
     */
    public static void showError(String msg) {
        System.out.println("Error: " + msg);
    }

    /**
     * Prints the welcome banner and any initial help text.
     */
    public static void showWelcome() {
        System.out.println("Hello! I'm John");
        System.out.println("How may I assist you?");
    }

    /**
     * Prints a horizontal rule or divider line to separate sections.
     */
    public static void showLine() {
        System.out.println("===================================================");
    }
}
