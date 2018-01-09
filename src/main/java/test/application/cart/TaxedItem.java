package test.application.cart;

import test.application.tax.NoTaxType;
import test.application.tax.TaxType;

public class TaxedItem {
    private Item item;
    private TaxType taxType = new NoTaxType();

    public TaxedItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }
}
