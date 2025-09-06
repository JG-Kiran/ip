package Command;

import Exception.DukeException;
import Task.TaskList;
import UI.Ui;

public class FindCommand extends Command{
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        TaskList filteredList = tasks.find(keyword);
        ui.showList(filteredList);
    }
}
