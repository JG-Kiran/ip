package Command;

import Exception.DukeException;
import Task.TaskList;
import UI.Ui;

public class ByeCommand extends Command {
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        ui.showBye();
    }
}
