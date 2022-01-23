import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Profile extends JFrame implements ActionListener
{

	private JLabel l1,myLabel2,myLabel3,myLabel4;
	private JButton back;
	private JPanel panel;
	private JTextArea j;
	private String userId;
	
	public Profile(String userId,String name,String password)
	{
		super("Librarian Profile");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
	    l1 = new JLabel("PROFILE DETAILS");
		l1.setBounds(330, 20, 600, 50);
		panel.add(l1);
		
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
		back.setBounds(620, 400, 100, 50);
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
		if(a.getSource()==back)
		{
			this.setVisible(false);
			new Homepage(userId);	
		}
		else{}
	}
}