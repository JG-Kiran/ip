package Command;

import Exception.DukeException;
import Task.TaskList;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks) throws DukeException {
        tasks.list();
    }
}
