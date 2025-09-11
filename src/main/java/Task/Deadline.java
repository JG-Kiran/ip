package Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Deadline extends TaskItem {
    private final LocalDate deadline;

    public Deadline(String name, boolean isDone, String by) {
        super(name);
        assert by != null && !by.trim().isEmpty() : "Deadline: /by must not be empty";
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
        assert name.indexOf('|') < 0 : "Save: name must not contain '|'";
        return "D|" + isDone + "|" + name + "|" + deadline;
    }

    @Override
    public Optional<LocalDate> getDate() {
        return Optional.of(deadline);
    }
}
