import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowedBook extends JFrame implements ActionListener
{
	private JLabel myLabel1,myLabel2;
	private JTextField textField1,textField2;
	private JButton back; 
	private JPanel panel;
	private JTextArea j;
	
	public BorrowedBook()
	{
		super("Borrowed Book");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
		back=new JButton("Back");
		back.setBackground( new Color(0,184,89));
		back.setBounds(285,350,100,50);
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
			new ManageBorrower();
		}
		else{}
	}
	
}