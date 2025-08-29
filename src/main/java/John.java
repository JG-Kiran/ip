import Command.Command;
import Exception.DukeException;
import Parser.Parser;
import Task.TaskList;
import UI.Ui;

/**
 * Entry point of the John application. Coordinates the main program loop:
 * loading tasks from storage, reading user commands, executing them,
 * and saving results back to disk upon exit.
 */
public class John {
    private static Storage storage;
    private static TaskList tasks;
    private final Ui ui;

    /**
     * Creates a John instance with the default storage path and
     * supporting components.
     */
    public John() {
        ui = new Ui();
        storage = new Storage();
        tasks = storage.load();
    }

    /**
     * Starts the program loop. Continues reading commands from
     * the UI, parsing them, executing the corresponding Command, and
     * displaying results until an exit command is issued.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks);
                storage.save(tasks);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Launches John from the command line.
     *
     * @param args optional CLI arguments (ignored by default)
     */
    public static void main(String[] args) {
        new John().run();
    }
}