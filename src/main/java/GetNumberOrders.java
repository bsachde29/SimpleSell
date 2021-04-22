import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "GetNumberOrders", value = "/GetNumberOrders")
public class GetNumberOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sellerID = request.getParameter("sellerID");
        String url = "jdbc:mysql://selldb.cqt5tgj7qyws.us-east-2.rds.amazonaws.com:3306/simpledb";
        String username = "simpledb";
        String password = "sell1234";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            float totalCustomer = 0;
            float returningCustomer = 0;
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                Statement s1 = con.createStatement();
                String check = "SELECT  Count(OrderID) from Seller_Buyer_Orders where SellerID = '" + sellerID + "'";
                ResultSet result = s1.executeQuery(check);
                int count = -1;
               if (result.next()) {
                    count = result.getInt(0); // Column index check

                }
                Gson gson = new Gson();
                String data = gson.toJson(count);
                response.getWriter().write(data);

            }
        } catch (Exception e) {
            response.getWriter().write("Some Problem");
            e.printStackTrace();
        }


    }
}
