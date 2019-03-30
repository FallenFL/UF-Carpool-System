import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMainGUI {

	JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainGUI window = new UserMainGUI();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserMainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 469, 300);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		
		JLabel lblWhatAreWe = new JLabel("What are going to do today?");
		lblWhatAreWe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWhatAreWe.setBounds(126, 11, 218, 91);
		frmMainMenu.getContentPane().add(lblWhatAreWe);
		
		JButton btnJoinACarpool = new JButton("Show All Offers");
		btnJoinACarpool.setBounds(41, 113, 163, 23);
		frmMainMenu.getContentPane().add(btnJoinACarpool);
		btnJoinACarpool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMainMenu.dispose();
				OffersGUI window = new OffersGUI();
				window.frmOfferList.setVisible(true);
				
			}
		});
		
		JButton btnLookForPassengers = new JButton("Show All Requests");
		btnLookForPassengers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMainMenu.dispose();
				RequestsGUI window = new RequestsGUI();
				window.frmRequestList.setVisible(true);;
				
			}
		});
		btnLookForPassengers.setBounds(41, 163, 163, 23);
		frmMainMenu.getContentPane().add(btnLookForPassengers);
		
		JButton btnPostAnOffer = new JButton("Post a New Offer");
		btnPostAnOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				PostNewOfferGUI window = new PostNewOfferGUI();
				window.Search.setVisible(true);
			}
		});
		btnPostAnOffer.setBounds(248, 113, 155, 23);
		frmMainMenu.getContentPane().add(btnPostAnOffer);
		
		JButton btnPostARequest = new JButton("Post a New Request");
		btnPostARequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				PostNewRequestGUI window = new PostNewRequestGUI();
				window.Search.setVisible(true);
			}
		});
		btnPostARequest.setBounds(248, 163, 155, 23);
		frmMainMenu.getContentPane().add(btnPostARequest);
		
		JButton btnRecharge = new JButton("Recharge Balance");
		btnRecharge.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				RechargeBalanceGUI window = new RechargeBalanceGUI();
				window.frmRechargeBalance.setVisible(true);
				
			}		
		});
		btnRecharge.setBounds(41, 210, 163, 23);
		frmMainMenu.getContentPane().add(btnRecharge);
		
		
		JButton btnViewMyHistory = new JButton("View My Carpools");
		btnViewMyHistory.setBounds(248, 210, 155, 23);
		frmMainMenu.getContentPane().add(btnViewMyHistory);
		btnViewMyHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainMenu.dispose();
				MyHistoryGUI window = new MyHistoryGUI();
				window.frmRequestList.setVisible(true);
			}
		});
	}

}
