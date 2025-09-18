package Parser;

import JohnException.JohnException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

public class DateParser {

    // === Storage (save/load) ===
    // Always ISO-8601 (LocalDate.toString uses this). Example: "2025-09-18"
    public static final DateTimeFormatter STORAGE =
            DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle(ResolverStyle.STRICT);

    // === Display (pretty) ===
    public static final DateTimeFormatter DISPLAY =
            DateTimeFormatter.ofPattern("MMM d yyyy").withResolverStyle(ResolverStyle.STRICT);

    // === User input formats (strict) ===
    private static final List<DateTimeFormatter> INPUT_FORMATS = List.of(
            DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT), // 2025-09-18
            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT), // 18/09/2025
            DateTimeFormatter.ofPattern("d-M-uuuu").withResolverStyle(ResolverStyle.STRICT),   // 18-9-2025
            DateTimeFormatter.ofPattern("MMM d uuuu").withResolverStyle(ResolverStyle.STRICT), // Sep 18 2025
            DateTimeFormatter.ofPattern("MMMM d uuuu").withResolverStyle(ResolverStyle.STRICT) // September 18 2025
    );

    public static LocalDate parseUser(String raw) throws JohnException {
        if (raw == null || raw.trim().isEmpty()) {
            throw new JohnException("Date input cannot be empty.");
        }
        String s = raw.trim();
        for (var f : INPUT_FORMATS) {
            try {
                return LocalDate.parse(s, f);
            } catch (DateTimeParseException ignore) { }
        }
        // Try to tailor the message if it looks like one of the known shapes but has bad values
        if (s.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new JohnException("Invalid date value. Use yyyy-MM-dd (e.g., 2025-09-18).");
        } else if (s.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            throw new JohnException("Invalid date value. Use dd/MM/yyyy (e.g., 18/09/2025).");
        } else if (s.matches("\\d{1,2}-\\d{1,2}-\\d{4}")) {
            throw new JohnException("Invalid date value. Use d-M-yyyy (e.g., 18-9-2025).");
        } else if (s.matches("[A-Za-z]{3} \\d{1,2} \\d{4}")) {
            throw new JohnException("Invalid date value. Use MMM d yyyy (e.g., Sep 18 2025).");
        } else if (s.matches("[A-Za-z]+ \\d{1,2} \\d{4}")) {
            throw new JohnException("Invalid date value. Use MMMM d yyyy (e.g., September 18 2025).");
        }
        throw new JohnException(
                "Unrecognized date format. Supported: yyyy-MM-dd, dd/MM/yyyy, d-M-yyyy, MMM d yyyy, MMMM d yyyy.");
    }

    /** Parse from storage (single strict format only). */
    public static LocalDate parseStorage(String raw) throws JohnException {
        try {
            return LocalDate.parse(raw, STORAGE);
        } catch (DateTimeParseException e) {
            // This indicates corrupted save data or a version mismatch
            throw new JohnException("Corrupted save date: " + raw);
        }
    }

    public static String formatForDisplay(LocalDate d) {
        return d.format(DISPLAY);
    }

    public static String formatForStorage(LocalDate d) {
        return d.format(STORAGE);
    }
}
