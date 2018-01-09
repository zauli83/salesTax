package test.application;

import test.application.cart.Cart;
import test.application.parser.CartParser;
import test.application.parser.CartParserException;
import test.application.printer.CartReceiptPrinter;
import test.application.tax.cart.CartTaxStrategy;

public class App {
    public void run(String input){
        Cart parse = null;
        try {
            parse = new CartParser().parse(input);
        } catch (CartParserException e) {
            e.printStackTrace();
            return;
        }
//        parse.applyTaxes(new CartTaxStrategy() {
//            @Override
//            public void apply() {
//
//            }
//        });
//        parse.printReceipt(new CartReceiptPrinter() {
//            @Override
//            public void print() {
//
//            }
//        });
    }
}
