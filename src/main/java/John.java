import java.util.ArrayList;
import java.util.Scanner;

public class John {
    public static void main(String[] args) {
        System.out.println("Hello! I'm John\n");
        System.out.println("How may I assist you?\n");

        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while(true) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (line.equalsIgnoreCase("list")) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            } else {
                tasks.add(line);
                System.out.println("added: " + line);
            }
        }
        sc.close();
    }
}
