package Command;

import JohnException.JohnException;
import Task.TaskList;
import UI.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui) throws JohnException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        ui.showList(tasks);
    }
}
