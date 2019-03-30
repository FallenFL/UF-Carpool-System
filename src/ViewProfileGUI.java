import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class ViewProfileGUI {

	JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProfileGUI window = new ViewProfileGUI();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewProfileGUI() {
		//initialize(0);
	}

	public ViewProfileGUI(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		frame = new JFrame();
		frame.setTitle("Profile");
		frame.setBounds(100, 100, 638, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 11, 610, 39);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Object[][] userProfile = Check.getUserProfile(user);
		table.setModel(new DefaultTableModel(
			userProfile,
			new String[] {
				"User Name", "Phone", "Email","Rating", "Vehicle Make", "Model"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 108, 600, 273);
		frame.getContentPane().add(scrollPane_1);
		Object[][] rateList = Check.getRateList(user);
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			rateList,
			new String[] {
				"By", "Rating", "Comment"
			}
		));
		table_1.getColumnModel().getColumn(2).setPreferredWidth(258);
		scrollPane_1.setViewportView(table_1);
		table.getColumnModel().getColumn(5).setPreferredWidth(106);
	}
}
