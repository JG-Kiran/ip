package Task;

public class Todo extends TaskItem {

    public Todo(String name, boolean isDone) {
        super(name);
        if (isDone) {
            super.markDone();
        }
    }

    @Override
    public String typeTag() {
        return "[T]";
    }

    @Override
    public String toSaveString() {
        assert name.indexOf('|') < 0 : "Save: name must not contain '|'";
        return "T|" + isDone + "|" + name;
    }
}
