package test.application.tax.cart;

import org.junit.Assert;
import org.junit.Test;
import test.application.cart.Cart;
import test.application.cart.CartItem;
import test.application.cart.Item;
import test.application.cart.TaxedItem;

public class ApplicationCartTaxStrategyTest {

    @Test
    public void fullTaxedItem() {
        ApplicationCartTaxStrategy applicationCartTaxStrategy = new ApplicationCartTaxStrategy();
        CartItem cartItem = createCartItemWithName("t");
        Item item = cartItem.getPurchaseItem().getItem();
        item.setPrice(100d);
        item.setImported(true);
        Cart cart = new Cart();
        cart.getCartItems().add(cartItem);
        applicationCartTaxStrategy.apply(cart);

        CartItem cartItem1 = cart.getCartItems().get(0);
        TaxedItem purchaseItem = cartItem1.getPurchaseItem();
        Double tax = purchaseItem.getTaxType().calculateTax(purchaseItem.getItem());

        Assert.assertTrue(15d == tax);
    }

    @Test
    public void notImportedTaxedItem() {
        ApplicationCartTaxStrategy applicationCartTaxStrategy = new ApplicationCartTaxStrategy();
        CartItem cartItem = createCartItemWithName("t");
        cartItem.getPurchaseItem().getItem().setPrice(100d);
        Cart cart = new Cart();
        cart.getCartItems().add(cartItem);
        applicationCartTaxStrategy.apply(cart);

        CartItem cartItem1 = cart.getCartItems().get(0);
        TaxedItem purchaseItem = cartItem1.getPurchaseItem();
        Double tax = purchaseItem.getTaxType().calculateTax(purchaseItem.getItem());

        Assert.assertTrue(10d == tax);
    }

    public CartItem createCartItemWithName(String name) {
        Item item = new Item();
        item.setName(name);
        CartItem cartItem = new CartItem();
        cartItem.setPurchaseItem(new TaxedItem(item));
        return cartItem;
    }

}
