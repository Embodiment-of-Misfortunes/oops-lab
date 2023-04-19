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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/regi")
public class signin extends HttpServlet {
 
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
 
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
            pst = con.prepareStatement("select * from user where name=? and pass=? ");
            pst.setString(1, name);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            
            if(rs.next()){  
               HttpSession httpSession = request.getSession();
            // By setting the variable in session, it can be forwarded
            httpSession.setAttribute("username", name);
        RequestDispatcher rd=request.getRequestDispatcher("wel");  
        rd.forward(request,response);  
    }  
    else{  
        out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
            
            
            pst.executeUpdate();
            pst.close();
            con.close();
            PrintWriter out = response.getWriter();
           
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
}