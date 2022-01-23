import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManageBook extends JFrame implements ActionListener
{
	private JButton bookList,addBook,deleteBook,bookRequest,back; 
	private JPanel panel;
	private JTextArea j;
	private String userId;
	
	public ManageBook()
	{
		super("Manage Book");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(0,0,800,600);
		panel.setLayout(null);
		
		bookList=new JButton("Book List");
		bookList.setBackground( new Color(0,184,89));
		bookList.setBounds(101, 105, 166, 180);
		panel.add(bookList);
		
		addBook=new JButton("Add New Book");
		addBook.setBackground( new Color(0,184,89));
		addBook.setBounds(317, 105, 166, 180);
		panel.add(addBook);
		
		deleteBook=new JButton("Delete Book");
		deleteBook.setBackground( new Color(0,184,89));
		deleteBook.setBounds(533, 105, 166, 180);
		panel.add(deleteBook);
		
		bookRequest=new JButton("Book Request");
		bookRequest.setBackground( new Color(0,184,89));
		bookRequest.setBounds(101, 335, 166, 180);
		panel.add(bookRequest);
		
		back=new JButton("Back");
		back.setBackground( new Color(0,184,89));
		back.setBounds(620, 480, 100, 50);
		panel.add(back);
		
		j=new JTextArea();
		j.setBackground(Color.WHITE);
		j.setBounds(5,5,770,540);
		j.setEditable(false);
		panel.add(j);
		
		bookList.addActionListener(this);
        addBook.addActionListener(this);
		deleteBook.addActionListener(this);
        bookRequest.addActionListener(this);
		back.addActionListener(this);
		
		this.setVisible(true);
		this.add(panel);
		
	}
	
	public void actionPerformed(ActionEvent a)
	{	
		if(a.getSource()==bookList)
		{
			this.setVisible(false);
			new BookList();	
		}
		
		else if (a.getSource()==addBook)
		{
			this.setVisible(false);
			new AddBook();
		}
		else if (a.getSource()==deleteBook)
		{
			this.setVisible(false);
			new DeleteBook();
		}
		else if (a.getSource()==bookRequest)
		{
			this.setVisible(false);
			new BookRequest();
		}
		else if (a.getSource()==back)
		{
			this.setVisible(false);
			new Homepage(userId);
		}
		else{}
	}
}