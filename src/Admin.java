import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Admin {
    //Variable for Admin
    public static  String adminUserName;
    public static  String adminPassWord;
//    //Constructor
    public Admin(String usrName, String psWord) {
        adminUserName = usrName;
        adminPassWord = psWord;
    }
       enum adminStatus {
        LGOIN, UNLOG
    }

    private adminStatus admstatus = adminStatus.UNLOG ;
//    public static int xx1= 2;


    //adminLogin
    public void adminLogin() {
        Scanner input = new Scanner(System.in);
        while (true) {
            //input username
            System.out.printf("Please input your user name:\nuserName: ");
            String usrName = input.nextLine();
            //input password
            System.out.printf("Please input your password:\npassword: ");
            String psWord = input.nextLine();
            if (adminUserName.compareTo(usrName) == 0 || adminPassWord.compareTo(psWord) == 0) {
                admstatus = adminStatus.LGOIN;
                System.out.printf("Login Success");
                break;
            } else {
                System.out.printf("Login Failed, Please try again!");
            }
        }
    }

    //Judge if it's Log in
    public boolean is_log_in(){
        if( admstatus == adminStatus.LGOIN)
            return true;
        return false;
    }

    //Create Flight
    public static void createFlight(String fliID, String dptTime,String fliDate, String arrivTime, String stCity,
                                        String stpCity, String arrivCity, String alCompany, String plType ){
        Flight newFlight = new Flight(fliID, dptTime,fliDate, arrivTime, stCity, stpCity, arrivCity, alCompany, plType);
        DataBase.flight_list.add(newFlight);

    }



    //superQuery
    public void superQuery() {
        Scanner input = new Scanner(System.in);
        if (is_log_in()) {
            if (is_log_in()) {
                System.out.printf("Do you want to check flightID or OrderID or do normal query ?" +
                        "(Input \"1\" for check by flightID and \"2\" for check by OrderId )"+
                        "\"3\" for normal query "+"\nInput:");
            int factor = input.nextInt();
            // 3 cases of superQuery
            switch (factor) {
                case 1:
                    System.out.printf("Please Input the flightID \n Flight Id:");
                    String fID = input.nextLine();
                    for (Flight everyFlight : DataBase.flight_list) {
                        if (everyFlight.flightID == fID) {
                            System.out.printf("Input 'Y' to book it, and Input 'N' to continue your check");
                            String choice = input.nextLine();
                            if (choice.compareTo("Y") == 0) {
                                everyFlight.dis_full_inform();
                            }
                        } else {
                            continue;
                        }
                    }break;
                case 2:

                case 3:
                    queryFlight();
            }
            }
        }else{
                System.out.printf("You have not log in, please log in first.");
                adminLogin();
            }

        }

public void queryFlight() {
    Scanner input = new Scanner(System.in);
        if (is_log_in()) {
            System.out.printf("Do you want to check by detailed information or by flightID?" +
                    "(Input \"1\" for check by detailed information and \"2\" for check by flightID)"+"\nInput:");
            int choic = input.nextInt();
            switch (choic) {
                case 1:
                    System.out.printf("What's your choice for departure city\n City name:");
                    String dpCity = input.nextLine();
                    System.out.printf("What's your choice for arriving city\n City name:");
                    String arvCity = input.nextLine();
                    System.out.printf("What's your idea starting date ?(Input in the form of yyyy-MM-dd,for example: 2016-04-22)\n: Date:");
                    String startDate = input.nextLine();
                    for (Flight everyFlight : DataBase.flight_list) {
                        if (everyFlight.startCity == dpCity || everyFlight.arrivalCity == arvCity || everyFlight.flightDate == startDate) {
                            System.out.printf("The flight you are looking for is" + everyFlight.flightID + "; the Price is " + everyFlight.price + "; the flight Sate is" + everyFlight.flightStatus);
                            System.out.printf("Input 'Y' to finish, and Input 'N' to continue your check");
                            String choice = input.nextLine();
                            if (choice.compareTo("Y") == 0) {
                                break;
                            }
                            } else {
                                continue;
                            }
                        }
                        break;
                case 2:
                    System.out.printf("Please Input the flightID \n Flight Id:");
                    String fID = input.nextLine();
                    for (Flight everyFlight : DataBase.flight_list) {
                        if (everyFlight.flightID == fID) {
                            System.out.printf("The flight you are looking for is" + everyFlight.flightID + "; the Price is " + everyFlight.price + "; the flight Sate is" + everyFlight.flightStatus);
                            System.out.printf("Input 'Y' to book it, and Input 'N' to continue your check");
                            String choice = input.nextLine();
                            if (choice.compareTo("Y") == 0) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    break;

                    }
            }
       }
}




