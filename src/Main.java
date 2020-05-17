import java.util.Scanner;

public class Main {

	//Daytour search service, add and search for daytours
	public static void main(String[] args) {
		TourService tour = new TourService("DayTour");
		createDummyData(tour);
		systemService(tour);
	}
	
	private static void systemService(TourService tour ){
		
		Scanner scan = new Scanner(System.in);
		boolean isTrue = true;
		while(isTrue) {
			System.out.println("----------------");
			printOptions();
			System.out.println("----------------");
			
			int n = scan.nextInt();
			
			switch(n){	
				case 1:  n = 1;
					printOptions();
					break;
				case 2:  n=2;
					tourSearch(tour);
            		break;
				case 3:  n=3;
					addTour(tour);
					break;
				case 4:  n=4;
					listAllTours(tour);
					break;
				case 5:  n=5;
					sortAllTours(tour);
					break;
				case 6:  n=6;
					addCustomer(tour);
					break;
				case 7:  n=7;
					addTourPrice(tour);
					break;
				case 8:  n=8;
					isTrue = false;
					System.out.println("Quitting service");
					break;
			}
		}
	}
	
	private static void addTourPrice(TourService tour) {
		// TODO Auto-generated method stub
		System.out.println("Type the name of the tour to set a price for");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		System.out.println("Type the new price for the tour");
		int price = scan.nextInt();
		if(price > 0 && name != "") {
			tour.addChangeTourPrice(name, price);
		}
	}

	private static void addCustomer(TourService tour) {
		System.out.println("Type the name of the tour You wish to book:");
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		if(!str1.equals("")  && !str1.equals(null)) {
			System.out.println("Type the name of the customer to add:");
			String str2 = scan.nextLine();
			if(!str2.equals("")  && !str2.equals(null)) {
				tour.addCustomer(str1,str2);
			}
		}
	}

	private static void printOptions() {
		System.out.println("Type 1 for options");
		System.out.println("Type 2 to search for a tour");
		System.out.println("Type 3 to add a tour");
		System.out.println("Type 4 to see a list all avalable tours");
		System.out.println("Type 5 to sort all tours by price");
		
		System.out.println("Type 6 to add a customer to a DayTour");
		System.out.println("Type 7 to add a new price fo a DayTour");
		System.out.println("Type 8 to quit");
	}
	
	private static void tourSearch(TourService tour) {
		System.out.println("Type the name of the tour you want informations about");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		tour.getTourInfo(str);
	}

	private static void addTour(TourService tour) {
		System.out.println("Type the name of the tour you want to add");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Type the name of the Daytour:");
		
		String name = scan.nextLine();
		
		System.out.println("Type the number of seats for the Daytour:");
		int num = scan.nextInt();

		scan.nextLine();
		System.out.println("Type the name of the guide:");
		String guide = scan.nextLine();

		System.out.println("Type the time/duration of the Daytour:");
		int time = scan.nextInt();
		
		System.out.println("Type the price in isk for the Daytour:");
		int price = scan.nextInt();

		tour.addTour(name,num,guide,time,price);
	}

	private static void listAllTours(TourService tour) {
		tour.getDayTour();
	}
	
	private static void sortAllTours(TourService tour) {
		tour.sortByPrice();
	}
	
	private static void createDummyData(TourService tour) {
		
		tour.addTour("Diving", 15, 30000);
		tour.addTour("SkyDiving");
		
		tour.addTour("Gullfoss");
		tour.addCustomer("Gullfoss","Sindri");
		tour.addCustomer("Gullfoss","Joe");
		tour.addCustomer("Gullfoss","Jimmy");
		tour.addCustomer("Gullfoss","Anonymous");
		
		tour.addTour("DeepDiving", 20);
		tour.addTour("Hang Gliding", 1,"Sindri",2,35000);
		tour.addCustomer("Hang Gliding","Crazy guy");
		
		//tour.getTourMaxGoers("DeepDiving");
		//tour.getTourMaxGoers("Hang Gliding");
		//tour.getDayTour();
		
		tour.addTour("Glacial walk");
		tour.addTour("Paddleboarding");
		tour.addTour("Cycling In HFJ", 20,"Sindri",3,5000);
		tour.addTour("Running In HFJ", 30,"Sindri",1,5000);
		tour.addTour("Þyngvellir Cycling", 20,"Sindri",3,20000);
	
	}
}
