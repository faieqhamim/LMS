import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentSettings extends JFrame implements ActionListener
{

	private JButton changePassword, changeInfo, back;
	private JPanel panel;
	private JTextArea j;
	private String userId;
	
	public StudentSettings(String userId)
	{
		super("Student Settings");
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.userId=userId;
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,500,600);
		panel.setLayout(null);
		
	
		
		changePassword = new JButton("CHANGE PASSWORD");
		changePassword.setBackground( new Color(0,184,89));
		changePassword.setBounds(150, 100, 200, 50);
		panel.add(changePassword);
		
		changeInfo = new JButton("CHANGE INFORMATION");
		changeInfo.setBackground( new Color(0,184,89));
		changeInfo.setBounds(150, 200, 200, 50);
		panel.add(changeInfo);
		
		back = new JButton("BACK");
		back.setBackground( new Color(0,184,89));
		back.setBounds(200, 300, 100, 50);
		panel.add(back);
		
		j=new JTextArea();
		j.setBackground(Color.WHITE);
		j.setBounds(5,5,770,540);
		j.setEditable(false);
		panel.add(j);
		
		changePassword.addActionListener(this);
		changeInfo.addActionListener(this);
		back.addActionListener(this);
		
		this.setVisible(true);
		this.add(panel);
		
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	{	
		if (a.getSource()==changePassword)
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
							String name = rs.getString("name");
							StudentChangePassword ush = new StudentChangePassword(this.userId,name);
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
		else if (a.getSource()==changeInfo)
		{
			Connection con=null;//for connection
			Statement st = null;//for query execution
			ResultSet rs = null;
			try
					{
						String query =  "SELECT `id`, `password` FROM `student` WHERE id ="+'"'+userId+'"';
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
							String password = rs.getString("password");
							StudentChangeInfo ush = new StudentChangeInfo(this.userId,password);
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
		else if (a.getSource()==back)
		{
			this.setVisible(false);
			new StudentHomepage(userId);
		}
		else{}
	}
}