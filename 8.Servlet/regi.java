import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regi")
public class regi extends HttpServlet {
 
    Connection con;
    PreparedStatement pst;
    
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        try
        {
            
            response.setContentType("text/html");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/oop", "root", "");
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            pst = con.prepareStatement("insert into user(name,pass)values(?,?)");
            pst.setString(1, name);
            pst.setString(2, pass);
            
            pst.executeUpdate();
            pst.close();
            con.close();
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>");
           
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
}