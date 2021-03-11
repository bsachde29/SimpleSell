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
        String ProductID = request.getParameter("ProductID");
        String category = request.getParameter("Category");
        String name = request.getParameter("Name");
        int hasSubcategories = Integer.parseInt(request.getParameter("hasSubcategories"));
        double price = Double.parseDouble(request.getParameter("Price"));
        int inStock = Integer.parseInt(request.getParameter("inStock"));
        String description = request.getParameter("Description");
        int isSubProduct = Integer.parseInt(request.getParameter("isSubProduct"));
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
                    String updateCategory = "UPDATE Product SET Category=" + category + " WHERE ProductID=" + productId;
                    String updateName = "UPDATE Product SET Name=" + name + " WHERE ProductID=" + productId;
                    String updateSubcategories = "UPDATE Product SET hasSubcategories=" + hasSubcategories + " WHERE ProductID=" + productId;
                    String updatePrice = "UPDATE Product SET price=" + price + " WHERE ProductID=" + productId;
                    String updateInstock = "UPDATE Product SET inStock=" + inStock + " WHERE ProductID=" + productId;
                    String updateDescription = "UPDATE Product SET Description=" + description + " WHERE ProductID=" + productId;
                    String updateIsSubProduct = "UPDATE Product SET isSubProduct=" + isSubProduct + " WHERE ProductID=" + productId;
                    ResultSet result1 = s1.executeQuery(updateCategory);
                    ResultSet result2 = s1.executeQuery(updateName);
                    ResultSet result3 = s1.executeQuery(updateSubcategories);
                    ResultSet result4 = s1.executeQuery(updatePrice);
                    ResultSet result5 = s1.executeQuery(updateInstock);
                    ResultSet result6 = s1.executeQuery(updateDescription);
                    ResultSet result7 = s1.executeQuery(updateIsSubProduct);
                    if (result1.next() && result2.next() && result3.next() && result4.next()
                            && result5.next() && result6.next() && result7.next()) {
                        System.out.println("Updated successfully");
                    }
                    else {
                        System.out.println("update unsuccessful");
                        response.getWriter().write("update unsuccessful");
                    }
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
