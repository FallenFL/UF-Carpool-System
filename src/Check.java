
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Check {

	public static boolean checkLogin(String acc, String pwd) {	
		for (int i = 0; i < Init.userList.size(); i++)
		{
			if (Init.userList.get(i).getName().equals(acc) && Init.userList.get(i).getPwd().equals(pwd))
			{
					Init.currentUser = Init.userList.get(i);
					return true;
			}
		}
		return false;
	}

	public static boolean duplicateName(String name) {
		for (int i = 0; i < Init.userList.size(); i++)
		{
			if (Init.userList.get(i).getName().equals(name) || name.equals("Admin") )
			{
					return false;
			}
		}
		return true;
	}
	
	public static int checkName(String acc) {	
		for (int i = 0; i < Init.userList.size(); i++)
		{
			System.out.println(acc+" "+Init.userList.get(i).getName());
			if (Init.userList.get(i).getName().equals(acc))
			{
					return i;
			}
		}
		return -1;
	}
	
	public static Object[][] getRequestList()
	{
		int count = 0;
		Object obj[][] = new Object[Init.carpoolList.size()*10][10];
		for (int i = 0; i < Init.userList.size(); i++)
			for (int j = 0; j < Init.userList.get(i).getcList().size(); j++)
			{
				Carpool carpool = Init.userList.get(i).getcList().get(j);
			if (carpool instanceof Request && carpool.getSpot()!= 0 
			&& carpool.getDriver() == null && carpool.getStatus().equals("r"))
		{
				obj[count][0] = carpool.getFrom();
				obj[count][1] = carpool.getTo();
				obj[count][2] = carpool.getDate();
				obj[count][3] = carpool.getTime();
				obj[count][4] = carpool.getSpot();
				obj[count][5] = carpool.getPrice();
				User passenger = carpool.getPassenger(0);
				String name = passenger.getName();
				obj[count][6] = name;
				obj[count][7] = carpool.getSchedule();
				obj[count][8] = carpool.getID();
				obj[count][9] = carpool;
				count++;
		}
			}
		
		Object obj1[][] = new Object[count][10];
		for (int i = 0; i < count; i++)
			for (int j = 0; j < 10; j++)
			{
				obj1[i][j] = obj[i][j];
			}
		return obj1;
	}
	
	public static Object[][] getRequestList(String date, String dc, int spot)
	{
		int count = 0;
		Object obj[][] = new Object[Init.carpoolList.size()*10][10];
		for (int i = 0; i < Init.userList.size(); i++)
			for (int j = 0; j < Init.userList.get(i).getcList().size(); j++)
			{
				Carpool carpool = Init.userList.get(i).getcList().get(j);
			if (carpool instanceof Request && carpool.getDirection().equals(dc) 
					&& carpool.getDate().equals(date) && carpool.getSpot() <= spot 
					&& carpool.getSpot()!= 0 && carpool.getDriver() == null && 
					(carpool.getStatus().equals("r")))
		{
				obj[count][0] = carpool.getFrom();
				obj[count][1] = carpool.getTo();
				obj[count][2] = carpool.getDate();
				obj[count][3] = carpool.getTime();
				obj[count][4] = carpool.getSpot();
				obj[count][5] = carpool.getPrice();
				User passenger = carpool.getPassenger(0);
				String name = passenger.getName();
				obj[count][6] = name;
				obj[count][7] = carpool.getSchedule();
				obj[count][8] = carpool.getID();
				obj[count][9] = carpool;
				count++;
			count++;
		}
			}
		
		Object obj1[][] = new Object[count][10];
		for (int i = 0; i < count; i++)
			for (int j = 0; j <10 ; j++)
			{
				obj1[i][j] = obj[i][j];
			}
		return obj1;
	}
	
	public static Object[][] getOfferList()
	{
		int count = 0;
		Object obj[][] = new Object[1000][10];
		//System.out.println(Init.carpoolList.size());
		for (int i = 0; i < Init.userList.size(); i++)
			for (int j = 0; j < Init.userList.get(i).getcList().size(); j++)
			{
				Carpool carpool = Init.userList.get(i).getcList().get(j);
			if (carpool instanceof Offer && carpool.getDriver() == Init.userList.get(i) && carpool.getSpot() > 0 &&
			(carpool.getStatus().equals("o") || carpool.getStatus().equals("w")))
				{
				obj[count][0] = carpool.getFrom();
				obj[count][1] = carpool.getTo();
				obj[count][2] = carpool.getDate();
				obj[count][3] = carpool.getTime();
				obj[count][4] = carpool.getSpot();
				obj[count][5] = carpool.getPrice();
				User driver = carpool.getDriver();
				String name = driver.getName();
				obj[count][6] = name;
				obj[count][7] = carpool.getSchedule();
				obj[count][8] = carpool.getID();
				obj[count][9] = carpool;
				count++;
				}
			}
		Object obj1[][] = new Object[count][10];
		for (int i = 0; i < count; i++)
			for (int j = 0; j < 10; j++)
			{
				obj1[i][j] = obj [i][j];
			}
		return obj1;
	}
	
	public static Object[][] getOfferList(String date, String dc, int spot)
	{
		int count = 0;
		Object obj[][] = new Object[Init.carpoolList.size()*20][10];
		for (int i = 0; i < Init.userList.size(); i++)
			for (int j = 0; j < Init.userList.get(i).getcList().size(); j++)
		{
			Carpool carpool = Init.userList.get(i).getcList().get(j);
			if ((carpool instanceof Offer) && carpool.getDirection().equals(dc) 
					&& carpool.getDate().equals(date) && carpool.getSpot() >= spot && carpool.getDriver() != null && 
					(carpool.getStatus().equals("o") || carpool.getStatus().equals("w")) && carpool.getDriver().equals(Init.userList.get(i)))
		{
				obj[count][0] = carpool.getFrom();
				obj[count][1] = carpool.getTo();
				obj[count][2] = carpool.getDate();
				obj[count][3] = carpool.getTime();
				obj[count][4] = carpool.getSpot();
				obj[count][5] = carpool.getPrice();
				User driver = carpool.getDriver();
				String name = driver.getName();
				obj[count][6] = name;
				obj[count][7] = carpool.getSchedule();
				obj[count][8] = carpool.getID();
				obj[count][9] = carpool;
				count++;
		}
		}
		Object obj1[][] = new Object[count][10];
		for (int i = 0; i < count; i++)
			for (int j = 0; j <10; j++)
			{
				obj1[i][j] = obj[i][j];
			}
		return obj1;
	}
	
	public static void joinOffer(Carpool carpool, User currentUser, int spots)
	{
				carpool.addPassneger(currentUser);
				carpool.setSpot(carpool.getSpot() - spots);
				carpool.setBalance(carpool.getpList().size() - 1,carpool.getPrice()*spots);
				Init.currentUser.getcList().add(carpool);
				if (carpool.getSpot() == 0) carpool.setStatus("f");
				else carpool.setStatus("w");
			
		
		//StreamUtils.writeCarpoolList(Init.carpoolList);
		StreamUtils.writeUserList(Init.userList);
	}
	
	public static void takeRequest(Carpool carpool, User currentUser)
	{
		carpool.setDriver(currentUser);
		carpool.setBalance(0, carpool.getPrice()*carpool.getSpot());
		carpool.setStatus("f");
		Init.currentUser.getcList().add(carpool);
		//StreamUtils.writeCarpoolList(Init.carpoolList);
		StreamUtils.writeUserList(Init.userList);
	}

	public static Object[][] getHistoryList() {
		int count = 0,j = 0;
		Object obj[][] = new Object[1000][10];
		for (int i = 0; i < Init.currentUser.getcList().size(); i++)
			if (Init.currentUser.getcList().get(i).getDriver() != null)
			{
			if (Init.currentUser.getcList().get(i).getDriver().equals(Init.currentUser))
			{
				System.out.println(Init.currentUser.getcList().get(i).getID() + " " + Init.currentUser.getcList().get(i).getpList().size());
				if (Init.currentUser.getcList().get(i).getpList().size() != 0)
				{	
					System.out.println(Init.currentUser.getcList().get(i).getpList().size());
					j = 0;
					Carpool carpool = Init.currentUser.getcList().get(i);
					System.out.println(carpool.getpList());
					while (j< carpool.getpList().size() && carpool.getPassenger(j) != null)
					{
						obj[count][0] = carpool.getFrom();
						obj[count][1] = carpool.getTo();
						obj[count][2] = carpool.getDate();
						obj[count][3] = carpool.getTime();
						obj[count][4] = carpool.getBalance(j);
						if (carpool.getStatus().equals("f"))
						obj[count][5] = "full";
						else if (carpool.getStatus().equals("w"))
						obj[count][5] = "to be filled";
						else if (carpool.getStatus().equals("c"))
						obj[count][5] = "canceled";
						else if (carpool.getStatus().equals("e"))
						obj[count][5] = "expired";
						else if (carpool.getStatus().equals("o"))
						obj[count][5] = "offer";
						else if (carpool.getStatus().equals("d"))
						{
							if (checkIfPaid(carpool,carpool.getPassenger(j)))
							obj[count][5] = "done";
							else 
							obj[count][5] = "to be paid";
						}	
						else if (carpool.getStatus().equals("tb"))
						obj[count][5] = "to be paid";
						obj[count][6] = "driver";
						obj[count][7] = carpool.getPassenger(j).getName();
						obj[count][8] = carpool.getID();
						obj[count][9] = carpool;
						count++;
						//System.out.println(count);
						j++;
					}
				}
				else
				{
					Carpool carpool = Init.currentUser.getcList().get(i);
					obj[count][0] = carpool.getFrom();
					obj[count][1] = carpool.getTo();
					obj[count][2] = carpool.getDate();
					obj[count][3] = carpool.getTime();
					obj[count][4] = "";
					if (carpool.getStatus().equals("f"))
					obj[count][5] = "full";
					else if (carpool.getStatus().equals("w"))
					obj[count][5] = "to be filled";
					else if (carpool.getStatus().equals("c"))
					obj[count][5] = "canceled";
					else if (carpool.getStatus().equals("e"))
					obj[count][5] = "expired";
					else if (carpool.getStatus().equals("o"))
					obj[count][5] = "offer";
					else if (carpool.getStatus().equals("d"))
					{
						if (checkIfPaid(carpool,carpool.getPassenger(j)))
						obj[count][5] = "done";
						else 
						obj[count][5] = "to be paid";
					}	
					else if (carpool.getStatus().equals("tb"))
					obj[count][5] = "to be paid";
					obj[count][6] = "driver";
					obj[count][7] = "";
					obj[count][8] = carpool.getID();
					obj[count][9] = carpool;
					count++;
				}
			}
		}
		
		//get all history as passengers
		for (int i = 0; i < Init.currentUser.getcList().size(); i++)
		{
			for (int k = 0; k < Init.currentUser.getcList().get(i).getpList().size(); k++)
			{	
				Carpool carpool = Init.currentUser.getcList().get(i);
				System.out.println(carpool.getID() + " "+ carpool.getpList().size());
				if (carpool.getPassenger(k) != null)
				{
				if (Init.currentUser.getcList().get(i).getPassenger(k).equals(Init.currentUser))
				{
					if (carpool.getDriver() == null)
					{
						obj[count][0] = carpool.getFrom();
						obj[count][1] = carpool.getTo();
						obj[count][2] = carpool.getDate();
						obj[count][3] = carpool.getTime();
						obj[count][4] = carpool.getBalance(k);
						if (carpool.getStatus().equals("f"))
						obj[count][5] = "full";
						else if (carpool.getStatus().equals("w"))
						obj[count][5] = "to be filled";
						else if (carpool.getStatus().equals("c"))
						obj[count][5] = "canceled";
						else if (carpool.getStatus().equals("e"))
						obj[count][5] = "expired";
						else if (carpool.getStatus().equals("r"))
						obj[count][5] = "request";
						else if (carpool.getStatus().equals("d"))
						{
							if (!checkIfPaid(carpool, Init.currentUser))
								obj[count][5] = "to be paid";
								else 
								obj[count][5] = "done";
						}
						else if (carpool.getStatus().equals("tb"))
						{
							if (!checkIfPaid(carpool, Init.currentUser))
							obj[count][5] = "to be paid";
							else 
							obj[count][5] = "done";
						}
						obj[count][6] = "passenger";
						obj[count][7] = "";
						obj[count][8] = carpool.getID();
						obj[count][9] = carpool;
						count++;
						break;
					}
					else
					{
						obj[count][0] = carpool.getFrom();
						obj[count][1] = carpool.getTo();
						obj[count][2] = carpool.getDate();
						obj[count][3] = carpool.getTime();
						obj[count][4] = carpool.getBalance(k);
						if (carpool.getStatus().equals("f"))
						obj[count][5] = "full";
						else if (carpool.getStatus().equals("w"))
						obj[count][5] = "to be filled";
						else if (carpool.getStatus().equals("c"))
						obj[count][5] = "canceled";
						else if (carpool.getStatus().equals("e"))
						obj[count][5] = "expired";
						else if (carpool.getStatus().equals("r"))
						obj[count][5] = "request";
						else if (carpool.getStatus().equals("d"))
						{
							if (!checkIfPaid(carpool, Init.currentUser))
								obj[count][5] = "to be paid";
								else 
								obj[count][5] = "done";
						}
						else if (carpool.getStatus().equals("tb"))
						{
							if (!checkIfPaid(carpool, Init.currentUser))
							obj[count][5] = "to be paid";
							else 
							obj[count][5] = "done";
						}
						obj[count][6] = "passenger";
						obj[count][7] = carpool.getDriver().getName();
						obj[count][8] = carpool.getID();
						obj[count][9] = carpool;
						count++;
						break;
					}
				}
			 }
			}
		}
		Object obj1[][] = new Object[count][10];
		for (int i = 0; i < count; i++)
			for (j = 0; j <10; j++)
			{
				obj1[i][j] = obj [i][j];
			}
		return obj1;
	}


	public static void updateStatus() throws ParseException {
		for (int i = 0; i < Init.userList.size(); i++)
			for (int j = 0; j < Init.userList.get(i).getcList().size(); j++)
		{
			Carpool carpool = Init.userList.get(i).getcList().get(j);
			String date = carpool.getDate();
			String time = carpool.getTime();
			String datetime = date + " " + time;
			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				Date rideDate = fmt.parse(datetime);
				Date nowDate = new Date(); 
				if (rideDate.before(nowDate))
				{
					
					if (carpool.getStatus().equals("f") || carpool.getStatus().equals("w"))
					{
						if (checkPayment(carpool)) carpool.setStatus("d"); else carpool.setStatus("tb");
					}
					else if (carpool.getStatus().equals("r") || carpool.getStatus().equals("o"))
					{
						carpool.setStatus("e");
					}
					else if (carpool.getStatus().equals("tb"))
					{
						if (checkPayment(carpool)) carpool.setStatus("d");
					}
					StreamUtils.writeUserList(Init.userList);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static boolean checkPayment(Carpool carpool) {
		for (int i = 0; i < 4; i++)
		{
			if (carpool.getPayment(i) == false && carpool.getPassenger(i) != null)
			{
				return false;
			}
		}
		return true;
	}

	public static boolean checkTime(Carpool carpool) throws ParseException {
		String date = carpool.getDate();
		String time = carpool.getTime();
		String datetime = date + " " + time;
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date rideDate = fmt.parse(datetime);
		Date nowDate = new Date(); 
		if (rideDate.before(nowDate))
		{
			return true;
		}
		else return false;
	}
	
	private static boolean checkIfPaid(Carpool carpool, User currentUser) {
		for (int i = 0; i < carpool.getpList().size(); i++)
		{
			if (carpool.getpList().get(i).equals(currentUser)&& carpool.getPayment(i) == false)
			{
				return false;
			}
		}
		return true;
	}

	public static boolean checkIfRated(Carpool carpool, User currentUser, User user) {
		for (int i = 0; i < Init.rateList.size(); i++)
		{
			Rate rate = Init.rateList.get(i);
			if (rate.getCarpool().equals(carpool) && rate.getFrom().equals(currentUser) && rate.getto().equals(user))
				return true;
		}
		return false;
	}

	public static Object[][] getUserProfile(User user) {
		Object obj[][] = new Object[1][6];
		obj[0][0] = user.getName();
		obj[0][1] = user.getPhone();
		obj[0][2] = user.getEmail();
		obj[0][3] = getRating(user);
		obj[0][4] = user.getMake();
		obj[0][5] = user.getModel();
		return obj;
	}

	public static Object getRating(User user) {
		float rating = 0;
		int sum = 0;
		for (int i = 0; i < user.getrtList().size(); i++)
		{
			Rate rate = user.getrtList().get(i);
			sum ++;
			rating = (rating+rate.getRate()) / sum;
		}
		if (sum == 0) rating = 5;
		return (Object) rating;
	}
	
	public static Object[][] getRateList(User user)
	{
		Object obj[][] = new Object[user.getrtList().size()][3];
		int count = 0;
		for (int i = 0; i < user.getrtList().size(); i++)
		{
			    Rate rate = user.getrtList().get(i);	
				obj[count][0] = rate.getFrom().getName();
				obj[count][1] = rate.getRate();
				obj[count][2] = rate.getComment();
				count ++;
				System.out.println(count);
		}
		
		return obj;
	}

	public static void sendReminder(Carpool carpool, String otherName) {
		User to = new User();
		for (int i = 0; i < Init.userList.size(); i++)
		{
			if (Init.userList.get(i).getName().equals(otherName))
			{
				to = Init.userList.get(i);
				for (int j = 0; j < to.getrList().size(); j++)
				{
					Reminder reminder = to.getrList().get(j);
					if (reminder.getCarpool() != null)
					if (reminder.getCarpool().equals(carpool))
					{
						return;
					}
				}
			}
		}
		Reminder reminder = new Reminder(true, carpool, Init.currentUser, to);
		//Init.reminderList = new ArrayList<>(Init.reminderList);
		//Init.reminderList.add(reminder);
		to.getrList().add(reminder);
		StreamUtils.writeUserList(Init.userList);
		System.out.println("sent reminder for " + carpool.getID() + " to " + to.getName());
		//StreamUtils.writeReminderList(Init.reminderList);
		
	}

	public static void showReminder() {
		for (int i = 0; i < Init.currentUser.getrList().size(); i++)
		{
			
			Reminder reminder = Init.currentUser.getrList().get(i);
			{
				if (reminder.getCarpool() != null && reminder.getStatus())
				JOptionPane.showMessageDialog(null , "Please do not forget to pay for your carpool with id "+ reminder.getCarpool().getID() + " to " + reminder.getFrom().getName(), "Reminder", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void cancelReminder(Carpool carpool, User user, User currentUser) {
		for (int i = 0; i < currentUser.getrList().size(); i++)
		{
			Reminder reminder = currentUser.getrList().get(i);
			if (reminder.getCarpool() != null)
			if (reminder.getFrom().equals(user) && reminder.getto().equals(Init.currentUser) && reminder.getCarpool().equals(carpool))
			{
				reminder.setStatus(false);
				StreamUtils.writeUserList(Init.userList); 
				break;
			}
		}
		
	}

 }
