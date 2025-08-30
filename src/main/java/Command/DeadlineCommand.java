package Command;

import Exception.DukeException;

import Task.TaskItem;
import Task.TaskList;
import Task.Deadline;

public class DeadlineCommand extends Command {
    private String description;
    private String deadline;

    public DeadlineCommand(String content) throws DukeException {
        if (!content.contains("/by")) {
            throw new DukeException("☹ OOPS!!! The description of a deadline must have '/by'.");
        }
        String[] parts = content.split("/by", 2);

        this.description = parts[0].trim();
        this.deadline = parts[1].trim();
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        if (description.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The deadline description cannot be empty.");
        }
        if (deadline.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The deadline datetime cannot be empty.");
        }

        TaskItem t = new Deadline(description, false, deadline);
        tasks.add(t);
    }
}
