package test.application.tax.item;

import org.junit.Assert;
import org.junit.Test;
import test.application.cart.Item;

public class PercentageTaxTypeTest {
    @Test
    public void bestCaseNoApproximation() {
        Item item = new Item();
        item.setPrice(10d);
        Double tax = new PercentageTaxType(10d).calculateTax(item);

        Assert.assertTrue(1d == tax);
    }

    @Test
    public void bestCaseApproximation() {
        Item item = new Item();
        item.setPrice(1d);
        for (int i = 1; i < 5; i++) {
            Double tax = new PercentageTaxType((double) i * 0.01).calculateTax(item);
            Assert.assertTrue(0.05 == tax);
        }
    }

}
