
public class Offer extends Carpool{
	
	public Offer(String fr, String to, String dc, String date, String time, int spots, int price, User dId, String schedule)
	{
		this.from =fr;
		this.to = to;
		this.date = date;
		this.time = time;
		this.spot = spots;
		this.price = (float)price;
		this.driver = dId;
		this.schedule = schedule;
		this.id = Init.carpoolList.size();
		this.status = "o";
		this.direction = dc;
	}
	
}
