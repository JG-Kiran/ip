package ;

public abstract class TaskItem {
    protected final String name;
    protected boolean marked;

    public TaskItem(String name) {
        this.name = name;
        this.marked = false;
    }

    public void markDone() { this.marked = true; }
    public void markUndone() { this.marked = false; }

    protected abstract String typeTag();
    protected String extraDetail() { return ""; }
    public abstract String toSaveString();

    @Override
    public String toString() {
        String status = marked ? "[X] " : "[ ] ";
        return typeTag() + status + name + extraDetail();
    }
}

