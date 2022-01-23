import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationCon extends JFrame
{

	
	public RegistrationCon ()
	{
		
		JLabel sU = new JLabel("Congratulations Your Registration Is Successfull");
		Font f = new Font("Serif", Font.BOLD, 25);
		sU.setForeground(Color.WHITE);
		sU.setBounds(130,100,600,50);
		sU.setFont(f);
		this.add(sU);
		
		JButton loginNow = new JButton("Login Now");
		loginNow.setForeground(Color.BLUE);
		loginNow.setBounds(310,400,150,30);
		this.add(loginNow);
		
		loginNow.addActionListener(new ActionListener()
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
       
	    ImageIcon background_image = new ImageIcon("Pic3.jpg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(800,600,Image.SCALE_SMOOTH);
	    background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("",background_image,JLabel.CENTER);        
	    background.setBounds(0,0,800,600);
		add(background);	
		
    }	
	
	
}