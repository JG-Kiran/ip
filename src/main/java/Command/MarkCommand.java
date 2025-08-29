package Command;

import Exception.DukeException;
import Task.TaskList;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        tasks.mark(index);
    }
}
