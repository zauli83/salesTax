package test.application.tax.item;

import test.application.cart.Item;

public interface TaxType {
    Double calculateTax(Item item);
}
