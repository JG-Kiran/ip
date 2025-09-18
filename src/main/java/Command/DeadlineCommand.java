package Command;

import JohnException.JohnException;

import Parser.DateParser;
import Task.TaskItem;
import Task.TaskList;
import Task.Deadline;
import UI.Ui;

import java.time.LocalDate;

public class DeadlineCommand extends Command {
    private String description;
    private String deadline;

    public DeadlineCommand(String content) throws JohnException {
        if (!content.contains("/by")) {
            throw new JohnException("☹ OOPS!!! The description of a deadline must have '/by'.");
        }
        String[] parts = content.split("/by", 2);

        this.description = parts[0].trim();
        this.deadline = parts[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws JohnException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        if (description.isEmpty()) {
            throw new JohnException("The deadline description cannot be empty.");
        }
        LocalDate deadlineDate = DateParser.parseUser(deadline);

        TaskItem t = new Deadline(description, false, deadlineDate);
        tasks.add(t);
        ui.showAdded(t, tasks.getSize());
    }
}
