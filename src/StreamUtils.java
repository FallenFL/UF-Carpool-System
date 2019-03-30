import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class StreamUtils {

    /**
     * Save objects
     */
	public static File userListFile = new File("User.txt");
	public static File carpoolListFile = new File("Carpool.txt");
	public static File rateListFile = new File("Rate.txt");
	public static File reminderListFile = new File("Reminder.txt");
	
	
	public static <User> boolean writeUserList(List<User> list)
    {
		  try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(userListFile)))
	        {
	            User[] obj = (User[]) new Object[list.size()];
	            list.toArray(obj);

	            out.writeObject(obj);
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	            return false;
	        }
		  return true;
    }



    /**
     * Read objects
     */
	public static <User> List<User> readUserList()
    {
        User[] object;
        try(ObjectInputStream out = new ObjectInputStream(new FileInputStream(userListFile))) 
        {
            object = (User[]) out.readObject();
            return Arrays.asList(object);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
	
	
	public static <Carpool> boolean writeCarpoolList(List<Carpool> list)
    {
		  try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(carpoolListFile)))
	        {
	            Carpool[] obj = (Carpool[]) new Object[list.size()];
	            list.toArray(obj);

	            out.writeObject(obj);
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	            return false;
	        }
		  return true;
    }
	
	public static <Carpool> List<Carpool> readCarpoolList()
    {
        Carpool[] object;
        try(ObjectInputStream out = new ObjectInputStream(new FileInputStream(carpoolListFile))) 
        {
            object = (Carpool[]) out.readObject();
            return Arrays.asList(object);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
	
	public static <Rate> boolean writeRateList(List<Rate> list)
    {
		  try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(rateListFile)))
	        {
	            Rate[] obj = (Rate[]) new Object[list.size()];
	            list.toArray(obj);

	            out.writeObject(obj);
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	            return false;
	        }
		  return true;
    }
	
	public static <Rate> List<Rate> readRateList()
    {
        Rate[] object;
        try(ObjectInputStream out = new ObjectInputStream(new FileInputStream(rateListFile))) 
        {
            object = (Rate[]) out.readObject();
            return Arrays.asList(object);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
	
	public static <Reminder> boolean writeReminderList(List<Reminder> list)
    {
		  try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(reminderListFile)))
	        {
			  Reminder[] obj = (Reminder[]) new Object[list.size()];
	            list.toArray(obj);

	            out.writeObject(obj);
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	            return false;
	        }
		  return true;
    }
	
	public static <Reminder> List<Reminder> readReminderList()
    {
        Reminder[] object;
        try(ObjectInputStream out = new ObjectInputStream(new FileInputStream(reminderListFile))) 
        {
            object = (Reminder[]) out.readObject();
            return Arrays.asList(object);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
}


