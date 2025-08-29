import java.util.ArrayList;

public class TaskList {
    private final ArrayList<TaskItem> items = new ArrayList<>();
    private int size = 0;

    public int getSize() { return size; }

    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    public void add(TaskItem t) {
        items.add(t);
        size = items.size();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void remove(int index) {
        TaskItem removedItem = items.remove(index);
        size = items.size();

        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removedItem);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void mark(int index) {
        TaskItem marked = items.get(index);
        marked.markDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + marked);
    }

    public void unmark(int index) {
        TaskItem unmarked = items.get(index);
        unmarked.markUndone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + unmarked);
    }
}
