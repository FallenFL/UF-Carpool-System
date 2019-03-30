import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class RateUserGUI {

	JFrame frmRateUser;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RateUserGUI window = new RateUserGUI();
					window.frmRateUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		
	public RateUserGUI()
	{
		
	}
	/**
	 * Create the application.
	 * @param user 
	 * @param currentUser 
	 * @param carpool 
	 */
	public RateUserGUI(Carpool carpool, User currentUser, User user) {
		initialize(carpool, currentUser, user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Carpool carpool, User from, User to) {
		frmRateUser = new JFrame();
		frmRateUser.setTitle("Rate User");
		frmRateUser.setBounds(100, 100, 450, 300);
		frmRateUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRateUser.getContentPane().setLayout(null);
		
		JLabel lblYouAreRating = new JLabel("You are rating:   " + to.getName());
		lblYouAreRating.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYouAreRating.setBounds(36, 42, 172, 35);
		frmRateUser.getContentPane().add(lblYouAreRating);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		comboBox.setBounds(126, 141, 92, 20);
		frmRateUser.getContentPane().add(comboBox);
		
		JLabel lblRate = new JLabel("Rate:");
		lblRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRate.setBounds(36, 138, 70, 23);
		frmRateUser.getContentPane().add(lblRate);
		
		textField = new JTextField();
		textField.setBounds(279, 80, 111, 23);
		frmRateUser.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblComment = new JLabel("Comment:");
		lblComment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComment.setBounds(279, 52, 89, 14);
		frmRateUser.getContentPane().add(lblComment);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(164, 196, 89, 23);
		frmRateUser.getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rating = Integer.parseInt(comboBox.getSelectedItem().toString());
				String comment = textField.getText();
				Rate rate = new Rate(carpool,from,to,rating,comment);
				Init.rateList = new ArrayList<>(Init.rateList);
				Init.rateList.add(rate);
				to.getrtList().add(rate);
				StreamUtils.writeUserList(Init.userList);
				frmRateUser.dispose();
				MyHistoryGUI window = new MyHistoryGUI();
				window.frmRequestList.setVisible(true);
				JOptionPane.showMessageDialog(null , "Rate Successfully" , "Rate Successfully", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
	}
}
