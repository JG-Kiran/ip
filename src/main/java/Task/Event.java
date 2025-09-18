package Task;

import java.time.LocalDate;
import java.util.Optional;

import static Parser.DateParser.formatForDisplay;
import static Parser.DateParser.formatForStorage;

public class Event extends TaskItem {
    private final LocalDate from;
    private final LocalDate to;

    public Event(String name, boolean isDone, LocalDate from, LocalDate to) {
        super(name);
        assert from != null : "Event: /from missing";
        assert to != null : "Event: /to missing";
        this.from = from;
        this.to = to;
        if (isDone) {
            markDone();
        }
    }

    @Override
    protected String typeTag() {
        return "[E]";
    }

    @Override
    protected String extraDetail() {
        return " (from: " + formatForDisplay(from) + " to: " + formatForDisplay(to) + ")";
    }

    @Override public String toSaveString() {
        assert name.indexOf('|') < 0 : "Save: name must not contain '|'";
        return "E|" + isDone + "|" + name + "|" + formatForStorage(from) + "|" + formatForStorage(to);
    }

    @Override
    public Optional<LocalDate> getDate() {
        return Optional.of(from);
    }
}
