import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Settings extends JFrame implements ActionListener
{

	private JButton changePassword, changeinfo, back;
	private JPanel panel;
	private JTextArea j;
	private String userId;
	
	public Settings(String userId)
	{
		super("Librarian Settings");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.userId=userId;
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
	
		
		changePassword = new JButton("CHANGE PASSWORD");
		changePassword.setBackground( new Color(0,184,89));
		changePassword.setBounds(200, 175, 400, 100);
		panel.add(changePassword);
		
		changeinfo = new JButton("CHANGE INFORMATION");
		changeinfo.setBackground( new Color(0,184,89));
		changeinfo.setBounds(200, 325, 400, 100);
		panel.add(changeinfo);
		
		back = new JButton("BACK");
		back.setBackground( new Color(0,184,89));
		back.setBounds(620, 480, 100, 50);
		panel.add(back);
		
		j=new JTextArea();
		j.setBackground(Color.WHITE);
		j.setBounds(5,5,770,540);
		j.setEditable(false);
		panel.add(j);
		
		changePassword.addActionListener(this);
		changeinfo.addActionListener(this);
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
						String query =  "SELECT `id`, `name` FROM `librarian` WHERE id ="+'"'+userId+'"';
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
							ChangePassword ush = new ChangePassword(this.userId);
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
		else if (a.getSource()==changeinfo)
		{
			Connection con=null;//for connection
			Statement st = null;//for query execution
			ResultSet rs = null;
			try
					{
						String query =  "SELECT `id`, `password` FROM `librarian` WHERE id ="+'"'+userId+'"';
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
							ChangeInfo ush = new ChangeInfo(this.userId);
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
			new Homepage(userId);
		}
		else{}
	}
}