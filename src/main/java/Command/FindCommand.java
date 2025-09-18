package Command;

import JohnException.JohnException;
import Task.TaskList;
import UI.Ui;

public class FindCommand extends Command{
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws JohnException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        TaskList filteredList = tasks.find(keyword);
        ui.showList(filteredList);
    }
}
