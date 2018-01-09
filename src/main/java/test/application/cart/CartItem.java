package test.application.cart;

public class CartItem {
    private Double quantity;
    private TaxedItem purchaseItem;

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
}
