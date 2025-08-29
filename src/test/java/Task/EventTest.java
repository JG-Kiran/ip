package Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    void toString_notDone_formatsRange() {
        Event e = new Event("project meeting", false, "2025-08-01", "2025-08-05");
        assertEquals("[E][ ] project meeting (from: Aug 1 2025 to: Aug 5 2025)", e.toString());
    }

    @Test
    void toString_done_formatsRange() {
        Event e = new Event("project meeting", true, "2025-08-01", "2025-08-05");
        assertEquals("[E][X] project meeting (from: Aug 1 2025 to: Aug 5 2025)", e.toString());
    }

    @Test
    void toSaveString_matchesSpec() {
        Event e = new Event("project meeting", true, "2025-08-01", "2025-08-05");
        // From your code: "E|<isDone>|<name>|<MMM d yyyy>|<MMM d yyyy>"
        assertEquals("E|true|project meeting|Aug 1 2025|Aug 5 2025", e.toSaveString());
    }
}
