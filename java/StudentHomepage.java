import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentHomepage extends JFrame implements ActionListener
{
	private JButton  profile, bookRequest, settings, logout;
	private JPanel panel;
	private JTextArea j;
	private String userId;
	
	public StudentHomepage(String userId)
	{
		
		super("Student Homepage");
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.userId=userId;
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,500,600);
		panel.setLayout(null);
		
		
		profile = new JButton("PROFILE");
		profile.setBackground( new Color(0,184,89));
		profile.setBounds(130, 105,200,50);
		panel.add(profile);
		
		bookRequest = new JButton("BOOK REQUEST");
		bookRequest.setBackground( new Color(0,184,89));
		bookRequest.setBounds(130,200, 200, 50);
		panel.add(bookRequest);
		
		
		settings = new JButton("SETTINGS");
		settings.setBackground( new Color(0,184,89));
		settings.setBounds(130, 295, 200, 50);
		panel.add(settings);
		
		logout = new JButton("LOG OUT");
		logout.setBackground( new Color(0,184,89));
		logout.setBounds(130, 390, 200, 50);
		panel.add(logout);
		
		j=new JTextArea();
		j.setBackground(Color.WHITE);
		j.setBounds(5,5,770,540);
		j.setEditable(false);
		panel.add(j);
		
		profile.addActionListener(this);
		bookRequest.addActionListener(this);
		settings.addActionListener(this);
		logout.addActionListener(this);
		
		this.setVisible(true);
		this.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent a)
	{	
	
		
		if(a.getSource()==profile)
		{
			Connection con=null;//for connection
			Statement st = null;//for query execution
			ResultSet rs = null;//to get row by row result from DB
				     
			try
			{
				String query = "SELECT `id`, `name`,`password` FROM `student` WHERE id ="+'"'+this.userId+'"';
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1?useTimezone=true&serverTimezone=UTC","root","");
				System.out.println("connection done");
				st = con.createStatement();
				System.out.println("statement created");
				rs = st.executeQuery(query);
				System.out.println("results received");
						
				while(rs.next())
				{
					String userId = rs.getString("id");
					String na = rs.getString("name");
					String pass = rs.getString("password");
					StudentProfile ush = new StudentProfile(this.userId,na,pass);;
					this.setVisible(false);
					ush.setVisible(true);
				}			
			}
				catch(Exception ex)
				{
					System.out.println("Exception");
				}
					finally
					{
						try
						{
							if(rs!=null)
								rs.close();

							if(st!=null)
								st.close();

							if(con!=null)
								con.close();
						}
						catch(Exception ex){}
					}
				
		}
		
		else if (a.getSource()==bookRequest)
		{
			Connection con=null;//for connection
			Statement st = null;//for query execution
			ResultSet rs = null;    
					try
					{
						String query =  "SELECT `id`,`book1`,`book2` FROM `student` WHERE id ="+'"'+userId+'"';
						Class.forName("com.mysql.cj.jdbc.Driver");
						System.out.println("driver loaded");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1?useTimezone=true&serverTimezone=UTC","root","");
						System.out.println("connection done");
						st = con.createStatement();
						System.out.println("statement created");
						rs = st.executeQuery(query);
						System.out.println("results received");
								
						while(rs.next())
						{
							String userId = rs.getString("id");
							String book1 = rs.getString("book1");
							String book2 = rs.getString("book2");
							StudentBookRequest ush = new StudentBookRequest(this.userId,book1,book2);
							this.setVisible(false);
							ush.setVisible(true);
						}
								
					}			
					catch(Exception ex)
					{
						System.out.println("Exception ");
					}
					finally
					{
						try
						{
							if(rs!=null)
								rs.close();

							if(st!=null)
								st.close();

							if(con!=null)
								con.close();
						}
						catch(Exception ex){}
					}
					
		}
		
		
		
		else if (a.getSource()==settings)
		{
			Connection con=null;//for connection
			Statement st = null;//for query execution
			ResultSet rs = null;
			try
					{
						String query =  "SELECT `id`, `name` FROM `student` WHERE id ="+'"'+userId+'"';
						Class.forName("com.mysql.cj.jdbc.Driver");
						System.out.println("driver loaded");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1?useTimezone=true&serverTimezone=UTC","root","");
						System.out.println("connection done");
						st = con.createStatement();
						System.out.println("statement created");
						rs = st.executeQuery(query);
						System.out.println("results received");
								
						while(rs.next())
						{
							String userId = rs.getString("id");
							StudentSettings ush = new StudentSettings(this.userId);
							this.setVisible(false);
							ush.setVisible(true);
						}
								
					}			
					catch(Exception ex)
					{
						System.out.println("Exception ");
					}
					finally
					{
						try
						{
							if(rs!=null)
								rs.close();

							if(st!=null)
								st.close();

							if(con!=null)
								con.close();
						}
						catch(Exception ex){}
					}
		}
		else if (a.getSource()==logout)
		{
			this.setVisible(false);
			//new LibraryManagementSystem();
		}
		else{}
	}
}