package BankManagementSystem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Database {
	File file;
	
	
	public Database() {
		 file = new File("Files/Data");
		if(!file.exists()) {
			try {
				file.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			};
		}
	}
	public ArrayList<Account> getAccounts(){
		String text = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			while((s = br.readLine()) != null) {
			text = text + s;
		}
		br.close();
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		ArrayList<Account> accounts = new ArrayList<>();
		String[] array1 = text.split("(<NewAccount/>);");
		for(String v : array1) {
			if(!v.equals("")) {
				String[] array2 = v.split("<A/>");
				Account a = new Account();
				a.setFirstName(array2[0]);
				a.setLastName(array2[1]);
				a.setAcc_id(Integer.parseInt(array2[2]));
				a.setPassword(Integer.parseInt(array2[4]));
				accounts.add(a);
				
			}
				
		}
		return accounts;
	}
	public void saveAccounts(ArrayList<Account> accounts) {
		String text = "";
		for(Account a : accounts) {
			StringBuilder bd = new StringBuilder();
			bd.append(a.getFirstName()).append("<A/>");
			bd.append(a.getLastName()).append("<A/>");
			bd.append(String.valueOf(a.getAcc_id())).append("<A/>");
			bd.append(String.valueOf(a.getBalance())).append("<A/>");
			bd.append(String.valueOf(a.getPassword())).append("<A/>");
			text = text + bd.toString();
			bd.append("<NewAccount/>").append("\n");
		}
		try {
		PrintWriter pw = new PrintWriter(file);
		pw.print(text);
		pw.close();
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		
		
	}
		
}

}
