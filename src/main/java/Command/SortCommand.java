package Command;

import Exception.DukeException;
import Task.TaskList;
import UI.Ui;

public class SortCommand extends Command {
    private final String mode;

    public SortCommand(String mode) {
        this.mode = (mode == null || mode.isBlank()) ? "name" : mode.toLowerCase();
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        tasks.sortByDate();
        ui.showList(tasks);
    }
}
