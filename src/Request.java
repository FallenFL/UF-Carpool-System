
public class Request extends Carpool {
	

	public Request(String fr, String to, String dc, String date, String time, int spots, float price, User p, String schedule)
	{
		this.from =fr;
		this.to = to;
		this.date = date;
		this.time = time;
		this.spot = spots;
		this.price = price;
		this.pList.add(p);
		this.schedule = schedule;
		this.id = Init.carpoolList.size();
		this.status = "r";
		this.direction = dc;
		this.balance[0] = spots*price;
		this.status = "r";
	}
		
}
