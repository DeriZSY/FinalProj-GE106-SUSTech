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
    public Plane plane;//  不区分plane 与planetype,将Plane的对象的名字作为planetype
    //enum
    public enum flightStatusENU{UNPUBLISHED, AVAILABLE, FULL, TERMINATE};
    public enum flightExistting{EXIST, DELETED}
    flightStatusENU flightStatus = flightStatusENU.UNPUBLISHED;
    flightExistting flightEx = flightExistting.DELETED;
    //ArrayList for information of the plane
    private ArrayList<Passenger> all_Passenger = new ArrayList<Passenger>();
    
    /*************get method***************/


    public String price;
    /*********** Method ***********/

    //Constructor
    public  Flight(String fliID, String dptTime,String fliDate, String arrivTime, String stCity,
                  String stpCity, String arrivCity, String alCompany,String pri, Plane plType){
        flightID = fliID;
        departureTime = dptTime;
        arrivalTime = arrivTime;
        flightDate = fliDate;
        startCity = stCity;
        stopByCity = stpCity;
        arrivalCity = arrivCity;
        airlineCompany = alCompany;
        flightEx = flightExistting.EXIST;
        price = pri;
        plane = plType;

    }
    public Flight(String fliID, String dptTime,String fliDate, String arrivTime,
                  String stCity,String arrivCity, String alCompany,String pri, Plane plType){
        flightID = fliID;
        departureTime = dptTime;
        flightDate = fliDate;
        arrivalTime = arrivTime;
        startCity = stCity;
        arrivalCity = arrivCity;
        airlineCompany = alCompany;
        flightEx = flightExistting.EXIST;
        price = pri;
        plane = plType;
    }



    /********* For Other's Usage **************/
/************************  显示乘坐次航班的所有乘客 的名字和ID ******************************/
    public void dis_full_inform(){
        System.out.printf("The list of passengers:");
        System.out.printf("Name\t\tID\t\tBook Time\t\tOrder Status");
        for(Passenger pasger:all_Passenger){
            System.out.printf("%s\t%s",pasger.realName,pasger.realID);
        }

    }


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
