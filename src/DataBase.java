import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by DeriZsy on 4/23/17.
 */
public class DataBase {

/************* 初始化数据   ******************/
    // Initialize Planes
    public static Plane Airbus251 = new Plane(100, 20, 80);
    public static Plane Mig_MniJet = new Plane(3, 1, 2);
    public static ArrayList<Flight> flight_list = new ArrayList<Flight>();
    public static ArrayList<Order> order_list = new ArrayList<Order>();
    public static ArrayList<Admin> admin_list = new ArrayList<Admin>();
    public static ArrayList<Passenger> passengers_lilst = new ArrayList<Passenger>();
    public static String present_time = "01:00";
    public static String present_date = "2017-01-01";

/************  Administer 登陆 *************/
    //Method
    public static void adminLogin() {
        Scanner input = new Scanner(System.in);
        boolean  is_ture = true;
        while (is_ture) {
            //input username
            System.out.printf("\nPlease input your user name:\nuserName: ");
            String usrName = input.next();
            //input password
            System.out.printf("Please input your password:\npassword: ");
            String psWord = input.next();
            for (Admin everyAdmin : admin_list) {
//                System.out.printf("on");
                if (everyAdmin.adminUserName.compareTo(usrName) == 0 ) {
//                    everyAdmin.admstatus = Admin.adminStatus.LGOIN;
                    if(everyAdmin.adminPassWord.compareTo(psWord) == 0) {
                        System.out.printf("Login Success! ");
                        System.out.printf("Welcome back to the system, %s!", everyAdmin.adminUserName);
                        is_ture = false;
                        break;
                    }
                }  
            }
            if(is_ture) {
                System.out.println("Login failed, pleas try again!");
            }
        }
    }

/*************** Passenger 登陆 *****************/
    public static void passengerLogIn() {
        boolean is_ture = true;
        while (is_ture) {
            Scanner input = new Scanner(System.in);
            System.out.printf("Please Input your User Name: \nusername:\t");
            String uName = input.nextLine();
            System.out.printf("Pelase Input your Pass Word:\npassword:\t");
            String pword = input.nextLine();
            for(Passenger everyPassenger : passengers_lilst) {
                if (uName.compareTo(everyPassenger.passengerID) == 0 && pword.compareTo(everyPassenger.passengerPassword) == 0) {
                    System.out.printf("Log In Success !\n");
                    everyPassenger.loginStates = Passenger.logingSatus.LGOING;
                    is_ture = false;
                    break;
                }} if(is_ture == true){
                    System.out.printf("Log In Error. Input \"1\" for try again and \"2\" for go to register   ");
                    int choice = input.nextInt();
                    if (choice == 1)
                        continue;
                   if(choice == 2){
                        System.out.printf("Now you will come to register");
                        register();}}}}
     


/*********   Passenger 注册 ****************/
    public static void register() {
    	boolean is_true = false;
        String ID;
        //input passenger's info
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter your real name please\t\t   ");
        String passenger_realName = input.nextLine();
        System.out.print("Enter your real ID please\t\t   ");
        String passenger_realID = input.nextLine();
        //检查是否有重名
       do {
        System.out.print("Create an ID used for Log in please\t   ");
         ID = input.nextLine();
        	for(Passenger everypassenger : passengers_lilst){
        		if (everypassenger.passengerID.compareTo(ID)==0){
        			System.out.println("Your ID has been used ,please use another one!\n   ");
        			 input.nextLine();
        			is_true = true;
        			break;
        		}else
        			is_true = false;
        	}
       
        }   while(is_true);
        //input password , confirm twice
        System.out.print("Enter your password please\t\t   ");
        String password1 = input.nextLine();
        System.out.print("Enter your password again please\t   ");
        String password2 = input.nextLine();
        while (decideString(password1, password2) == false) {
            System.out.println("Different password,please try again");
            System.out.print("Enter your password please\t   ");
            password1 = input.nextLine();
            System.out.print("Enter your password again please\t   ");
            password2 = input.nextLine();
        }
        System.out.println("You have succeeded in setting your password");
        String passenger_Password = password1;
        //create new passenger
        Passenger new_passenger = new Passenger(passenger_realName,passenger_realID);
        new_passenger.passengerID = ID;
        new_passenger.passengerPassword = passenger_Password;
     // input passenger's status
        System.out.println("Willing to become a VIP? (100$ per year)");
        System.out.println("Type 1 for yes, Type 2 for no");
        int decide = input.nextInt();
        switch (decide) {
            case 1:
                new_passenger.passengerStatus = Passenger.passengerStat.VIP;
                System.out.printf("Dear %s, you have become a VIP in our company.\n",passenger_realName);
                break;
            case 2:
                new_passenger.passengerStatus = Passenger.passengerStat.nonVIP;
                break;

        }
        passengers_lilst.add(new_passenger);// add the new passenger to the array list
    }

    //decidePassword is used in register for determining the 2 String  are the same or not
    public static boolean decideString(String passwordA, String passwordB) {
        boolean a = false;
        if (passwordA .equals(passwordB) ) {
            a = true;
        }
        return a;
    }
    
    
}
