import java.util.ArrayList;
import java.util.List;

public class TourService {
	
	private String name;
	private ArrayList<DayTour> daytour;
	
	public TourService(String name) {
		this.name = name;
		this.daytour = new ArrayList<DayTour>();
	}

	public void addTour(String tourName) {
		if(!tourName.equals("")  && !tourName.equals(null)) {
			this.daytour.add(new DayTour(tourName));
		}
		else {
			System.out.println("Unsuccessful: daytour name cannot be null or empty String");
		}
	}
	
	public void addTour(String tourName,int maxNum) {
		if(!tourName.equals("")  && !tourName.equals(null)) {
			this.daytour.add(new DayTour(tourName,maxNum));
		}
		else {
			System.out.println("Unsuccessful: daytour name cannot be null or empty String");
		}
	}
	public void addTour(String tourName,int maxNum,int price) {
		if(!tourName.equals("")  && !tourName.equals(null)) {
			this.daytour.add(new DayTour(tourName,maxNum, price));
		}
		else {
			System.out.println("Unsuccessful: daytour name cannot be null or empty String");
		}
	}
	
	public void addTour(String tourName, int maxNum,String guideName, int time, int price) {
		if(!tourName.equals("")  && !tourName.equals(null)) {
			this.daytour.add(new DayTour(tourName,maxNum,guideName, time, price));
		}
		else {
			System.out.println("Unsuccessful: daytour name cannot be null or empty String");
		}
	}
	public void addCustomer(String tourName, String customerName) {
		DayTour checkeddaytour = findDayTour1(tourName);
		if (checkeddaytour != null) {
			checkeddaytour.newCustomer(customerName);
		}
	}
	
	private DayTour findDayTour1(String tour) {
		
		for(int i = 0; i < daytour.size(); i++) {
			DayTour checkedDayTour = this.daytour.get(i);
			if(checkedDayTour.getName().equals(tour)) {
				return this.daytour.get(i);
			}
		}
		return null;
	}
	
	public void getDayTour(){
		for(int i = 0; i< daytour.size(); i++) {
			System.out.println(daytour.get(i).getName());	
		}
	}
	
	public String findDayTour(String tourName){
		System.out.println("Searching for the tour "  + tourName);
		for(int i = 0; i< daytour.size(); i++) {
			if(daytour.get(i).getName().equals(tourName)) {
				System.out.println("The tour " + tourName + " is in the database");
				
				return daytour.get(i).getName();
			}
		}
		return null; 
	}
	
	public void getTourMaxGoers(String tourName) {
		for(int i = 0; i< daytour.size(); i++) {
			if(daytour.get(i).getName().equals(tourName)) {
				System.out.println("The tour " + tourName + " Supports " + daytour.get(i).getMaxNum() + " people :)");
				return;
			}
		}
		return; 
	}
	
	public void getTourInfo(String tourName) {
		
		for(int i = 0; i< daytour.size(); i++) {
			if(daytour.get(i).getName().equals(tourName)) {
				System.out.println("The daytour "+  daytour.get(i).getName() +  " is in the database");
				if(daytour.get(i).getPrice() > 0) {
					System.out.println("Price = " + daytour.get(i).getPrice());
				}
				if(daytour.get(i).getGuideName() != null ) {
					System.out.println("Guide: " + daytour.get(i).getGuideName());
				}
				if(daytour.get(i).getTime() > 0) {
					System.out.println("Time/Duration: " + daytour.get(i).getTime());
				}
				ArrayList<Customer> tourCustomers = daytour.get(i).getCustomer();
				for(int j = 0; j<tourCustomers.size(); j++ ) {
					System.out.println(tourCustomers.get(j).getName() + " is booked for " + daytour.get(i).getName());
				
				}
			}
		}
	}
	
	public void addChangeTourPrice(String name, int price) {
		
		DayTour tour = findDayTour1(name);
		tour.setPrice(price);
		//System.out.println("Price testing");
	}
	
	public void sortByPrice() {
		ArrayList<Object> tempList = new ArrayList<Object>();
		for(int i = 0; i < daytour.size(); i++) {	
			if(daytour.get(i).getPrice() > 0) {
				tempList.add(daytour.get(i).getName());
				tempList.add(daytour.get(i).getPrice());
			}	
		}
		
		System.out.println("Sorting DayTours by price: ");
		//I know I know, Bubble Sort is Expensive....Works for now :)
		// 0 1  2 3  4 5  6 7  8 9
		// a 3, b 7, c 2, d 1, e 2
		
		System.out.println("___________________");
		for(int i = 0; i<tempList.size()/2; i++ ) {
			for(int j = 1; j<tempList.size()-1; j+=2 ) {
				int p = (int) tempList.get(j);
				int q = (int) tempList.get(j+2);
				if(p > q) {
					int temp = p;
					Object strTemp =  tempList.get(j-1);
					Object strTemp2 = tempList.get(j+1);
					
					//Swap the price in order
					tempList.set(j, q);
					tempList.set(j+2, temp);
					
					//Also, swap the string name associated with the right price 
					tempList.set(j-1,strTemp2);
					tempList.set(j+1,strTemp);
				}
			}	
		}
		
		for(int i = 0; i<tempList.size()-1; i+=2 ) {
			System.out.print(tempList.get(i) + ": " + tempList.get(i+1) + " Krónur");
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Other Daytours have not listed a price yet");
		System.out.println();
	}
}


