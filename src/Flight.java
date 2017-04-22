import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Flight {
    /************ Variables ********/
    public String flightID;
    public Date departureTime;
    public Date arrivalTime;
    public String startCity;
    public String stopByCity;
    public String arrivalCity;
    public String airlineCompany;
    public String planeType;
    //enum
    enum flightStatusENU{UNPUBLISHED, AVAILABLE, FULL, TERMINATE};
    enum flightExistting{EXIST, DELETED}
    flightStatusENU flightStatus = flightStatusENU.UNPUBLISHED;
    flightExistting flightEx = flightExistting.DELETED;
    //ArrayList for information of the plane
    private ArrayList<String> all_Passenger_Names = new ArrayList<String>();
    private ArrayList<String> all_Passenger_IDs = new ArrayList<String>();

    // ArrayLIst used for superQuery

//    public static ArrayList<String> flightStates = new ArrayList<String>();
//    public static ArrayList<String> allNames = new ArrayList<String>();
//    public static ArrayList<String> allIDs = new ArrayList<String>();

    public int price;
    /*********** Method ***********/

    //Constructor
    public  Flight(String fliID, Date dptTime, Date arrivTime, String stCity,
                  String stpCity, String arrivCity, String alCompany, String plType){
        flightID = fliID;
        departureTime = dptTime;
        arrivalTime = arrivTime;
        startCity = stCity;
        stopByCity = stpCity;
        arrivalCity = arrivCity;
        airlineCompany = alCompany;
        flightEx = flightExistting.EXIST;
        planeType = plType;


        //Add inform to ArrayList
        Main.flightIDs.add(fliID);
        Main.startCitys.add(stCity);
        Main.arrivalCitys.add(arrivCity);
    }
    public Flight(String fliID, Date dptTime, Date arrivTime,
                  String stCity,String arrivCity, String alCompany, String plType){
        flightID = fliID;
        departureTime = dptTime;
        arrivalTime = arrivTime;
        startCity = stCity;
        arrivalCity = arrivCity;
        airlineCompany = alCompany;
        flightEx = flightExistting.EXIST;
        planeType = plType;
    }



    /********* For Other's Usage **************/


    //display the information of a plane;


    /*
    public void dispinform() {
        System.out.printf("Flight ID: %s\nAirline Company:%s\nDeparture Time:%s\nArrival Time:%s\nStarting City:%s\nArrival City:%s\nStop By City:%s\n Plane Type:%s\n",
                flightID, airlineCompany, departureTime, arrivalTime, startCity, arrivalCity, stopByCity, planeType);
        System.out.printf("The Names of passengers of the plane is :");
//        for (String pasName : all_Passenger_Names) {
//            System.out.println(pasName);
//        }
//        System.out.printf("The IDs of passengers of the plane is :");
//
//        for (String IDs : all_Passenger_IDs) {
//            System.out.println(IDs);
        System.out.printf("Name\tID\t");
        for(int i=0; i < all_Passenger_Names.size(); i++)
            System.out.printf("%s\t%s\n",all_Passenger_Names.get(i), all_Passenger_IDs.get(i));

    }
*/

    /***********  For Admin's Usage **********/
    //For administer to reset inform;
    public void set_Flight(String fliID, Date dptTime, Date arrivTime, String stCity, String stpCity, String arrivCity, String alCompany){
        if(flightEx == flightExistting.EXIST) {
            flightID = fliID;
            departureTime = dptTime;
            arrivalTime = arrivTime;
            startCity = stCity;
            stopByCity = stpCity;
            arrivalCity = arrivCity;
            airlineCompany = alCompany;
        }
        else
            System.out.printf("The flight has been deleted");
    }

    //for admin to create the Flight
//    public static void createFlight(String fliID, Date dptTime, Date arrivTime, String stCity,
//                                    String stpCity, String arrivCity, String alCompany, String plType) {
//        if (Admin.admstatus == Admin.adminStatus.LGOIN) {
//            /**************** Undone ***************/
//            Flight(String fliID; Date dptTime, Date arrivTime,
//                    String stCity,String arrivCity, String alCompany, String plType);
//
//
//        } else {
//            System.out.printf("You have not log in, please log in first.");
//            Admin.adminLogin();
//        }
//    }

    //for admin to create the Flight
    public void deleteFlight(){
        if(Admin.admstatus == Admin.adminStatus.LGOIN){
            Scanner input = new Scanner(System.in);
            System.out.printf("Are you sure to delete this flight?(input \"Y\" for yes and \"N\" for No)");
            String choice = input.nextLine();
            if(choice.compareTo("Y")==0)
                flightEx = flightExistting.DELETED;
            else
                System.out.printf("Deleting canceled.");
        }else{
            System.out.printf("You have not log in, please log in first.");
            Admin.adminLogin();
        }
    }
}

