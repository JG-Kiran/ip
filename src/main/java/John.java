import Tasks.Deadline;
import Tasks.Event;
import Tasks.TaskItem;
import Tasks.TaskList;
import Tasks.Todo;

import java.util.Scanner;

public class John {
    private static final Storage storage = new Storage();
    private static final TaskList tasks = storage.load();

    public static void main(String[] args) {
        System.out.println("Hello! I'm John");
        System.out.println("How may I assist you?");

        Scanner sc = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit && sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            try {
                if (line.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    isExit = true;
                } else if (line.equals("list")) {
                    tasks.list();
                } else if (line.startsWith("mark")) {
                    handleMark(line);
                } else if (line.startsWith("unmark")) {
                    handleUnmark(line);
                } else if (line.startsWith("todo")) {
                    handleTodo(line);
                } else if (line.startsWith("deadline")) {
                    handleDeadline(line);
                } else if (line.startsWith("event")) {
                    handleEvent(line);
                } else if (line.startsWith("delete")) {
                    handleDelete(line);
                } else {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            } finally {
                storage.save(tasks);
            }
        }
    }

    private static void handleTodo(String line) throws DukeException {
        String desc = line.substring(4).trim();

        if (desc.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }

        TaskItem t = new Todo(desc, false);
        tasks.add(t);
    }

    private static void handleDeadline(String line) throws DukeException {
        String desc = line.substring(8).trim();

        if (!desc.contains("/by")) {
            throw new DukeException("☹ OOPS!!! The description of a deadline must have '/by'.");
        }

        String[] deadline = desc.split("/by", 2);

        if (deadline[0].trim().isEmpty()) {
            throw new DukeException("☹ OOPS!!! The deadline description cannot be empty.");
        }

        if (deadline[1].trim().isEmpty()) {
            throw new DukeException("☹ OOPS!!! The deadline datetime cannot be empty.");
        }

        TaskItem t = new Deadline(deadline[0].trim(), false, deadline[1].trim());
        tasks.add(t);
    }

    private static void handleEvent(String line) throws DukeException {
        String desc = line.substring(5).trim();

        if (!desc.contains("/from") || !desc.contains("/to") || desc.indexOf("/from") > desc.indexOf("/to")) {
            throw new DukeException("☹ OOPS!!! The description of an event must have '/from' then '/to'.");
        }

        String[] first = desc.split("/from", 2);
        if (first[0].trim().isEmpty()) {
            throw new DukeException("☹ OOPS!!! The even description cannot be empty.");
        }
        String name = first[0].trim();

        String[] second = first[1].split("/to", 2);
        if (second[0].trim().isEmpty()) {
            throw new DukeException("☹ OOPS!!! The event start datetime cannot be empty.");
        }
        String from = second[0].trim();
        if (second[1].trim().isEmpty()) {
            throw new DukeException("☹ OOPS!!! The event end datetime cannot be empty.");
        }
        String to = second[1].trim();

        TaskItem t = new Event(name, false, from, to);
        tasks.add(t);
    }

    private static void handleDelete(String line) throws DukeException {
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            throw new DukeException("☹ OOPS!!! The task number for 'delete' is missing.");
        }
        int index;
        try {
            index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("☹ OOPS!!! That is not a valid task number.");
        }
        if (index < 0 || index >= tasks.getSize()) {
            throw new DukeException("☹ OOPS!!! This task number is invalid.");
        }
        tasks.remove(index);
    }

    private static void handleMark(String line) throws DukeException {
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            throw new DukeException("☹ OOPS!!! The task number for 'done' is missing.");
        }
        int index;
        try {
            index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("☹ OOPS!!! That is not a valid task number.");
        }
        if (index < 0 || index >= tasks.getSize()) {
            throw new DukeException("☹ OOPS!!! This task number is invalid.");
        }
        tasks.mark(index);
    }

    private static void handleUnmark(String line) throws DukeException {
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            throw new DukeException("☹ OOPS!!! The task number for 'done' is missing.");
        }
        int index;
        try {
            index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("☹ OOPS!!! That is not a valid task number.");
        }
        if (index < 0 || index >= tasks.getSize()) {
            throw new DukeException("☹ OOPS!!! This task number is invalid.");
        }
        tasks.unmark(index);
    }
}