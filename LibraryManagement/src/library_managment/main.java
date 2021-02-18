package library_managment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.*;


class check implements ActionListener
{
	
	JButton login_button;
	JPasswordField password_input;
	JTextField username_input;
	JFrame login_frame;
	
	check(JFrame login_frame,JButton login_button,JPasswordField password_input,JTextField username_input)
	{
		this.login_button= login_button;
		this.password_input = password_input;
		this.username_input =  username_input;
		this.login_frame=login_frame;
		
		login_button.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==login_button)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				  
				String g=username_input.getText();
				
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("select * from liblogin where email = '"+g+"'");  
				
				boolean count=true;
				
				while(rs.next())  
				{
					if(rs.getString(1)!=null && rs.getString(2).equals(password_input.getText()) )
					{
						if(rs.getString(3).equals("admin"))
					    admin.admin();
						else
						librarian.librarian();
						login_frame.dispose();
						
					 count=false;
					}
					
					
				}
				
				if(count)
				JOptionPane.showMessageDialog(login_frame,"Eiether password or email is invalid");  
				  
				//step5 close the connection object  
				con.close();  
				
			}
			catch(Exception ll){ System.out.println(ll +"error");}  

		}
		
		
	}
	
}

public class main {
	

	
	
	static void login()
	{
		JFrame login_frame =new JFrame("LogIn");
		
		JLabel username=new JLabel("<html><body><p style='color:white;font-size:10px'>UserName :</p></body></html>");
		username.setBounds(40,20,100,100);
		login_frame.add(username);
		
		JTextField username_input = new JTextField();
		username_input.setBounds(120,60,200,20);
		username_input.setBackground(Color.decode("#6C798C"));
		username_input.setBorder(new LineBorder(Color.decode("#6C798C")));
		username_input.setForeground(Color.WHITE);
		login_frame.add(username_input);
		
		JLabel password=new JLabel("<html><body><p style='color:white;font-size:10px'>Password :</p></body></html>");
		password.setBounds(40,60,100,100);
		login_frame.add(password);
		
		
		JPasswordField password_input = new JPasswordField();
		password_input.setBounds(120,100,200,20);
		password_input.setBackground(Color.decode("#6C798C"));
		password_input.setBorder(new LineBorder(Color.decode("#6C798C")));
		password_input.setForeground(Color.WHITE);
		login_frame.add(password_input);
		
		JButton login_button = new JButton("Log In");
		login_button.setBounds(145,145,100,40);
		login_button.setBackground(Color.decode("#31B0D5"));
		login_button.setForeground(Color.WHITE);
		login_frame.add(login_button);
		
		login_frame.setSize(400,255);
		login_frame.setLayout(null);
		login_frame.setVisible(true);
		login_frame.getContentPane().setBackground(Color.decode("#2B3C53"));
		login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		check obj = new check(login_frame,login_button,password_input,username_input);
		
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 login();
	}

}
