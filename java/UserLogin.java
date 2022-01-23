import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class UserLogin extends JFrame implements ActionListener
{	
	private JLabel myLabel1,myLabel2;
	private JTextField textField1;
	private JPasswordField textField2;
	private JButton login,cancel; 
	private JPanel panel;
	private JTextArea j;
	private boolean flag;
	
	public UserLogin()
	{
		super("User Log In");
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,500,600);
		panel.setLayout(null);
		
		myLabel1=new JLabel("User Id");
		myLabel1.setBounds(50, 100,100,80);
		panel.add(myLabel1);
		
		myLabel2=new JLabel("Password");
		myLabel2.setBounds(50, 230,100,80);
		panel.add(myLabel2);
		
		textField1=new JTextField();
		textField1.setBounds(50, 150, 300, 80);
		panel.add(textField1);
		
		textField2=new JPasswordField();
		textField2.setBounds(50, 280, 300, 80);
		panel.add(textField2);
		
		login=new JButton("Log in");
		login.setBackground( new Color(0,184,89));
		login.setBounds(50,410,100,50);
		panel.add(login);
		
		cancel=new JButton("Cancel");
		cancel.setBackground( new Color(0,184,89));
		cancel.setBounds(200,410,100,50);
		panel.add(cancel);
		
		j=new JTextArea();
		j.setBackground(Color.WHITE);
		j.setBounds(5,5,770,540);
		j.setEditable(false);
		panel.add(j);
		
		login.addActionListener(this);
        cancel.addActionListener(this);
		
		this.setVisible(true);
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent a)
	{	
		if(a.getSource()==login)
		{
			System.out.println("hello");
			flag=true;
			check();
		}
		
		else if (a.getSource()==cancel)
		{
			this.setVisible(false);
			new HPage();
		}
		else{}
	}

	public void check()
	{
        String query = "SELECT `id`, `name`, `financial`, `book1`, `book2`,`password` FROM `student`;";	     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1?useTimezone=true&serverTimezone=UTC","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
					
			while(rs.next())
			{
                String userId = rs.getString("id");
                String password = rs.getString("password");
				
				
				if(userId.equals(textField1.getText()))
				{
					flag=false;
					if(password.equals(textField2.getText()))
					{
							StudentHomepage ush = new StudentHomepage(userId);
							this.setVisible(false);
							ush.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Invalid pass"); 
					}
				}			
			}
			if(flag){JOptionPane.showMessageDialog(this,"Invalid name"); }
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
    }
	
}