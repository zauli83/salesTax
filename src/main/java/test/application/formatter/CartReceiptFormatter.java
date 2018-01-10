package test.application.formatter;

import test.application.cart.Cart;
import test.application.cart.CartItem;
import test.application.utils.StringUtils;

public class CartReceiptFormatter {

    public String format(Cart cart) {
        StringBuilder response = new StringBuilder("");

        for (CartItem cartItem : cart.getCartItems()) {
            StringBuilder line = new StringBuilder();
            String qty = formatQuantity(cartItem);

            line.append(qty)
                    .append(" ")
                    .append(cartItem.getPurchaseItem().getItem().getName())
                    .append(": ")
                    .append(cartItem.calculateTotalPrice());
            response.append(line);
            response.append(StringUtils.LINE_SEPARATOR);
        }

        response.append("Sales Taxes: ")
                .append(cart.getTaxes())
                .append(StringUtils.LINE_SEPARATOR);

        response.append("Total: ")
                .append(cart.getTotal());
        return response.toString();
    }

    private String formatQuantity(CartItem cartItem) {
        String qty;
        Double quantity = cartItem.getQuantity();
        if (quantity % 1 == 0) {
            qty = quantity.intValue() + "";
        } else {
            qty = quantity + "";
        }
        return qty;
    }
}
