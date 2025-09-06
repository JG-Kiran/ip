package Command;

import Exception.DukeException;
import Task.TaskList;
import UI.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        ui.showList(tasks);
    }
}
