import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SignUp", value = "/SignUp")
public class SignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Name");
        String firstName = name;
        String lastName = "Doe";
        String emailID = request.getParameter("EmailID");
        String mobileNum = request.getParameter("MobileNumber");
        String password = request.getParameter("Password");
        String storeName = request.getParameter("StoreName");

        String dburl = "jdbc:mysql://selldb.cqt5tgj7qyws.us-east-2.rds.amazonaws.com:3306/simpledb";
        String dbusername = "simpledb";
        String dbpassword = "sell1234";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dburl, dbusername, dbpassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                Statement s1 = con.createStatement();
                String sqlquery = "INSERT INTO Sellers (FirstName,LastName,Email,MobileNum,Pswd,StoreName) " +
                        "VALUES ('" + firstName + "','" + lastName + "','" + emailID + "','" + mobileNum + "','" +
                        password + "','" + storeName + "')";
                System.out.println(sqlquery);
                s1.executeUpdate(sqlquery);
                System.out.println("Inserted Seller into Table");
                response.getWriter().write(sqlquery + "\n");
                response.getWriter().write("User Registered Successfully");
            }
        } catch (Exception e) { 
            response.getWriter().write("User Not Registered");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
