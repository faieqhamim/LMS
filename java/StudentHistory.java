import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentHistory extends JFrame implements ActionListener
{

	private JLabel myLabel1,myLabel2,myLabel3;
	private JButton back;
	private JPanel panel;
	private JTextArea j;
	private String userId;
	
	public StudentHistory(String userId,String borrowbook)
	{
		super("History");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.userId=userId;
		
		panel = new JPanel();
		panel.setBackground(new Color(0,138,150));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
	    myLabel1 = new JLabel("BORROW HISTORY");
		myLabel1.setBounds(330, 20, 600, 50);
		panel.add(myLabel1);
		
		myLabel2 = new JLabel("BORROW Book 1 : "+borrowbook);
		myLabel2.setBounds(200, 150, 600, 50);
		panel.add(myLabel2);
		
		myLabel2 = new JLabel("BORROW Book 2 : ");
		myLabel2.setBounds(200, 250, 600, 50);
		panel.add(myLabel2);
		
		back = new JButton("BACK");
		back.setBackground( new Color(0,138,150));
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