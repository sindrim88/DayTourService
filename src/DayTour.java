import java.util.ArrayList;

public class DayTour{

	private String name;
	private int maxNum;
	private String guideName;
	private int time;
	private int price;
	private ArrayList <Customer> customer;
	
	
	public  DayTour(String name) {
		this.name = name;
		this.customer = new ArrayList<Customer>();	
		}
	
	public  DayTour(String name, int maxNum, int price) {
		this.name = name;
		this.maxNum = maxNum;
		this.price = price;
		this.customer = new ArrayList<Customer>();
	}
	
	public  DayTour(String name, int maxNum) {
		this.name = name;
		this.maxNum = maxNum;
		this.customer = new ArrayList<Customer>();
	}

	public  DayTour(String name, int maxNum,String guideName, int time, int price) {
		this.name = name;
		this.maxNum = maxNum;
		this.guideName = guideName;
		this.time = time;
		this.price = price;
		this.customer = new ArrayList<Customer>();
	}

	public ArrayList<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(ArrayList<Customer> customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}
	
	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public void newCustomer(String customerName) {
		getCustomer().add(new Customer(customerName));
	}
}
