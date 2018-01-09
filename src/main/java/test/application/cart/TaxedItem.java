package test.application.cart;

import test.application.tax.TaxItem;

public class TaxedItem {
    private Item item;
    private TaxItem taxItem;

    public TaxedItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public TaxItem getTaxItem() {
        return taxItem;
    }

    public void setTaxItem(TaxItem taxItem) {
        this.taxItem = taxItem;
    }
}
