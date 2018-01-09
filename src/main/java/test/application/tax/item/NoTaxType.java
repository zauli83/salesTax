package test.application.tax.item;

import test.application.cart.Item;

public class NoTaxType implements TaxType {
    @Override
    public Double calculateTax(Item item) {
        return 0d;
    }
}
