import java.util.ArrayList;

enum orderAccept {
    ACCEPTED, REJECTED;
}

enum orderState {
    PLACED, COMPLETED;
}

public class Order {
    private int buyerId;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;
    private double totalPrice;
    private String orderId;

    public Order(int buyerId, ArrayList<Product> products, ArrayList<Integer> quantities, double totalPrice, String orderId) {
        this.buyerId = buyerId;
        this.products = products;
        this.quantities = quantities;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }



    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderId() {
        return orderId;
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
