import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "PasswordReset", value = "/PasswordReset")
public class PasswordReset extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailID = request.getParameter("EmailID");
        String newPassword = request.getParameter("NewPassword");
        boolean updatePass = true;
        boolean check = pwcheck.isValidPass(newPassword);
        if (!check) {
            updatePass = false;
            response.getWriter().write("Password Too weak");
            return;
        }

        //HASHING THE PASSWORD
        String hashedPass = "";
        hashedPass = SHA256Hash.hash(newPassword);
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
                String checkUser = "SELECT * FROM Sellers WHERE Email = '" + emailID + "' ";
                ResultSet userCheck = s1.executeQuery(checkUser);
                if (!userCheck.next()) {
                    response.getWriter().write("User does not exist");
                    return;
                }

//                String checkEmailQuery = "SELECT * FROM Sellers WHERE Sellers.Email = '" + emailID + "'";
//                ResultSet set = s1.executeQuery(checkEmailQuery);
//                if ((set.next() && !set.getString("SellerID").equals(request.getParameter("SellerID")))) {
//                    response.getWriter().write("Email Exists");
//                    return;
//                }
//                String checkPhoneQuery = "SELECT * FROM Sellers WHERE Sellers.MobileNum = '" + mobileNum + "'";
//                set = s1.executeQuery(checkPhoneQuery);
//                if ((set.next() && !set.getString("SellerID").equals(request.getParameter("SellerID")))) {
//                    response.getWriter().write("Phone Exists");
//                    return;
//                }

                String sqlquery;
                sqlquery = "UPDATE Sellers SET Pswd = '" + hashedPass + "' + WHERE Email = '" + emailID + "'";
                System.out.println(sqlquery);
                s1.executeUpdate(sqlquery);
                System.out.println("Updated Seller Info");
                response.getWriter().write("Seller Info Updated");
                // check and return appropriate message to response.getWriter
            }
        } catch (Exception e) {
            response.getWriter().write("User Not Registered");
            e.printStackTrace();
        }
    }
}
