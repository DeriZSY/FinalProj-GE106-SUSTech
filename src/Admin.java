import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Admin {
    //Variable for Admin
    public String adminUserName;
    public String adminPassWord;

    //    //Constructor
    public Admin(String usrName, String psWord) {
        adminUserName = usrName;
        adminPassWord = psWord;
    }
       enum adminStatus {LGOIN, UNLOG}
       adminStatus adminstatus;

    public adminStatus admstatus = adminStatus.UNLOG ;
//    public static int xx1= 2;
/************************************************** 方法 **************************************************/
    /********* 判断是否登陆 ******/
    //Judge if it's Log in
//    public  boolean is_log_in(){
//        if( admstatus == adminStatus.LGOIN)
//            return true;
//        return false;
//    }


    /*************** 管理员功能 ： 创建新管理员  ************************/
    public static void create_newAdmin() {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please the username:\n ");
        String uName = input.nextLine();
        System.out.printf("password for a new Administer:\n");
        String pWord = input.nextLine();
//        String[] inform_list = origin_inform.split(";");
        Admin new_admin = new Admin(uName,pWord);
        DataBase.admin_list.add(new_admin);
    }
/*****************************************************************/


    /*************** 管理员功能 ： 超级查找 ************************/
    //超级查找功能 superQuery
    public static void superQuery() {
        Scanner input = new Scanner(System.in);
//            if (is_log_in()) {
                /*选择查询种类： 1：通过航班ID 查询，2：通过订单ID查询 3，通过具体信息查询*/
        System.out.printf("Do you want to check flightID or OrderID or do normal query ?" +
                "\n(Input \"1\" for check by flightID and \"2\" for check by OrderId " +
                "  \"3\" for normal query) " + "\nInput:");
        System.out.println();
        int factor = input.nextInt();
        System.out.println();
        input.nextLine();
        // 3 cases of superQuery


        switch (factor) {
            case 1:
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
                    case 2:
                        break;//case 2 break;

                    //case 3 starts
                    case 3:
                        System.out.printf("What's your choice for departure city\n City name:");
                        String dpCity = input.nextLine();
                        System.out.printf("What's your choice for arriving city\n City name:");
                        String arvCity = input.nextLine();
                        System.out.printf("What's your idea starting date ?(Input in the form of yyyy-MM-dd,for example: 2016-04-22)\nDate:");
                        String startDate = input.nextLine();

                        for (Flight everyFlight : DataBase.flight_list) {
                            if (everyFlight.startCity.compareTo(dpCity) == 0 && everyFlight.arrivalCity.compareTo(arvCity) == 0 && everyFlight.flightDate.compareTo(startDate) == 0) {
                                System.out.printf("1");
                                System.out.printf("The flight you are looking for is %s \n the price of the flight %s \n The Current State of the flight is %s", everyFlight.flightID, everyFlight.price, everyFlight.flightStatus);
                                System.out.println();
                                System.out.printf("Input 'Y' to finish, and Input 'N' to continue your check");
                                String choice = input.nextLine();
                                if (choice.compareTo("Y") == 0) {
                                    System.out.printf("Do you want to delete it or Change its States?(input \"D\" for deleting and \"C\"for changing)");
                                    String Choice = input.nextLine();
                                    if (Choice.compareTo("D") == 0) {
                                        System.out.printf("Are you sure to delete this flight?(input \"Y\" for yes and \"N\" for No)\n");
                                        String choicek = input.nextLine();
                                        if (choicek.compareTo("Y") == 0)
                                            everyFlight.flightEx = Flight.flightExistting.DELETED;
                                        else
                                            System.out.printf("Deleting canceled.");
                                    }//extended deleted end
                                    else if (Choice.compareTo("C") == 0) {
                                        System.out.printf("Are you sure to delete this flight?(input \"Y\" for yes and \"N\" for No)\n");
                                        String choicek = input.nextLine();
                                        System.out.printf("Changing,end");
                                    }//changing end
                                }// extended function ended
                                else {
                                    continue;
                                }
                            }
                        }
                        break;
                    //case 3 breaks;

                }
        }




    /*****************************************************************/


    /***************管理员功能： 创建航班  ************************/
    public static void createFlight() {
//        if (is_log_in()) {
        Scanner input = new Scanner(System.in);
            /*依次输入航班信息， 用 ； 分隔开*/
        String[] inform_list = new String[10];
        System.out.printf("Please Input \nflightID\n");
        inform_list[0] = input.nextLine();
        System.out.printf("departure Time(e.g. 18:00)\n");
        inform_list[1] = input.nextLine();
        System.out.printf("flight date (e.g. 2017-03-22)\n");
        inform_list[2] = input.nextLine();
        System.out.printf(" arrival time(e.g.19:00)\n");
        inform_list[3] = input.nextLine();
        System.out.printf("departure city\n");
        inform_list[4] = input.nextLine();
        System.out.printf("stop by city(input null if there isn't)\n ");
        inform_list[5] = input.nextLine();
        System.out.printf("arrival city\n");
        inform_list[6] = input.nextLine();
        System.out.printf("airline company,\n ");
        inform_list[7] = input.nextLine();
        System.out.printf("Ticket price:");
        inform_list[8] = input.nextLine();
        System.out.printf("plane type\n");
        inform_list[9] = input.nextLine();
//        String original_Input = input.nextLine();
        Flight new_flight = new Flight(inform_list[0], inform_list[1], inform_list[2], inform_list[3], inform_list[4], inform_list[5], inform_list[6], inform_list[7], inform_list[8],inform_list[9]);
        DataBase.flight_list.add(new_flight);
//        } else {
//            System.out.printf("Please Log in First!");
//            DataBase.adminLogin();
//        }
    }//create Flight end
    /*****************************************************************/


    /**************** 管理员功能 ： 删除航班   *********************/
    public static void deleteFlight() {
//        if (is_log_in()) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.printf("The list of the planes are:\n");
            System.out.printf("FlightID\tFlightStatus\tExistence\tDeparture City\t\tArrival City\t\tFlight Date\n");
                /* 显示航班信息*/
            for (Flight everyflight : DataBase.flight_list) {
                if (everyflight.flightEx == Flight.flightExistting.EXIST)
                    System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t\t%s\t\t\t%s\n", everyflight.flightID, everyflight.flightStatus, everyflight.flightEx,
                            everyflight.startCity, everyflight.arrivalCity, everyflight.flightDate);

                Graphing.sepreate__Line_sharp_50();
            }// inform displaying end
                /*选择所要删除的航班*/
            System.out.printf("Input the flight ID for the flight you want to delete\nFlightID:");
            String deleting_ID = input.nextLine();
            for (Flight everyflight : DataBase.flight_list) {
                if (everyflight.flightID.compareTo(deleting_ID) == 0 && everyflight.flightEx == Flight.flightExistting.EXIST) {
                    System.out.printf("Are you sure to delete this flight?(input \"Y\" for yes and \"N\" for No)\n");
                    String choice = input.nextLine();
                    if (choice.compareTo("Y") == 0)
                        everyflight.flightEx = Flight.flightExistting.DELETED;
                    else
                        System.out.printf("Deleting canceled.");
                }
//                else
//                    System.out.printf("The Flight you chose does not Exist");
//                Graphing.sepreate__Line_sharp_50();
                Graphing.a_Empty_Line();
            }//deleting process end
                /*是否继续删除作业？*/
            System.out.printf("Do you want to continue to delete flights ?(Input \"Y\" for Yes, and \"N\" for no)");
            String choice = input.nextLine();
            if (choice.compareTo("Y") == 0)
                continue;
            else
            Graphing.sepreate__Line_sharp_50();
            Graphing.a_Empty_Line();
                break;
//            }// orperation end
//        }else{
//            System.out.printf("You have not log in, please log in first.");
//            DataBase.adminLogin();
//        }
        }// delete Flight End
    }

/**************** 管理员功能 ： 更新航班   *********************/
public static void updateFlight(){
	//input a flight 
	Scanner input = new Scanner(System.in);
	String validId;// 这个应该就是下面的inputStr
	boolean is_true = true;
	while (is_true){
		System.out.println("Please enter the flight ID for the flight you want to update");
	    String inputStr = input.nextLine() ;
	for(Flight flight :DataBase.flight_list){
		if (flight.flightID.compareTo(inputStr)==0){
			System.out.println("Succeed in finding this flight");
			is_true = false ;
			break;
		}else{
			System.out.print("the flight is not found,please type the ID again");
		}
	}
	}
	
     System.out.printf("1:check out the latest flight's information\t2:reset the flight status\t3:reset the plane type\t4:reset the prize ");
     
}
}




