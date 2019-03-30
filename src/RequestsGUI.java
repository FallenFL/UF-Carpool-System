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

public class RequestsGUI {

	JFrame frmRequestList;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestsGUI window = new RequestsGUI();
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
	public RequestsGUI() {
		initialize(Check.getRequestList());
	}
	
	public RequestsGUI(String date, String dc, int spots)
	{
		initialize(Check.getRequestList(date, dc, spots));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Object obj[][]) {
		frmRequestList = new JFrame();
		frmRequestList.setTitle("Request List");
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
		
		JButton btnChooseSelectedCarpool = new JButton("Accept selected carpool");
		btnChooseSelectedCarpool.setBounds(71, 286, 175, 23);
		frmRequestList.getContentPane().add(btnChooseSelectedCarpool);
		btnChooseSelectedCarpool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();
				int selectedID= Integer.parseInt(table.getValueAt(count, 8).toString());
				Carpool carpool = (Carpool) obj[count][9];
				if (count >= 0)
				{
						Check.takeRequest(carpool, Init.currentUser);
						frmRequestList.dispose();
						JOptionPane.showMessageDialog(null , "Accept Successfully" , "Accept Successfully", JOptionPane.INFORMATION_MESSAGE);
						RequestsGUI window = new RequestsGUI();
						window.frmRequestList.setVisible(true);
				}
				else JOptionPane.showMessageDialog(null , "Please select a row" , "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		JButton btnPostAnOffer = new JButton("Post a new offer");
		btnPostAnOffer.setBounds(408, 286, 156, 23);
		frmRequestList.getContentPane().add(btnPostAnOffer);
		btnPostAnOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRequestList.dispose();
				PostNewOfferGUI window = new PostNewOfferGUI();
				window.Search.setVisible(true);
			}
		});
		
		
		JButton btnSearchCarpools = new JButton("Search carpools");
		btnSearchCarpools.setBounds(71, 356, 175, 23);
		frmRequestList.getContentPane().add(btnSearchCarpools);
		btnSearchCarpools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRequestList.dispose();
				SearchGUI window = new SearchGUI();
				window.Search.setVisible(true);
			}
		});
		
		JButton btnViewProfile = new JButton("View His Profile");
		btnViewProfile.setBounds(408, 356, 156, 23);
		frmRequestList.getContentPane().add(btnViewProfile);
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
