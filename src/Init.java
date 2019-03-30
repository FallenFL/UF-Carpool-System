import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Init implements Serializable {
	
	public static String AdminPwd = "admin";
	public static User currentUser = null;
	
	public static List<User> userList = new ArrayList<>();
	public static List<Carpool> carpoolList = new ArrayList<>();
	public static List<Rate> rateList = new ArrayList<>();
	public static List<Reminder> reminderList = new ArrayList<>();
	
	public static void main(String[] args) {
		/** User user1 = new User("peter","123","12345678","352990887","peter@ufl.edu","Mercedez","GLK350");
		userList.add(user1);
		User user2 = new User("ellen","456","87654321","804234567","ellen@gmail.com","Honda","Civic");
		userList.add(user2);
		StreamUtils.writeUserList(userList);
		
		
		Request request1 = new Request("mco","mia","s","2019-03-02","19:30",1,50,userList.get(0),"");
		carpoolList.add(null);
		Request request2 = new Request("mco","jax","n","2019-03-02","19:30",2,50,userList.get(1),"");
		carpoolList.add(null);
		userList.get(0).getcList().add(request1);
		userList.get(1).getcList().add(request2);
		userList = StreamUtils.readUserList();
		Offer offer1 = new Offer("mco","jax","n","2019-03-02","19:30",5,50,userList.get(1),"");
		carpoolList.add(null);
		Offer offer2 = new Offer("boston","gnv","s","2019-03-03","19:30",5,50,userList.get(0),"");
		carpoolList.add(null);
		userList.get(1).getcList().add(offer1);
		userList.get(0).getcList().add(offer2);

		
		StreamUtils.writeUserList(userList);
		StreamUtils.writeCarpoolList(carpoolList);
		
		StreamUtils.writeRateList(rateList);
		StreamUtils.writeReminderList(reminderList);**/
		
		userList = StreamUtils.readUserList();
		carpoolList = StreamUtils.readCarpoolList();

		rateList = StreamUtils.readRateList();
		reminderList = StreamUtils.readReminderList();
		try {
			Check.updateStatus();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginGUI window = new UserLoginGUI();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}
