import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

@WebServlet(name = "returningCustomer", value = "/returningCustomer")
public class returningCustomer extends HttpServlet {
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
                String check = "SELECT BuyerID, Count(OrderID) from Seller_Buyer_Orders where SellerID = '" + sellerID + "' group by BuyerID";
                ResultSet result = s1.executeQuery(check);
                while (result.next()) {
                    int count = result.getInt(1);
                    totalCustomer++;
                    if (count > 1) {
                        returningCustomer++;
                    }

                }
                float returningRate = (returningCustomer / totalCustomer) * 100;
                Gson gson = new Gson();
                String data = gson.toJson(returningRate);
                response.getWriter().write(data);

            }
        } catch (Exception e) {
            response.getWriter().write("Some Problem");
            e.printStackTrace();
        }


    }
}
