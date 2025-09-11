import Task.Deadline;
import Task.Event;
import Task.TaskItem;
import Task.TaskList;
import Task.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Handles persistence of tasks to and from the filesystem.
 * Responsible for reading a saved task list at startup and saving updates
 * after task mutations.
 */
public class Storage {
    private final File file = new File("data/john.txt");

    /**
     * Constructs a Storage bound to the given file path.
     */
    public Storage() {
        ensureFileReady();
    }

    /**
     * Ensures the parent directory and file exist, creating them when necessary.
     */
    private void ensureFileReady() {
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdir();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("[Warn] Cannot create save file: " + e.getMessage());
            }
        }
    }

    /**
     * Loads tasks from disk into memory.
     *
     * @return a {@link TaskList} populated with tasks from the save file; empty list if file is missing
     */
    public TaskList load() {
        TaskList list = new TaskList();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] p = line.split("\\|");
                String type = p[0];
                boolean isDone = "1".equals(p[1]);
                String desc = p[2];

                switch (type) {
                case "T":
                    assert p.length == 3 : "Storage T expects 3 fields";
                    list.add(new Todo(desc, isDone));
                    break;
                case "D":
                    assert p.length == 4 : "Storage D expects 4 fields";
                    list.add(new Deadline(desc, isDone, p[3]));
                    break;
                case "E":
                    assert p.length == 5 : "Storage E expects 5 fields";
                    list.add(new Event(desc, isDone, p[3], p[4]));
                    break;
                default:
                    assert false : "Storage: unknown record type " + type;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("[Warn] Load failed: " + e.getMessage());
        }
        assert list != null : "Storage.load must return non-null list";
        return list;
    }

    /**
     * Writes the given tasks to disk, overwriting any existing contents.
     *
     * @param tasks list of tasks to save
     */
    public void save(TaskList tasks) {
        try (FileWriter fw = new FileWriter(file)) {
            for (TaskItem t : tasks.view()) {
                fw.write(t.toSaveString());
                fw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("[Warn] Save failed: " + e.getMessage());
        }
        assert file.exists() : "Storage.save: file should exist post-save";
    }
}