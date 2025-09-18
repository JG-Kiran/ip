package Task;

import java.time.LocalDate;
import java.util.Optional;

import static Parser.DateParser.formatForDisplay;
import static Parser.DateParser.formatForStorage;

public class Deadline extends TaskItem {
    private final LocalDate deadline;

    public Deadline(String name, boolean isDone, LocalDate by) {
        super(name);
        assert by != null : "Deadline: /by must not be empty";
        this.deadline = by;
        if (isDone) {
            super.markDone();
        }
    }

    @Override
    public String typeTag() {
        return "[D]";
    }

    @Override
    public String extraDetail() {
        return " (by: " + formatForDisplay(deadline) + ")";
    }

    @Override
    public String toSaveString() {
        assert name.indexOf('|') < 0 : "Save: name must not contain '|'";
        return "D|" + isDone + "|" + name + "|" + formatForStorage(deadline);
    }

    @Override
    public Optional<LocalDate> getDate() {
        return Optional.of(deadline);
    }
}
