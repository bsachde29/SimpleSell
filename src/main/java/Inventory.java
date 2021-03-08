import com.google.gson.Gson;
import com.sun.tools.javac.jvm.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "Inventory", value = "/Inventory")
public class Inventory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sellerID = request.getParameter("SellerID");
        String url = "jdbc:mysql://selldb.cqt5tgj7qyws.us-east-2.rds.amazonaws.com:3306/simpledb";
        String username = "simpledb";
        String password = "sell1234";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                Statement s1 = con.createStatement();
                String itemList = "SELECT * FROM Seller_Items WHERE SellerID = '" + sellerID + "'";
                ResultSet result = s1.executeQuery(itemList);
                if (result.next()) {
                    ArrayList<Product> inventory = new ArrayList<Product>();
                    System.out.println("Inventory found");
                    //creating new Seller object from SQL response
                    while (result.next()) {
                        int productId = result.getInt("ProductID");
                        boolean isSub = result.getBoolean("isSubProduct");
                        ArrayList<Product> subcategory = new ArrayList<Product>();
                        if (!isSub) {
                            Statement s2 = con.createStatement();
                            String sublist = "SELECT * FROM Product_Subcategories WHERE ProductID = '" + productId + "'";
                            ResultSet res2 = s2.executeQuery(sublist);
                            if (res2.next()) {
                                while (res2.next()) {
                                    int subID = res2.getInt("SubItemID");
                                    Statement s3 = con.createStatement();
                                    String retrieveSub = "SELECT * FROM Product WHERE ProductID ='" + subID + "'";
                                    ResultSet res3 = s3.executeQuery(retrieveSub);
                                    inStock stock = inStock.OUT_OF_STOCK;
                                    if (res2.getBoolean("inStock")) {
                                        stock = inStock.IN_STOCK;
                                    }
                                    Product p = new Product(res2.getString("Name"), res2.getString("Description"),
                                            res2.getString("Category"), false, res2.getInt("price"),
                                            subID, stock, null);
                                    subcategory.add(p);
                                }
                            }
                        }
                        inStock stock = inStock.OUT_OF_STOCK;
                        if (result.getBoolean("inStock")) {
                            stock = inStock.IN_STOCK;
                        }
                        Product product = new Product(result.getString("Name"), result.getString("Description"),
                                result.getString("Category"), result.getBoolean("hasSubcategories"), result.getInt("price"),
                                productId, stock, subcategory);
                    }

                    /*Gson gson = new Gson();
                    String jsonSeller = gson.toJson(currentSeller);
                    response.getWriter().write(jsonSeller);*/
                } else {
                    System.out.println("No items");
                    response.getWriter().write("No items");
                }

            }
        } catch (Exception e) {
            response.getWriter().write("No Items in Inventory");
            e.printStackTrace();
        }
    }
}
