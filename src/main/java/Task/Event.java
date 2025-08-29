package Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends TaskItem {
    private final LocalDate from;
    private final LocalDate to;

    public Event(String name, boolean isDone, String from, String to) {
        super(name);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
        if (isDone) {
            markDone();
        }
    }

    @Override
    protected String typeTag() {
        return "[E]";
    }

    private String dateToString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    @Override
    protected String extraDetail() {
        return " (from: " + dateToString(from) + " to: " + dateToString(to) + ")";
    }

    @Override public String toSaveString() {
        return "E|" + isDone + "|" + name + "|" + dateToString(from) + "|" + dateToString(to);
    }
}
