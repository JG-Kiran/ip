package Command;

import Exception.DukeException;

import Task.TaskItem;
import Task.TaskList;
import Task.Todo;

public class ToDoCommand extends Command {
    private String description;

    public ToDoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        if (description.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }

        TaskItem t = new Todo(description, false);
        tasks.add(t);
    }
}