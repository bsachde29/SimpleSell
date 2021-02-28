import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String MySQLURL = "simpledb@selldb.cqt5tgj7qyws.us-east-2.rds.amazonaws.com";
        String databseUserName = "simpledb";
        String databasePassword = "sell1234";
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                Statement s1 = con.createStatement();
                ResultSet result = s1.executeQuery("select * from Buyers");



                try (PrintWriter writer = response.getWriter()) {
                    writer.println("<!DOCTYPE html><html>");
                    writer.println("<head>");
                    writer.println("<meta charset=\"UTF-8\" />");
                    writer.println("<title>MyServlet.java:doGet(): Servlet code!</title>");
                    writer.println("</head>");
                    writer.println("<body>");

                    writer.println("<h1>"+result.getString("FirstName")+"</h1>");

                    writer.println("</body>");
                    writer.println("</html>");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
