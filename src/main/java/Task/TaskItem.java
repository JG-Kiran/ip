package Task;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Base abstraction for a user task. Stores a name/description and completion state,
 * and defines the common rendering and serialization contracts used by the app.
 *
 * <p>Concrete subclasses include {@code Todo}, {@code Deadline}, and {@code Event}.</p>
 */
public abstract class TaskItem {
    protected final String name;
    protected boolean isDone;

    /**
     * Creates a task with the given name and completion flag.
     *
     * @param name description of the task
     */
    public TaskItem(String name) {
        assert name != null : "TaskItem: name must not be null";
        assert !name.trim().isEmpty() : "TaskItem: name must not be empty";
        this.name = name;
        this.isDone = false;
    }

    /**
     * Marks this task as completed.
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Marks this task as not completed.
     */
    public void markUndone() {
        this.isDone = false;
    }

    /**
     * Returns a brief two-letter tag that identifies the task kind
     * (e.g., {@code [T]}, {@code [D]}, {@code [E]}).
     *
     * @return the type tag to prefix in {@link #toString()}
     */
    protected abstract String typeTag();

    /**
     * Returns extra details specific to the task type (e.g., deadline or event range),
     * formatted for display. Subclasses return an empty string when not applicable.
     *
     * @return a formatted suffix like {@code " (by: Aug 1 2025)"} or empty string
     */
    protected String extraDetail() {
        return "";
    }

    /**
     * Returns a machine-friendly representation suitable for storage,
     * typically a pipe-delimited row containing type, completion flag, name,
     * and any extra fields.
     *
     * @return a string to write to the save file
     */
    public abstract String toSaveString();

    /**
     * Returns the canonical display form shown in the UI, combining the
     * type tag, completion status, name, and any extra detail.
     *
     * @return the display string for this task
     */
    @Override
    public String toString() {
        String status = isDone ? "[X] " : "[ ] ";
        return typeTag() + status + name + extraDetail();
    }

    public String getName() {
        return this.name;
    }

    public Optional<LocalDate> getDate() {
        return Optional.empty();
    }
}

