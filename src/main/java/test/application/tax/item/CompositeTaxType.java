package test.application.tax.item;

import test.application.cart.Item;

import java.util.ArrayList;
import java.util.List;

public class CompositeTaxType implements TaxType {

    private final List<PercentageTaxType> taxTypes = new ArrayList<>();

    public CompositeTaxType() {
    }

    public void addTax(PercentageTaxType percentageTaxType) {
        this.taxTypes.add(percentageTaxType);
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
