import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;

public class OffersGUI {

	 JFrame frmOfferList;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OffersGUI window = new OffersGUI();
					window.frmOfferList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OffersGUI() {
		initialize(Check.getOfferList());
	}
	
	public OffersGUI(String date, String dc, int spots)
	{
		initialize(Check.getOfferList(date, dc, spots));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Object obj[][]) {
		frmOfferList = new JFrame();
		frmOfferList.setTitle("Offer List");
		frmOfferList.setBounds(100, 100, 648, 496);
		frmOfferList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOfferList.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 25, 612, 233);
		frmOfferList.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			obj,
			new String[] {
				"From", "To", "Date", "Time", "Spots", "Total Price", "User Name", "Schedule", "id"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Object.class, Object.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		scrollPane.setViewportView(table);
		
		JSpinner spotSpinner = new JSpinner();
		spotSpinner.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spotSpinner.setBounds(256, 287, 29, 20);
		frmOfferList.getContentPane().add(spotSpinner);
		
		JLabel lblPeople = new JLabel("People");
		lblPeople.setBounds(289, 290, 46, 14);
		frmOfferList.getContentPane().add(lblPeople);
		
		JButton btnChooseSelectedCarpool = new JButton("Join selected carpool");
		btnChooseSelectedCarpool.setBounds(71, 286, 175, 23);
		frmOfferList.getContentPane().add(btnChooseSelectedCarpool);
		btnChooseSelectedCarpool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();
				int spot = (int) spotSpinner.getValue();
				Carpool carpool = (Carpool) obj[count][9];
				if (count >= 0)
				{
					if (spot <= carpool.getSpot())
					{
						Check.joinOffer(carpool, Init.currentUser, spot);
						frmOfferList.dispose();
						JOptionPane.showMessageDialog(null , "Join Successfully" , "Join Successfully", JOptionPane.INFORMATION_MESSAGE);
						OffersGUI window = new OffersGUI();
						window.frmOfferList.setVisible(true);
					}
					else JOptionPane.showMessageDialog(null , "Spots are not enough" , "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else JOptionPane.showMessageDialog(null , "Please select a row" , "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		JButton btnPostAnOffer = new JButton("Post a new request");
		btnPostAnOffer.setBounds(408, 286, 156, 23);
		frmOfferList.getContentPane().add(btnPostAnOffer);
		btnPostAnOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOfferList.dispose();
				PostNewRequestGUI window = new PostNewRequestGUI();
				window.Search.setVisible(true);
			}
		});
		
		JButton btnSearchCarpools = new JButton("Search carpools");
		btnSearchCarpools.setBounds(71, 356, 175, 23);
		frmOfferList.getContentPane().add(btnSearchCarpools);
		btnSearchCarpools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOfferList.dispose();
				SearchGUI window = new SearchGUI();
				window.Search.setVisible(true);
			}
		});
		
		JButton btnViewProfile = new JButton("View His Profile");
		btnViewProfile.setBounds(408, 356, 156, 23);
		frmOfferList.getContentPane().add(btnViewProfile);
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();
				String otherName = table.getValueAt(count, 6).toString();
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
		
	
	}
}
