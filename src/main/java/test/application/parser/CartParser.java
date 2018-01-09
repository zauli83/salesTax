package test.application.parser;

import test.application.StringUtils;
import test.application.cart.Cart;
import test.application.cart.CartItem;
import test.application.cart.Item;
import test.application.cart.TaxedItem;

import java.util.Arrays;
import java.util.List;

public class CartParser {

    private static final String IMPORTED_TOKEN = "imported";

    public Cart parse(String input) throws CartParserException {
        Cart cart = new Cart();
        if (StringUtils.isEmpty(input)) {
            return cart;
        }
        String[] strings = StringUtils.splitLines(input);
        for (String string : strings) {
            if (StringUtils.isEmpty(string)) {
                continue;
            }
            cart.getCartItems().add(parseItem(string));
        }

        return cart;
    }


    private CartItem parseItem(String string) throws CartParserException {
        String trim = string.trim();
        String[] split = trim.split("\\s+");
        List<String> tokens = Arrays.asList(split);
        if (tokens.isEmpty()) {
            throw new CartParserException("Empty tokens for string:" + string);
        }

        String price = tokens.get(tokens.size() - 1);

        String qty = tokens.get(0);

        Item item = new Item();
        try {
            item.setPrice(Double.parseDouble(price));
        } catch (NumberFormatException n) {
            throw new CartParserException("Cannot parse input: " + string, n);
        }
        item.setImported(string.toLowerCase().contains(IMPORTED_TOKEN));
        item.setName(formatName(tokens).toString());

        CartItem cartItem = new CartItem();
        try {
            cartItem.setQuantity(Double.parseDouble(qty));
        } catch (NumberFormatException e) {
            throw new CartParserException("Cannot parse input: " + string, e);
        }
        cartItem.setPurchaseItem(new TaxedItem(item));

        return cartItem;

    }

    private StringBuilder formatName(List<String> tokens) {
        StringBuilder currentName = new StringBuilder();
        for (int i = 1; i < tokens.size() - 2; i++) {
            String currentToken = tokens.get(i);
            if (!IMPORTED_TOKEN.equalsIgnoreCase(currentToken)) {
                if (!currentName.toString().isEmpty())
                    currentName.append(" ");
                currentName.append(currentToken.trim());
            }
        }
        return currentName;
    }

}
