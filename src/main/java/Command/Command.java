package Command;

import Exception.DukeException;
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
     * @throws DukeException if execution fails (e.g., invalid index, I/O errors)
     */
    public abstract void execute(TaskList tasks, Ui ui) throws DukeException;

    public String executeAndReturn(TaskList tasks) throws DukeException {
        GuiUi tempUi = new GuiUi();
        this.execute(tasks, tempUi);
        return tempUi.getOutput();
    }
}
