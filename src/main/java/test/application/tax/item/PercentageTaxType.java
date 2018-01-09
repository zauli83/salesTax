package test.application.tax.item;

import test.application.cart.Item;

public class PercentageTaxType implements TaxType {
    private Double rate;

    public Double getRate() {
        return rate;
    }

    public PercentageTaxType(Double rate) {
        this.rate = rate;
    }

    @Override
    public Double calculateTax(Item item) {
        Double price = item.getPrice() * rate / 100d;
        return roundUpTo5Cent(price);
    }

    private double roundUpTo5Cent(Double price) {
        return Math.ceil(price * 20) / 20.0;
    }
}
