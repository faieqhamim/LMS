import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePassword extends JFrame implements ActionListener
{
	private JLabel myLabel1,myLabel2,myLabel3;
	private JTextField textField1,textField2,textField3;
	private JButton submit,cancel; 
	private JPanel panel;
	private JTextArea j;
	private String userId,password;
	
	public ChangePassword(String userId)
	{
		super("Change Password");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.userId=userId;
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
		myLabel1=new JLabel("Old PassWord");
		myLabel1.setBounds(120,100,150,50);
		panel.add(myLabel1);
		
		myLabel2=new JLabel("New PassWord");
		myLabel2.setBounds(120,200,150,50);
		panel.add(myLabel2);
		
		myLabel3=new JLabel("Confirm PassWord");
		myLabel3.setBounds(120,300,150,50);
		panel.add(myLabel3);
		
		textField1=new JTextField();
		textField1.setBounds(250,100,350,50);
		panel.add(textField1);
		
		textField2=new JTextField();
		textField2.setBounds(250,200,350,50);
		panel.add(textField2);
		
		textField3=new JTextField();
		textField3.setBounds(250,300,350,50);
		panel.add(textField3);
		
		submit=new JButton("Submit");
		submit.setBackground( new Color(0,184,89));
		submit.setBounds(250,400,100,50);
		panel.add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBackground( new Color(0,184,89));
		cancel.setBounds(400,400,100,50);
		panel.add(cancel);
		
		j=new JTextArea();
		j.setBackground(Color.WHITE);
		j.setBounds(5,5,770,540);
		j.setEditable(false);
		panel.add(j);
		
		submit.addActionListener(this);
        cancel.addActionListener(this);
		
		this.setVisible(true);
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent a)
	{	
		String password=textField3.getText();
		
		if(a.getSource()==submit)
		{
			Connection con=null;
			Statement st = null;
			ResultSet rs = null;
			
			String query = "SELECT `id`,`password` FROM `librarian` WHERE id ="+'"'+this.userId+'"';
			
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");//load driver
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1?useTimezone=true&serverTimezone=UTC","root","");
				System.out.println("connection done");//connection with database established
				st = con.createStatement();//create statement
				System.out.println("statement created");
				rs = st.executeQuery(query);//getting result
				System.out.println("results received");
					System.out.println(".");
				
				query = "UPDATE `librarian` SET `password`="+password+" where id="+'"'+this.userId+'"';
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(this,"Changeing PassWord Successfully"); 
			}
			catch(Exception e){System.out.println(e.getMessage());}	
		}
		else if (a.getSource()==cancel)
		{
			this.setVisible(false);
			new Settings(userId);
		}
		else{}
	}
	
}