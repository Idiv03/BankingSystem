package BankManagementSystem;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class CreateAccount {
	public CreateAccount(int lastacc_id, ArrayList<Account> accounts,Database database) {
		
		JFrame frame = Main.Frame(500, 400);
		JLabel title = Main.Label("Create new Account", 23);
		
		JPanel panel = new JPanel(new GridLayout(5,2,10,10));
		
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		JLabel label1 = Main.Label("First Name", 20);
		JLabel label2 = Main.Label("Last Name", 20);
		JLabel label3 = Main.Label("Balance", 20);
		JLabel label4 = Main.Label("Password (digits)", 20);
		JLabel label5 = Main.Label("Confirm Password", 20);
		
		JTextField firstName = Main.TextField(20);
		JTextField lastName = Main.TextField(20);
		JTextField balance = Main.TextField(20);
		JPasswordField password = Main.PasswordField(20);
		JPasswordField password2 = Main.PasswordField(20);
		
		
		panel.add(label1);
		panel.add(firstName);
		panel.add(label2);
		panel.add(lastName);
		panel.add(label3);
		panel.add(balance);
		panel.add(label4);
		panel.add(password);
		panel.add(label5);
		panel.add(password2); 
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel2.setBackground(null);
		JButton createAcc = Main.Button("Create Account", 19);
		
		

		createAcc.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(firstName.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(frame,"first Name cannot be empty!");
					return;
				}
				if(lastName.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(frame,"last Name cannot be empty!");
					return;
				}
				try {
					Double.parseDouble(balance.getText().toString());
				}catch(Exception n) {
					JOptionPane.showMessageDialog(frame,"balance must be a number!");
					return;
				}
				try {
					Integer.parseInt(password.getText().toString());
				}catch(Exception n1) {
					JOptionPane.showMessageDialog(frame,"password must be in digits!");
					return;
				}
				if(!password.getText().toString().equals(password2.getText().toString())) {
					JOptionPane.showMessageDialog(frame,"password didn't match\n");
				
					return;
				}

				Account acc = new Account(
						firstName.getText().toString(),
						lastName.getText().toString(),
						lastacc_id,
						Double.parseDouble(balance.getText().toString()), 
						Integer.parseInt(password.getText().toString()));
				accounts.add(acc);
				JOptionPane.showMessageDialog(frame,"Your account id: " + lastacc_id);
				database.saveAccounts(accounts);
				
				new Menu(acc, database, accounts);
				database.saveAccounts(accounts);
				frame.dispose();
			}
			
		});
		panel2.add(createAcc, BorderLayout.CENTER);
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		
	}

}
