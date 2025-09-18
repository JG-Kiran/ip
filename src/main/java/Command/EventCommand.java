package Command;

import JohnException.JohnException;

import Parser.DateParser;
import Task.TaskItem;
import Task.TaskList;
import Task.Event;
import UI.Ui;

import java.time.LocalDate;

public class EventCommand extends Command {
    private String description;
    private String from;
    private String to;

    public EventCommand(String content) throws JohnException {
        if (!content.contains("/from") || !content.contains("/to") || content.indexOf("/from") > content.indexOf("/to")) {
            throw new JohnException("☹ OOPS!!! The description of an event must have '/from' then '/to'.");
        }
        String[] part1 = content.split("/from", 2);
        this.description = part1[0].trim();
        String[] part2 = part1[1].split("/to", 2);
        this.from = part2[0].trim();
        this.to = part2[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws JohnException {
        assert tasks != null : "Command: tasks must not be null";
        assert ui != null : "Command: ui must not be null";
        if (description.isEmpty()) {
            throw new JohnException("The event description cannot be empty.");
        }
        LocalDate fromDate = DateParser.parseUser(from);
        LocalDate toDate = DateParser.parseUser(to);

        TaskItem t = new Event(description, false, fromDate, toDate);
        tasks.add(t);
        ui.showAdded(t, tasks.getSize());
    }
}
