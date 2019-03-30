import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RechargeBalanceGUI {

	JFrame frmRechargeBalance;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechargeBalanceGUI window = new RechargeBalanceGUI();
					window.frmRechargeBalance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RechargeBalanceGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRechargeBalance = new JFrame();
		frmRechargeBalance.setTitle("Recharge Balance");
		frmRechargeBalance.setBounds(100, 100, 450, 300);
		frmRechargeBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechargeBalance.getContentPane().setLayout(null);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance:  "+Init.currentUser.getBalance());
		lblCurrentBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentBalance.setBounds(34, 45, 184, 14);
		frmRechargeBalance.getContentPane().add(lblCurrentBalance);
		
		JLabel lblAmountRechage = new JLabel("Amount Recharge:");
		lblAmountRechage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmountRechage.setBounds(34, 116, 131, 29);
		frmRechargeBalance.getContentPane().add(lblAmountRechage);
		
		textField = new JTextField();
		textField.setBounds(158, 122, 86, 20);
		frmRechargeBalance.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(155, 202, 89, 23);
		frmRechargeBalance.getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRechargeBalance.dispose();
				UserMainGUI window = new UserMainGUI();
				window.frmMainMenu.setVisible(true);
				String textFieldValue = textField.getText();
				int money = Integer.parseInt(textFieldValue);
				Init.currentUser.addBalance(money);
				StreamUtils.writeUserList(Init.userList);
				JOptionPane.showMessageDialog(null , "Recharge $"+textFieldValue+" Successfully " , "Recharge Successfully", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
	}

}
