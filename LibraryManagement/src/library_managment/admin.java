package library_managment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

class build implements ActionListener{
	
	JFrame admin_frame;
	JButton addl;
	JButton viewl;
	JButton removel;
	JButton logoutl;
	
	build(JFrame admin_frame)
	{
		this.admin_frame = admin_frame;
		
		JLabel heading=new JLabel("<html><body><p style='color:white;font-size:15px'>Admin Section</p></body></html>");
		heading.setBounds(120,40,160,100);
		admin_frame.add(heading);
		
	    addl = new JButton("Add Librariran");
		addl.setBounds(90,145,200,40);
		addl.setBackground(Color.decode("#31B0D5"));
		addl.setForeground(Color.WHITE);
		admin_frame.add(addl);
		
		
		viewl = new JButton("View Librariran");
		viewl.setBounds(90,215,200,40);
		viewl.setBackground(Color.decode("#31B0D5"));
		viewl.setForeground(Color.WHITE);
		admin_frame.add(viewl);
		
		removel = new JButton("remove Librariran");
		removel.setBounds(90,285,200,40);
		removel.setBackground(Color.decode("#31B0D5"));
		removel.setForeground(Color.WHITE);
		admin_frame.add(removel);
		
		logoutl = new JButton("Log Out");
		logoutl.setBounds(90,355,200,40);
		logoutl.setBackground(Color.decode("#31B0D5"));
		logoutl.setForeground(Color.WHITE);
		admin_frame.add(logoutl);
		
		addl.addActionListener(this);
		viewl.addActionListener(this);
		removel.addActionListener(this);
		logoutl.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent x) {
		// TODO Auto-generated method stub
		
		if(x.getSource()==addl)
		{
		
			JFrame addl_frame =new JFrame("Add Librarian");
			
			JLabel admin_heading=new JLabel("<html><body><p style='color:white;font-size:20px'>Add Librarian</p></body></html>");
			admin_heading.setBounds(100,20,200,100);
			addl_frame.add(admin_heading);
			
			
			JLabel name=new JLabel("<html><body><p style='color:white;font-size:10px'>UserName :</p></body></html>");
			name.setBounds(40,90,100,100);
			addl_frame.add(name);
			
			JTextField name_input = new JTextField();
			name_input.setBounds(120,130,200,20);
			name_input.setBackground(Color.decode("#6C798C"));
			name_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			name_input.setForeground(Color.WHITE);
			addl_frame.add(name_input);
			
			JLabel email=new JLabel("<html><body><p style='color:white;font-size:10px'>Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></body></html>");
			email.setBounds(40,130,100,100);
			addl_frame.add(email);
			
			JTextField email_input = new JTextField();
			email_input.setBounds(120,170,200,20);
			email_input.setBackground(Color.decode("#6C798C"));
			email_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			email_input.setForeground(Color.WHITE);
			addl_frame.add(email_input);
			
			JLabel password=new JLabel("<html><body><p style='color:white;font-size:10px'>Password :</p></body></html>");
			password.setBounds(40,170,100,100);
			addl_frame.add(password);
			
			
			JPasswordField password_input = new JPasswordField();
			password_input.setBounds(120,210,200,20);
			password_input.setBackground(Color.decode("#6C798C"));
			password_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			password_input.setForeground(Color.WHITE);
			addl_frame.add(password_input);
			
			JLabel address=new JLabel("<html><body><p style='color:white;font-size:10px'>Address &nbsp;&nbsp; :</p></body></html>");
			address.setBounds(40,210,100,100);
			addl_frame.add(address);
			
			JTextField address_input = new JTextField();
			address_input.setBounds(120,250,200,20);
			address_input.setBackground(Color.decode("#6C798C"));
			address_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			address_input.setForeground(Color.WHITE);
			addl_frame.add(address_input);
			
			JLabel city=new JLabel("<html><body><p style='color:white;font-size:10px'>City &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</p></body></html>");
			city.setBounds(40,250,100,100);
			addl_frame.add(city);
			
			JTextField city_input = new JTextField();
			city_input.setBounds(120,290,200,20);
			city_input.setBackground(Color.decode("#6C798C"));
			city_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			city_input.setForeground(Color.WHITE);
			addl_frame.add(city_input);
			
			JLabel phone=new JLabel("<html><body><p style='color:white;font-size:10px'>Phone No :</p></body></html>");
			phone.setBounds(40,290,100,100);
			addl_frame.add(phone);
			
			JTextField phone_input = new JTextField();
			phone_input.setBounds(120,330,200,20);
			phone_input.setBackground(Color.decode("#6C798C"));
			phone_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			phone_input.setForeground(Color.WHITE);
			addl_frame.add(phone_input);
			
			JButton addl = new JButton("ADD");
			addl.setBounds(90,395,200,40);
			addl.setBackground(Color.decode("#FF9500"));
			addl.setForeground(Color.WHITE);
			addl_frame.add(addl);

			addl_frame.setSize(400,530);
			addl_frame.setLayout(null);
			addl_frame.setVisible(true);
			addl_frame.getContentPane().setBackground(Color.decode("#2B3C53"));
			
			addl.addActionListener ( new ActionListener()
			 {  
	            public void actionPerformed( ActionEvent e )  
	            {
	            	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
	            	
	            	if(name_input.getText().isEmpty() || email_input.getText().isEmpty() || password_input.getText().isEmpty() || address.getText().isEmpty() || city_input.getText().isEmpty() || phone_input.getText().isEmpty())
	            		JOptionPane.showMessageDialog(addl_frame,"Input Must Not Be Null.");
	            	else if(!email_input.getText().matches(emailRegex))
	            		JOptionPane.showMessageDialog(addl_frame,"invalid Email.");
	            	else if(password_input.getText().length()<4)
	            		JOptionPane.showMessageDialog(addl_frame,"Password length must be >=4");
	            	else if(phone_input.getText().length()!=10 || !phone_input.getText().matches("[0-9]+"))
	            		JOptionPane.showMessageDialog(addl_frame,"Enter valid number");	
	            	else
	            	{
	            		try {
	        				Class.forName("com.mysql.jdbc.Driver");  
	        				  
	        				//step2 create  the connection object  
	        				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
	        				  
	        				//step3 create the statement object  
	        				Statement stmt=con.createStatement();  
	        				  
	        				String user_email=email_input.getText();
	        				
	        				//step4 execute query  
	        				ResultSet rs=stmt.executeQuery("select * from librarian where email = '"+user_email+"'");  
	        				
	        				boolean count=true;
	        				
	        				while(rs.next())  
	        				if(rs.getString(1)!=null)
	        				count=false;
	        				
	        				if(!count)
	        				JOptionPane.showMessageDialog(addl_frame,"Email Already Exist");  
	        				else
	        				{
	        					String sql = "INSERT INTO librarian " +
	        			                   "VALUES ('" + name_input.getText()+"', '"+ email_input.getText()+"', '"+ password_input.getText()+"', '"+city_input.getText()+"' , '"+phone_input.getText()+"' , ' "+address_input.getText()+" ')";
	        					
	        					String sql1 = "INSERT INTO liblogin " +
	        			                   "VALUES ('"+email_input.getText()+"', '"+password_input.getText()+"', 'lib')";
	        					
	        					
	        					stmt.executeUpdate(sql);
	        					stmt.executeUpdate(sql1);
	        					JOptionPane.showMessageDialog(addl_frame,"Added Succesfully"); 
	        					
	        					email_input.setText("");
	        					name_input.setText("");
	        					password_input.setText("");
	        					city_input.setText("");
	        					phone_input.setText("");
	        					address_input.setText("");
		        				
	        					
	        				}
	        				  
	        				//step5 close the connection object  
	        				con.close();  
	        				
	        			}
	        			catch(Exception ll){ System.out.println(ll +"error");JOptionPane.showMessageDialog(addl,ll);}  

	            	}
	            		
	            	
	            }
			   
        });  
			
			
		}
		
		if(x.getSource()==viewl)
		{
			JFrame f=new JFrame("Librarian Record");    
		    String column[]={"User Name","Email","Password","Address","City","Phone"};         
		    DefaultTableModel model = new DefaultTableModel();
		    JTable jt=new JTable(model);
		    
		    model.addColumn("User Name");
		    model.addColumn("Email");
		    model.addColumn("Password");
		    model.addColumn("Address");
		    model.addColumn("City");
		    model.addColumn("Phone");
		    
		    try {
				Class.forName("com.mysql.jdbc.Driver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				  
				
				
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("select * from librarian");  
				
				
				while(rs.next())  
				model.addRow(new Object[] { rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(6),rs.getString(4),rs.getString(5) });
				
				
				  
				//step5 close the connection object  
				con.close();  
				
			}
			catch(Exception e){ System.out.println(e +"error");JOptionPane.showMessageDialog(f,e);}  

		    jt.setBounds(30,40,200,400);
		    
		    JScrollPane sp=new JScrollPane(jt);    
		    f.add(sp);          
		    f.setSize(1000,500);
		    f.setVisible(true); 
		}
		
		
		if(x.getSource() == removel)
		{
			JFrame remove_frame = new JFrame("Remove Librarian");
			
			JLabel remove_heading=new JLabel("<html><body><p style='color:white;font-size:20px'>Remove Librarian</p></body></html>");
			remove_heading.setBounds(80,20,300,100);
			remove_frame.add(remove_heading);
			
			JLabel email=new JLabel("<html><body><p style='color:white;font-size:10px'>Enter Email :</p></body></html>");
			email.setBounds(40,90,100,100);
			remove_frame.add(email);
			
			JTextField email_input = new JTextField();
			email_input.setBounds(140,130,200,20);
			email_input.setBackground(Color.decode("#6C798C"));
			email_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			email_input.setForeground(Color.WHITE);
			remove_frame.add(email_input);
			
			JButton addl = new JButton("Remove");
			addl.setBounds(85,200,200,40);
			addl.setBackground(Color.decode("#FF9500"));
			addl.setForeground(Color.WHITE);
			remove_frame.add(addl);
			
			remove_frame.setSize(400,340);
			remove_frame.setLayout(null);
			remove_frame.setVisible(true);
			remove_frame.getContentPane().setBackground(Color.decode("#2B3C53"));
			
			addl.addActionListener ( new ActionListener()
			 {  
	            public void actionPerformed( ActionEvent e )  
	            {
	            	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
	            	
	            	if(email_input.getText().isEmpty())
	            		JOptionPane.showMessageDialog(remove_frame,"Input Must Not Be Null.");
	            	else if(!email_input.getText().matches(emailRegex))
	            		JOptionPane.showMessageDialog(remove_frame,"invalid Email.");
	            	else
	            	{
	            		try {
	            			Class.forName("com.mysql.jdbc.Driver");  
	            			  
	            			//step2 create  the connection object  
	            			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
	            			  
	            			//step3 create the statement object  
	            			Statement stmt=con.createStatement();  
	            			  
	            			String g=email_input.getText();
	            			
	            			//step4 execute query  
	            			ResultSet rs=stmt.executeQuery("select * from librarian where email = '"+g+"'");  
	            			
	            			boolean counter = false;
	            			
	            			while(rs.next() )  
	            			counter=true;
	            			
	            			if(counter)
	            			{
	            			String sql = "DELETE FROM librarian " +
	            	                   "where email = '"+g+"'";
	            			
	            			String sql1 = "DELETE FROM liblogin " +
	            					"where email = '"+g+"'";
	            			
	            			
	            			stmt.executeUpdate(sql);
	            			stmt.executeUpdate(sql1);
	            			JOptionPane.showMessageDialog(remove_frame,"Deleted Successfully");	
	            			email_input.setText("");
	            			}
	            			
	            			else
	            			
	            				JOptionPane.showMessageDialog(remove_frame,"Email Donot Exist");	
	            			
	            			
	            			  
	            			//step5 close the connection object  
	            			con.close();  
	            			
	            		}
	            		catch(Exception ll){ System.out.println(ll +"error");JOptionPane.showMessageDialog(remove_frame,ll);}  
	            	}
	            		
	            	
	            }
	            
	          });  
			
			
		}
		
		if(x.getSource()==logoutl)
		{
			main.login();
			admin_frame.dispose();
		}
		
	}
	
	//end 
	
	
}


public class admin {
	
	static void admin() {
		
		JFrame admin_frame =new JFrame("Admin LogIn");
		
		new build(admin_frame);
		
		admin_frame.setSize(400,530);
		admin_frame.setLayout(null);
		admin_frame.setVisible(true);
		admin_frame.getContentPane().setBackground(Color.decode("#2B3C53"));
		admin_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
}
	
	
	public static void main(String[] args)
	{
		admin();
	}

	
	
}
