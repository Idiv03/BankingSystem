package BankManagementSystem;
import java.awt.*;
import java.util.*;
import javax.swing.*;


public class Main {
	static Scanner sc;
	static int next_id = 0;
	private static ArrayList<Account> accounts;
	

	public static void main(String[] args) {
		
		
		
		accounts = new ArrayList<>();
		sc = new Scanner(System.in);
		Database database = new Database();
		accounts = database.getAccounts();
		if(accounts.size() == 0) {
			next_id = 1000000;
		}else {
			next_id = accounts.size() + 1000001;
		}
		
		new Login(accounts, database, next_id);
	


	}
	public static JFrame Frame(int width, int height) {
		JFrame frame = new JFrame("Bank Management System");
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.white);
		return frame;
		
	}
	public static JLabel Label(String text, int size) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Tahoma", Font.BOLD, size));
		label.setForeground(Color.black);
		label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		return label;
		
	}
	
	
	public static JTextField TextField(int size) {
		JTextField textField = new JTextField();
		
		textField.setFont(new Font("Tahoma", Font.BOLD, size));
		textField.setForeground(Color.black);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		
		return textField;
	}
	
	public static JPasswordField PasswordField(int size) {
		JPasswordField passField = new JPasswordField();
		
		passField.setFont(new Font("Tahoma", Font.BOLD, size));
		passField.setForeground(Color.black);
		passField.setHorizontalAlignment(SwingConstants.CENTER);
		
		return passField;
	}
	
	
	public static JButton Button(String text, int size) {
		JButton btn = new JButton(text);
		
		btn.setFont(new Font("Tahoma", Font.BOLD, size));
		btn.setForeground(Color.blue);
		btn.setBackground(Color.lightGray);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		return btn;
	}
	
	

}
