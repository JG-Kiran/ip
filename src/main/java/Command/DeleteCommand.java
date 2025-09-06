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
        TaskItem removedTask = tasks.remove(index);
        ui.showDeleted(removedTask, tasks.getSize());
    }
}
