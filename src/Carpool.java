import java.util.ArrayList;
import java.util.List;

public class Carpool implements java.io.Serializable{
	
	private static final long serialVersionUID = 6616643641806130210L;
	
	protected String date;
	protected String time;
	protected String direction;//s,n
	protected String from;
	protected String to;
	protected String schedule;//dayly(d),weekly(w),every two weeks(2w),monthly(m) or null
	protected int id;
	protected User driver;
	protected List<User> pList = new ArrayList<>();
	protected boolean[] paid = new boolean[4];
	protected float[] balance = new float[4];
	protected String status;//offer(o),request(r),wait to be filled(w),full(f),expired(e),cancel(c),to be paid(t),done(d)
	protected int spot;
	protected float price;
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
	
	public String getTime()
	{
		return this.time;
	}
	
	public void setDirection(String dc)
	{
		this.direction = dc;
	}
	
	public String getDirection()
	{
		return this.direction; 
	}
	
	public void setFrom(String fr)
	{
		this.from = fr;
	}
	
	public String getFrom()
	{
		return this.from;
	}
	
	public void setTo(String to)
	{
		this.to = to;
	}
	
	public String getTo()
	{
		return this.to;
	}
	
	public void setSchedule(String schedule)
	{
		this.schedule = schedule;
	}
	
	public String getSchedule()
	{
		return this.schedule;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public int getSpot()
	{
		return this.spot;
	}
	
	public float getPrice()
	{
		return this.price;
	}
	
	public User getPassenger(int index)
	{
		return this.pList.get(index);
	}

	public User getDriver() {
		return this.driver;
	}

	public void addPassneger(User p) {
		this.pList.add(p);
	}

	public void setSpot(int spot) {
		this.spot = spot;
		
	}

	public void setBalance(int index, float price) {
		this.balance[index] = price;
	}

	public void setDriver(User Driver) {
		this.driver = Driver;	
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getStatus()
	{
		return this.status;
	}
	
	public float getBalance(int index)
	{
		return this.balance[index];
	}
	
	public boolean getPayment(int index)
	{
		return this.paid[index];
	}
	
	public void setPayment(User currentUser)
	{
		for (int i = 0; i < pList.size(); i++)
			if (this.pList.get(i) == currentUser)
			{
				this.paid[i] = true;
				break;
			}
	}

	public List<User> getpList() {
		return this.pList;
	}
	
}
