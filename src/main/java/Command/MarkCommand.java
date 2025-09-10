package Command;

import Exception.DukeException;
import Task.TaskList;
import UI.Ui;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        tasks.mark(index);
        ui.showMarked(tasks.getItem(index));
    }
}
