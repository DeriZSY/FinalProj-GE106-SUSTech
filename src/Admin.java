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
                "(Input \"1\" for check by flightID and \"2\" for check by OrderId " +
                "  \"3\" for normal query) " + "\nInput:");
        System.out.println();
        int factor = input.nextInt();
        System.out.println();
        input.nextLine();
        // 3 cases of superQuery


        switch (factor) {
            case 1:
                System.out.printf("Please Input the flightID \n Flight Id:");
                String fID = input.nextLine();
                for (Flight everyFlight : DataBase.flight_list) {
                    if (everyFlight.flightID == fID) {
                        System.out.printf("Input 'Y' to see  inform, and Input 'N' to continue your check");
                        String choice = input.nextLine();
                        if (choice.compareTo("Y") == 0) {
                            everyFlight.dis_full_inform();
                        }
                    } else {
                        continue;
                    }
                }
                break;//case 1 break;
            case 2:
                break;//case 2 break;
            case 3:
                System.out.printf("What's your choice for departure city\n City name:");
                String dpCity = input.nextLine();
                System.out.printf("What's your choice for arriving city\n City name:");
                String arvCity = input.nextLine();
                System.out.printf("What's your idea starting date ?(Input in the form of yyyy-MM-dd,for example: 2016-04-22)\nDate:");
                String startDate = input.nextLine();

                for (Flight everyFlight : DataBase.flight_list) {
                    if (everyFlight.startCity == dpCity && everyFlight.arrivalCity == arvCity && everyFlight.flightDate == startDate) {
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
        }
//        }else{
//                System.out.printf("You have not log in, please log in first.");
//                DataBase.adminLogin();
//            }
    }
    /*****************************************************************/


/*** 基础查询功能, 因为此部分功能已经整合到超级查询中，故注释 ********************************/
//public void queryFlight() {
//    Scanner input = new Scanner(System.in);
//    if (is_log_in()) {
//            /*选择查询种类： 1：通过具体信息查询，2：通过航班ID查询*/
//            System.out.printf("Do you want to check by detailed information or by flightID?" +
//                    "(Input \"1\" for check by detailed information and \"2\" for check by flightID)"+"\nInput:");
//            int choic = input.nextInt();
//            switch (choic) {
//                /*通过具体信息： 始发城市，到达城市，航班日期查询*/
//                case 1:
//                    System.out.printf("What's your choice for departure city\n City name:");
//                    String dpCity = input.nextLine();
//                    System.out.printf("What's your choice for arriving city\n City name:");
//                    String arvCity = input.nextLine();
//                    System.out.printf("What's your idea starting date ?(Input in the form of yyyy-MM-dd,for example: 2016-04-22)\n: Date:");
//                    String startDate = input.nextLine();
//                    for (Flight everyFlight : DataBase.flight_list) {
//                        if (everyFlight.startCity == dpCity || everyFlight.arrivalCity == arvCity || everyFlight.flightDate == startDate) {
//                            System.out.printf("The flight you are looking for is" + everyFlight.flightID + "; the Price is " + everyFlight.price + "; the flight Sate is" + everyFlight.flightStatus);
//                            System.out.printf("Input 'Y' to finish, and Input 'N' to continue your check");
//                            String choice = input.nextLine();
//                            if (choice.compareTo("Y") == 0) {
//                                break;
//                            }
//                            } else {
//                                continue;
//                            }
//                        }
//                        break;
//                /*通过航班号查询*/
//                case 2:
//                    System.out.printf("Please Input the flightID \n Flight Id:");
//                    String fID = input.nextLine();
//                    for (Flight everyFlight : DataBase.flight_list) {
//                        if (everyFlight.flightID == fID) {
//                            System.out.printf("The flight you are looking for is" + everyFlight.flightID + "; the Price is " + everyFlight.price + "; the flight Sate is" + everyFlight.flightStatus);
//                            System.out.printf("Input 'Y' to book it, and Input 'N' to continue your check");
//                            String choice = input.nextLine();
//                            if (choice.compareTo("Y") == 0) {
//                                break;
//                            }
//                        } else {
//                            continue;
//                        }
//                    }
//                    break;
//
//                    }//end switch
//            }else{
//            System.out.printf("Please Log in First!");
//            adminLogin();
//        }
//       }
//    public static void createFlight(String fliID, String dptTime,String fliDate, String arrivTime, String stCity,
//                                          String stpCity, String arrivCity, String alCompany, String plType) {
//        if (Admin.admstatus == Admin.adminStatus.LGOIN) {
//            /**************** Undone ***************/
//            Flight(String fliID, Date dptTime, Date arrivTime,
//                    String stCity,String arrivCity, String alCompany, String plType);
//
//
//        } else {
//            System.out.printf("You have not log in, please log in first.");
//            Admin.adminLogin();
//        }
//    }

    /***************管理员功能： 创建航班  ************************/
    public static void createFlight() {
//        if (is_log_in()) {
        Scanner input = new Scanner(System.in);
            /*依次输入航班信息， 用 ； 分隔开*/
        String[] inform_list = new String[9];
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
        System.out.printf("plane type\n");
        inform_list[8] = input.nextLine();
//        String original_Input = input.nextLine();
        Flight new_flight = new Flight(inform_list[0], inform_list[1], inform_list[2], inform_list[3], inform_list[4], inform_list[5], inform_list[6], inform_list[7], inform_list[8]);
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
            System.out.printf("FlightID\tFlightStatus\tFlight Existence\tDeparture City\tArrival City\fFlight Date\n");
                /* 显示航班信息*/
            for (Flight everyflight : DataBase.flight_list) {
                if (everyflight.flightEx == Flight.flightExistting.EXIST)
                    System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", everyflight.flightID, everyflight.flightStatus, everyflight.flightEx,
                            everyflight.startCity, everyflight.arrivalCity, everyflight.flightDate);
            }// inform displaying end
                /*选择所要删除的航班*/
            System.out.printf("Input the flight ID for the flight you want to delete");
            String deleting_ID = input.nextLine();
            for (Flight everyflight : DataBase.flight_list) {
                if (everyflight.flightID.compareTo(deleting_ID) == 0 && everyflight.flightEx == Flight.flightExistting.EXIST) {
                    System.out.printf("Are you sure to delete this flight?(input \"Y\" for yes and \"N\" for No)\n");
                    String choice = input.nextLine();
                    if (choice.compareTo("Y") == 0)
                        everyflight.flightEx = Flight.flightExistting.DELETED;
                    else
                        System.out.printf("Deleting canceled.");
                } else
                    System.out.printf("The Flight you chose does not Exist");
                System.out.printf("###############################################################################\n\n");
            }//deleting process end
                /*是否继续删除作业？*/
            System.out.printf("Do you want to continue to delete flights ?(Input \"Y\" for Yes, and \"N\" for no)");
            String choice = input.nextLine();
            if (choice.compareTo("Y") == 0)
                continue;
            else
                System.out.printf("################################################################################\n\n");
                break;
//            }// orperation end
//        }else{
//            System.out.printf("You have not log in, please log in first.");
//            DataBase.adminLogin();
//        }
        }// delete Flight End
    }
        /*****************************************************************/
}




