package test.application.cart;

public class Item {
    private String name;
    private boolean imported;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
