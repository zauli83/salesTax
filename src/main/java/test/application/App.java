package test.application;

import test.application.cart.Cart;
import test.application.formatter.CartReceiptFormatter;
import test.application.parser.CartParser;
import test.application.parser.CartParserException;
import test.application.tax.cart.ApplicationCartTaxStrategy;

public class App {
    public String run(String input) throws CartParserException {
        CartParser cartParser = new CartParser();
        Cart parse = cartParser.parse(input);
        parse.setTaxesStrategy(new ApplicationCartTaxStrategy());
        parse.compute();
        return new CartReceiptFormatter().format(parse);
    }
}
