import java.util.ArrayList;

public class Order {
    private Buyer customer;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;
    private double totalPrice;
    private String orderId;

    public Order(Buyer customer, ArrayList<Product> products, ArrayList<Integer> quantities, double totalPrice, String orderId) {
        this.customer = customer;
        this.products = products;
        this.quantities = quantities;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Buyer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setCustomer(Buyer customer) {
        this.customer = customer;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setQuantities(ArrayList<Integer> quantities) {
        this.quantities = quantities;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
