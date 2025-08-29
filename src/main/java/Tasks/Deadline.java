package Tasks;

public class Deadline extends TaskItem {
    private final String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public Deadline(String name, boolean isDone, String by) {
        super(name);
        this.by = by;
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
        return " (by: " + by + ")";
    }

    @Override
    public String toSaveString() {
        return "D|" + isDone + "|" + name + "|" + by;
    }
}
