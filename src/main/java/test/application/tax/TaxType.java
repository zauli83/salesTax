package test.application.tax;

import test.application.cart.Item;

public interface TaxType {
    Double calculateTax(Item item);
}
