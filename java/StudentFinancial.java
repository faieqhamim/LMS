import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentFinancial extends JFrame implements ActionListener
{
	private JButton back,b1; 
	private JPanel panel;
	private JTextArea j;
	private String userId;
	
	public StudentFinancial(String userId,String financial)
	{
		super("Borrowed Book");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.userId=userId;
		
		panel = new JPanel();
		panel.setBackground(new Color(0,138,150));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
		b1=new JButton("Your Due Is : "+financial);
		b1.setBackground( new Color(0,138,150));
		b1.setBounds(150, 150, 400, 50);
		panel.add(b1);
		
		back=new JButton("Back");
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