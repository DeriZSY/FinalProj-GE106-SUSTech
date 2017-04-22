import java.util.ArrayList;
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

//    public static int xx1= 2;



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
                System.out.printf("Login Failed, Please try again!");
            }
        }
    }//end of adminLogin

    //create flight used in flight.

    //delete flight used in flight.//Not yet finished

    //superQuery
    public void superQuery(){
        Scanner input = new Scanner(System.in);
        if(admstatus == adminStatus.LGOIN ){
            System.out.printf("What do you want to search?\n");
            System.out.printf("Input 1 to search with flightID\n");
            System.out.printf("Input 2 to search with city name\n");
            System.out.printf("Input 3 to get the list of all flight\n");
            System.out.printf(">>");
            int factor = input.nextInt();
            // 3 cases of superQuery
            switch(factor){
                case 1:
                case 2:
                    System.out.printf("Input 1 to search with departure city, and 2 to search with arriving city");
                    int factor2 = input.nextInt();
                    switch(factor2) {
                        //Case 1 Search with the starting Cities
                        case 1:
                            System.out.printf("Please Input the name of departure city");
                            String dpc = input.nextLine();
                            int index1;
                            //get the index of flight
                            for(String startingcity:Main.startCitys){
                                if(startingcity.compareTo(dpc) == 0){
                                    index1 = Main.startCitys.indexOf(startingcity);
                                    break;
                                }
                                System.out.printf("");
                                    /*************** Not yet finished **************/

                            }
                         //Case2   Search with the arriving Cities
                        case 2:
                            System.out.printf("Please Input the name of arrival city");
                            String arvc = input.nextLine();
                            int index2;
                            for(String arrivingcity:Main.arrivalCitys){
                                if( arrivingcity == arvc){
                                    index2 = Main.arrivalCitys.indexOf(arrivingcity);
                                    break;
                                }
                                System.out.printf("");
                                    /********************* Not yet finished **************/
                            }
                    }
                        //Case 3 : display all the flight IDs
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


