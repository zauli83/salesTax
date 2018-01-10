package test.application.formatter;

import test.application.cart.Cart;
import test.application.cart.CartItem;
import test.application.cart.Item;
import test.application.utils.StringUtils;

import java.text.DecimalFormat;

public class CartReceiptFormatter {

    public String format(Cart cart) {
        StringBuilder response = new StringBuilder("");

        for (CartItem cartItem : cart.getCartItems()) {
            StringBuilder line = new StringBuilder();
            String qty = formatQuantity(cartItem);

            Item item = cartItem.getPurchaseItem().getItem();
            line.append(qty)
                    .append(" ")
                    .append(item.isImported() ? "imported " : "")
                    .append(item.getName())
                    .append(": ")
                    .append(formatTo2Decimal(cartItem.calculateTotalPrice()));
            response.append(line);
            response.append(StringUtils.LINE_SEPARATOR);
        }

        response.append("Sales Taxes: ")
                .append(formatTo2Decimal(cart.getTaxes()))
                .append(StringUtils.LINE_SEPARATOR);

        response.append("Total: ")
                .append(formatTo2Decimal(cart.getTotal()));
        return response.toString();
    }

    private String formatQuantity(CartItem cartItem) {
        String qty;
        Double quantity = cartItem.getQuantity();
        if (quantity % 1 == 0) {
            qty = quantity.intValue() + "";
        } else {
            qty = formatTo2Decimal(quantity);
        }

        return qty;
    }

    private String formatTo2Decimal(Double quantity) {
        return new DecimalFormat("#0.00").format(quantity);
    }


}
