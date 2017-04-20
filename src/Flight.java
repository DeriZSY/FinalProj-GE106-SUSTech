import java.util.Date;
import java.util.Scanner;
public class Flight {
    public String flightID;
    public Date departureTime;
    public Date arrivalTime;
    public String startCity;
    public String stopByCity;
    public String arrivalCity;
    public String airlineCompany;
    public String planeType;
    enum flightStatusENU{UNPUBLISHED, AVAILABLE, FULL, TERMINATE};
    enum flightExistting{EXIST, DELETED}
    flightStatusENU flightStatus = flightStatusENU.UNPUBLISHED;
    flightExistting flightEx = flightExistting.DELETED;

    public int price;

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
    public void dispinform(){
        System.out.printf("Flight ID: %s\nAirline Company:%s\nDeparture Time:%s\nArrival Time:%s\nStarting City:%s\nArrival City:%s\nStop By City:%s\n Plane Type:%s\n",
                flightID,airlineCompany,departureTime,arrivalTime,startCity,arrivalCity,stopByCity,planeType);
    }

    public void createFlight() {
        if (Admin.admstatus == Admin.adminStatus.LGOIN) {
            /**************** Undone ***************/
        } else {
            System.out.printf("You have not log in, please log in first.");
            Admin.adminLogin();
        }
    }
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

