package test.application.tax;

import test.application.cart.Item;

public class NoTaxType implements TaxType {
    @Override
    public Double calculateTax(Item item) {
        return 0d;
    }
}
