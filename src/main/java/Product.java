enum inStock {
    IN_STOCK, OUT_OF_STOCK;
}
public class Product {
    private String name;
    private String description;
    private String category;
    private boolean hasSubCategories;
    private double price;
    private String skuNumber;
    private inStock in_Stock;

    public Product(String name, String description, String category, boolean hasSubCategories, double price, String skuNumber, inStock in_Stock) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.hasSubCategories = hasSubCategories;
        this.price = price;
        this.skuNumber = skuNumber;
        this.in_Stock = in_Stock;
    }

    public boolean isHasSubCategories() {
        return hasSubCategories;
    }

    public inStock getIn_Stock() {
        return in_Stock;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getSkuNumber() {
        return skuNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHasSubCategories(boolean hasSubCategories) {
        this.hasSubCategories = hasSubCategories;
    }

    public void setIn_Stock(inStock in_Stock) {
        this.in_Stock = in_Stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSkuNumber(String skuNumber) {
        this.skuNumber = skuNumber;
    }
}
