package Tasks;

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
        return "T|" + isDone + "|" + name;
    }
}
