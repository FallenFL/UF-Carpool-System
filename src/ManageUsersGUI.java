import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManageUsersGUI {

	JFrame frmManageUsers;
	private JTextField ufidField;
	private JTextField nameField;
	private JTextField pwdField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField makeField;
	private JTextField modelField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUsersGUI window = new ManageUsersGUI();
					window.frmManageUsers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageUsersGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageUsers = new JFrame();
		frmManageUsers.setTitle("Manage Users");
		frmManageUsers.setBounds(100, 100, 450, 300);
		frmManageUsers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageUsers.getContentPane().setLayout(null);
		
		JLabel lblUfid = new JLabel("UFID");
		lblUfid.setBounds(20, 19, 46, 14);
		frmManageUsers.getContentPane().add(lblUfid);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(20, 50, 66, 14);
		frmManageUsers.getContentPane().add(lblUserName);
		
		JLabel lblPhone = new JLabel("Password");
		lblPhone.setBounds(20, 87, 66, 14);
		frmManageUsers.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Phone");
		lblEmail.setBounds(20, 121, 66, 14);
		frmManageUsers.getContentPane().add(lblEmail);
		
		JLabel lblVehicleMake = new JLabel("Email");
		lblVehicleMake.setBounds(19, 155, 66, 14);
		frmManageUsers.getContentPane().add(lblVehicleMake);
		
		JLabel lblModel = new JLabel("Make");
		lblModel.setBounds(19, 189, 66, 14);
		frmManageUsers.getContentPane().add(lblModel);
		
		ufidField = new JTextField();
		ufidField.setBounds(96, 18, 129, 20);
		frmManageUsers.getContentPane().add(ufidField);
		ufidField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(96, 47, 129, 20);
		frmManageUsers.getContentPane().add(nameField);
		
		pwdField = new JTextField();
		pwdField.setColumns(10);
		pwdField.setBounds(97, 83, 129, 20);
		frmManageUsers.getContentPane().add(pwdField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(96, 117, 129, 20);
		frmManageUsers.getContentPane().add(phoneField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(97, 151, 129, 20);
		frmManageUsers.getContentPane().add(emailField);
		
		makeField = new JTextField();
		makeField.setColumns(10);
		makeField.setBounds(96, 186, 129, 20);
		frmManageUsers.getContentPane().add(makeField);
		
		JButton btnAddNewUser = new JButton("Add as New User");
		btnAddNewUser.setBounds(262, 50, 162, 23);
		frmManageUsers.getContentPane().add(btnAddNewUser);
		btnAddNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String pwd = pwdField.getText();
				String phone = phoneField.getText();
				String email = emailField.getText();
				String make = makeField.getText();
				String model = modelField.getText();
				String ufid = ufidField.getText();
				if (Check.duplicateName(name))
				{
					if (!pwd.equals(""))
					{
						User user = new User(name, pwd, ufid, phone, email, make, model);
						System.out.println(user.getDetails());
						Init.userList = new ArrayList<>(Init.userList);
						Init.userList.add(user);
						StreamUtils.writeUserList(Init.userList);
						JOptionPane.showMessageDialog(null , "Add successfully" , "Congraz!", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null , "Password must not be empty!" , "Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null , "Account Already Exists!" , "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnSearchUser = new JButton("Search User");
		btnSearchUser.setBounds(289, 99, 115, 23);
		frmManageUsers.getContentPane().add(btnSearchUser);
		btnSearchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				if (Check.checkName(name) != -1)
				{
					frmManageUsers.dispose();
					ModifyUserGUI window = new ModifyUserGUI(Check.checkName(name));
					window.frmManageUsers.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null , "No such user!" , "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton btnResetButton = new JButton("Reset");
		btnResetButton.setBounds(302, 151, 89, 23);
		frmManageUsers.getContentPane().add(btnResetButton);
		btnResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ufidField.setText("");
				nameField.setText("");
				pwdField.setText("");
				phoneField.setText("");
				emailField.setText("");
				makeField.setText("");
				modelField.setText("");
				ufidField.setText("");

			}
		});
		
		modelField = new JTextField();
		modelField.setBounds(96, 216, 129, 20);
		frmManageUsers.getContentPane().add(modelField);
		modelField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Model");
		lblPassword.setBounds(20, 219, 46, 14);
		frmManageUsers.getContentPane().add(lblPassword);
	}
}
