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

    @Test
    public void bestCaseApproximation() {
        Item item = new Item();
        item.setPrice(10d);
        double rateStart = 0.100;
        for (int i = 1; i < 5; i++) {
            Double tax = new PercentageTaxType(rateStart + i * 0.001).calculateTax(item);
            Assert.assertTrue(1.05 == tax);
        }
    }


}
