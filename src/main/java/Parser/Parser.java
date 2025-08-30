package Parser;

import Command.Command;
import Command.ByeCommand;
import Command.DeadlineCommand;
import Command.DeleteCommand;
import Command.EventCommand;
import Command.ListCommand;
import Command.MarkCommand;
import Command.ToDoCommand;
import Command.UnmarkCommand;

import Exception.DukeException;

public class Parser {

    /**
     * Parses a raw user command line and creates an appropriate {@link Command}.
     *
     * @param input the entire line typed by the user
     * @return a command object ready to execute
     * @throws DukeException if the command is unknown or arguments are invalid
     */
    public static Command parse(String input) throws DukeException {
        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            throw new DukeException("Empty command");
        }
        String[] parts = trimmed.split("\\s+", 2);
        String cmd = parts[0].toLowerCase();
        String args = parts.length > 1 ? parts[1] : "";

        switch (cmd) {
        case "list":
            return new ListCommand();
        case "todo":
            if (args.isBlank()) throw new DukeException("Usage: todo <description>");
            return new ToDoCommand(args);
        case "deadline":
            String[] p = args.split("/by ", 2);
            if (p.length < 2) {
                throw new DukeException("Usage: deadline <desc> /by <yyyy-MM-dd>");
            }
            return new DeadlineCommand(args);
        case "event":
            String[] i = args.split("/from ", 2);
            String[] j = args.split("/to", 2);
            if (i.length < 2 || j.length < 2) {
                throw new DukeException("Usage: event <desc> /from <yyyy-MM-dd> /to <yyyy-MM-dd>");
            }
            return new EventCommand(args);
        case "mark":
            return new MarkCommand(parseIndex(args));
        case "unmark":
            return new UnmarkCommand(parseIndex(args));
        case "delete":
            return new DeleteCommand(parseIndex(args));
        case "bye":
            return new ByeCommand();
        default:
            throw new DukeException("Unknown command: " + cmd);
        }
    }

    /**
     * Retrieves any integers within the given string
     *
     * @param s input line
     * @return an integer representing the index of the item
     * @throws DukeException if the index is an invalid value
     */
    private static int parseIndex(String s) throws DukeException {
        try {
            int i = Integer.parseInt(s.trim());
            if (i <= 0) {
                throw new NumberFormatException();
            }
            return i;
        } catch (Exception e) {
            throw new DukeException("Index must be a positive integer");
        }
    }
}
