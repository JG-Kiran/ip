package Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mutable collection of {@link TaskItem} with convenience operations used by commands,
 * such as add/remove/mark/unmark, indexed access, searching, and safe viewing.
 */
public class TaskList {
    private final ArrayList<TaskItem> items = new ArrayList<>();
    private int size = 0;

    /**
     * Returns the number of tasks in the list.
     *
     * @return size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns a read-only snapshot view of the tasks in insertion order.
     *
     * @return an unmodifiable list of tasks
     */
    public List<TaskItem> view() {
        return Collections.unmodifiableList(items);
    }

    /**
     * Prints all the tasks in a notepad-like format.
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    /**
     * Adds a task to the end of the list.
     *
     * @param t task to add
     */
    public void add(TaskItem t) {
        items.add(t);
        size = items.size();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Removes the task at the given 0-based index.
     *
     * @param index zero-based index of the task to remove
     */
    public void remove(int index) {
        TaskItem removedItem = items.remove(index);
        size = items.size();

        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removedItem);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Marks the task at the given index as done.
     *
     * @param index zero-based index of the task to mark
     */
    public void mark(int index) {
        TaskItem marked = items.get(index);
        marked.markDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + marked);
    }

    /**
     * Unmarks the task at the given index as not done.
     *
     * @param index zero-based index of the task to unmark
     */
    public void unmark(int index) {
        TaskItem unmarked = items.get(index);
        unmarked.markUndone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + unmarked);
    }
}
