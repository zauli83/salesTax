package test.application.cart;

public class CartItem {
    private Double quantity;
    private TaxedItem purchaseItem;

    public CartItem() {
    }

    public CartItem(Double quantity, TaxedItem purchaseItem) {
        this.quantity = quantity;
        this.purchaseItem = purchaseItem;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public TaxedItem getPurchaseItem() {
        return purchaseItem;
    }

    public void setPurchaseItem(TaxedItem purchaseItem) {
        this.purchaseItem = purchaseItem;
    }

    public Double calculateTotalPrice() {
        return purchaseItem.getTotal() * quantity;
    }

    public Double calculateTotalTax() {
        return purchaseItem.calculateTaxes() * quantity;
    }
}
