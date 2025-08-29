package Command;

import Exception.DukeException;
import Task.TaskList;

public class ByeCommand extends Command {
    @Override
    public boolean isExit() {
        return true;                    // tells John.run() to break the loop
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
