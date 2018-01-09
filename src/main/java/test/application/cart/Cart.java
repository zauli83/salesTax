package test.application.cart;

import test.application.tax.cart.CartTaxStrategy;
import test.application.printer.CartReceiptPrinter;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();
    private Double totalTaxes = 0d;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public Double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(Double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public void applyTaxes(CartTaxStrategy cartTaxStrategy) {
        cartTaxStrategy.apply(this);
    }

    public void printReceipt(CartReceiptPrinter cartReceiptPrinter) {
        cartReceiptPrinter.print();
    }
}
