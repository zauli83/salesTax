package test.application.tax;

import test.application.cart.Item;
import test.application.cart.TaxedItem;

public class PercentageTaxType implements TaxType {
    private Double rate;
    private TaxedItem taxedItem;

    public Double getRate() {
        return rate;
    }

    public PercentageTaxType(Double rate) {
        this.rate = rate;
        this.taxedItem = taxedItem;
    }

    @Override
    public Double calculateTax(Item item) {
        Double price = taxedItem.getItem().getPrice();
        return roundUpTo5Cent(price);
    }

    private double roundUpTo5Cent(Double price) {
        return Math.round(price * 20.0) / 20.0;
    }
}
