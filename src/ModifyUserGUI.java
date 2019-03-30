import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;

public class ModifyUserGUI {

	JFrame frmManageUsers;
	private JTextField ufidField;
	private JTextField nameField;
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
					ModifyUserGUI window = new ModifyUserGUI(0);
					window.frmManageUsers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ModifyUserGUI(int index) {
		initialize(index);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int index) {
		frmManageUsers = new JFrame();
		frmManageUsers.setTitle("Modify");
		frmManageUsers.setBounds(100, 100, 450, 300);
		frmManageUsers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageUsers.getContentPane().setLayout(null);
		
		JLabel lblUfid = new JLabel("UFID");
		lblUfid.setBounds(20, 19, 46, 14);
		frmManageUsers.getContentPane().add(lblUfid);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(20, 50, 66, 14);
		frmManageUsers.getContentPane().add(lblUserName);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(20, 87, 66, 14);
		frmManageUsers.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 121, 66, 14);
		frmManageUsers.getContentPane().add(lblEmail);
		
		JLabel lblVehicleMake = new JLabel("Vehicle Make");
		lblVehicleMake.setBounds(19, 155, 66, 14);
		frmManageUsers.getContentPane().add(lblVehicleMake);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(19, 189, 66, 14);
		frmManageUsers.getContentPane().add(lblModel);
		
		ufidField = new JTextField();
		ufidField.setEditable(false);
		ufidField.setText(Init.userList.get(index).getUFID());
		ufidField.setBounds(96, 18, 129, 20);
		frmManageUsers.getContentPane().add(ufidField);
		ufidField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setText(Init.userList.get(index).getName());
		nameField.setColumns(10);
		nameField.setBounds(96, 49, 129, 20);
		frmManageUsers.getContentPane().add(nameField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(97, 83, 129, 20);
		phoneField.setText(Init.userList.get(index).getPhone());
		frmManageUsers.getContentPane().add(phoneField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(96, 117, 129, 20);
		emailField.setText(Init.userList.get(index).getEmail());
		frmManageUsers.getContentPane().add(emailField);
		
		makeField = new JTextField();
		makeField.setColumns(10);
		makeField.setBounds(97, 151, 129, 20);
		makeField.setText(Init.userList.get(index).getMake());
		frmManageUsers.getContentPane().add(makeField);
		
		modelField = new JTextField();
		modelField.setColumns(10);
		modelField.setBounds(96, 186, 129, 20);
		modelField.setText(Init.userList.get(index).getModel());
		frmManageUsers.getContentPane().add(modelField);
		
		JButton btnSearchUser = new JButton("Finish Modification");
		btnSearchUser.setBounds(263, 66, 143, 23);
		frmManageUsers.getContentPane().add(btnSearchUser);
		btnSearchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phone = phoneField.getText();
				String email = emailField.getText();
				String make = makeField.getText();
				String model = modelField.getText();
				String ufid = ufidField.getText();
				Init.userList.get(index).setPhone(phone);
				Init.userList.get(index).setEmail(email);
				Init.userList.get(index).setMake(make);
				Init.userList.get(index).setModel(model);
				Init.userList.get(index).setUFID(ufid);						
				//System.out.println(user.getDetails());
				StreamUtils.writeUserList(Init.userList);
				frmManageUsers.dispose();
				JOptionPane.showMessageDialog(null , "Modify successfully" , "Congraz!", JOptionPane.INFORMATION_MESSAGE);
				ManageUsersGUI window = new ManageUsersGUI();
				window.frmManageUsers.setVisible(true);
			}
		});
		
		JButton btnResetButton = new JButton("Reset");
		btnResetButton.setBounds(294, 132, 89, 23);
		frmManageUsers.getContentPane().add(btnResetButton);
		btnResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phoneField.setText("");
				emailField.setText("");
				makeField.setText("");
				modelField.setText("");
				ufidField.setText("");

			}
		});
	}
}
