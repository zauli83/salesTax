package test.application.utils;

public class StringUtils {

    public static final String LINE_SEPARATOR = String.format("%n");

    public static String[] splitLines(String input) {
        return input.split("\\r?\\n");
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
