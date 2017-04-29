import javax.xml.crypto.Data;
import java.util.Scanner;

public class Passenger {
    /****** variables ********/
    public String passengerID;//used for registration.
    public String passengerPassword;
    public String realName;
    public String realID;//passenger's own ID.
    public String orderList;

    public enum passengerStat {VIP, nonVIP}

    ;
    passengerStat passengerStatus = passengerStat.nonVIP;
    Scanner input = new Scanner(System.in);

    public enum logingSatus {LGOING, UNLOGIN}

    ;
    logingSatus loginStates = logingSatus.UNLOGIN;

    /***** methods *****/

    //constructor
	public Passenger (String name, String ID){
		realName = name;
		realID = ID;
	}


/****************************** 判断是否登陆  ***********************************/
//    //Judge if it's login
//    public boolean is_log_in() {
//        if (loginStates == logingSatus.LGOING)
//            return true;
//        return false;
//    }
/******************************  再次输入密码以确认   ***********************************/
    //Confirm passWord
    public static void confirmPasword() {

        Scanner input = new Scanner(System.in);
        System.out.printf("Please Input your password to confirm :\n password:");
        String pWord = input.nextLine();
        for(Passenger everypassenger : DataBase.passengers_lilst) {
            if (pWord.compareTo(everypassenger.passengerPassword) == 0) {
                System.out.printf("Success !");
            }
        }
    }
/******************************* 乘客功能 ： 查询航班   **********************************/
    // queryFlight
    public static void queryFlight() {
//        if (is_log_in()) {
        Scanner input = new Scanner(System.in);
            System.out.printf("Do you want to check by detailed information or by flightID?" +
                    "\n(Input \"1\" for check by detailed information and \"2\" for check by flightID, Input \"3\" to check "
                    +"the whole order list)"+"\nInput:");
            int choic = input.nextInt();
            input.nextLine();
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
                            System.out.printf("Input 'Y' to book it, and Input 'N' to continue your check");
                            String choice = input.nextLine();
                            if (choice.compareTo("Y") == 0) {
                                confirmPasword();
                                /**************** add an order **************/
                                System.out.printf("Book Success!");
                            } else {
                                continue;
                            }
                        }
                    }
                    break;
                case 2:

                    System.out.printf("Please Input the flightID\nFlight Id:");
                    String fID = input.nextLine();
//
                    char[] input_for_search = new char[fID.length()];
                    for (int i = 0; i < fID.length(); i++) {
                        input_for_search[i] = fID.charAt(i);
                    }


                    for (Flight everyFlight : DataBase.flight_list) {
                        int i = 0;
                        int j = 0;
                        boolean is_result = false;
                        while (j < everyFlight.flightID.length() && i < fID.length()) {
//                           System.out.printf("While running\n");
                            if (input_for_search[i] == everyFlight.flightID.charAt(j)) {
                                i++;
//                                System.out.printf("if running\n");
                            }
                            j++;
                            if (i == fID.length())
                                is_result = true;
                        }
                        if (is_result) {
                            System.out.printf("The flight you are looking for is " + everyFlight.flightID + "; the Price is " + everyFlight.price + "; the flight Sate is " + everyFlight.flightStatus);
                            System.out.println();
                            System.out.printf("Input 'Y' to book it, and Input 'N' to continue your check\n");
                            String choice = input.nextLine();
                            if (choice.compareTo("Y") == 0) {
                                System.out.printf("Input 'Y' to see  inform, and Input 'N' to continue your check\n");
                                String choice2 = input.nextLine();
                                if (choice2.compareTo("Y") == 0) {
                                    everyFlight.dis_full_inform();
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    System.out.printf("Check Over, all available results have been shown");
                    break;//case 1 break;
                case 3:
                    for(Order order: DataBase.order_list){
                        order.order_disp();
                    }
            }
//       }else
//            DataBase.passengerLogIn();
//    //end register and methods involved
    }
}
