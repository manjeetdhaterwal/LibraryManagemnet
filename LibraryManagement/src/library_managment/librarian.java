package library_managment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

class book implements ActionListener{
	
	JFrame lib_frame;
	JButton add_book;
	JButton view_book;
	JButton issue_book;
	JButton view_issue_book;
	JButton return_book;
	JButton logout;
	
	
	book(JFrame lib_frame)
	{
		this.lib_frame=lib_frame;
		JLabel heading=new JLabel("<html><body><p style='color:white;font-size:15px'>Librarian Section</p></body></html>");
		heading.setBounds(110,10,200,100);
		lib_frame.add(heading);
		
		add_book = new JButton("Add Book");
		add_book.setBounds(90,100,200,40);
		add_book.setBackground(Color.decode("#31B0D5"));
		add_book.setForeground(Color.WHITE);
		lib_frame.add(add_book);
		
		view_book = new JButton("View Book");
		view_book.setBounds(90,160,200,40);
		view_book.setBackground(Color.decode("#31B0D5"));
		view_book.setForeground(Color.WHITE);
		lib_frame.add(view_book);
		
		issue_book = new JButton("Issue Book");
		issue_book.setBounds(90,220,200,40);
		issue_book.setBackground(Color.decode("#31B0D5"));
		issue_book.setForeground(Color.WHITE);
		lib_frame.add(issue_book);
		
		view_issue_book = new JButton("View Issue Book");
		view_issue_book.setBounds(90,280,200,40);
		view_issue_book.setBackground(Color.decode("#31B0D5"));
		view_issue_book.setForeground(Color.WHITE);
		lib_frame.add(view_issue_book);
		
		return_book = new JButton("Return Book");
		return_book.setBounds(90,340,200,40);
		return_book.setBackground(Color.decode("#31B0D5"));
		return_book.setForeground(Color.WHITE);
		lib_frame.add(return_book);
		
		logout = new JButton("Logout");
		logout.setBounds(90,400,200,40);
		logout.setBackground(Color.decode("#31B0D5"));
		logout.setForeground(Color.WHITE);
		lib_frame.add(logout);
		
		add_book.addActionListener(this);;
		view_book.addActionListener(this);;
		issue_book.addActionListener(this);;
		view_issue_book.addActionListener(this);;
		return_book.addActionListener(this);;
		logout.addActionListener(this);;
		
	}


	@Override
	public void actionPerformed(ActionEvent x) {
		
		if(x.getSource()==add_book)
		{
JFrame add_book_frame =new JFrame("Add Book");
			
			JLabel admin_heading=new JLabel("<html><body><p style='color:white;font-size:20px'>Add Book</p></body></html>");
			admin_heading.setBounds(130,30,200,100);
			add_book_frame.add(admin_heading);
			
			
			JLabel call=new JLabel("<html><body><p style='color:white;font-size:10px'>Call No.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></body></html>");
			call.setBounds(40,100,100,100);
			add_book_frame.add(call);
			
			JTextField call_input = new JTextField();
			call_input.setBounds(120,140,200,20);
			call_input.setBackground(Color.decode("#6C798C"));
			call_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			call_input.setForeground(Color.WHITE);
			add_book_frame.add(call_input);
			
			JLabel name=new JLabel("<html><body><p style='color:white;font-size:10px'>Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></body></html>");
			name.setBounds(40,150,100,100);
			add_book_frame.add(name);
			
			JTextField name_input = new JTextField();
			name_input.setBounds(120,190,200,20);
			name_input.setBackground(Color.decode("#6C798C"));
			name_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			name_input.setForeground(Color.WHITE);
			add_book_frame.add(name_input);
			
			JLabel author=new JLabel("<html><body><p style='color:white;font-size:10px'>Author &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></body></html>");
			author.setBounds(40,200,100,100);
			add_book_frame.add(author);
			
			
			JTextField author_input = new JTextField();
			author_input.setBounds(120,240,200,20);
			author_input.setBackground(Color.decode("#6C798C"));
			author_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			author_input.setForeground(Color.WHITE);
			add_book_frame.add(author_input);
			
			JLabel publisher=new JLabel("<html><body><p style='color:white;font-size:10px'>Publisher &nbsp;&nbsp;:</p></body></html>");
			publisher.setBounds(40,250,100,100);
			add_book_frame.add(publisher);
			
			JTextField publisher_input = new JTextField();
			publisher_input.setBounds(120,290,200,20);
			publisher_input.setBackground(Color.decode("#6C798C"));
			publisher_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			publisher_input.setForeground(Color.WHITE);
			add_book_frame.add(publisher_input);
			
			JLabel quantity=new JLabel("<html><body><p style='color:white;font-size:10px'>Quantity &nbsp;&nbsp;&nbsp;:</p></body></html>");
			quantity.setBounds(40,300,100,100);
			add_book_frame.add(quantity);
			
			JTextField quantity_input = new JTextField();
			quantity_input.setBounds(120,340,200,20);
			quantity_input.setBackground(Color.decode("#6C798C"));
			quantity_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			quantity_input.setForeground(Color.WHITE);
			add_book_frame.add(quantity_input);
			
			
			JButton addl = new JButton("ADD");
			addl.setBounds(90,400,200,40);
			addl.setBackground(Color.decode("#FF9500"));
			addl.setForeground(Color.WHITE);
			add_book_frame.add(addl);

			add_book_frame.setSize(400,530);
			add_book_frame.setLayout(null);
			add_book_frame.setVisible(true);
			add_book_frame.getContentPane().setBackground(Color.decode("#2B3C53"));
			
			
			addl.addActionListener ( new ActionListener()
			 {  
	            public void actionPerformed( ActionEvent e )  
	            {
	            	if(call_input.getText().isEmpty() || name_input.getText().isEmpty() || author_input.getText().isEmpty() || publisher_input.getText().isEmpty() || quantity_input.getText().isEmpty())
	            		JOptionPane.showMessageDialog(add_book_frame,"Input Must Not Be Null.");
	            	else
	            	{
	            		try {
	        				Class.forName("com.mysql.jdbc.Driver");  
	        				  
	        				//step2 create  the connection object  
	        				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
	        				  
	        				//step3 create the statement object  
	        				Statement stmt=con.createStatement();  
	        				  
	        				String user_call=call_input.getText();
	        				
	        				//step4 execute query  
	        				ResultSet rs=stmt.executeQuery("select * from libbooks where CallNo = '"+user_call+"'");  
	        				
	        				boolean count=true;
	        				
	        				while(rs.next())  
	        				if(rs.getString(1)!=null)
	        				{count=false;break;}
	        				
	        				if(!count)
	        				{
	        					int old=Integer.parseInt(rs.getString(5));
	        					int newb=Integer.parseInt(quantity_input.getText());
	        					newb+=old;
	        					
	        					
	        					String sql = "update libbooks" +
	        								" set quantity = ' "+newb+" '"+
		            	                   "where callno = '"+user_call+"'";
	        					stmt.executeUpdate(sql);
	        					JOptionPane.showMessageDialog(add_book_frame,"Added Succesfully"); 
	        					
	        				}
	        				else
	        				{
	        					String sql = "INSERT INTO libbooks " +
	        			                   "VALUES ('" + call_input.getText()+"', '"+ name_input.getText()+"', '"+ author_input.getText()+"', '"+publisher_input.getText()+"' , '"+quantity_input.getText()+"' , 0)";
	        					
	        					stmt.executeUpdate(sql);
	        					JOptionPane.showMessageDialog(add_book_frame,"Added Succesfully"); 
	        					
	        					
	        					
		        				
	        					
	        				}
	        				
	        				call_input.setText("");
        					name_input.setText("");
        					author_input.setText("");
        					publisher_input.setText("");
        					quantity_input.setText("");
	        				  
	        				//step5 close the connection object  
	        				con.close();  
	        				
	        			}
	        			catch(Exception ll){ System.out.println(ll +"error");JOptionPane.showMessageDialog(add_book_frame,ll); 
    					}  

	            	}
	            }
	            
			 });   
			
		}
		
		
		if(x.getSource()==view_book)
		{
			JFrame f=new JFrame("Librarian Record");    
		    String column[]={"User Name","Email","Password","Address","City","Phone"};         
		    DefaultTableModel model = new DefaultTableModel();
		    JTable jt=new JTable(model);
		    
		    model.addColumn("Call No.");
		    model.addColumn("Name");
		    model.addColumn("Author");
		    model.addColumn("Issued");
		    model.addColumn("Publisher");
		    model.addColumn("Quantity");
		    
		    
		    try {
				Class.forName("com.mysql.jdbc.Driver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				  
				
				
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("select * from libbooks");  
				
				
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
		
		
		if(x.getSource()==issue_book)
		{
JFrame issue_book_frame =new JFrame("Issue Book");
			
			JLabel admin_heading=new JLabel("<html><body><p style='color:white;font-size:20px'>Issue Book</p></body></html>");
			admin_heading.setBounds(110,30,200,100);
			issue_book_frame.add(admin_heading);
			
			
			JLabel call=new JLabel("<html><body><p style='color:white;font-size:10px'>Call No.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></body></html>");
			call.setBounds(40,100,100,100);
			issue_book_frame.add(call);
			
			JTextField call_input = new JTextField();
			call_input.setBounds(120,140,200,20);
			call_input.setBackground(Color.decode("#6C798C"));
			call_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			call_input.setForeground(Color.WHITE);
			issue_book_frame.add(call_input);
			
			JLabel id=new JLabel("<html><body><p style='color:white;font-size:10px'>Studemt Id :</p></body></html>");
			id.setBounds(40,150,100,100);
			issue_book_frame.add(id);
			
			JTextField id_input = new JTextField();
			id_input.setBounds(120,190,200,20);
			id_input.setBackground(Color.decode("#6C798C"));
			id_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			id_input.setForeground(Color.WHITE);
			issue_book_frame.add(id_input);
			
			JLabel name=new JLabel("<html><body><p style='color:white;font-size:10px'>Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></body></html>");
			name.setBounds(40,200,100,100);
			issue_book_frame.add(name);
			
			
			JTextField name_input = new JTextField();
			name_input.setBounds(120,240,200,20);
			name_input.setBackground(Color.decode("#6C798C"));
			name_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			name_input.setForeground(Color.WHITE);
			issue_book_frame.add(name_input);
			
			JLabel phone=new JLabel("<html><body><p style='color:white;font-size:10px'>Contact No :</p></body></html>");
			phone.setBounds(40,250,100,100);
			issue_book_frame.add(phone);
			
			JTextField phone_input = new JTextField();
			phone_input.setBounds(120,290,200,20);
			phone_input.setBackground(Color.decode("#6C798C"));
			phone_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			phone_input.setForeground(Color.WHITE);
			issue_book_frame.add(phone_input);
			
			JLabel branch=new JLabel("<html><body><p style='color:white;font-size:10px'>Branch &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></body></html>");
			branch.setBounds(40,300,100,100);
			issue_book_frame.add(branch);
			
			JTextField branch_input = new JTextField();
			branch_input.setBounds(120,340,200,20);
			branch_input.setBackground(Color.decode("#6C798C"));
			branch_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			branch_input.setForeground(Color.WHITE);
			issue_book_frame.add(branch_input);
			
			
			JButton addl = new JButton("Issue");
			addl.setBounds(90,400,200,40);
			addl.setBackground(Color.decode("#FF9500"));
			addl.setForeground(Color.WHITE);
			issue_book_frame.add(addl);

			issue_book_frame.setSize(400,530);
			issue_book_frame.setLayout(null);
			issue_book_frame.setVisible(true);
			issue_book_frame.getContentPane().setBackground(Color.decode("#2B3C53"));
			
			addl.addActionListener ( new ActionListener()
			 {  
	            public void actionPerformed( ActionEvent e )  
	            {
	            	
	            	if(call_input.getText().isEmpty() || id_input.getText().isEmpty() || name_input.getText().isEmpty() || phone_input.getText().isEmpty() || branch_input.getText().isEmpty())
	            		{JOptionPane.showMessageDialog(issue_book_frame,"Values Cannot Be Empty");
    				return;}
	            	else if(phone_input.getText().length()!=10 || !phone_input.getText().matches("[0-9]+"))
	            		{JOptionPane.showMessageDialog(issue_book_frame,"Enter valid number");	
	            		return ;
	            		}
	            	
	            	try {
	    				Class.forName("com.mysql.jdbc.Driver");  
	    				  
	    				//step2 create  the connection object  
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
	    				  
	    				//step3 create the statement object  
	    				Statement stmt=con.createStatement();  
	    				  
	    				String g=call_input.getText();
	    				
	    				//step4 execute query  
	    				ResultSet rs=stmt.executeQuery("select * from issue where callno = '"+g+"' and id = '"+ id_input.getText() +"'");  
	    				
	    				boolean count=true;
	    				
	    				while(rs.next())  
	    				
	    				{JOptionPane.showMessageDialog(issue_book_frame,"Book already issued by this student");
	    				return;
	    				
	    				} 
	    				
	    				  rs=stmt.executeQuery("select * from libbooks where callno = '"+g+"'");  
	    				
	    				 while(rs.next())  
		        		 if(rs.getString(1)!=null)
		        		 {count=false;break;}
		        				
		        		  if(count)
		        			{
		        			  JOptionPane.showMessageDialog(issue_book_frame,"Book Not Exist");
			    				return;		
		        			}
	    				 
		        		  int old=Integer.parseInt(rs.getString(5));
      					  old=old-1;
      					  
      					  int iss=Integer.parseInt(rs.getString(6));
      					  iss=iss+1;
      					  
      					LocalDateTime myDateObj = LocalDateTime.now(); 
      					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
      				    
      				    String myObj = myDateObj.format(myFormatObj); 
      					  
      					String sql = "update libbooks" +
								" set quantity = ' "+old+" '"+
        	                   "where callno = '"+g+"'";
      					
      					String sql1 = "update libbooks" +
								" set issued = ' "+iss+" '"+
        	                   "where callno = '"+g+"'";
      					
      					String sql2 = "INSERT INTO issue " +
 			                   "VALUES ('" + call_input.getText()+"', '"+ id_input.getText()+"', '"+ name_input.getText()+"', '"+phone_input.getText()+"' , '"+branch_input.getText()+"' , '" +myObj+"')";
 					
      					
      				stmt.executeUpdate(sql2);	
					stmt.executeUpdate(sql);
					stmt.executeUpdate(sql1);
					
					JOptionPane.showMessageDialog(issue_book_frame,"Issue Succesfully"); 
					
					call_input.setText("");
					name_input.setText("");
					id_input.setText("");
					branch_input.setText("");
					phone_input.setText("");
		        		  
	    				//step5 close the connection object  
	    				con.close();  
	    				
	    			}
	    			catch(Exception ll){ System.out.println(ll +"error");JOptionPane.showMessageDialog(issue_book_frame,ll);}  

	            }
			 });  
			
		}

		
		if(x.getSource()==view_issue_book)
		{
			JFrame f=new JFrame("View Issue Book");    
		    DefaultTableModel model = new DefaultTableModel();
		    JTable jt=new JTable(model);
		    
		    model.addColumn("Call No.");
		    model.addColumn("Student Id");
		    model.addColumn("Name");
		    model.addColumn("Phone");
		    model.addColumn("Branch");
		    model.addColumn("Issued Date");
		    
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");  
				  
				//step2 create  the connection object  
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				  
				
				
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("select * from issue");  
				
				
				while(rs.next())  
				model.addRow(new Object[] { rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) });
				
				
				  
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
		
		if(x.getSource()==return_book)
		{
JFrame return_frame = new JFrame("Return Book");
			
			JLabel remove_heading=new JLabel("<html><body><p style='color:white;font-size:20px'>Return Book</p></body></html>");
			remove_heading.setBounds(100,20,300,100);
			return_frame.add(remove_heading);
			
			JLabel call=new JLabel("<html><body><p style='color:white;font-size:10px'>Call No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</p></body></html>");
			call.setBounds(40,90,100,100);
			return_frame.add(call);
			
			JTextField call_input = new JTextField();
			call_input.setBounds(140,130,200,20);
			call_input.setBackground(Color.decode("#6C798C"));
			call_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			call_input.setForeground(Color.WHITE);
			return_frame.add(call_input);
			
			JLabel id=new JLabel("<html><body><p style='color:white;font-size:10px'>Student id :</p></body></html>");
			id.setBounds(40,140,100,100);
			return_frame.add(id);
			
			JTextField id_input = new JTextField();
			id_input.setBounds(140,180,200,20);
			id_input.setBackground(Color.decode("#6C798C"));
			id_input.setBorder(new LineBorder(Color.decode("#6C798C")));
			id_input.setForeground(Color.WHITE);
			return_frame.add(id_input);
			
			JButton addl = new JButton("Return");
			addl.setBounds(85,235,200,40);
			addl.setBackground(Color.decode("#FF9500"));
			addl.setForeground(Color.WHITE);
			return_frame.add(addl);
			
			return_frame.setSize(400,340);
			return_frame.setLayout(null);
			return_frame.setVisible(true);
			return_frame.getContentPane().setBackground(Color.decode("#2B3C53"));
			
			addl.addActionListener ( new ActionListener()
			 {  
	            public void actionPerformed( ActionEvent e )  
	            {
	            	if(call_input.getText().isEmpty() || id_input.getText().isEmpty())
	            	{JOptionPane.showMessageDialog(return_frame,"Values Cannot Be Empty");
    				return;}
	            	
	            	try {
	    				Class.forName("com.mysql.jdbc.Driver");  
	    				  
	    				//step2 create  the connection object  
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
	    				  
	    				//step3 create the statement object  
	    				Statement stmt=con.createStatement();  
	    				  
	    				String g=call_input.getText();
	    				
	    				//step4 execute query  
	    				ResultSet rs=stmt.executeQuery("select * from issue where CallNo = '"+g+"' and id = '"+ id_input.getText() +"'");  
	    				
	    				boolean count=true;
	    				
	    				while(rs.next())  
	    				count=false;
	    				
	    				if(count)
	    				{
	    					JOptionPane.showMessageDialog(return_frame,"Invalid");
		    				return;
	    				}
	    				
	    				count=true;
	    				
	    				  rs=stmt.executeQuery("select * from libbooks where callno = '"+g+"'");  
	    				
	    				 while(rs.next())  
		        		 if(rs.getString(1)!=null)
		        		 {count=false;break;}
		        				
		        		  if(count)
		        			{
		        			  JOptionPane.showMessageDialog(return_frame,"Book Not Exist");
			    				return;		
		        			}
	    				 
		        		  int old=Integer.parseInt(rs.getString(5));
      					  old=old+1;
      					  
      					  int iss=Integer.parseInt(rs.getString(6));
      					  iss=iss-1;
      					  
      					LocalDateTime myDateObj = LocalDateTime.now(); 
      					DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-mm-dd");  
      				    
      				    String myObj = myDateObj.format(myFormatObj); 
      					  
      					String sql = "update libbooks" +
								" set quantity = ' "+old+" '"+
        	                   "where callno = '"+g+"'";
      					
      					String sql1 = "update libbooks" +
								" set issued = ' "+iss+" '"+
        	                   "where callno = '"+g+"'";
      					
      					String sql2 = "DELETE FROM issue " +
      							"where callno = '"+g+"' and id = '"+ id_input.getText() +"'";
      					
      				stmt.executeUpdate(sql2);	
					stmt.executeUpdate(sql);
					stmt.executeUpdate(sql1);
					
					JOptionPane.showMessageDialog(return_frame,"Returned Succesfully"); 
					
					call_input.setText("");
					id_input.setText("");
					
		        		  
	    				//step5 close the connection object  
	    				con.close();  
	    				
	    			}
	    			catch(Exception ll){ System.out.println(ll +"error");JOptionPane.showMessageDialog(return_frame,ll);}  

	            	
	            }
			 });
		}
		
		if(x.getSource()==logout)
		{
			main.login();
			lib_frame.dispose();
		}

	}

//end
}


public class librarian {
	
	static void  librarian()
	{

		JFrame lib_frame =new JFrame("Librarian LogIn");
		 new book(lib_frame);
		lib_frame.setSize(400,530);
		lib_frame.setLayout(null);
		lib_frame.setVisible(true);
		lib_frame.getContentPane().setBackground(Color.decode("#2B3C53"));
		lib_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		librarian();
	}

}
