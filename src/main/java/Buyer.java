import com.sun.tools.javac.jvm.Items;

import java.util.ArrayList;

public class Buyer {
    private String name;
    private String customerId;
    private String phoneNumber;
    private String email;
    private ArrayList<Items> order;

    public Buyer(String name, String customerId, String phoneNumber, String email, ArrayList<Items> order) {
        this.name = name;
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Items> getOrder() {
        return order;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setOrder(ArrayList<Items> order) {
        this.order = order;
    }
}
