package test.application.tax.cart;

import test.application.cart.Cart;

public interface CartTaxStrategy {
    void apply(Cart cart);
}
