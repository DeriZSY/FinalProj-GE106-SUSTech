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
    public String price;
    public int seatCap;
    //enum
    public enum flightStatusENU{UNPUBLISHED, AVAILABLE, FULL, TERMINATE};
    public enum flightExistting{EXIST, DELETED}
    flightStatusENU flightStatus = flightStatusENU.UNPUBLISHED;
    flightExistting flightEx = flightExistting.DELETED;
    //ArrayList for information of the plane
    private ArrayList<Passenger> all_Passenger = new ArrayList<Passenger>();


    /***** Constructor *****/
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
        seatCap = plType.seatCapacity;

    }
//    public Flight(String fliID, String dptTime,String fliDate, String arrivTime,
//                  String stCity,String arrivCity, String alCompany,String pri, Plane plType){
//        flightID = fliID;
//        departureTime = dptTime;
//        flightDate = fliDate;
//        arrivalTime = arrivTime;
//        startCity = stCity;
//        arrivalCity = arrivCity;
//        airlineCompany = alCompany;
//        flightEx = flightExistting.EXIST;
//        price = pri;
//        plane = plType;
//    }

    /***** 显示航班中所有乘客的信息 *****/
    public void dis_full_inform(){
        System.out.printf("The list of passengers:");
        System.out.printf("Name\t\tID\t\tBook Time\t\tOrder Status");
        for(Passenger pasger:all_Passenger){
            System.out.printf("%s\t%s",pasger.realName,pasger.realID);
        }

    }

    /***** 修改航班信息 *****/
//    public void set_Flight(){
////
////        }
////        else
////            System.out.printf("The flight has been deleted");
//    }



}
