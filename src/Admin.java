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

    public adminStatus admstatus = adminStatus.UNLOG;


    /***** 管理员功能： 创建新管理员 *****/
    public static void create_newAdmin() {
        Scanner input = new Scanner(System.in);
        boolean is_true = true;
        String uName = "defaultName";
        while (is_true) {
            System.out.printf("Please input the username for a new Administer (Input 'Q' to leave):\nUsername:>>");
            uName = input.nextLine();
            for (Admin everyAdmin : DataBase.admin_list) {
//                System.out.printf("on");
                if (everyAdmin.adminUserName.compareTo(uName) == 0 ) {
//                    System.out.printf("Check1\n");
                    System.out.printf("The name is already taken; please try a new one !\n");
                    input.nextLine();
                    break;
                } else if (everyAdmin.adminUserName.compareTo(uName) != 0) {
//                    System.out.printf("Check2\n");
                    is_true = false;
                }
//                System.out.printf("Check\n");
            }
        }//while end
        is_true = true;
        if (uName.compareTo("Q") != 0) {
            while (is_true) {
                System.out.printf("Please input the password for a new Administer:\nPassword:>>");
                String pWord = input.nextLine();
//        String[] inform_list = origin_inform.split(";");
                System.out.printf("Please input again to confirm:\nPassword:>>");
                String pWord2 = input.nextLine();
                if (pWord.compareTo(pWord2) == 0) {
                    Admin new_admin = new Admin(uName, pWord);
                    DataBase.admin_list.add(new_admin);
                    is_true = false;
                } else {
                    System.out.printf("The two password you input isn't the same, please try again");
                }
            }
        }
    }

    /***** 管理员功能： 更新个人信息*****/
    public static void modifyPersonalInform() {
        // 登录
        Scanner input = new Scanner(System.in);
        boolean is_ture = true;
        while (is_ture) {
            //input username
            System.out.printf("Please input your user name:\nuserName: ");
            String usrName = input.nextLine();
            //input password
            System.out.printf("Please input your password:\npassword: ");
            String psWord = input.nextLine();
            // check if account exist
            for (Admin everyAdmin : DataBase.admin_list) {
                if (everyAdmin.adminUserName.compareTo(usrName) == 0) { //check if username exist
                    if (everyAdmin.adminPassWord.compareTo(psWord) == 0) { // check if it's the corresponding password
                        System.out.printf("Login Success! ");
                        boolean new_is_true = true;
                        String uName = "defaultName";
                        //输入用户名
                        while (new_is_true) {
                            System.out.printf("Please input your new username (Input 'Q' to leave):\nUsername:>>");
                            uName = input.nextLine();
                            //检查是否存在重名
                            for (Admin newEveryAdmin : DataBase.admin_list) {
                                if (uName.compareTo(newEveryAdmin.adminUserName) == 0) {
                                    System.out.printf("The name is already taken; please try a new one !\n");
                                    break;
                                }//如果存在重名，继续输入，如果不存在重名
                                new_is_true = false;//检查结束
                            }
                            //输入用户名结束
                        }


                        //输入密码并验证
                        if (uName.compareTo("Q") != 0) {
                            new_is_true = true;
                            //输入密码
                            while (new_is_true) {
                                System.out.printf("Please input your new password:\nPassword:>>");
                                String pWord = input.nextLine();
                                System.out.printf("Please input again to confirm:\nPassword:>>");
                                String pWord2 = input.nextLine();
                                if (pWord.compareTo(pWord2) == 0) {//如果验证成功
                                    everyAdmin.adminUserName = uName;
                                    everyAdmin.adminPassWord = psWord;
                                    new_is_true = false;
                                }
                                //如果密码验证失败：
                                else {
                                    System.out.printf("The two password you input isn't the same, please try again");
                                }
                            }
                        }//密码输入结束

                        is_ture = false;
                        break;
                    }//检查密码结束
                }//检查用户名结束
            }//登录结束
            //如果登录失败：
            if (is_ture) {
                System.out.println("Login failed, pleas try again!");
            }
        }
    }

    /***** 管理员功能：超级查找 *****/
    public static void superQuery() {
        Scanner input = new Scanner(System.in);
//            if (is_log_in()) {
                /*选择查询种类： 1：通过航班ID 查询，2：通过订单ID查询 3，通过具体信息查询*/
        System.out.printf("Do you want to check flightID or OrderID or do normal query ?" +
                "\n(Input \"1\" for check by flightID and \"2\" for check by OrderId " +
                "  \"3\" for normal query) " + "(Input 'Q' to leave)\nInput:");
        System.out.println();
        String factor_str = input.nextLine();
        System.out.println();
//        input.nextLine();
        // 3 cases of superQuery
        if (factor_str.compareTo("Q") != 0) {
            int factor = Integer.parseInt(factor_str);
            switch (factor) {
                //管理员查询，模式1：按照航班号码查询，结束后可查看信息，或者修改信息；支持模糊查询功能；
                case 1:
                    Admin.flightAutoCheck();
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
                            if (input_for_search[i] == everyFlight.flightID.charAt(j)) {
                                i++;
                            }
                            j++;
                            if (i == fID.length())
                                is_result = true;
                        }
                        if (is_result) {
                            System.out.printf("The flight you are looking for is " + everyFlight.flightID + "; the Price is " + everyFlight.price + "; the flight Sate is " + everyFlight.flightStatus);
                            System.out.println();
                            System.out.printf("Input 'U' to update, 'M' to modify, 'D' to display full information, and 'N' to continue your check\n");
                            String choice = input.nextLine();
                            //输入为 D 则显示完整信息
                            if (choice.compareTo("D") == 0) {
                                System.out.printf("Input 'Y' to see  inform, and Input 'N' to continue your check\n");
                                String choice2 = input.nextLine();
                                if (choice2.compareTo("Y") == 0) {
                                    everyFlight.dis_full_inform();
                                }
                            }
                            //输入为 U 则调用更新信息功能
                            else if (choice.compareTo("U") == 0) {
                                Admin.updateFlight();
                            } else if (choice.compareTo("M") == 0) {
                                Admin.reset_Flight(everyFlight);
                            }
                            //否则结束对该此查询结果的操作，继续查询
                            else {
                                continue;
                            }
                        }
                    }
                    System.out.printf("Check Over, all available results have been shown");
                    break;//case 1 break;
                case 2:
                    Admin.flightAutoCheck();
                    break;//case 2 break;

                //case 3 starts
                case 3:
                    Admin.flightAutoCheck();
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
    }

    /***** 管理员功能：创建航班 *****/
    public static void createFlight() {
//        if (is_log_in()) {
        Scanner input = new Scanner(System.in);
        String[] inform_list = new String[9];
        boolean is_true = true;
        while (is_true) {
            System.out.printf("(Input 'Q' to leave at any moment)\n");
            System.out.printf("Please Input \nflightID\n");
            inform_list[0] = input.next();
            if (inform_list[0].compareTo("Q")==0)  
                break;
            System.out.printf("Departure Time(e.g. 18:00)\n");
            inform_list[2] = input.next();
            if (inform_list[2].compareTo("Q")==0)
                break;
            System.out.printf("Arrival Time(e.g.19:00)\n");
            inform_list[1] = input.next();
            if (inform_list[1].compareTo("Q")==0)
                break;
            System.out.printf("Flight Date (e.g. 2017-03-22)\n");
            inform_list[3] = input.next();
            if (inform_list[3].compareTo("Q")==0)
                break;
            System.out.printf("Departure City\n");
            inform_list[4] = input.next();
            if (inform_list[4].compareTo("Q")==0)
                break;
            System.out.printf("Stop by City(input null if there isn't):\n");
            inform_list[5] = input.nextLine();
            if (inform_list[5].compareTo("Q")==0)
                break;
            System.out.printf("Arrival City:\n");
            inform_list[6] = input.nextLine();
            if (inform_list[6].compareTo("Q")==0)
                break;
            System.out.printf("Airline Company:\n");
            inform_list[7] = input.nextLine();
            if (inform_list[7].compareTo("Q")==0)
                break;
            System.out.printf("Ticket Price:\n");
            inform_list[8] = input.nextLine();
            if (inform_list[8].compareTo("Q")==0)
                break;
            System.out.printf("Plane Type：\n(\"1\" for Airbus251 and \"2\" for Mig_MniJet)\n");
//      为了方便起见，在DataBase中就new了两个plane，演示的时候用战斗机，选2.如果仍想输入名称的话，
//        可以将plane放在arraylist里面通过对比字符串与计数调出所要的plane.
            int decide = input.nextInt();
            Plane plane0 = DataBase.Mig_MniJet;
            switch (decide) {
                case 1:
                    plane0 = DataBase.Airbus251;
                    break;
                case 2:
                    plane0 = DataBase.Mig_MniJet;
                    break;
            }

            Flight new_flight = new Flight(inform_list[0], inform_list[2], inform_list[1], inform_list[3], inform_list[4], inform_list[5], inform_list[6], inform_list[7], inform_list[8], plane0);
            DataBase.flight_list.add(new_flight);
            System.out.println("Enter 1:go on creating new flights  2:quit");
            int k = input.nextInt();
            if (k==2)
            	is_true = false;
        }
    }//create Flight end

    /***** 管理员功能： 删除航班 *****/
    public static void deleteFlight() {
//        if (is_log_in()) {
        while (true) {
            flightAutoCheck();
            Scanner input = new Scanner(System.in);
            System.out.printf("The list of the planes are:\n");
            System.out.printf("FlightID\tFlightStatus\tExistence\tDeparture City\t\tArrival City\t\tFlight Date\n");
                /* 显示航班信息*/
            for (Flight everyflight : DataBase.flight_list) {
                if (everyflight.flightEx == Flight.flightExistting.EXIST)
                    System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t\t%s\t\t\t%s\n", everyflight.flightID, everyflight.flightStatus, everyflight.flightEx,
                            everyflight.startCity, everyflight.arrivalCity, everyflight.flightDate);

                Graphing.sepreate__Line_sharp_50();
                System.out.println();
            }// inform displaying end
                /*选择所要删除的航班*/
            System.out.printf("Input the flight ID for the flight you want to delete (Input 'Q' to quit)\nFlightID:");
            String deleting_ID = input.nextLine();
            if (deleting_ID.compareTo("Q") != 0) {
                for (Flight everyflight : DataBase.flight_list) {
                    if (everyflight.flightID.compareTo(deleting_ID) == 0 && everyflight.flightEx == Flight.flightExistting.EXIST) {
                        System.out.printf("Are you sure to delete this flight?(input \"Y\" for yes and \"N\" for No)\n");
                        String choice = input.nextLine();
                        if (choice.compareTo("Y") == 0)
                            everyflight.flightEx = Flight.flightExistting.DELETED;
                        else
                            System.out.printf("Deleting canceled.");
                    }
                }
            }//deleting process end
                /*是否继续删除作业？*/
            System.out.printf("Do you want to continue to delete flights ?(Input \"Y\" for Yes, and \"N\" for no)\n");
            String choice = input.nextLine();
            if (choice.compareTo("Y") == 0)
                continue;
            else
                Graphing.sepreate__Line_sharp_50();
            Graphing.a_Empty_Line();
            break;
        }// delete Flight End
    }

    /***** 管理员功能： 更新航班信息 *****/
    public static void updateFlight() {
        //显示所有航班信息
        flightAutoCheck();
        System.out.printf("The list of the planes are:\n");
        System.out.printf("FlightID\tFlightStatus\tExistence\tDeparture City\t\tArrival City\t\tFlight Date\n");
                /* 显示航班信息*/
        for (Flight everyflight : DataBase.flight_list) {
            if (everyflight.flightEx == Flight.flightExistting.EXIST)
                System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t\t%s\t\t\t%s\n", everyflight.flightID, everyflight.flightStatus, everyflight.flightEx,
                        everyflight.startCity, everyflight.arrivalCity, everyflight.flightDate);

            Graphing.sepreate__Line_sharp_50();
            System.out.println();
        }// inform displaying end
        //input a flight
        Scanner input = new Scanner(System.in);
        String validId = "";
        int num = 0;//输入的这个航班在arraylist的位数，第一位num=0
        boolean is_true = true;
        while (is_true) {
            System.out.println("Please enter the flight ID for the flight you want to update");
            String inputStr = input.nextLine();
            int counter = 0;
            for (Flight flight : DataBase.flight_list) {
                if (flight.flightID.compareTo(inputStr) == 0) {
                    System.out.printf("Succeed in finding the flight %s\n", inputStr);
                    is_true = false;
                    validId = inputStr;
                    break;
                }
                counter++;
            }

            if (is_true)
                System.out.print("the flight is not found,please type the ID again");
            else {
                num = counter;
            }

        }
      boolean is_true0 = true;
       while (is_true0){
        System.out.printf("1:check out the latest flight's information\t2:reset the flight status\t3:reset the plane type\t4:reset the prize ");
        int decide = input.nextInt();
        switch (decide) {
            case 1:
                System.out.printf("price:%d\n", DataBase.flight_list.get(num).price);
                System.out.print("flight status:");
                System.out.println(DataBase.flight_list.get(num).flightStatus);
                System.out.printf("plane type:%d\ndepature time:%d\narrival time:%d\n", DataBase.flight_list.get(num).plane, DataBase.flight_list.get(num).departureTime, DataBase.flight_list.get(num).arrivalTime);
                break;

            case 2:
                System.out.println("1 for unpublished, 2 for avaliable,3 for full, 4 for terminate");
                int a = input.nextInt();
                switch (a) {
                    case 1:
                        DataBase.flight_list.get(num).flightStatus = Flight.flightStatusENU.UNPUBLISHED;
                        break;
                    case 2:
                        DataBase.flight_list.get(num).flightStatus = Flight.flightStatusENU.AVAILABLE;
                        break;
                    case 3:
                        DataBase.flight_list.get(num).flightStatus = Flight.flightStatusENU.FULL;
                        break;
                    case 4:
                        DataBase.flight_list.get(num).flightStatus = Flight.flightStatusENU.TERMINATE;

                }
                break;
            case 3://DataBase.flight_list.get(num).planeType = plane type是类 待改
                break;
            case 4:
                System.out.println("enter the price you want to alter to");
                String price = input.nextLine();
                DataBase.flight_list.get(num).price = price;

        }
        System.out.println("Enter 1.go on updating  2.quit");
        int k = input.nextInt();
        if (k==2)
        	is_true0 = false;
        
    }}

    /***** 管理员功能： 修改航班信息 *****/
    public static void reset_Flight(Flight selectedFlight) {
        flightAutoCheck();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.printf("Choose the inform you want to reset:\n");
            System.out.printf("1. Flight ID\n2. Departure Time\n3.Arrival Time" +
                    "4. Flight Date\n5. Start Ciy\n6. Stop by City\n7. Arrival City\n8. Airline Company\n9. Price\n10. Seat Capacity\n" +
                    "11. Flight State\n(Input 'Q' to quit)\n");
            String origin_function = "Flight ID;Departure Time(e.g. 13:00);Arrival Time(e.g. 12:00);Flight Date(e.g. 2016-12-22);Start Ciy;Stop by City;Arrival City;Airline Company;Price;Seat Capacity;Flight State";
            String[] function_array = origin_function.split(";");
            String choiceStr = input.nextLine();
            if (choiceStr.compareTo("Q") != 0) {
                int choiceNum = Integer.parseInt(choiceStr);
                System.out.printf("The information you choose to change is %s\n", function_array[choiceNum - 1]);
                System.out.printf("Please Input the new Information\nInform:>>");
                String newInform = input.nextLine();
                switch (choiceNum) {
                    case 1:
                        selectedFlight.flightID = newInform;
                        break;
                    case 2:
                        selectedFlight.departureTime = newInform;
                        break;
                    case 3:
                        selectedFlight.arrivalTime = newInform;
                        break;
                    case 4:
                        selectedFlight.flightDate = newInform;
                        break;
                    case 5:
                        selectedFlight.startCity = newInform;
                        break;
                    case 6:
                        selectedFlight.stopByCity = newInform;
                        break;
                    case 7:
                        selectedFlight.arrivalCity = newInform;
                        break;
                    case 8:
                        selectedFlight.airlineCompany = newInform;
                        break;
                    case 9:
                        selectedFlight.price = newInform;
                        break;
                    case 10:
                        int new_SeatCap = Integer.parseInt(newInform);
                        selectedFlight.seatCap = new_SeatCap;
                        break;
                    case 11:
                        if (newInform.compareTo("Publish") == 0) {
                            selectedFlight.flightStatus = Flight.flightStatusENU.AVAILABLE;
                        } else
                            System.out.printf("Selected state doesn't exist");
                        break;
                }
            } else
                break;
        }
    }

    public static void showAndReset() {
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
                System.out.println();
            }// inform displaying end
                /*选择所要修改的航班*/
            System.out.printf("Input the flight ID for the flight you want to modify (Input 'Q' to quit)\nFlightID:");
            String deleting_ID = input.nextLine();
            if (deleting_ID.compareTo("Q") != 0) {
                for (Flight everyflight : DataBase.flight_list) {
                    if (everyflight.flightID.compareTo(deleting_ID) == 0 && everyflight.flightEx == Flight.flightExistting.EXIST) {
                        System.out.printf("Are you sure to modify this flight?(input \"Y\" for yes and \"N\" for No)\n");
                        String choice = input.nextLine();
                        if (choice.compareTo("Y") == 0)
                            reset_Flight(everyflight);
                        else
                            System.out.printf("Modify Canceled.");
                    }
                }
            }//modify process end
                /*是否继续修改作业？*/
            System.out.printf("Do you want to continue to delete flights ?(Input \"Y\" for Yes, and \"N\" for no)\n");
            String choice = input.nextLine();
            if (choice.compareTo("Y") == 0)
                continue;
            else
                Graphing.sepreate__Line_sharp_50();
            Graphing.a_Empty_Line();
            break;
        }// Modify Flight End
    }


    public static void flightAutoCheck() {
        for(Flight everyFlight : DataBase.flight_list){
            everyFlight.check_and_change();
        }
    }
}


