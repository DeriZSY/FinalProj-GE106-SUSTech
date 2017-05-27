import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Main {
    /************ Variables ********/
    public static void main(String[] args) {
        Admin d1 = new Admin("deri","zhang");
        DataBase.admin_list.add(d1);
        Admin.create_newAdmin();//只需要运行一次
        //Login
        // Initialize Flights 
        
        Flight a1= new Flight("ZG0001", "12:00", "2017-06-02", "18.22","NewYork",
                "Beijing ","Moscow", "UA", "$230", DataBase.Mig_MniJet);
        Flight a2 = new Flight("ZG0002", "14:00", "2017-06-02", "22:22","Shenzhen",
                "Moscow ", "Xi'an", "Airplot", "$300",DataBase.Airbus251);
        Flight a3 = new Flight("ZG0003", "11:00", "2017-06-02", "23:22","HongKong",
                "Xi'an ", "Beijing", "South Airline", "$100", DataBase.Airbus251);
       
        Flight b1 = new Flight("CA0004", "11:00", "2017-06-02", "18:22", 
                "Moscow ", "Beijing", "NewYork","UA","$100", DataBase.Mig_MniJet);
        Flight b2 = new Flight("CA0010", "11:00", "2017-06-02", "22:22", "Xi'an"
        		,"Moscow ", "Shenzhen","Airplot", "$100", DataBase.Airbus251);
        Flight b3 = new Flight("ZG0025", "11:00", "2017-06-02", "17:22", "Beijing",
        		"Xi'an", "HongKong", "South Airline", "$100", DataBase.Airbus251);
        
        Flight c1 = new Flight("ZG0013", "11:00", "2017-06-03", "18:22", "NewYork",
                "Beijing ", "Moscow", "UA", "$100", DataBase.Mig_MniJet);
        Flight c2 = new Flight("ZG0022", "11:00", "2017-06-03", "22:22","Shenzhen",
                "Moscow ", "Xi'an", "Airplot", "$100", DataBase.Airbus251);
        Flight c3 = new Flight("ZG0034", "11:00", "2017-06-03", "23:22","HongKong",
                "Xi'an ", "Beijing", "South Airline", "$100", DataBase.Airbus251);
        
        Flight e1 = new Flight("ZG0012", "11:00", "2017-06-03", "18:22","NewYork",
                "Moscow ", "Beijing", "UA", "$100", DataBase.Mig_MniJet);
        Flight e2 = new Flight("ZG0021", "11:00", "2017-06-03", "22:22", "Xi'an"
        		,"Moscow ", "Shenzhen", "Airplot", "$100", DataBase.Airbus251);
        Flight e3 = new Flight("ZG0032", "11:00", "2017-06-03", "17:22", "Beijing",
        		"Xi'an", "HongKong", "South Airline", "$100", DataBase.Airbus251);
        
        Flight f1 = new Flight("ZG0035", "11:00", "2017-06-04", "18:22","NewYork",
                "Beijing ", "Moscow", "UA", "$100", DataBase.Mig_MniJet);
        Flight f2 = new Flight("ZG0056", "11:00", "2017-06-04", "22:22","Shenzhen",
                "Moscow ", "St.Petersburg", "Airplot", "$100", DataBase.Airbus251);
        Flight f3 = new Flight("ZG0027", "11:00", "2017-06-04", "23:22", "HongKong",
                "Xi'an ", "Beijing", "South Airline", "$100", DataBase.Airbus251);
        
        Flight g1 = new Flight("UA0021", "11:00", "2017-06-04", "19:22","NewYork",
                "Beijing ", "Moscow", "UA", "$100", DataBase.Mig_MniJet);
        Flight g2 = new Flight("CA0836", "11:00", "2017-06-04", "22:22","Xi'an"
        		,"Moscow ", "Shenzhen","Airplot", "$100", DataBase.Airbus251);
        Flight g3 = new Flight("MI0123", "11:00", "2017-06-04", "17:22","Beijing",
        		"Xi'an", "HongKong", "South Airline", "$100", DataBase.Airbus251);
        DataBase.flight_list.add(a1);
        DataBase.flight_list.add(a2);
        DataBase.flight_list.add(a3);
        
        DataBase.flight_list.add(b1);
        DataBase.flight_list.add(b2);
        DataBase.flight_list.add(b3);
        
        
        DataBase.flight_list.add(c1);
        DataBase.flight_list.add(c2);
        DataBase.flight_list.add(c3);
        
        DataBase.flight_list.add(e1);
        DataBase.flight_list.add(e2);
        DataBase.flight_list.add(e3);
       
        
        DataBase.flight_list.add(f1);
        DataBase.flight_list.add(f2);
        DataBase.flight_list.add(f3);
        
        DataBase.flight_list.add(g1);
        DataBase.flight_list.add(g2);
        DataBase.flight_list.add(g3);
        Scanner input = new Scanner(System.in);
        boolean system_On = true;  //这个没有用啊

        DataBase.present_date = "2017-03-22";
        DataBase.present_time = "10:00";

        while (true) {
            //系统开启
            while (system_On) {
                System.out.printf("Welcome to the Ticket System\n");  
                //选择登录模式（乘客／管理员）
                System.out.printf("Input \"admin\" to login as administer, and \"passenger \" to login as passenger\n\t\t");
                String status = input.nextLine();

                //管理员模式
                if (status.compareTo("admin") == 0) {
                    //进入登录
                    Graphing.sepreate__Line_sharp_50();
                    DataBase.adminLogin();
                    System.out.println();
                    Graphing.sepreate__Line_underLine_50();
                    System.out.printf("\nFunction Menu\n");
                    boolean admin_moode_on = true;
                    //进入管理员功能
                    while (admin_moode_on) {
                        String origin_function = ";create new Administer;Modify Information of a Existing Administer;Create a new flight;delete flight;SuperQuery;Renew Flight inform and display;Modify Existing Flight;Log Out;";
                        String[] function_array = origin_function.split(";");
                        System.out.printf("#1 Create A New Administer\n#2 Modify Information of a Existing Administer\n#3 Create A New Flight\n#4 Delete A Flight\n#5 SuperQuery\n"
                                + "#6 Renew Flight inform and display\n#7 Log Out\n");
                        Graphing.sepreate__Line_sharp_50();
                        System.out.printf("Please input the number for function\nFunction Number:>>");
                        int chocieNum = input.nextInt();
                        input.nextLine();
                        System.out.println();
                        if( chocieNum <= 6) {                     
                            switch (chocieNum) {
                                case 1:
                                    Admin.create_newAdmin();
                                    continue;
                                case 2:
                                    Admin.modifyPersonalInform();
                                    continue;
                                case 3:
                                	Admin.flightAutoCheck();
                                    Admin.createFlight();
                                    continue;
                                case 4:
                                	Admin.flightAutoCheck();
                                    Admin.deleteFlight();
                                    continue;
                                case 5:
                                	 Admin.flightAutoCheck();
                                  Admin.superQuery();
                                    continue;
                                case 6:
                                	Admin.flightAutoCheck();
                                    Admin.updateFlight();
                                    continue;
//                                case 7:
//                                    Admin.showAndReset();
//                                    continue;
                            }		//end Switch
                        }	
                           admin_moode_on = false;    

                    }//end Admin Function
                }//end Admin Mood

                // 乘客模式
                else if (status.compareTo("passenger") == 0) {
                    boolean passenger_mode_on = true;
                while (passenger_mode_on) {
                	 Graphing.sepreate__Line_underLine_50();
        	   System.out.printf("\nWelcome to the passenger System\n");
               //选择登录模式(注册/登陆）
        	   System.out.printf("what do you wnat to do?\n");
        	   String origin_function =";register;login;";
        	   String[] function_array = origin_function.split(";");
                    System.out.printf("#1 register\n#2 login\n");
                    Graphing.sepreate__Line_sharp_50();
                   System.out.printf("please enter the number>>");
                   int choice = input.nextInt();
                  System.out.println();
                   if( choice <= 2) {
                     
                     switch(choice){
                     case 1:
                    	 Graphing.sepreate__Line_underLine_50();
                    	 DataBase.register();
                    	 System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    	 Graphing.sepreate__Line_underLine_50();
                    	 continue;
                     case 2:
                    	 Graphing.sepreate__Line_underLine_50();
                    	 DataBase.passengerLogIn();
                    	 Graphing.sepreate__Line_underLine_50();
                    	 System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                 
                   System.out.printf("Now, you are logging in !\n");
                   //循环
                   boolean is_true1 = true; 
                   while(is_true1){
                   Graphing.sepreate__Line_underLine_50();
                   System.out.printf("Which function would you like to choose\n");
                   String origin_function1 = ";reserve a flight;unsubscribe a flight;check out the flight's information;";
                    String[] function_array1 = origin_function1.split(";");
                    System.out.printf("#1 reserve a flight\n#2 unsubscribe a flight\n#3 flight's information\n#4 Log Out\n");
                    Graphing.sepreate__Line_sharp_50();
                    System.out.printf("Please input the number for function\n");
                    int chocieNum = input.nextInt();
                    System.out.println();
                   if (chocieNum <= 3){
                    switch (chocieNum) {
                        case 1:
                        	Admin.flightAutoCheck();
                           Passenger.reserveFlight();
                            continue;
                        case 2:
                        	Admin.flightAutoCheck();
                           Passenger.unsubscribedFlight();
                            continue;
                        case 3:
                        	Admin.flightAutoCheck();
                            Passenger.queryFlight();
                            continue;
                    }//end Switch
                   }else
                   	is_true1 = false;
                   }//end while 跳出选择功能的循环
                    	passenger_mode_on  = false;
                       }
                   } 

               
           }// end passenger mode;
           
       }//end system
            }
        }
    }}



