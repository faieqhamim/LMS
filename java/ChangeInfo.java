import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangeInfo extends JFrame implements ActionListener
{
	private JLabel myLabel1,myLabel2;
	private JTextField textField1,textField2;
	private JButton submit,cancel; 
	private JPanel panel;
	private JTextArea j;
	private String userId,name;
	
	public ChangeInfo(String userId)
	{
		super("Change Information");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.userId=userId;
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
		myLabel1=new JLabel("Enter New Name");
		myLabel1.setBounds(50,150,150,50);
		panel.add(myLabel1);
		
		myLabel2=new JLabel("Confirm Name");
		myLabel2.setBounds(50,250,150,50);
		panel.add(myLabel2);
		
		textField1=new JTextField();
		textField1.setBounds(210,150,250,50);
		panel.add(textField1);
		
		textField2=new JTextField();
		textField2.setBounds(210,250,250,50);
		panel.add(textField2);
		
		submit=new JButton("Submit");
		submit.setBackground( new Color(0,184,89));
		submit.setBounds(135,350,100,50);
		panel.add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBackground( new Color(0,184,89));
		cancel.setBounds(285,350,100,50);
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
		String name=textField2.getText();
		
		if(a.getSource()==submit)
		{
			Connection con=null;
			Statement st = null;
			ResultSet rs = null;
			
			String query = "SELECT `id`, `name`,`password` FROM `librarian` WHERE id ="+'"'+this.userId+'"';
			
			
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
				
				query = "UPDATE `librarian` SET `name`="+'"'+name+'"'+" where id="+'"'+this.userId+'"';
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(this,"Changeing Name Successfully"); 
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