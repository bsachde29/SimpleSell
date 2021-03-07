import com.sun.tools.javac.jvm.Items;

import java.util.ArrayList;

public class Seller {
    private String name;
    private String appName;
    private String about;
    private String email;
    private String phoneNumber;
    private ArrayList<Items> items;

    public Seller(String name, String appName, String about, String email, String phoneNumber, ArrayList<Items> items) {
        this.name = name;
        this.appName = appName;
        this.email = email;
        this.about = about;
        this.phoneNumber = phoneNumber;
        this.items = items;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public String getAbout() {
        return about;
    }

    public String getAppName() {
        return appName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
