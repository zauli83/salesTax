package test.application.formatter;

import org.junit.Assert;
import org.junit.Test;
import test.application.cart.Cart;
import test.application.cart.CartItem;
import test.application.cart.Item;
import test.application.cart.TaxedItem;
import test.application.utils.StringUtils;

public class CartReceiptFormatterTest {
    @Test
    public void zeroItemsTest() {
        Cart cart = new Cart();
        String formatted = new CartReceiptFormatter().format(cart);
        Assert.assertEquals("Sales Taxes: 0.00" + StringUtils.LINE_SEPARATOR + "Total: 0.00", formatted);
    }

    @Test
    public void oneItemTest() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1d, new TaxedItem(new Item("book", false, 2d))));
        String formatted = new CartReceiptFormatter().format(cart);
        Assert.assertEquals("1 book: 2.00" + StringUtils.LINE_SEPARATOR + "Sales Taxes: 0.00" + StringUtils.LINE_SEPARATOR + "Total: 0.00", formatted);
    }


    @Test
    public void moreItemTest() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1.5d, new TaxedItem(new Item("book", false, 2d))));
        cart.addItem(new CartItem(1.5d, new TaxedItem(new Item("test", false, 4d))));
        String formatted = new CartReceiptFormatter().format(cart);
        Assert.assertEquals("1.50 book: 3.00" + StringUtils.LINE_SEPARATOR+ "1.50 test: 6.00" + StringUtils.LINE_SEPARATOR + "Sales Taxes: 0.00" + StringUtils.LINE_SEPARATOR + "Total: 0.00", formatted);
    }
}
