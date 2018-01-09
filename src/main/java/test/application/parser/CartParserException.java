package test.application.parser;

public class CartParserException extends Exception {
    public CartParserException() {
    }

    public CartParserException(String s) {
        super(s);
    }

    public CartParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartParserException(Throwable cause) {
        super(cause);
    }
}
