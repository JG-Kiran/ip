package Parser;

import Command.ByeCommand;
import Command.Command;
import Command.DeadlineCommand;
import Command.DeleteCommand;
import Command.EventCommand;
import Command.ListCommand;
import Command.MarkCommand;
import Command.ToDoCommand;
import Command.UnmarkCommand;

import Exception.DukeException;

public class Parser {

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
            case "deadline": {
                String[] p = args.split("/by ", 2);
                if (p.length < 2) {
                    throw new DukeException("Usage: deadline <desc> /by <yyyy-MM-dd>");
                }
                return new DeadlineCommand(args);
            }
            case "event": {
                String[] p = args.split("/from ", 2);
                String[] q = args.split("/to", 2);
                if (p.length < 2 || q.length < 2) {
                    throw new DukeException("Usage: event <desc> /from <yyyy-MM-dd> /to <yyyy-MM-dd>");
                }
                return new EventCommand(args);
            }
            case "mark":    return new MarkCommand(parseIndex(args));
            case "unmark":  return new UnmarkCommand(parseIndex(args));
            case "delete":  return new DeleteCommand(parseIndex(args));
            case "bye":     return new ByeCommand();
            default: throw new DukeException("Unknown command: " + cmd);
        }
    }

    private static int parseIndex(String s) throws DukeException {
        try {
            int i = Integer.parseInt(s.trim());
            if (i <= 0) throw new NumberFormatException();
            return i;
        } catch (Exception e) {
            throw new DukeException("Index must be a positive integer");
        }
    }
}
