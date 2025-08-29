package Tasks;

public class Todo extends TaskItem {
    public Todo(String name) {
        super(name);
    }

    public Todo(String name, boolean isDone) {
        super(name);
        markDone();
    }

    @Override
    public String typeTag() { return "[T]"; }

    @Override
    public String toSaveString() {
        return "T|" + isDone + "|" + name;
    }
}
