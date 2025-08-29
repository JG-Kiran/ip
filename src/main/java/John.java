import Command.Command;
import Exception.DukeException;
import Parser.Parser;
import Task.Deadline;
import Task.Event;
import Task.TaskItem;
import Task.TaskList;
import Task.Todo;
import UI.Ui;

import java.util.Scanner;

public class John {
    private static Storage storage;
    private static TaskList tasks;
    private final Ui ui;

    public John(String filePath) {
        ui = new Ui();
        storage = new Storage();
        tasks = storage.load();
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new John("data/tasks.txt").run();
    }
}