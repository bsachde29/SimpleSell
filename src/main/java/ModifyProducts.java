import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.jsp.jstl.sql.SQLExecutionTag;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ModifyProducts", value = "/ModifyProducts")
public class ModifyProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("ProductID"));
        String dburl = "jdbc:mysql://selldb.cqt5tgj7qyws.us-east-2.rds.amazonaws.com:3306/simpledb";
        String dbusername = "simpledb";
        String dbpassword = "sell1234";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dburl, dbusername, dbpassword);
            if (con != null) {
                Statement s1 = con.createStatement();
                System.out.println("Database connection is successful !!!!");
                String checkProduct = "SELECT * FROM Product WHERE ProductID = '" + productID + "' ";
                //String checkProductSubCategory = "SELECT * FROM Product_Subcategories WHERE ProductID = '" + productID + "' ";
                ResultSet productCheck = s1.executeQuery(checkProduct);
                //ResultSet productCheck1 = s1.executeQuery(checkProductSubCategory);
                inStock stock = inStock.OUT_OF_STOCK;
                if (productCheck.getBoolean("inStock")) {
                    stock = inStock.IN_STOCK;
                }
                if (productCheck.next()) {
                    Product product = new Product(productCheck.getString("Name"),
                            productCheck.getString("Description"),
                            productCheck.getString("Category"),
                            productCheck.getBoolean("hasSubcategories"),
                            productCheck.getDouble("price") ,
                            productID, stock, null);
                    Gson gson = new Gson();
                    String jsonProduct = gson.toJson(product);
                    response.getWriter().write(jsonProduct);
                } else {
                    response.getWriter().write("Product does not exist");
                }
                // check and return appropriate message to response.getWriter

            }
        } catch (Exception e) {
            response.getWriter().write("Product Not Registered");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ProductID = request.getParameter("ProductID");
        String category = request.getParameter("Category");
        String name = request.getParameter("Name");
        String has_Subcategories = request.getParameter("hasSubcategories");
        double price = Double.parseDouble(request.getParameter("Price"));
        String in_Stock = request.getParameter("inStock");
        String description = request.getParameter("Description");
        String is_SubProduct = request.getParameter("isSubProduct");
        boolean hasSubcategories, inStock, isSubProduct;
        if (has_Subcategories.equalsIgnoreCase("true")) {
            hasSubcategories = true;
        }
        else {
            hasSubcategories = false;
        }
        if (in_Stock.equalsIgnoreCase("true")) {
            inStock = true;
        }
        else {
            inStock = false;
        }
        if (is_SubProduct.equalsIgnoreCase("true")) {
            isSubProduct = true;
        }
        else {
            isSubProduct = false;
        }
        String url = "jdbc:mysql://selldb.cqt5tgj7qyws.us-east-2.rds.amazonaws.com:3306/simpledb";
        String username = "simpledb";
        String password = "sell1234";
        //String hashedPass = SHA256Hash.hash(Password);
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                Statement s1 = con.createStatement();
                //String check = "SELECT * FROM Sellers WHERE Email = '" + emailID + "' AND Pswd ='" + hashedPass + "'";
                String checkProductQuery = "SELECT * FROM Product WHERE ProductID = '" + ProductID + "'";
                ResultSet result = s1.executeQuery(checkProductQuery);
                if (result.next()) {
                    System.out.println("Product Found");
                    int productId = result.getInt("ProductID");
                    //String checkCategoryQuery = "SELECT * FROM Product WHERE Category = '" + category + "'";
                    //String update = "UPDATE Product SET Category=" + category +  " WHERE ProductID=" + productId;
                    String update = "UPDATE Product SET Category = '" + category + "', Name = '" + name +
                            "', hasSubCategories = '" + hasSubcategories + "', price = '" + price + "', inStock = '" + inStock +
                            "', Description = '" + description + "', isSubProduct = '" + isSubProduct
                            + "' WHERE ProductID = '" + productId + "')";
                    //ResultSet result1 = s1.executeQuery(update);
                    s1.executeUpdate(update);
//                    if (result1.next()) {
                    System.out.println("Updated successfully");
//                    }
//                    else {
//                        System.out.println("update unsuccessful");
//                        response.getWriter().write("update unsuccessful");
//                    }
                } else {
                    System.out.println("Wrong Details");
                    response.getWriter().write("Wrong Details");
                }
            }
        } catch (Exception e) {
            response.getWriter().write("User Not Registered");
            e.printStackTrace();
        }
    }
}
