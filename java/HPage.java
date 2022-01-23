import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HPage extends JFrame 
{
	
    JButton userLogin,librarianLogin,registration; 
	JLabel label;

	public HPage()
	{
		Font f = new Font("Serif", Font.BOLD, 30);
		label = new JLabel("Home Page");
		label.setForeground(Color.BLACK);
		label.setBounds(320,5,400,50);
		label.setFont(f);
	    this.add(label);
		
		
		userLogin = new JButton("User Log in");
		userLogin.setForeground(Color.BLACK);
		userLogin.setBackground(new Color(0,184,89));
		userLogin.setBounds(300,180,210,50);
		this.add(userLogin);
		
		userLogin.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==userLogin)
                { 
                  UserLogin userLogin = new UserLogin();
				  userLogin.setVisible(true);
                }
			  
			}
		
        });
		
		
		librarianLogin = new JButton("Librarian Log in");
		librarianLogin.setForeground(Color.BLACK);
		librarianLogin.setBackground(new Color(0,184,89));
		librarianLogin.setBounds(300,260,210,50);
		this.add(librarianLogin);
	    librarianLogin.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
            {
               if(e.getSource()==librarianLogin)
                {
				  LibrarianLogin librarianLogin = new LibrarianLogin();
				  librarianLogin.setVisible(true);
				  
                }
		    }
		   
        });
		
		
		registration = new JButton("Registration");
		registration.setForeground(Color.BLACK);
		registration.setBackground(new Color(0,184,89));
		registration.setBounds(300,340,210,50);
		this.add(registration);
		
	    registration.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
            {
               if(e.getSource()==registration)
                {
				  Registration registration = new Registration();
				  registration.setVisible(true);
                }
		    }
		   
        });
	
		this.setSize(800,600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		
    }

}
