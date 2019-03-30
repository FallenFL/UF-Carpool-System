import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JList;

public class SearchGUI {

	JFrame Search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGUI window = new SearchGUI();
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
	public SearchGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Search = new JFrame();
		Search.setTitle("Search Carpools\r\n");
		Search.setBounds(100, 100, 543, 414);
		Search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Search.getContentPane().setLayout(null);
		
		JLabel lblTime = new JLabel("Date");
		lblTime.setBounds(10, 69, 73, 14);
		Search.getContentPane().add(lblTime);
		
		JLabel lblNewLabel = new JLabel("Direction");
		lblNewLabel.setBounds(10, 111, 57, 14);
		Search.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Spots");
		lblNewLabel_1.setBounds(10, 149, 46, 14);
		Search.getContentPane().add(lblNewLabel_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(95, 217, 161, 23);
		Search.getContentPane().add(btnReset);
		
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
		
		SpinnerDateModel model = new SpinnerDateModel();
		JSpinner year = new JSpinner(model);
		year.setValue(new Date());
		JSpinner.DateEditor editor = new JSpinner.DateEditor(year,"yyyy-MM-dd");
		year.setEditor(editor);
		year.setBounds(105, 66, 135, 20);
		Search.getContentPane().add(year);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setBounds(101, 146, 139, 20);
		Search.getContentPane().add(comboBox);

		
		JButton btnGoBack = new JButton("Search for an Offer");
		btnGoBack.setBounds(322, 166, 161, 23);
		Search.getContentPane().add(btnGoBack);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search.dispose();
				Object obj = model.getDate();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = formatter.format(obj);
				System.out.println(dateString);
				String dc = "";
				if (rdbtnToNorth.isSelected())
				{
					dc = "n";
				}
				else 
				{
					dc = "s";
				}
				int spots = Integer.parseInt((String) comboBox.getSelectedItem());
				OffersGUI window = new OffersGUI(dateString,dc,spots);
				window.frmOfferList.setVisible(true);
			}
		});
		
		

		
		JButton btnConfirm = new JButton("Search for a Request");
		btnConfirm.setBounds(322, 78, 161, 23);
		Search.getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search.dispose();
				Object obj = model.getDate();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = formatter.format(obj);
				System.out.println(dateString);
				String dc = "";
				if (rdbtnToNorth.isSelected())
				{
					dc = "n";
				}
				else 
				{
					dc = "s";
				}
				int spots = Integer.parseInt((String) comboBox.getSelectedItem());
				RequestsGUI window = new RequestsGUI(dateString,dc,spots);
				window.frmRequestList.setVisible(true);
			}
		});
		
	}
}
