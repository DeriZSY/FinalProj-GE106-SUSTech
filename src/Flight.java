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
    public int remainingSeat;
    public ArrayList<Integer> seatNumList =  new ArrayList<Integer>() ;
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
        remainingSeat = seatCap;

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
    /***** 辅助功能： 时间处理 *****/
    private int time_modification(String origin_time)
    {
        int tot_time = 0;
        int tot_hour = 0;
        int tot_minute = 0;
        for(int i = 0; i< origin_time.length(); i++){
            char k = origin_time.charAt(i);
            String k2 = String.valueOf(k);
            if(k2.compareTo("0") != 0 ){
                if(i != 2){
                    int num = Integer.parseInt(k2);
                    switch (i) {
                        case 0 :
                            tot_hour += num * 10;
                            break;
                        case 1:
                            tot_hour += num;
                            break;
                        case 3:
                            tot_minute += num * 10;
                            break;
                        case 4:
                            tot_minute += num;
                            break;
                    }
                }
            }
        }
        tot_time = tot_hour * 60 + tot_minute;
        return tot_time;
    }

    /***** 检测并修改状态（单个航班） *****/
    public void check_and_change(){
        int termin_time1 = time_modification(departureTime) - 120;
        int present_time1  = time_modification(DataBase.present_time);
       
        int YearP=DataBase. present_date.charAt(0)*1000+DataBase.present_date.charAt(1)*100+DataBase.present_date.charAt(2)*10+DataBase.present_date.charAt(3);
        int mouthP=DataBase.present_date.charAt(5)*10+DataBase.present_date.charAt(6);
        int DayP=DataBase.present_date.charAt(8)*10+DataBase.present_date.charAt(9);
        int YearT=flightDate.charAt(0)*1000+flightDate.charAt(1)*100+flightDate.charAt(2)*10+flightDate.charAt(3);
        int mouthT=flightDate.charAt(5)*10+flightDate.charAt(6);
        int DayT=flightDate.charAt(8)*10+flightDate.charAt(9);
        if (YearT>YearP){
        	flightStatus = flightStatusENU.TERMINATE;}
        	else if (mouthT>mouthP){
        		flightStatus = flightStatusENU.TERMINATE;}
        		else if (DayT>DayP){
        			flightStatus = flightStatusENU.TERMINATE;}
        			else if (termin_time1 >= present_time1 && flightDate.compareTo(DataBase.present_date) == 0){
            flightStatus = flightStatusENU.TERMINATE;}
        if(remainingSeat == 0){
            flightStatus = flightStatusENU.FULL;
        }
    }

    public  void disp_flight_inform(){
        System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t\t%s\t\t\t%s\n",flightID, flightStatus, flightEx,
                startCity, arrivalCity, flightDate);
    }

}

  