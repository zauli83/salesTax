package test.application.tax.cart;

import test.application.cart.Cart;
import test.application.cart.CartItem;
import test.application.cart.Item;
import test.application.cart.TaxedItem;
import test.application.tax.item.CompositeTaxType;
import test.application.tax.item.PercentageTaxType;

import java.util.List;

public class ApplicationCartTaxStrategy implements CartTaxStrategy {
    @Override
    public void apply(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            CompositeTaxType compositeTaxType = new CompositeTaxType();
            TaxedItem purchaseItem = cartItem.getPurchaseItem();
            Item item = purchaseItem.getItem();
            if (!isTaxesFree(item)) {
                compositeTaxType.addTax(new PercentageTaxType(10d));
            }

            if (item.isImported()) {
                compositeTaxType.addTax(new PercentageTaxType(5d));
            }
            purchaseItem.setTaxType(compositeTaxType);
        }
    }

    private boolean isTaxesFree(Item item) {
        return item.getName().toLowerCase().contains("book")
                || item.getName().toLowerCase().contains("chocolate") ||
                item.getName().toLowerCase().contains("headache pills");
    }
}
