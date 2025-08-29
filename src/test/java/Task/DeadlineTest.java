package Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    void toString_notDone_formatsWithDate() {
        Deadline d = new Deadline("submit report", false, "2025-08-30");
        assertEquals("[D][ ] submit report (by: Aug 30 2025)", d.toString());
    }

    @Test
    void toString_done_formatsWithDate() {
        Deadline d = new Deadline("submit report", true, "2025-08-30");
        assertEquals("[D][X] submit report (by: Aug 30 2025)", d.toString());
    }

    @Test
    void toSaveString_matchesSpec() {
        Deadline d = new Deadline("submit report", true, "2025-08-30");
        assertEquals("D|true|submit report|Aug 30 2025", d.toSaveString());
    }
}
