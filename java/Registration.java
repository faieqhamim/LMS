import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registration extends JFrame
{

	
	public Registration ()
	{
		
		JLabel sU = new JLabel("Registration");
		Font f = new Font("Serif", Font.BOLD, 30);
		sU.setForeground(Color.BLACK);
		sU.setBounds(350,55,600,50);
		sU.setFont(f);
		this.add(sU);
		
		JLabel labelFname = new JLabel("First Name");
		labelFname.setBounds(100,120,600,50);
		labelFname.setForeground(Color.BLACK);
		JTextField fname = new JTextField(20);
		fname.setBounds(175,135,200,24);
		this.add(labelFname);
		this.add(fname);
		
		
		JLabel labelLname = new JLabel("Last Name");
		labelLname.setBounds(400,120,600,50);
		labelLname.setForeground(Color.BLACK);
		JTextField lname = new JTextField(20);
		lname.setBounds(475,135,200,24);
		this.add(labelLname);
		this.add(lname);
		
			
		JLabel labelUname = new JLabel("Username");
		labelUname.setBounds(100,160,600,50);
		labelUname.setForeground(Color.BLACK);
		JTextField uname = new JTextField(20);
		uname.setBounds(175,175,200,24);
	    this.add(labelUname);
		this.add(uname); 
		
		
		JLabel labelPass = new JLabel("Password");
		labelPass.setBounds(400,160,600,50);
		labelPass.setForeground(Color.BLACK);
		JPasswordField pass = new JPasswordField(20);
		pass.setBounds(475,175,200,24);
		this.add(labelPass);
		this.add(pass);
		
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(100,200,600,50);
		labelEmail.setForeground(Color.BLACK);
		JTextField email= new JTextField(20);
		email.setBounds(175,215,200,24);
		this.add(labelEmail);
		this.add(email);
		
		
		JLabel labelPhoneNo = new JLabel("Phone No");
		labelPhoneNo.setBounds(400,200,600,50);
		labelPhoneNo.setForeground(Color.BLACK);
		JTextField phoneno= new JTextField(20);
		phoneno.setBounds(475,215,200,24);
		this.add(labelPhoneNo);
		this.add(phoneno);
		
		
		JLabel labelDob = new JLabel("DOB");
		labelDob.setBounds(100,240,600,50);
		labelDob.setForeground(Color.BLACK);
		JTextField dob = new JTextField(20);
		dob.setBounds(175,255,200,24);
		this.add(labelDob);
		this.add(dob);
		
		
		JLabel labelGender = new JLabel("Gender");
		labelGender.setBounds(400,240,600,50);
		labelGender.setForeground(Color.BLACK);
		ButtonGroup gender = new ButtonGroup();
		
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(475,255,95,24);
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(580,255,95,24);
		male.setActionCommand("Male");
		female.setActionCommand("Female");
		gender.add(male);
		gender.add(female);	
		this.add(labelGender);
		this.add(male);
		this.add(female);	
		
		
		JLabel labelAddress = new JLabel("Address");
		labelAddress.setBounds(100,280,600,50);
		labelAddress.setForeground(Color.BLACK);
		JTextArea address = new JTextArea(5,20);
	    address.setBounds(175,295,200,50);
		this.add(labelAddress);
		this.add(address);
		
		
		
		JButton register = new JButton("Register");
		register.setForeground(Color.BLACK);
		register.setBounds(280,420,100,30);
		this.add(register);

	    register.addActionListener(new ActionListener()
	    {  
            public void actionPerformed(ActionEvent e)
	        {  
                RegistrationCon regcon = new RegistrationCon();
                regcon .setVisible(true);
                dispose();				
		    }
        	
        }); 
	
	    JButton back = new JButton("Back");
		back.setForeground(Color.BLACK);
		back.setBounds(400,420,100,30);
		this.add(back);
		
		back.addActionListener(new ActionListener()
	    {  
            public void actionPerformed(ActionEvent e)
	        {  
                HPage hpage = new HPage();
                hpage.setVisible(true);	
                dispose();				
		    }
        	
        });
		
		
		
	    this.setSize(800,600);	
		this.setLayout(null);
	    this.setLocationRelativeTo(null);	
       
	    
		
    }	
	
	
}