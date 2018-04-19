package product;

public class ProductUnit implements Product {
    private String name;
    private Double price;

    public ProductUnit(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
