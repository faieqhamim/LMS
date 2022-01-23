import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentProfile extends JFrame implements ActionListener
{

	private JLabel myLabel1,myLabel2,myLabel3,myLabel4;
	private JButton back;
	private JPanel panel;
	private JTextArea j;
	private String userId;
	
	public StudentProfile(String userId,String name,String password)
	{
		super("Student Profile");
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.userId=userId;
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
	    myLabel1 = new JLabel("PROFILE DETAILS");
		myLabel1.setBounds(200, 20, 600, 50);
		panel.add(myLabel1);
		
		myLabel2=new JLabel("Name :"+name);
		myLabel2.setBounds(200,80,300,50);
		panel.add(myLabel2);
		
		myLabel3=new JLabel("ID :"+userId);
		myLabel3.setBounds(200,150,200,50);
		panel.add(myLabel3);
		
		myLabel4=new JLabel("Password :"+password);
		myLabel4.setBounds(200,220,200,50);
		panel.add(myLabel4);
		
		back = new JButton("BACK");
		back.setBackground( new Color(0,184,89));
		back.setBounds(200, 300, 100, 50);
		panel.add(back);
		
		j=new JTextArea();
		j.setBackground(Color.WHITE);
		j.setBounds(5,5,770,540);
		j.setEditable(false);
		panel.add(j);
		
		back.addActionListener(this);
		
		this.setVisible(true);
		this.add(panel);
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	{	
		if (a.getSource()==back)
		{
			this.setVisible(false);
			new StudentHomepage(userId);
		}
		else{}
	}
}