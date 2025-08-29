package Command;

import Exception.DukeException;
import Task.TaskList;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        tasks.remove(index);
    }
}
