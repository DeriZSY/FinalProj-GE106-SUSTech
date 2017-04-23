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
            if (adminUserName.compareTo(usrName) == 0 || adminPassWord.compareTo(psWord) == 0) {
                DataBase.admstatus = DataBase.adminStatus.LGOIN;
                System.out.printf("Login Success");
                break;
            } else {
                System.out.printf("Login Failed, Please try again!");
            }
        }
    }


        public static void createFlight(String fliID, Date dptTime, Date arrivTime, String stCity,
                                        String stpCity, String arrivCity, String alCompany, String plType,Flight k ){
        k = new Flight(fliID, dptTime, arrivTime, stCity, stpCity, arrivCity, alCompany, plType);
        DataBase.flight_list.add(k);

    }



    //superQuery
    public void superQuery() {
        Scanner input = new Scanner(System.in);
        if (DataBase.admstatus == DataBase.adminStatus.LGOIN) {
            System.out.printf("What do you want to search?\n");
            System.out.printf("Input 1 to search with flightID\n");
            System.out.printf("Input 2 to search with city name\n");
            System.out.printf("Input 3 to get the list of all flight\n");
            System.out.printf(">>");
            int factor = input.nextInt();
            // 3 cases of superQuery
            switch (factor) {
            }
        }else{
                System.out.printf("You have not log in, please log in first.");
                adminLogin();
            }

        }
    }




