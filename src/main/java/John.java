import java.util.Scanner;

public class John {
    static class TaskItem {
        private final String name;
        private boolean marked;

        public TaskItem(String name) {
            this.name = name;
            this.marked = false;
        }

        public void markDone() { this.marked = true; }
        public void markUndone() { this.marked = false; }
        public boolean isDone() { return this.marked; }
        public String getName() { return this.name; }

        @Override
        public String toString() {
            return (marked ? "[X] " : "[ ] ") + name;
        }
    }

    static class TaskList {
        private final TaskItem[] items = new TaskItem[100];
        private int size = 0;

        public void add(String name) {
            items[size++] = new TaskItem(name);
            System.out.println("added: " + name);
        }

        public void list() {
            for (int i = 0; i < size; i++) {
                System.out.println((i + 1) + ". " + items[i]);
            }
        }

        public void mark(int index) {
            items[index].markDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("  " + items[index]);
        }

        public void unmark(int index) {
            items[index].markUndone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println("  " + items[index]);
        }

        public int size() { return size; }
    }

    public static void main(String[] args) {
        System.out.println("Hello! I'm John\n");
        System.out.println("How may I assist you?\n");

        Scanner sc = new Scanner(System.in);
        TaskList tasks = new TaskList();

        while(true) {
            String line = sc.nextLine().trim();

            if (line.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (line.equalsIgnoreCase("list")) {
                tasks.list();
            } else if (line.toLowerCase().startsWith("mark")) {
                String arg = line.substring(5).trim();
                int index = Integer.parseInt(arg) - 1;
                tasks.mark(index);
            } else if (line.toLowerCase().startsWith("unmark")) {
                String arg = line.substring(7).trim();
                int index = Integer.parseInt(arg) - 1;
                tasks.unmark(index);
            } else {
                tasks.add(line);
            }
        }
        sc.close();
    }
}
