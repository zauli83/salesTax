package test.application.cart;

import test.application.tax.CartTaxStrategy;
import test.application.printer.CartReceiptPrinter;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void applyTaxes(CartTaxStrategy cartTaxStrategy) {
        cartTaxStrategy.apply();
    }

    public void printReceipt(CartReceiptPrinter cartReceiptPrinter) {
        cartReceiptPrinter.print();
    }
}
