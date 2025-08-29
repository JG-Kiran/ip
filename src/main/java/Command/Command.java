package Command;

import Exception.DukeException;
import Task.TaskList;

public abstract class Command {
    public boolean isExit() {
        return false;
    }

    public abstract void execute(TaskList tasks) throws DukeException;
}
