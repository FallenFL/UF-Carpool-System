
public class Reminder implements java.io.Serializable {
	
	private static final long serialVersionUID = -836378538244530333L;
	
	private boolean status;
	private Carpool carpool;
	private User from;
	private User to;
	
	public Reminder()
	{
		
	}
	
	public Reminder(boolean b, Carpool c, User from, User to)
	{
		this.status = b;
		this.carpool = c;
		this.from = from;
		this.to = to;
	}
	
	public void setStatus(boolean b)
	{
		this.status = b;
	}
	
	public void setCarpool(Carpool carpool)
	{
		this.carpool = carpool;
	}
	
	public void setFrom(User user)
	{
		this.from = user;
	}
	
	public void setTo(User to)
	{
		this.to = to;
	}
	
	public boolean getStatus()
	{
		return this.status;
	}
	
	public Carpool getCarpool()
	{
		return this.carpool;
	}
	
	public User getFrom()
	{
		return this.from;
	}
	
	public User getto()
	{
		return this.to;
	}
}
