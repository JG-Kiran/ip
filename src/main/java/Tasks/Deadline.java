package Tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends TaskItem {
    private final LocalDate deadline;

    public Deadline(String name, boolean isDone, String by) {
        super(name);
        this.deadline = LocalDate.parse(by);
        if (isDone) {
            super.markDone();
        }
    }

    @Override
    public String typeTag() {
        return "[D]";
    }

    private String dateToString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    @Override
    public String extraDetail() {
        return " (by: " + dateToString(deadline) + ")";
    }

    @Override
    public String toSaveString() {
        return "D|" + isDone + "|" + name + "|" + dateToString(deadline);
    }
}
