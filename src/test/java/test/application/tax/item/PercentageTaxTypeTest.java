package test.application.tax.item;

import org.junit.Assert;
import org.junit.Test;
import test.application.cart.Item;

public class PercentageTaxTypeTest {
    @Test
    public void bestCaseNoApproximation() {
        Item item = new Item();
        item.setPrice(10d);
        Double tax = new PercentageTaxType(0.1).calculateTax(item);

        Assert.assertTrue(1d == tax);
    }


}
