import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class GUI implements ActionListener{

	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	//private static char input;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPanel panel=new JPanel();
		JFrame frame =new JFrame();
		frame.setSize(350,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel=new JLabel("Username");
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);

        userText=new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passwordLabel=new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText=new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		button=new JButton("Login");
		button.setBounds(10,80,80,25);
		button.addActionListener(new GUI());
		panel.add(button);
		
		success=new JLabel("");
		success.setBounds(10,110,300,25);
		panel.add(success);
		//success.setText(n);
		
		frame.setVisible(true);
       
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
           String user=userText.getText();
           char[] password=passwordText.getPassword();
           String pass=String.valueOf(password);

           try {
        	   Connection connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo","root","");
             //your mysql database name ,username and password to be given inside .getConnection
           PreparedStatement st=(PreparedStatement) connection.prepareStatement("Select name, password from Student where name=? and password=?");
           
           st.setString(1, user);
           st.setString(2, pass);
           ResultSet rs=st.executeQuery();
           
           if (rs.next()) {
        	   success.setText("Login successfull");

           } else {
        	   success.setText("Invalid username or password");

           }
       } catch (SQLException sqlException) {
           sqlException.printStackTrace();
       }
         
           System.out.println(user+","+pass);
	
           
           if(user.equals("Lucien")&&pass.equals("#LE")) {
        	   success.setText("Login successfull");
           }
           else 
           {
        	   success.setText("Invalid username or password");
           }
	}

}
