public class Deadline extends TaskItem {
    private final String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    public Deadline(String name, boolean done, String by) {
        super(name);
        this.by = by;
        if (done) {
            super.markDone();
        }
    }

    @Override
    public String typeTag() { return "[D]"; }

    @Override
    public String extraDetail() { return " (by: " + by + ")"; }

    @Override
    public String toSaveString() {
        return String.join(" | ", "D", marked ? "1" : "0", name, by);
    }
}
