import java.util.Scanner;

public class John {
    public static void main(String[] args) {
        System.out.println("Hello! I'm John\n");
        System.out.println("How may I assist you?\n");

        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            System.out.println(line);
        }
        sc.close();
    }
}
