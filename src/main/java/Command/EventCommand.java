package Command;

import Exception.DukeException;

import Task.TaskItem;
import Task.TaskList;
import Task.Event;
import UI.Ui;

public class EventCommand extends Command {
    private String description;
    private String from;
    private String to;

    public EventCommand(String content) throws DukeException {
        if (!content.contains("/from") || !content.contains("/to") || content.indexOf("/from") > content.indexOf("/to")) {
            throw new DukeException("☹ OOPS!!! The description of an event must have '/from' then '/to'.");
        }
        String[] part1 = content.split("/from", 2);
        this.description = part1[0].trim();
        String[] part2 = part1[1].split("/to", 2);
        this.from = part2[0].trim();
        this.to = part2[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui) throws DukeException {
        if (description.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The event description cannot be empty.");
        }
        if (from.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The event start datetime cannot be empty.");
        }
        if (to.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The event end datetime cannot be empty.");
        }

        TaskItem t = new Event(description, false, from, to);
        tasks.add(t);
        ui.showAdded(t, tasks.getSize());
    }
}
