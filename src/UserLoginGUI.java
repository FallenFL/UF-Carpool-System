import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class UserLoginGUI {

	JFrame frmLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginGUI window = new UserLoginGUI();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserLoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 121, 191, 27);
		frmLogin.getContentPane().add(passwordField);
		
		JFormattedTextField accountField = new JFormattedTextField();
		accountField.setBounds(133, 73, 191, 27);
		frmLogin.getContentPane().add(accountField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(67, 126, 56, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccount.setBounds(67, 78, 46, 14);
		frmLogin.getContentPane().add(lblAccount);
		
		JLabel lblGainesvilleorlandoCarpoolSystem = new JLabel("UF Carpool System");
		lblGainesvilleorlandoCarpoolSystem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGainesvilleorlandoCarpoolSystem.setBounds(109, 11, 252, 51);
		frmLogin.getContentPane().add(lblGainesvilleorlandoCarpoolSystem);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(174, 173, 89, 23);
		frmLogin.getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					String accountValue = accountField.getText();
					String pwdValue = passwordField.getText();
					if (accountValue.equals("Admin") && pwdValue.equals(Init.AdminPwd))
					{
						frmLogin.dispose();
						ManageUsersGUI window = new ManageUsersGUI();
						window.frmManageUsers.setVisible(true);
					}
					else if(Check.checkLogin(accountValue,pwdValue)) 
					{
						frmLogin.dispose();
						UserMainGUI window = new UserMainGUI();
						window.frmMainMenu.setVisible(true);
						Check.showReminder();
					}
					else
					{
						JOptionPane.showMessageDialog(null , "Account or Password is incorrect" , "Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
	}
}
