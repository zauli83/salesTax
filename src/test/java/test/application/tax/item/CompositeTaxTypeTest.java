package test.application.tax.item;

import org.junit.Assert;
import org.junit.Test;
import test.application.cart.Item;

public class CompositeTaxTypeTest {
    @Test
    public void bestCase() {
        CompositeTaxType compositeTaxType = new CompositeTaxType();
        compositeTaxType.addTax(new PercentageTaxType(50d));
        compositeTaxType.addTax(new PercentageTaxType(50d));
        Item item = new Item();
        item.setPrice(100d);
        Double tax = compositeTaxType.calculateTax(item);
        Assert.assertTrue(100d == tax);
    }
}
