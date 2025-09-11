package Command;

import Exception.DukeException;
import Task.TaskList;
import UI.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        ui.showList(tasks);
    }
}
