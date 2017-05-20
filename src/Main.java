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
        
        /*    一下的内容都可在line 12的createflight中完成
        Flight a1 = new Flight("ZG001", "12:00", "2017-03-22", "13:22", "NewYork",
                "Beijing ", "Moscow", "UA", "$230", DataBase.Mig_MniJet);
        Flight a2 = new Flight("ZG002", "14:00", "2017-03-23", "15:22", "Shenzhen",
                "Moscow ", "St.Petersburg", "Airplot", "$300",DataBase.Airbus251);
        Flight a3 = new Flight("ZG003", "11:00", "2017-04-12", "17:22", "HongKong",
                "null ", "Beijing", "South Airline", "$100", DataBase.Airbus251);
        DataBase.flight_list.add(a1);
        DataBase.flight_list.add(a2);
        DataBase.flight_list.add(a3);     */
        Scanner input = new Scanner(System.in);
        boolean system_On = true;

        DataBase.present_date = "2017-03-22";
        DataBase.present_time = "10:00";

        while (true) {
            //系统开启
            while (system_On) {
                System.out.printf("Welcome to the Ticket System\n");
                //选择登录模式（乘客／管理员）
                System.out.printf("Input \"admin\" to login as administer, and \"passenger \" to login as passenger\n");
                String status = input.nextLine();
                if (status.compareTo("admin") == 0) {
                    //管理员模式
                    Graphing.sepreate__Line_sharp_50();
                DataBase.adminLogin();
                    System.out.println();
                    Graphing.sepreate__Line_underLine_50();
                    System.out.printf("\nFunction Menu\n");
                    boolean admin_moode_on = true;

                    while (admin_moode_on) {
                        String origin_function = ";create new Administer;Modify Information of a Existing Administer;Create a new flight;delete flight;SuperQuery;Renew Flight inform and display;Modify Existing Flight;Log Out;";
                        String[] function_array = origin_function.split(";");
                        System.out.printf("#1 Create A New Administer\n#2 Modify Information of a Existing Administer\n#3 Create A New Flight\n#4 Delete A Flight\n#5 SuperQuery\n"
                                + "#6 Renew Flight inform and display\n#7 Log Out\n");
                        Graphing.sepreate__Line_sharp_50();
                        System.out.printf("Please input the number for function\nFunction Number:>>");
                        int chocieNum = input.nextInt();
                        System.out.println();
                        if( chocieNum < 6) {
                            System.out.printf("The function you are going to enter is %s, are you Sure? ", function_array[chocieNum]);
                            System.out.printf("Input \"Y\" for YES and \"N\" for NO \nConfirm:>>");
                            String confirm = input.nextLine();
//                            input.nextLine();
                            if (confirm.compareTo("N") == 0)
                                continue;
                            switch (chocieNum) {
                                case 1:
                                    Admin.create_newAdmin();
                                    continue;
                                case 2:
                                    Admin.modifyPersonalInform();
                                    continue;
                                case 3:
                                    Admin.createFlight();
                                    continue;
                                case 4:
                                    Admin.deleteFlight();
                                    continue;
                                case 5:
                                    Admin.superQuery();
                                    continue;
                                case 6:
                                    Admin.updateFlight();
                                    continue;
                           //     case 7:
                          //          Admin.showAndReset();
                           //         continue;
                            }//end Switch
                        }
                           admin_moode_on = false;    

                    }//end Admin Function
                }//end Admin Mood
           else if (status.compareTo("passenger") == 0) {
//                //乘客模式
    /*         boolean passenger_mode_on = true;
                while (passenger_mode_on) {
                    System.out.printf("Do you need to register first? (input \"Y\" for Yes and \"N\" for No)");
                   String choice = input.nextLine();
                   if (choice.compareTo("Y") == 0) {
                      DataBase.register();
                    } else {
                      System.out.printf("Now, you are logging in !");
                       DataBase.passengerLogIn();
                    }
                   String origin_function = ";reserve a flight;unsubscribe a flight;check out the flight's information;";
                    String[] function_array = origin_function.split(";");
                    System.out.printf("#1 reserve a flight\n#2 unsubscribe a flight\n#3 check out the flight's information\n#4 Log Out\n");
                    Graphing.sepreate__Line_sharp_50();
                    System.out.printf("Please input the number for function\n");
                    int chocieNum = input.nextInt();
                    System.out.println();
                    System.out.printf("The function you are going to enter is %s, are you Sure? ", function_array[chocieNum]);
                    System.out.printf("Input \"Y\" for YES and \"N\" for NO ");
                    String confirm = input.next();

                    if (confirm.compareTo("N") == 0)
                        continue;
                    switch (chocieNum) {
                        case 1:
                           Passenger.reserveFlight();
                            continue;
                        case 2:
                           Passenger.unsubscribedFlight();
                            continue;
                        case 3:
                            Passenger.queryFlight();
                            continue;
                    }//end Switch
                    System.out.printf("Are you sure to Log Out?");
                    System.out.printf("Input \"Y\" for YES and \"N\" for NO ");
                    String confirm_out = input.nextLine();
                    if (confirm_out.compareTo("Y") == 0)
                    	passenger_mode_on  = false;
                   

               } */
           }// end passenger mode;
       }//end system
            }
        }
    }



