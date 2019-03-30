import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = -8194100761372950993L;
	
	
	private String name;
	private String password;
	private int id;
	private String ufid;
	private String phone;
	private String email;
	private float rate;
	private String model;
	private String make;
	public static int count;
	private float balance;
	private List<Carpool> cList= new ArrayList<>();
	private List<Reminder> rList = new ArrayList<>();
	private List<Rate> rtList = new ArrayList<>();
	
	public User()
	{
		this.id = count;
		this.id = Init.userList.size();
	}
	
	public User(String name, String pwd)
	{
		this.name = name;
		this.password = pwd;
		this.id = Init.userList.size();
	}
	
	public User(String name, String pwd, String ufid, String phone, String email, String make, String model)
	{
		this.name = name;
		this.password = pwd;
		this.id = Init.userList.size();
		this.email = email;
		this.model = model;
		this.make = make;
		this.phone = phone;
		this.ufid = ufid;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setPwd(String pwd)
	{
		this.password = pwd;
	}
	
	public String getPwd()
	{
		return this.password;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getDetails() 
	{
		return    id + "," + name + ","  + password;
	}
	
	public void addBalance(float money)
	{
		this.balance += money;
	}
	
	public float getBalance()
	{
		return this.balance;
	}

	public String getUFID() {
		return this.ufid;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getEmail() {
		return this.email;
	}

	public String getModel() {
		return this.model;
	}

	public String getMake() {
		return this.make;
	}

	public void setPhone(String phone2) {
		this.phone = phone2;
		
	}

	public void setEmail(String email2) {
		this.email = email2;
		
	}

	public void setMake(String make2) {
		this.make = make2;
		
	}

	public void setModel(String model2) {
		this.model = model2;
		
	}

	public void setUFID(String ufid2) {
		this.ufid = ufid2;
		
	}

	public List<Carpool> getcList() {
		return this.cList;
	}

	public List<Rate> getrtList() {
		return this.rtList;
	}

	public List<Reminder> getrList() {
		return this.rList;
	}
}
