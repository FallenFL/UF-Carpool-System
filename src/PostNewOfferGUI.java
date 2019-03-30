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
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class PostNewOfferGUI {

	JFrame Search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostNewOfferGUI window = new PostNewOfferGUI();
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
	public PostNewOfferGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Search = new JFrame();
		Search.setTitle("Post a New Offer");
		Search.setBounds(300, 300, 743, 514);
		Search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Search.getContentPane().setLayout(null);
		
		JLabel lblTime = new JLabel("Date & Time");
		lblTime.setBounds(10, 69, 73, 14);
		Search.getContentPane().add(lblTime);
		
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
		
		JRadioButton rdbtnToSouth = new JRadioButton("To South");
		rdbtnToSouth.setBounds(181, 107, 109, 23);
		Search.getContentPane().add(rdbtnToSouth);
		
		rdbtnToNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnToSouth.setSelected(false);
			}
		});
		
		rdbtnToSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnToNorth.setSelected(false);
			}
		});
		
		JLabel lblTotalPrice = new JLabel("Unit Price");
		lblTotalPrice.setBounds(10, 182, 73, 14);
		Search.getContentPane().add(lblTotalPrice);
		
		JFormattedTextField priceField = new JFormattedTextField();
		priceField.setBounds(105, 179, 140, 21);
		Search.getContentPane().add(priceField);
			
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(10, 221, 73, 14);
		Search.getContentPane().add(lblDeparture);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(10, 263, 73, 14);
		Search.getContentPane().add(lblDestination);
		
		JFormattedTextField frField = new JFormattedTextField();
		frField.setBounds(105, 218, 140, 21);
		Search.getContentPane().add(frField);
		
		JFormattedTextField toField = new JFormattedTextField();
		toField.setBounds(105, 260, 140, 21);
		Search.getContentPane().add(toField);
		
		SpinnerDateModel model = new SpinnerDateModel();
		JSpinner year = new JSpinner(model);
		year.setValue(new Date());
		JSpinner.DateEditor editor = new JSpinner.DateEditor(year,"yyyy-MM-dd HH:mm");
		year.setEditor(editor);
		year.setBounds(105, 66, 135, 20);
		Search.getContentPane().add(year);
		
		JComboBox spotsBox = new JComboBox();
		spotsBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		spotsBox.setBounds(106, 146, 139, 20);
		Search.getContentPane().add(spotsBox);
		
		JComboBox scheduleBox = new JComboBox();
		scheduleBox.setModel(new DefaultComboBoxModel(new String[] {"No Schedule", "Every Day", "Every Week", "Every Two Week", "Every Month"}));
		scheduleBox.setBounds(102, 309, 153, 20);
		Search.getContentPane().add(scheduleBox);
		
		JLabel lblSchedule = new JLabel("Schedule");
		lblSchedule.setBounds(10, 312, 62, 14);
		Search.getContentPane().add(lblSchedule);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(322, 107, 89, 23);
		Search.getContentPane().add(btnConfirm);
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
					Offer offer = new Offer(fr,to,dc,dateString,timeString,spots,price,Init.currentUser,schedule);
					Init.carpoolList = new ArrayList<>(Init.carpoolList);
					Init.carpoolList.add(offer);
					Init.currentUser.getcList().add(offer);
					StreamUtils.writeCarpoolList(Init.carpoolList);
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
						Offer offer1 = new Offer(fr,to,dc,dateString1,timeString,spots,price,Init.currentUser,schedule);
						Init.carpoolList.add(offer1);
						Init.currentUser.getcList().add(offer1);
						StreamUtils.writeCarpoolList(Init.carpoolList);
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
						Offer offer1 = new Offer(fr,to,dc,dateString1,timeString,spots,price,Init.currentUser,schedule);
						Init.carpoolList.add(offer1);
						StreamUtils.writeCarpoolList(Init.carpoolList);
						Init.currentUser.getcList().add(offer1);
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
						Offer offer1 = new Offer(fr,to,dc,dateString1,timeString,spots,price,Init.currentUser,schedule);
						Init.carpoolList.add(offer1);
						StreamUtils.writeCarpoolList(Init.carpoolList);
						Init.currentUser.getcList().add(offer1);
						StreamUtils.writeUserList(Init.userList);
					}
				}
				else if (scheduleBox.getSelectedIndex() == 4)
				{
					for(int i = 0; i < 3; i++)
					{
						Calendar cal = Calendar.getInstance();
						cal.setTime((Date) obj);
						cal.add(Calendar.MONTH, i);
						Date date1 = cal.getTime();
						String dateString1 = formatter.format(date1);
						Init.carpoolList = new ArrayList<>(Init.carpoolList);
						Offer offer1 = new Offer(fr,to,dc,dateString1,timeString,spots,price,Init.currentUser,schedule);
						Init.carpoolList.add(offer1);
						StreamUtils.writeCarpoolList(Init.carpoolList);
						Init.currentUser.getcList().add(offer1);
						StreamUtils.writeUserList(Init.userList);
					}
				}
				OffersGUI window = new OffersGUI();
				window.frmOfferList.setVisible(true);
				JOptionPane.showMessageDialog(null , "Post Successfully" , "Post Successfully", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
