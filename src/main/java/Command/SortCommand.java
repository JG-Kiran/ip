package Command;

import JohnException.JohnException;
import Task.TaskList;
import UI.Ui;

public class SortCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui) throws JohnException {
        tasks.sortByDate();
        ui.showList(tasks);
    }
}
