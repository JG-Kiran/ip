package Command;

import Exception.DukeException;
import Task.TaskItem;
import Task.TaskList;
import UI.Ui;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        TaskItem removedTask = tasks.remove(index);
        ui.showDeleted(removedTask, tasks.getSize());
    }
}
