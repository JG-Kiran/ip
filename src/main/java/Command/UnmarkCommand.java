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
        tasks.unmark(index);
        ui.showUnmarked(tasks.getItem(index));
    }
}
