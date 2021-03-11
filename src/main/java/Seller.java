import java.util.ArrayList;

public class Seller {
    private int sellerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String appName;
    private String description;
    private String fbHandle;
    private String instaHandle;
    private ArrayList<Product> items;

    public Seller(int sellerID, String firstName, String lastName, String email, String phoneNumber, String appName) {
        this.sellerID = sellerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.appName = appName;
        this.items = new ArrayList<>();
        this.description = null;
        this.fbHandle = null;
        this.instaHandle = null;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public String getAbout() {
        return description;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() { return description; }

    public String getFbHandle() { return fbHandle; }

    public String getInstaHandle() { return instaHandle; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAbout(String about) {
        this.description = about;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public void setDescription(String description) { this.description = description; }

    public void setFbHandle(String fbHandle) { this.fbHandle = fbHandle; }

    public void setInstaHandle(String instaHandle) { this.instaHandle = instaHandle; }
}
