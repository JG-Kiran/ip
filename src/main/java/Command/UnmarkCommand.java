package Command;

import Exception.DukeException;
import Task.TaskList;
import UI.Ui;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        tasks.unmark(index);
        ui.showUnmarked(tasks.getItem(index));
    }
}
