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
    //Judge if it's login
    public boolean is_log_in() {
        if (loginStates == logingSatus.LGOING)
            return true;
        return false;
    }
/******************************  再次输入密码以确认   ***********************************/
    //Confirm passWord
    public void confirmPasword() {
        System.out.printf("Please Input your password to confirm :\n password:");
        String pWord = input.nextLine();
        if (pWord.compareTo(passengerPassword) == 0) {
            System.out.printf("Success !");
        }
    }
/******************************* 乘客功能 ： 查询航班   **********************************/
    // queryFlight
    public void queryFlight() {
        if (is_log_in()) {
            System.out.printf("Do you want to check by detailed information or by flightID?" +
                    "(Input \"1\" for check by detailed information and \"2\" for check by flightID)" +"Input \"3\" to check "
                    +"the whole order list"+"\nInput:");
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
                    System.out.printf("Please Input the flightID \n Flight Id:");
                    String fID = input.nextLine();
                    for (Flight everyFlight : DataBase.flight_list) {
                        if (everyFlight.flightID == fID) {
                            System.out.printf("The flight you are looking for is" + everyFlight.flightID + "; the Price is " + everyFlight.price + "; the flight Sate is" + everyFlight.flightStatus);
                            System.out.printf("Input 'Y' to book it, and Input 'N' to continue your check");
                            String choice = input.nextLine();
                            if (choice.compareTo("Y") == 0) {
                                confirmPasword();
                                /**************** add an order **************/
                                System.out.printf("Book Success!");
                            }else{
                                continue;
                            }
                        }
            }
            break;
                case 3:
                    for(Order order: DataBase.order_list){
                        order.order_disp();
                    }
            }
       }else
            DataBase.passengerLogIn();
    //end register and methods involved
    }
}
