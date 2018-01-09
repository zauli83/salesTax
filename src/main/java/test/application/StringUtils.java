package test.application;

public class StringUtils {
    public static String[] splitLines(String input) {
        return input.split("\\r?\\n");
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
