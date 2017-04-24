import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Flight {
    /************ Variables ********/
    public String flightID;
    public String flightDate;
    public String departureTime;
    public String arrivalTime;
    public String startCity;
    public String stopByCity;
    public String arrivalCity;
    public String airlineCompany;
    public String planeType;
    //enum
    public enum flightStatusENU{UNPUBLISHED, AVAILABLE, FULL, TERMINATE};
    public enum flightExistting{EXIST, DELETED}
    flightStatusENU flightStatus = flightStatusENU.UNPUBLISHED;
    flightExistting flightEx = flightExistting.DELETED;
    //ArrayList for information of the plane
    private ArrayList<Passenger> all_Passenger = new ArrayList<Passenger>();



    public int price;
    /*********** Method ***********/

    //Constructor
    public  Flight(String fliID, String dptTime,String fliDate, String arrivTime, String stCity,
                  String stpCity, String arrivCity, String alCompany, String plType){
        flightID = fliID;
        departureTime = dptTime;
        arrivalTime = arrivTime;
        flightDate = fliDate;
        startCity = stCity;
        stopByCity = stpCity;
        arrivalCity = arrivCity;
        airlineCompany = alCompany;
        flightEx = flightExistting.EXIST;
        planeType = plType;

    }
    public Flight(String fliID, String dptTime,String fliDate, String arrivTime,
                  String stCity,String arrivCity, String alCompany, String plType){
        flightID = fliID;
        departureTime = dptTime;
        flightDate = fliDate;
        arrivalTime = arrivTime;
        startCity = stCity;
        arrivalCity = arrivCity;
        airlineCompany = alCompany;
        flightEx = flightExistting.EXIST;
        planeType = plType;
    }



    /********* For Other's Usage **************/
/************************  显示乘坐次航班的所有乘客 的名字和ID ******************************/
    public void dis_full_inform(){
        System.out.printf("The list of passengers:");
        System.out.printf("Name\tID\tBook Time\tOrder Status");
        for(Passenger pasger:all_Passenger){
            System.out.printf("%s\t%s",pasger.realName,pasger.realID);
        }

    }


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
    public void set_Flight(String fliID, String dptTime,String fliDate, String arrivTime, String stCity, String stpCity, String arrivCity, String alCompany){
        if(flightEx == flightExistting.EXIST) {
            flightID = fliID;
            departureTime = dptTime;
            flightDate = fliDate;
            arrivalTime = arrivTime;
            startCity = stCity;
            stopByCity = stpCity;
            arrivalCity = arrivCity;
            airlineCompany = alCompany;

        }
        else
            System.out.printf("The flight has been deleted");
    }



}
