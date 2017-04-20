import java.util.Date;
import java.util.Scanner;
public class Admin {
    //Variables
    public static  String userName;
    public static  String passWord;
    //Method
    enum adminStatus {
        LGOIN, UNLOG
    }

    public static adminStatus admstatus = adminStatus.UNLOG ;

    //Constructor
    public Admin(String usrName, String psWord) {
        userName = usrName;
        passWord = psWord;
    }


    //adminLogin
    public static void adminLogin() {
        Scanner input = new Scanner(System.in);
        while (true) {
            //input username
            System.out.printf("Please input your user name:\nuserName: ");
            String usrName = input.nextLine();
            //input password
            System.out.printf("Please input your password:\npassword: ");
            String psWord = input.nextLine();
            if (userName.compareTo(usrName) == 0 || passWord.compareTo(psWord) == 0) {
                admstatus = adminStatus.LGOIN;
                System.out.printf("Login Success");
                break;
            } else {
                System.out.printf("Login Failed, Please try again!")
            }
        }
    }//end of adminLogin

    //create flight used in flight.

    //delete flight used in flight.//Not yet finished

    //superQuery
    public void superQuery{
        Scanner input = new Scanner(System.in);
        if(admstatus == adminStatus.LGOIN ){
            System.out.printf("What do you want to search?\n");
            System.out.printf("Input 1 to search with flightID\n");
            System.out.printf("Input 2 to search with city name\n");
            System.out.printf("Input 3 to get the list of all flight\n");
            System.out.printf(">>");
            int factor = input.nextInt();
            switch(factor){
                case 1:
                case 2:
                    System.out.printf("Input 1 to search with departure city, and 2 to search with arriving city");
                    int factor2 = input.nextInt();
                    switch(factor2) {
                        case 1:
                            System.out.printf("Please Input the name of departure city");
                            String dpc = input.nextLine();
                            for(String startingcity:Main.startCitys){
                                if(startingcity == dpc)
                                    /*************** Not yet finished **************/
                            }
                        case 2:
                            System.out.printf("Please Input the name of arrival city");
                            String arvc = input.nextLine();
                            for(String arrivingcity:Main.arrivalCitys){
                                if( arrivingcity == arvc)
                                    /********************* Not yet finished **************/
                            }
                    }
                        case 3:
                            System.out.print(Main.flightIDs);
                            break;
            }
        }else{
            System.out.printf("You have not log in, please log in first.");
            adminLogin();
        }

    }
}


