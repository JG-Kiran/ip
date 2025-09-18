package Command;

import JohnException.JohnException;
import Task.TaskList;
import UI.Ui;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws JohnException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        if (tasks.getSize() == 0) {
            throw new JohnException("Your task list is empty. Nothing to mark.");
        } else if (index > tasks.getSize() - 1) {
            throw new JohnException("Task index " + (index + 1) + " is out of range.");
        }
        tasks.mark(index);
        ui.showMarked(tasks.getItem(index));
    }
}
