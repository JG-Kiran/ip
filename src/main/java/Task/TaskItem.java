package Task;

public abstract class TaskItem {
    protected final String name;
    protected boolean isDone;

    public TaskItem(String name) {
        this.name = name;
        this.isDone = false;
    }

    public void markDone() {
        this.isDone = true;
    }

    public void markUndone() {
        this.isDone = false;
    }

    protected abstract String typeTag();

    protected String extraDetail() {
        return "";
    }

    public abstract String toSaveString();

    @Override
    public String toString() {
        String status = isDone ? "[X] " : "[ ] ";
        return typeTag() + status + name + extraDetail();
    }
}

