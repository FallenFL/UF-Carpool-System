
public class Rate implements java.io.Serializable  {
	private Carpool carpool;
	private User from;
	private User to;
	private float rate;
	private String comment;
	
	public Rate(Carpool carpool, User from, User to) {
		this.carpool = carpool;
		this.from = from;
		this.to = to;
	}

	public Rate(Carpool carpool, User from, User to, int rating, String comment2) {
		this.carpool = carpool;
		this.from = from;
		this.to = to;
		this.rate = rating;
		this.comment = comment2;
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
	
	public void setRate(float rate)
	{
		this.rate = rate;
	}
	
	public float getRate()
	{
		return this.rate;
	}
	
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	public String getComment()
	{
		return this.comment;
	}
}
