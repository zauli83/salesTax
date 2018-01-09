package test.application.tax;

import test.application.cart.Item;

public class CompositeTaxType implements TaxType {

    private final PercentageTaxType[] taxTypes;

    public CompositeTaxType(PercentageTaxType... taxTypes) {
        this.taxTypes = taxTypes;
    }

    @Override
    public Double calculateTax(Item item) {
        Double rate = 0d;
        for (PercentageTaxType taxType : taxTypes) {
            rate += taxType.getRate();
        }
        return new PercentageTaxType(rate).calculateTax(item);
    }
}
