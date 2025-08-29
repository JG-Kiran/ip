public class Todo extends TaskItem {
    public Todo(String name) {
        super(name);
    }

    public Todo(String name, boolean done) {
        super(name);
        if (done) {
            super.markDone();
        }
    }

    @Override
    public String typeTag() { return "[T]"; }

    @Override
    public String toSaveString() {
        return String.join(" | ", "T", marked ? "1" : "0", name);
    }
}
