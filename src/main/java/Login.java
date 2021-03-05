import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailID = request.getParameter("EmailID");
        String Password = request.getParameter("Password");
        //TODO use SHA - 256 Hash
        System.out.println("FUNN IS HERE");
        String url = "jdbc:mysql://selldb.cqt5tgj7qyws.us-east-2.rds.amazonaws.com:3306/simpledb";
        String username = "simpledb";
        String password = "sell1234";
        String hashedPass = SHA256Hash.hash(password);
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                Statement s1 = con.createStatement();
                String check = "SELECT EXISTS ( SELECT * FROM Sellers WHERE Email = '"+emailID+"'+ AND Pswd ='"+Password+"' )";
                ResultSet result = s1.executeQuery(check);
                if (result.getString(1).equals("1")) {
                    System.out.println("Seller found");
                    response.getWriter().write("Seller details found");
                } else {
                    System.out.println("Wrong Details");
                    response.getWriter().write("Wrong Details");
                }

                //TODO check in database whether email exists if not return with response does not exist
                //If exists then get the whole object return sellerID for now
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
