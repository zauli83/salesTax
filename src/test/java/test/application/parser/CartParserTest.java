package test.application.parser;

import org.junit.Assert;
import org.junit.Test;
import test.application.cart.Cart;
import test.application.cart.CartItem;
import test.application.cart.Item;

public class CartParserTest {

    @Test
    public void nullInput() throws CartParserException {
        Cart cart = new CartParser().parse(null);
        Assert.assertNotNull(cart);
        Assert.assertEquals(0, cart.getCartItems().size());
    }

    @Test
    public void emptyInput() throws CartParserException {
        Cart cart = new CartParser().parse("");
        Assert.assertNotNull(cart);
        Assert.assertEquals(0, cart.getCartItems().size());
    }

    @Test
    public void blankInput() throws CartParserException {
        Cart cart = new CartParser().parse("     \n \n  \n");
        Assert.assertNotNull(cart);
        Assert.assertEquals(0, cart.getCartItems().size());
    }

    @Test
    public void malformedInputNoNumbers() {
        try {
            new CartParser().parse("dh  dhj dh d");
            Assert.fail();
        } catch (CartParserException e) {
            Assert.assertEquals("Cannot parse input: dh  dhj dh d", e.getMessage());
        }
    }

    @Test
    public void malformedInputLastTokenIsNotANumber() {
        try {
            new CartParser().parse(" 2 dh  dhj dh d at ");
            Assert.fail();
        } catch (CartParserException e) {
            Assert.assertEquals("Cannot parse input:  2 dh  dhj dh d at ", e.getMessage());
        }
    }

    @Test
    public void malformedInputFirstTokenIsNotANumber() {
        try {
            new CartParser().parse(" e dh  dhj dh d at 3");
            Assert.fail();
        } catch (CartParserException e) {
            Assert.assertEquals("Cannot parse input:  e dh  dhj dh d at 3", e.getMessage());
        }
    }

    @Test
    public void bestCaseWithImportedKeyWordAtEnd() throws CartParserException {
        Cart parse = new CartParser().parse("2 books imported at 340");
        Assert.assertEquals(1, parse.getCartItems().size());
        CartItem item = parse.getCartItems().get(0);
        Assert.assertTrue(2 == item.getQuantity());
        Item item1 = item.getPurchaseItem().getItem();
        Assert.assertEquals("books", item1.getName());
        Assert.assertTrue(340 == item1.getPrice());
        Assert.assertTrue(item1.isImported());
    }

    @Test
    public void bestCaseWithImportedKeyWordAtMiddle() throws CartParserException {
        Cart parse = new CartParser().parse("2 books imported red at 340");
        Assert.assertEquals(1, parse.getCartItems().size());
        CartItem item = parse.getCartItems().get(0);
        Assert.assertTrue(2 == item.getQuantity());
        Item item1 = item.getPurchaseItem().getItem();
        Assert.assertEquals("books red", item1.getName());
        Assert.assertTrue(340 == item1.getPrice());
        Assert.assertTrue(item1.isImported());
    }

    @Test
    public void bestCaseWithImportedKeyWordAtBegin() throws CartParserException {
        Cart parse = new CartParser().parse("2 imported books red at 340");
        Assert.assertEquals(1, parse.getCartItems().size());
        CartItem item = parse.getCartItems().get(0);
        Assert.assertTrue(2 == item.getQuantity());
        Item item1 = item.getPurchaseItem().getItem();
        Assert.assertEquals("books red", item1.getName());
        Assert.assertTrue(340 == item1.getPrice());
        Assert.assertTrue(item1.isImported());
    }

    @Test
    public void bestCaseWithPadding() throws CartParserException {
        Cart parse = new CartParser().parse("   2 imported books      red      at     340");
        Assert.assertEquals(1, parse.getCartItems().size());
        CartItem item = parse.getCartItems().get(0);
        Assert.assertTrue(2 == item.getQuantity());
        Item item1 = item.getPurchaseItem().getItem();
        Assert.assertEquals("books red", item1.getName());
        Assert.assertTrue(340 == item1.getPrice());
        Assert.assertTrue(item1.isImported());
    }

    @Test
    public void bestCaseWithMoreLines() throws CartParserException {
        Cart parse = new CartParser().parse("   2 imported books      red      at     340\n  \n  4 food at 5");
        Assert.assertEquals(2, parse.getCartItems().size());
        CartItem firstItem = parse.getCartItems().get(0);
        Assert.assertTrue(2 == firstItem.getQuantity());
        Item item1 = firstItem.getPurchaseItem().getItem();
        Assert.assertEquals("books red", item1.getName());
        Assert.assertTrue(340 == item1.getPrice());
        Assert.assertTrue(item1.isImported());

        CartItem secondItem = parse.getCartItems().get(1);
        Assert.assertTrue(4 == secondItem.getQuantity());
        Item item2 = secondItem.getPurchaseItem().getItem();
        Assert.assertEquals("food", item2.getName());
        Assert.assertTrue(5 == item2.getPrice());
        Assert.assertFalse(item2.isImported());
    }

}
