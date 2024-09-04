package BankManagementSystem;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login {
	public Login(ArrayList<Account> accounts,Database database, int lastacc_id) {


		JFrame frame = Main.Frame(500, 270);
		JLabel title = Main.Label("Welcome to the Bank Management System", 23);
		JPanel panel = new JPanel(new GridLayout(2,2,10,10));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		JLabel label1 = Main.Label("Account id", 20);
		JTextField id = Main.TextField(20);
		JLabel label2 = Main.Label("Password", 20);
		JPasswordField password = Main.PasswordField(20);
		panel.add(label1);
		panel.add(id);
		panel.add(label2);
		panel.add(password);
		
		JPanel panel2 = new JPanel(new GridLayout(1,2,10,10));
		panel2.setBackground(null);
		panel2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JButton login = Main.Button("Login", 19);
		login.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {
				String id0 = id.getText().toString();
				@SuppressWarnings("deprecation")
				String password0 = id.getText().toString();
				try {
					Integer.parseInt(id0);
					
				}catch(Exception w) {
					JOptionPane.showMessageDialog(frame, "id must be in integer");
					return;
				}
				try {
					Integer.parseInt(password0);
					
				}catch(Exception w) {
					JOptionPane.showMessageDialog(frame, "password must be in digits");
					return;
				}
				
				int id = Integer.parseInt(id0);
				int password = Integer.parseInt(password0);
				Account account = new Account();
				boolean exist = false;
				for(Account acc : accounts) {
					if(acc.getAcc_id() == id && acc.getPassword() == password) {
						exist = true;
						account = acc;
					}
				}
				if(exist) {
					new Menu(account, database, accounts);
					frame.dispose();
					
				}else {
					JOptionPane.showMessageDialog(frame, "Account doesn't exist");

				}
			}
		});
		
		
		JButton createAcc = Main.Button("Create new Account", 19);
		createAcc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateAccount(lastacc_id, accounts, database);
				database.saveAccounts(accounts);
				frame.dispose();
				
			}
			
		});
		panel2.add(login);
		panel2.add(createAcc);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
	

	}
	
	

}
