package Tasks;

public class Event extends TaskItem {
    private final String from;
    private final String to;

    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public Event(String name, boolean done, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
        if (done) {
            markDone();
        }
    }

    @Override
    protected String typeTag() {
        return "[E]";
    }

    @Override
    protected String extraDetail() {
        return " (from: " + from + " to: " + to + ")";
    }

    @Override public String toSaveString() {
        return "E|" + isDone + "|" + name + "|" + from + "|" + to;
    }
}
