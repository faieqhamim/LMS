import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentBookRequest extends JFrame implements ActionListener
{
	private JLabel myLabel1,myLabel2;
	private JTextField myTextField1;
	private JButton search, back;
	private JTextArea j;
	private JPanel panel;
	private String userId;
	
	public StudentBookRequest(String userId,String book1,String book2)
	{
		super("Book Request For Student");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.userId=userId;
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
		myLabel1 = new JLabel("SEARCH THE BOOK YOU WANT TO BORROW");
		myLabel1.setBounds(250, 50, 350, 40);
		panel.add(myLabel1);
		
		
		myTextField1 = new JTextField();
		myTextField1.setBounds(170, 100, 370, 50);
		panel.add(myTextField1);
		
		
		search = new JButton("SEARCH");
		search.setBackground( new Color(0,184,89));
		search.setBounds(540, 101, 100, 48);
		panel.add(search);
		
		myLabel2 = new JLabel("Requested Book : "+book1);
		myLabel2.setBackground( new Color(0,184,89));
		myLabel2.setBounds(300, 400, 150, 50);
		panel.add(myLabel2);
		
		back = new JButton("BACK");
		back.setBackground( new Color(0,184,89));
		back.setBounds(620, 480, 100, 50);
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