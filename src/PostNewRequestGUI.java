import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;

public class PostNewRequestGUI {

	JFrame Search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostNewRequestGUI window = new PostNewRequestGUI();
					window.Search.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PostNewRequestGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Search = new JFrame();
		Search.setTitle("Post a New Request");
		Search.setBounds(100, 100, 543, 414);
		Search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Search.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Direction");
		lblNewLabel.setBounds(10, 111, 62, 14);
		Search.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Spots");
		lblNewLabel_1.setBounds(10, 149, 46, 14);
		Search.getContentPane().add(lblNewLabel_1);
		
		JButton btnGoBack = new JButton("Reset");
		btnGoBack.setBounds(322, 178, 89, 23);
		Search.getContentPane().add(btnGoBack);
		
		JRadioButton rdbtnToNorth = new JRadioButton("To North");
		rdbtnToNorth.setBounds(100, 107, 73, 23);
		Search.getContentPane().add(rdbtnToNorth);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("To South");
		rdbtnNewRadioButton.setBounds(181, 107, 109, 23);
		Search.getContentPane().add(rdbtnNewRadioButton);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setBounds(10, 182, 73, 14);
		Search.getContentPane().add(lblTotalPrice);
		
		JFormattedTextField priceField = new JFormattedTextField();
		priceField.setBounds(105, 179, 137, 21);
		Search.getContentPane().add(priceField);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(322, 107, 89, 23);
		Search.getContentPane().add(btnConfirm);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(10, 221, 73, 14);
		Search.getContentPane().add(lblDeparture);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(10, 263, 73, 14);
		Search.getContentPane().add(lblDestination);
		
		JFormattedTextField frField = new JFormattedTextField();
		frField.setBounds(105, 218, 137, 21);
		Search.getContentPane().add(frField);
		
		JFormattedTextField toField = new JFormattedTextField();
		toField.setBounds(105, 260, 137, 21);
		Search.getContentPane().add(toField);
		
		JLabel label = new JLabel("Date & Time");
		label.setBounds(10, 74, 73, 14);
		Search.getContentPane().add(label);
		
		SpinnerDateModel model = new SpinnerDateModel();
		JSpinner year = new JSpinner(model);
		year.setValue(new Date());
		JSpinner.DateEditor editor = new JSpinner.DateEditor(year,"yyyy-MM-dd HH:mm");
		year.setEditor(editor);
		year.setBounds(107, 65, 135, 20);
		Search.getContentPane().add(year);
		
		JComboBox spotsBox = new JComboBox();
		spotsBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		spotsBox.setBounds(103, 146, 139, 20);
		Search.getContentPane().add(spotsBox);
		
		JComboBox scheduleBox = new JComboBox();
		scheduleBox.setModel(new DefaultComboBoxModel(new String[] {"No Schedule", "Every  Day", "Every Week", "Every Two Week", "Every Month", "      "}));
		scheduleBox.setBounds(100, 312, 153, 20);
		Search.getContentPane().add(scheduleBox);
		
		JLabel label_1 = new JLabel("Schedule");
		label_1.setBounds(10, 315, 62, 14);
		Search.getContentPane().add(label_1);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search.dispose();
				String fr = frField.getText();
				String to = toField.getText();
				int price = Integer.parseInt((String) priceField.getText());
				Object obj = model.getDate();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat timeformatter = new SimpleDateFormat("HH:mm");
				String dateString = formatter.format(obj);
				String timeString = timeformatter.format(obj);
				String dc = "";
				if (rdbtnToNorth.isSelected())
				{
					dc = "n";
				}
				else 
				{
					dc = "s";
				}
				int spots = Integer.parseInt((String) spotsBox.getSelectedItem());
				String schedule = ((String) scheduleBox.getSelectedItem());
				if (scheduleBox.getSelectedIndex() == 0)
				{
					schedule ="";
					Request request = new Request(fr,to,dc,dateString,timeString,spots,price,Init.currentUser,schedule);
					Init.carpoolList = new ArrayList<>(Init.carpoolList);
					Init.carpoolList.add(request);
					StreamUtils.writeCarpoolList(Init.carpoolList);
					Init.currentUser.getcList().add(request);
					StreamUtils.writeUserList(Init.userList);
				}
				else if (scheduleBox.getSelectedIndex() == 1)
				{
					for(int i = 0; i < 7; i++)
					{
						Calendar cal = Calendar.getInstance();
						cal.setTime((Date) obj);
						cal.add(Calendar.DATE, i);
						Date date1 = cal.getTime();
						String dateString1 = formatter.format(date1);
						Init.carpoolList = new ArrayList<>(Init.carpoolList);
						Request request1 = new Request(fr,to,dc,dateString1,timeString,spots,price,Init.currentUser,schedule);
						Init.carpoolList.add(request1);
						StreamUtils.writeCarpoolList(Init.carpoolList);
						Init.currentUser.getcList().add(request1);
						StreamUtils.writeUserList(Init.userList);
					}
				}
				else if (scheduleBox.getSelectedIndex() == 2)
				{
					for(int i = 0; i < 4; i++)
					{
						Calendar cal = Calendar.getInstance();
						cal.setTime((Date) obj);
						cal.add(Calendar.DATE, i*7);
						Date date1 = cal.getTime();
						String dateString1 = formatter.format(date1);
						Init.carpoolList = new ArrayList<>(Init.carpoolList);
						Request request1 = new Request(fr,to,dc,dateString1,timeString,spots,price,Init.currentUser,schedule);
						Init.carpoolList.add(request1);
						StreamUtils.writeCarpoolList(Init.carpoolList);
						Init.currentUser.getcList().add(request1);
						StreamUtils.writeUserList(Init.userList);
					}
				}
				else if (scheduleBox.getSelectedIndex() == 3)
				{
					for(int i = 0; i < 4; i++)
					{
						Calendar cal = Calendar.getInstance();
						cal.setTime((Date) obj);
						cal.add(Calendar.DATE, i*14);
						Date date1 = cal.getTime();
						String dateString1 = formatter.format(date1);
						Init.carpoolList = new ArrayList<>(Init.carpoolList);
						Request request1 = new Request(fr,to,dc,dateString1,timeString,spots,price,Init.currentUser,schedule);
						Init.carpoolList.add(request1);
						StreamUtils.writeCarpoolList(Init.carpoolList);
						Init.currentUser.getcList().add(request1);
						StreamUtils.writeUserList(Init.userList);
					}
				}
				else if (scheduleBox.getSelectedIndex() == 4)
				{
					for(int i = 0; i < 4; i++)
					{
						Calendar cal = Calendar.getInstance();
						cal.setTime((Date) obj);
						cal.add(Calendar.MONTH, i);
						Date date1 = cal.getTime();
						String dateString1 = formatter.format(date1);
						Init.carpoolList = new ArrayList<>(Init.carpoolList);
						Request request1 = new Request(fr,to,dc,dateString1,timeString,spots,price,Init.currentUser,schedule);
						Init.carpoolList.add(request1);
						Init.currentUser.getcList().add(request1);
						StreamUtils.writeUserList(Init.userList);
					}
				}
				RequestsGUI window = new RequestsGUI();
				window.frmRequestList.setVisible(true);
				JOptionPane.showMessageDialog(null , "Post Successfully" , "Post Successfully", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
