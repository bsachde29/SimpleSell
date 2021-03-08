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

@WebServlet(name = "ModifyCategories", value = "/ModifyCategories")
public class ModifyCategories extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ProductID = request.getParameter("ProductID");
        String category = request.getParameter("Category");
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
                    ResultSet result1 = s1.executeQuery(updateCategory);
                    if (result1.next()) {
                        System.out.println("Category updated successfully");
                    }
                    else {
                        System.out.println("Category update unsuccessful");
                        response.getWriter().write("Category update unsuccessful");
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
