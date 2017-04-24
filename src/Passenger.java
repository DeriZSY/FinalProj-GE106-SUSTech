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
//

    //register and methods in register
//    public void register() {
//        //input passengerID
//        System.out.print("Enter your ID used for Log in");
//        passengerID = input.nextLine();
//        //input password , confirm twice
//        System.out.print("Enter your password please");
//        String password1 = input.nextLine();
//        System.out.print("Enter your password again please");
//        String password2 = input.nextLine();
//        while (decidePassword(password1, password2) == false) {
//            System.out.print("Different password,please try again");
//            System.out.print("Enter your password please");
//            password1 = input.nextLine();
//            System.out.print("Enter your password again please");
//            password2 = input.nextLine();
//        }
//        System.out.println("You have succeeded in setting your password");
//        passengerPassword = password1;
//        // input passenger's status
//        System.out.println("Willing to become a VIP? (100$ per year)");
//        System.out.println("Type 1 for yes, Type 2 for no");
//        int decide = input.nextInt();
//        switch (decide) {
//            case 1:
//                passengerStatus = passengerStat.VIP;
//                break;
//            case 2:
//                passengerStatus = passengerStat.nonVIP;
//                break;
//
//        }
//        ////// ??????? VIP ?????/////
//        /****not yet finished ****/
//    }
//
//    //decidePassword is used in register for determining the 2 passwords are the same or not
//    public boolean decidePassword(String passwordA, String passwordB) {
//        boolean a = false;
//        if (passwordA == passwordB) {
//            a = true;
//        }
//        return a;
//    }

    //Log in
//    public void passengerLogIn() {
//        while (true) {
//            System.out.printf("Please Input your User Name: \n username:");
//            String uName = input.nextLine();
//            System.out.printf("Pelase Input your Pass Word:\n password:");
//            String pword = input.nextLine();
//            if (uName.compareTo(passengerID) == 0 || pword.compareTo(passengerPassword) == 0) {
//                System.out.printf("Log In Success !");
//                loginStates = logingSatus.LGOING;
//                break;
//            } else {
//                System.out.printf("Log In Error.(Input \"1\" for try again and \"2\" for go to register");
//                int choice = input.nextInt();
//                if(choice == 1)
//                    continue;
//                else
//                    register();
//                }
//            }
//        }

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
