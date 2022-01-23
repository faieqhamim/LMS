import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManageStudent extends JFrame implements ActionListener
{

	private JButton studentInfo,financial,back;
	private JPanel panel;
	private JTextArea j;
	private String userId;
	
	public ManageStudent()
	{
		super("Manange Student");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
	
		
		studentInfo = new JButton("Student Information");
		studentInfo.setBackground( new Color(0,184,89));
		studentInfo.setBounds(200, 175, 400, 100);
		panel.add(studentInfo);
		
		financial = new JButton("financial");
		financial.setBackground( new Color(0,184,89));
		financial.setBounds(200, 325, 400, 100);
		panel.add(financial);
		
		back = new JButton("BACK");
		back.setBackground( new Color(0,184,89));
		back.setBounds(620, 480, 100, 50);
		panel.add(back);
		
		j=new JTextArea();
		j.setBackground(Color.WHITE);
		j.setBounds(5,5,770,540);
		j.setEditable(false);
		panel.add(j);
		
		studentInfo.addActionListener(this);
		financial.addActionListener(this);
		back.addActionListener(this);
		
		this.setVisible(true);
		this.add(panel);
		
		
		
	}
	public void actionPerformed(ActionEvent a)
	{	
		if (a.getSource()==studentInfo)
		{
			this.setVisible(false);
			new StudentInfo();
		}
		else if (a.getSource()==financial)
		{
			this.setVisible(false);
			new Financial();
		}
		if (a.getSource()==back)
		{
			this.setVisible(false);
			new Homepage(userId);
		}
		else{}
	}
}