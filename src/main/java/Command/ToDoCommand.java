package Command;

import JohnException.JohnException;

import Task.TaskItem;
import Task.TaskList;
import Task.Todo;
import UI.Ui;

public class ToDoCommand extends Command {
    private String description;

    public ToDoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws JohnException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        if (description.isEmpty()) {
            throw new JohnException("The description of a todo cannot be empty.");
        }

        TaskItem t = new Todo(description, false);
        tasks.add(t);
        ui.showAdded(t, tasks.getSize());
    }
}