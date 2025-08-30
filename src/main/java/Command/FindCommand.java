package Command;

import Exception.DukeException;
import Task.TaskList;

public class FindCommand extends Command{
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        tasks.find(keyword);
    }
}
