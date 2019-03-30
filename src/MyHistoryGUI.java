import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyHistoryGUI {

	JFrame frmRequestList;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyHistoryGUI window = new MyHistoryGUI();
					window.frmRequestList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyHistoryGUI() {
		initialize(Check.getHistoryList());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Object[][] obj) {
		frmRequestList = new JFrame();
		frmRequestList.setTitle("My Carpool History");
		frmRequestList.setBounds(100, 100, 648, 496);
		frmRequestList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRequestList.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 25, 612, 233);
		frmRequestList.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			obj ,
			new String[] {
				"From", "To", "Date", "Time", "Price", "Status", "I am", "His Name", "id"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Object.class, Object.class, Object.class, Object.class,Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setPreferredWidth(49);
		table.getColumnModel().getColumn(4).setPreferredWidth(62);
		scrollPane.setViewportView(table);
		
		JButton btnChooseSelectedCarpool = new JButton("Cancel Selected Carpool");
		btnChooseSelectedCarpool.setBounds(71, 286, 175, 23);
		frmRequestList.getContentPane().add(btnChooseSelectedCarpool);
		btnChooseSelectedCarpool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();
				int selectedID= Integer.parseInt(table.getValueAt(count, 8).toString());
				Carpool carpool = (Carpool) obj[count][9];
				try {
					if ((carpool.getStatus().equals("r") || carpool.equals("o")) 
							&& Check.checkTime(carpool) == false)
					{
						frmRequestList.dispose();
						carpool.setStatus("c");
						JOptionPane.showMessageDialog(null , "Cancel Successfully" , "Cancel Successfully", JOptionPane.INFORMATION_MESSAGE);
						MyHistoryGUI window = new MyHistoryGUI();
						window.frmRequestList.setVisible(true);
						//StreamUtils.writeCarpoolList(Init.carpoolList);
						StreamUtils.writeUserList(Init.userList);
					}
					else JOptionPane.showMessageDialog(null , "Can not cancel this carpool" , "Error", JOptionPane.INFORMATION_MESSAGE);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnPostAnOffer = new JButton("Make a Payment");
		btnPostAnOffer.setBounds(408, 286, 156, 23);
		frmRequestList.getContentPane().add(btnPostAnOffer);
		btnPostAnOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();
				int selectedID = Integer.parseInt(table.getValueAt(count, 8).toString());
				float price = Float.parseFloat(table.getValueAt(count, 4).toString());
				String status = table.getValueAt(count, 5).toString();
				String role = table.getValueAt(count, 8).toString();
				Carpool carpool = (Carpool) obj[count][9];
				if (status.equals("to be paid") || role.equals("passenger"))
					{	
						if (Init.currentUser.getBalance() >= price)
						{
							Init.currentUser.addBalance(-price);
							carpool.getDriver().addBalance(price);
							carpool.setPayment(Init.currentUser);
							JOptionPane.showMessageDialog(null , "Make Payment Successfully" , "Make Payment Successfully", JOptionPane.INFORMATION_MESSAGE);
							Check.cancelReminder(carpool,carpool.getDriver(),Init.currentUser);
							frmRequestList.dispose();
							MyHistoryGUI window = new MyHistoryGUI();
							window.frmRequestList.setVisible(true);
							carpool.setStatus("d");
							//StreamUtils.writeCarpoolList(Init.carpoolList);
							StreamUtils.writeUserList(Init.userList);
						}
						else JOptionPane.showMessageDialog(null , "Your balance is not enough" , "Error", JOptionPane.INFORMATION_MESSAGE);
					}
				else JOptionPane.showMessageDialog(null , "Not authorized to pay for it" , "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		JButton btnSearchCarpools = new JButton("View User's Profile");
		btnSearchCarpools.setBounds(71, 356, 175, 23);
		frmRequestList.getContentPane().add(btnSearchCarpools);
		btnSearchCarpools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();
				String otherName = table.getValueAt(count, 7).toString();
				for (int i = 0; i < Init.userList.size(); i++)
				{
					if (otherName.equals(Init.userList.get(i).getName()))
					{
						ViewProfileGUI window = new ViewProfileGUI(Init.userList.get(i));
						window.frame.setVisible(true);
						window.frame.setDefaultCloseOperation(2);
					}
				}
			}
		});
		
		JButton btnRate = new JButton("Rate Selected User");
		btnRate.setBounds(408, 356, 156, 23);
		frmRequestList.getContentPane().add(btnRate);
		btnRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();
				int selectedID = Integer.parseInt(table.getValueAt(count, 8).toString());
				String status = table.getValueAt(count, 5).toString();
				String role = table.getValueAt(count, 8).toString();
				String otherName = table.getValueAt(count, 7).toString();
				if (status.equals("done"))
				{
						for (int i = 0; i < Init.userList.size(); i++)
						{
							if (otherName.equals(Init.userList.get(i).getName()))
							{
								if (!Check.checkIfRated(Init.carpoolList.get(selectedID),Init.currentUser,Init.userList.get(i)))
								{
									frmRequestList.dispose();
									RateUserGUI window = new RateUserGUI(Init.carpoolList.get(selectedID),Init.currentUser,Init.userList.get(i));
									window.frmRateUser.setVisible(true);
								}
								else JOptionPane.showMessageDialog(null , "You have rated this carpool." , "Error", JOptionPane.INFORMATION_MESSAGE);
							}
		
						}
				}
				else JOptionPane.showMessageDialog(null , "You have not finished this carpool" , "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JLabel lblOnlyUnmatchedCarpools = new JLabel("(Only unmatched carpools can be canceled)");
		lblOnlyUnmatchedCarpools.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOnlyUnmatchedCarpools.setBounds(56, 315, 213, 14);
		frmRequestList.getContentPane().add(lblOnlyUnmatchedCarpools);
		
		JLabel lblonlyFinishedCarpools = new JLabel("(Only finished carpools can be rated)");
		lblonlyFinishedCarpools.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblonlyFinishedCarpools.setBounds(401, 385, 213, 14);
		frmRequestList.getContentPane().add(lblonlyFinishedCarpools);
		
		JLabel lblyouCanPay = new JLabel("(You can pay for the carpools as a passenger)");
		lblyouCanPay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblyouCanPay.setBounds(379, 315, 278, 14);
		frmRequestList.getContentPane().add(lblyouCanPay);
		
		JButton btnSendReminder = new JButton("Send Reminder");
		btnSendReminder.setBounds(71, 412, 175, 23);
		frmRequestList.getContentPane().add(btnSendReminder);
		btnSendReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tableSize = table.getRowCount();
				for (int i = 0 ; i < tableSize; i++)
				{
					int selectedID = Integer.parseInt(table.getValueAt(i, 8).toString());
					String status = table.getValueAt(i, 5).toString();
					String role = table.getValueAt(i, 6).toString();
					String otherName = table.getValueAt(i, 7).toString();
					Carpool carpool = (Carpool) obj[i][9];
					if (status.equals("to be paid") && role.equals("driver"))
					{
						Check.sendReminder(carpool,otherName);
					}
				}
				JOptionPane.showMessageDialog(null , "Finish all reminders" , "Notice", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
