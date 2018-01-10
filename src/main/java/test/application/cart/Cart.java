package test.application.cart;

import test.application.tax.cart.CartTaxStrategy;
import test.application.printer.CartReceiptPrinter;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();
    private Double taxes = 0d;
    private Double total = 0d;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public void setTaxesStrategy(CartTaxStrategy cartTaxStrategy) {
        cartTaxStrategy.apply(this);
    }

    public void compute() {
        calculateTaxes();
        calculateTotal();
    }

    public Double getTaxes() {
        return taxes;
    }

    public Double getTotal() {
        return total;
    }

    public void printReceipt(CartReceiptPrinter cartReceiptPrinter) {
        cartReceiptPrinter.print();
    }

    private void calculateTaxes() {
        Double sum = 0d;
        for (CartItem cartItem : cartItems) {
            sum += cartItem.calculateTotalTax();
        }
        taxes = sum;
    }

    private void calculateTotal() {
        Double sum = 0d;
        for (CartItem cartItem : cartItems) {
            sum += cartItem.calculateTotalPrice();
        }
        total = sum;
    }

}
