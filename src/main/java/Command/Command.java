package Command;

import JohnException.JohnException;
import Task.TaskList;
import UI.GuiUi;
import UI.Ui;

public abstract class Command {
    /**
     * Indicates whether executing this command should terminate the app.
     * Defaults to {@code false}; exit-like commands override to return {@code true}.
     *
     * @return {@code true} if the app should exit after execution; {@code false} otherwise
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Executes this command against the application state.
     *
     * @param tasks the current task list
     * @throws JohnException if execution fails (e.g., invalid index, I/O errors)
     */
    public abstract void execute(TaskList tasks, Ui ui) throws JohnException;

    public String executeAndReturn(TaskList tasks) throws JohnException {
        assert tasks != null : "Command: tasks must not be null";
        GuiUi tempUi = new GuiUi();
        this.execute(tasks, tempUi);
        String out = tempUi.getOutput();
        assert out != null : "Command: execute must produce non-null output";
        return out;
    }
}
