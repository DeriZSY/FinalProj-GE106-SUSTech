import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Admin {
    //Variable for Admin
	//Testing
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
    public static void create_newAdmin()  {
        Scanner input = new Scanner(System.in);
        boolean is_true = false;
        String uName = "defaultName";
      do {
            System.out.printf("Please input the username for a new Administer (Input 'Q' to leave):\nUsername:>>\t");
            uName = input.nextLine();
            for (Admin everyAdmin : DataBase.admin_list) {
//                System.out.printf("on");
                if (everyAdmin.adminUserName.compareTo(uName) == 0 ) {
//                    System.out.printf("Check1\n");
                    System.out.printf("The name is already taken; please try a new one !\n");
                   input.nextLine();
                    is_true = true;
                    break;
                } else 
                        is_true = false;
            }
        }while (is_true);
        is_true = true;
        if (uName.compareTo("Q") != 0) {
            while (is_true) {
                System.out.printf("Please input the password for a new Administer:\nPassword:>>\t");
                String pWord = input.nextLine();
//        String[] inform_list = origin_inform.split(";");
                System.out.printf("Please input again to confirm:\nPassword:>>\t");
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
            DataBase.confirmPasswordAdmin();
            //input username
//            System.out.printf("Please input your user name to verify identity:\nuserName: ");
//            String usrName = input.nextLine();
//            //input password
//            System.out.printf("Please input your password:\npassword: ");
//            String psWord = input.nextLine();
            // check if account exist
//            for (Admin everyAdmin : DataBase.admin_list) {
//                if (everyAdmin.adminUserName.compareTo(usrName) == 0) { //check if username exist
//                    String aim_Name = DataBase.reserved_Admin_Name;
//                    if (everyAdmin.adminPassWord.compareTo(psWord) == 0) { // check if it's the corresponding password
//                        System.out.printf("Login Success! ");
                        boolean new_is_true = true;
                        String uName = "defaultName";
                        //输入用户名
                        while (new_is_true) {
                            System.out.printf("Please input your new username (Input 'Q' to leave):\nUsername:>>");
                            uName = input.nextLine();
                            //检查是否存在重名
                            for (Admin newEveryAdmin : DataBase.admin_list) {
                                if (uName.compareTo(newEveryAdmin.adminUserName) == 0 && uName.compareTo(DataBase.reserved_Admin_Name) !=0 ) {
                                    System.out.printf("The name is already taken; please try a new one !\n");
                                    break;
                                }//如果存在重名，继续输入，如果不存在，则继续输入密码；用户名和密码在密码验证成功之后会统一更新

                                new_is_true = false;//检查并更改信息结束
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
                                    //修改指定用户的用户名和密码
                                    for(Admin aim_admin : DataBase.admin_list){
                                        if(DataBase.reserved_Admin_Name.compareTo(aim_admin.adminUserName) ==0){
                                            aim_admin.adminUserName = uName;
                                            aim_admin.adminPassWord = pWord;
                                            DataBase.reserved_Admin_Name = uName;
                                            System.out.print("Change Committed !\n");
                                        }
                                    }
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
    //登录结束
            //如果登录失败：
//            if (is_ture) {
//                System.out.println("Login failed, pleas try again!");



    /***** 管理员功能：超级查找 *****/
    public static void superQuery() {
        Scanner input = new Scanner(System.in);
        Admin.flightAutoCheck();//开始前先更新信息
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

                    System.out.printf("Please Input the flightID\nFlight Id:");
                    String fID = input.nextLine();
                    //模糊查询：提取输入信息中的有效信息
                    char[] input_for_search = new char[fID.length()];
                    for (int i = 0; i < fID.length(); i++) {
                        input_for_search[i] = fID.charAt(i);
                    }
                    //模糊查询
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
                            System.out.printf("The flight you are looking for is " + everyFlight.flightID + "; \nthe Price is " + everyFlight.price + "; \nthe flight Sate is " + everyFlight.flightStatus);
                            System.out.println();
                            System.out.println();
                            System.out.printf("Input 'U' to update, 'D' to display full information, and 'N' to continue your check\n");
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
                            }
                            //否则结束对该此查询结果的操作，继续查询
                            else {
                                continue;
                            }
                        }
                    }
                    System.out.printf("\nCheck Over, all available results have been shown\n");
                    break;//case 1 break;
                case 2:
                    System.out.printf("Please Input the OrderID:\n>>");
                    String OID = input.nextLine();
                    //模糊查询：提取输入信息中的有效信息
                    char[] input_order_for_search = new char[OID.length()];
                    for (int i = 0; i < OID.length(); i++) {
                        input_order_for_search[i] = OID.charAt(i);
                    }
                    //模糊查询
                    for (Order everyOrder : DataBase.order_list) {
                        int i = 0;
                        int j = 0;
                        boolean is_result = false;
                        while (j < everyOrder.getOrderID().length() && i < OID.length()) {
                            if (input_order_for_search[i] == everyOrder.getOrderID().charAt(j)) {
                                i++;
                            }
                            j++;
                            if (i == OID.length())
                                is_result = true;
                        }
                        if (is_result) {
                            System.out.printf("The order you are looking for is\n");
                            System.out.println();
                            break;//case 2 break;
                        }
                    }
                    break;
                case 3:
                    boolean is_true = true;
                    while(is_true) {
                        System.out.printf("What's your choice for departure city(Input 'Q' to quit for this information))\n City name:");
                        String dpCity = input.nextLine();
                        System.out.printf("What's your choice for arriving city(Input 'Q' to quit for this information))\n City name:");
                        String arvCity = input.nextLine();
                        System.out.printf("What's your idea starting date ?(Input in the form of yyyy-MM-dd,for example: 2016-04-22)(Input 'Q' to quit for this information))\nDate:");
                        String startDate = input.nextLine();
                        Graphing.standard_sepreation();
                        int choice1 = 0;
                        if (dpCity.compareTo("Q") == 0)
                            choice1 += 1;
                        if (arvCity.compareTo("Q") == 0)
                            choice1 += 2;
                        if (startDate.compareTo("Q") == 0)
                            choice1 += 4;
                        System.out.printf("%s\t\t%s\t\t%s%20s\t\t\t%s\n","FlightID","State","Departure City","Arrial City","Flight Date");
                        switch (choice1) {
                            case 0:
                                for (Flight every_Flight : DataBase.flight_list) {
                                    int times = 0;
                                    if (every_Flight.startCity.compareTo(dpCity) == 0 && every_Flight.arrivalCity.compareTo(arvCity) == 0 && every_Flight.flightDate.compareTo(startDate) == 0) {
//                                        Admin.searchThree(every_Flight);
                                        times += 1;
                                        every_Flight.disp_flight_inform();
                                    } else {
                                        continue;
                                    }

                                }
                                break;
                            case 1:
                                for (Flight every_Flight : DataBase.flight_list) {
                                    int times = 0;
                                    if (every_Flight.arrivalCity.compareTo(arvCity) == 0 && every_Flight.flightDate.compareTo(startDate) == 0) {
//                                        Admin.searchThree(every_Flight);
                                        times += 1;
                                        every_Flight.disp_flight_inform();
                                    } else {
                                        continue;
                                    }

                                }
                                break;
                            case 2:
                                for (Flight every_Flight : DataBase.flight_list) {
                                    int times = 0;
                                    if (every_Flight.startCity.compareTo(dpCity) == 0 && every_Flight.flightDate.compareTo(startDate) == 0) {
//                                        Admin.searchThree(every_Flight);
                                        times += 1;
                                        every_Flight.disp_flight_inform();
                                    } else {
                                        continue;
                                    }

                                }
                                break;
                            case 3:
                                for (Flight every_Flight : DataBase.flight_list) {
                                    int times = 0;
                                    if (every_Flight.flightDate.compareTo(startDate) == 0) {
//                                        Admin.searchThree(every_Flight);
                                        times += 1;
                                        every_Flight.disp_flight_inform();
                                    } else {
                                        continue;
                                    }

                                }
                                break;
                            case 4:
                                for (Flight every_Flight : DataBase.flight_list) {
                                    int times = 0;
                                    if (every_Flight.startCity.compareTo(dpCity) == 0 && every_Flight.arrivalCity.compareTo(arvCity) == 0) {
//                                        Admin.searchThree(every_Flight);
                                        times += 1;
                                        every_Flight.disp_flight_inform();
                                    } else {
                                        continue;
                                    }

                                }
                                break;
                            case 5:
                                for (Flight every_Flight : DataBase.flight_list) {
                                    int times = 0;
                                    if (every_Flight.arrivalCity.compareTo(arvCity) == 0) {
//                                        Admin.searchThree(every_Flight);
                                        times += 1;
                                        every_Flight.disp_flight_inform();
                                    } else {
                                        continue;
                                    }

                                }
                                break;
                            case 6:
                                for (Flight every_Flight : DataBase.flight_list) {
                                    int times = 0;
                                    if (every_Flight.startCity.compareTo(dpCity) == 0) {
                                        times += 1;
                                        every_Flight.disp_flight_inform();
                                    } else {
                                        continue;
                                    }
                                }
                                break;
                            default:
                                System.out.printf("No Available Result\n");
                                Graphing.standard_sepreation();
                                break;
                        }
                        Admin.searchThree();
                        System.out.printf("Input 'Y' to continue check and 'N' to finish checking process.\n");
                        String choice = input.nextLine();
                        Graphing.standard_sepreation();
                        if (choice.compareTo("Y") == 0) {
                            continue;
                        }
                        System.out.printf("\nQuery End.\n");
                        is_true = false;
                        break;

                    }
                    break;//case 3 breaks;
                    }
            }
        }

    /***** 管理员功能：搜索辅助，功能3 *****/
    public static void searchThree(){
        Scanner input = new Scanner(System.in);
         System.out.printf("Do you want to modify a flight?\n(Input the flight ID you want to modify, or input 'N' to quit)\nInput:>>");
            String choice = input.nextLine();
            if(choice.compareTo("Q") != 0) {
                for (Flight aim_Flight : DataBase.flight_list) {
                    if (aim_Flight.flightID.compareTo(choice) == 0) {
                        System.out.printf("Do you want to delete it or  update?(input \"D\" for deleting and \"U\"for changing,\"Q\" for quit)\n");
                        String Choice = input.nextLine();
                        Graphing.standard_sepreation();
                        if (Choice.compareTo("D") == 0) {
                            System.out.printf("Are you sure to delete this flight?(input \"Y\" for yes and \"N\" for No)\n");
                            String choicek = input.nextLine();
                            System.out.println();
                            if (choicek.compareTo("Y") == 0) {
                                String deletingID = aim_Flight.flightID;
                                Admin.delete_aimFlight(deletingID);
                            } else
                                System.out.printf("Deleting canceled.\n");
                            Graphing.standard_sepreation();
                        }//extended deleted end
                        else if (Choice.compareTo("U") == 0) {
                            Admin.updateFlight();
                            Graphing.standard_sepreation();
                        }
                    }//changing end
                }
            }
    }


    /***** 管理员功能：创建航班 *****/
    public static void createFlight() { //运行一次这个方法可以create 多个flight.
//        if (is_log_in()) {
        Scanner input = new Scanner(System.in);
        String[] inform_list = new String[9];
        boolean is_true = true;
        boolean is_true0 = false;
        int pTime = get_total_minutes(DataBase.present_time);
        while (is_true) {
            System.out.printf("(Input 'Q' to leave at any moment)\n");
      //input ID 并检查是否重名      
            do {
            	 System.out.printf("Please Input \nflightID\n");
            	 inform_list[0] = input.nextLine();
                	for(Flight everyFlight : DataBase.flight_list){
                		if (everyFlight.flightID.compareTo( inform_list[0])==0){
                			System.out.println("The flight ID has been used ,please input another one!");
                			 input.nextLine();
                			is_true0 = true;
                			break;
                		}else
                			is_true0 = false;
                	}
               
                }   while(is_true0);
            
            if (inform_list[0].compareTo("Q")==0){
                is_true = false;
                break;}

            //起飞日期
            System.out.printf("Flight Date (e.g. 2017-03-22)\n");
            inform_list[3] = input.nextLine();
            if (inform_list[3].compareTo("Q")==0)
            {   is_true = false;
                break;}
            //到达日期
            System.out.printf("Arrival Date (e.g. 2017-03-22)\n");
            String arrivalDate = input.nextLine();

            //起飞时间
            int dTime = 0;
            while(true) {
                    System.out.printf("Departure Time(e.g. 18:00)\n");
                    inform_list[2] = input.nextLine();

                    //检查起飞时间是否再当前时间之后两小时以上
                if(inform_list[2].compareTo("Q") !=0) {
                    dTime = get_total_minutes(inform_list[2]);

                    if (dTime -pTime < 120 && is_the_same_date(inform_list[3],DataBase.present_date)) {
                        System.out.printf("The present time is %s\n", DataBase.present_time);
                        System.out.printf("The departure time must be at least 2 hours later than the present time.\n");
                        System.out.printf("Please Input a Available departure time\n");
                        Graphing.standard_sepreation();
                        continue;
                    } else
                        break;
                }
                    else
                        break;
                }

            if (inform_list[2].compareTo("Q") == 0) {
                is_true = false;
                break;
            }




            //到达时间
            while(true) {
                    System.out.printf("Arrival Time(e.g.19:00)\n");
                    inform_list[1] = input.nextLine();
                    if(inform_list[1].compareTo("Q") != 0) {
                        //检测到达时间是否大于起飞时间
                        int aTime = get_total_minutes(inform_list[1]);
                        if (aTime <= dTime && is_the_same_date(arrivalDate,inform_list[3])) {
                            System.out.printf("Departure time is %s\n", inform_list[2]);
                            System.out.printf("The Arriving time must be greater than departure time.\n ");
                            System.out.printf("Please Input a Available arriving time.\n");
                            Graphing.standard_sepreation();
                            continue;
                        } else
                            break;
                    }else
                        break;
                }
            if (inform_list[1].compareTo("Q") == 0) {
                is_true = false;
                break;
            }



            //起飞城市
            System.out.printf("Departure City\n");
            inform_list[4] = input.nextLine();
            if (inform_list[4].compareTo("Q")==0)
            {   is_true = false;
                break;}
            //中转城市
            while (true) {
                    System.out.printf("Stop by City(input null if there isn't):\n");
                    inform_list[5] = input.nextLine();
                    //检测中转城市是否与起飞城市相同
                if(inform_list[5].compareTo("Q")!= 0){
                    if(inform_list[5].compareTo(inform_list[4]) == 0){
                        System.out.printf("Your departure city is %s\n",inform_list[4]);
                        System.out.printf("The Stop by city cannot be same as the departure city.\n");
                        System.out.printf("Please input a available stop by city.\n ");
                        Graphing.standard_sepreation();
                        continue;
                    }else
                        break;}
                        else
                            break;
                    }
            if (inform_list[5].compareTo("Q") == 0) {
                is_true = false;
                break;
                }

            //到达城市
            while(true) {
                System.out.printf("Arrival City:\n");
                inform_list[6] = input.nextLine();
                //检测到达城市是否与中转城市相同
                if(inform_list[6].compareTo("Q")!= 0){
                if(inform_list[6].compareTo(inform_list[5]) == 0){
                    System.out.printf("Your departure city is %s\n",inform_list[5]);
                    System.out.printf("The arrival city cannot be same as the stop by city.\n");
                    System.out.printf("Please input a available stop by city.\n ");
                    Graphing.standard_sepreation();
                    continue;
                }else
                    //检测到达城市是否与出发城市相同
                if(inform_list[6].compareTo(inform_list[4]) == 0){
                    System.out.printf("Your departure city is %s\n",inform_list[4]);
                    System.out.printf("The arrival city cannot be same as the departure city.\n");
                    System.out.printf("Please input a available stop by city.\n ");
                    Graphing.standard_sepreation();
                    continue;}
                    else
                        break;}
                        else
                            break;
                }
            if (inform_list[6].compareTo("Q")==0)
            {   is_true = false;
                break;}

            //航空公司
            System.out.printf("Airline Company:\n");
            inform_list[7] = input.nextLine();
            if (inform_list[7].compareTo("Q")==0)
            {   is_true = false;
                break;}

           //票价
            System.out.printf("Ticket Price:\n");
            inform_list[8] = input.nextLine();
            if (inform_list[8].compareTo("Q")==0)
            {   is_true = false;
                break;}
            //机型
            System.out.printf("Plane Type：\n(\"1\" for Airbus251 and \"2\" for Mig_MniJet)\n");
//      为了方便起见，在DataBase中就new了两个plane，演示的时候用战斗机，选2.如果仍想输入名称的话，
//        可以将plane放在arraylist里面通过对比字符串与计数调出所要的plane.
            int decide = input.nextInt();
            input.nextLine();
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
            System.out.printf("Do you want to continue to create new flights?\n");
            System.out.println("(Input 'Y' to continue and  'N' to quit and go to the main menu)\n");
            String choice = input.nextLine();
            if(choice.compareTo("Y") != 0) {
                is_true = false;
                break;
            }
            else
                continue;

        }
    }//create Flight end

    /***** 管理员功能： 删除航班（界面版） *****/
    public static void deleteFlight() {
//        if (is_log_in()) {
        while (true) {
//            flightAutoCheck();
            Scanner input = new Scanner(System.in);
            System.out.printf("The list of the planes are:\n");
            System.out.printf("FlightID\tFlightStatus\tExistence\tDeparture City\t\tArrival City\t\tFlight Date\n");
                /* 显示航班信息*/
            for (Flight everyflight : DataBase.flight_list) {
                everyflight.disp_flight_inform();
                Graphing.sepreate__Line_sharp_50();
                System.out.println();
            }// inform displaying end
                /*选择所要删除的航班*/
            System.out.printf("Input the flight ID for the flight you want to delete (Input 'Q' to quit)\nFlightID:");
            String deleting_ID = input.nextLine();
            Admin.delete_aimFlight(deleting_ID);
                /*是否继续删除作业？*/
            System.out.printf("Do you want to continue to delete flights ?(Input \"Y\" for Yes, and \"N\" for no)\n");
            String choice = input.nextLine();
            if (choice.compareTo("Y") == 0)
                continue;
            else
                Graphing.sepreate__Line_sharp_50();
            Graphing.a_Empty_Line();
            break;
        }
        }// delete Flight End
    /***** 管理员功能： 删除航班（功能版）*****/
    public static void delete_aimFlight(String deleting_ID){
        if (deleting_ID.compareTo("Q") != 0) {
            Scanner input = new Scanner(System.in);
            int aim_index = 0;
            boolean can_be_deleted = false;
            Flight.flightStatusENU aim = Flight.flightStatusENU.UNPUBLISHED;
            for (Flight everyflight : DataBase.flight_list) {

                if (everyflight.flightID.compareTo(deleting_ID) == 0) {
                    aim_index = DataBase.flight_list.indexOf(everyflight);
                    System.out.println(everyflight.flightStatus);
                    aim = everyflight.flightStatus;
                }
//                System.out.println(can_be_deleted);

//                System.out.println(can_be_deleted);
////                System.out.println();
            }
            if(aim  == Flight.flightStatusENU.TERMINATE || aim == Flight.flightStatusENU.UNPUBLISHED){
                can_be_deleted = true;
            }
            if (can_be_deleted) {
                System.out.printf("Are you sure to delete this flight?(input \"Y\" for yes and \"N\" for No)\n");
                String choice = input.nextLine();
                if (choice.compareTo("Y") == 0) {
                    DataBase.flight_list.remove(DataBase.flight_list.get(aim_index));
                    System.out.printf("Deleting Success !\n\n");
                } else
                    System.out.printf("Deleting canceled.\n\n");
            }
            else
                System.out.printf("The flight has been published and is not terminated, so it cannot be deleted.\n\n");
        }
    }

    /***** 管理员功能： 更新航班信息 *****/
    public static void updateFlight(String str){// 带参数，不显示所有信息
    	int num = flightNum(str);
    	change(num);
    }
       public static void updateFlight() {
   		//循环：修改多个flight的信息
   		boolean is_true0 = true;
   			while (is_true0) {
                //显示所有航班信息
//           flightAutoCheck();
                System.out.printf("The list of the planes are:\n");
                System.out.printf("FlightID\tFlightStatus\tExistence\tDeparture City\t\tArrival City\t\tFlight Date\n");
                   /* 显示航班信息*/
                for (Flight everyflight : DataBase.flight_list) {
                    everyflight.disp_flight_inform();
                    Graphing.sepreate__Line_sharp_50();
                    System.out.println();
                }// inform displaying end
                //input a flight
                Scanner input = new Scanner(System.in);
                String validId = "Default";
                int num = 0;//输入的这个航班在arraylist的位数，第一位num=0

                //循环至输入有效的flightID为止
                boolean is_true = true;
                while (is_true) {
                    System.out.println("Please enter the flight ID for the flight you want to update\n(Input 'Q' to quit)\n");
                    String inputStr = input.nextLine();
                    if (inputStr.compareTo("Q") != 0) {
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


                    } // 得到了管理员希望更改的航班 :DataBase.flight_list.get(num)
//       	   flightAutoCheck();
                    //  System.out.printf("Input '1' to Check out the latest flight's information\n '2' to reset the flight status\n '3' to reset the plane type\n '4' to reset the prize\n ");
                    //  int decide = input.nextInt();
                    // unpublished
                   change(num);
                        System.out.println("Enter 'Y' for updating another flight.Enter 'N' to quit.");
                        String decide = input.nextLine();
                        if (decide.compareTo("N") == 0) {
                            is_true0 = false;
                            is_true = false;
                        }
                }
                  else{
                        System.out.println("Enter 'Y' for updating another flight.Enter 'N' to quit.");
                        String decide = input.nextLine();
                        if (decide.compareTo("N") == 0) {
                            is_true0 = false;
                            is_true = false;
                        }
                  }
                }}}

//<<<<<<< HEAD
//                }//end while for is_true0
//            }
//=======
//           } // 得到了管理员希望更改的航班 :DataBase.flight_list.get(num)
//       	   flightAutoCheck();
//        
//                     change(num);
//                     
//   				System.out.println("Enter 'Y' for updating another flight.Enter 'N' to quit.");
//   				String decide = input.nextLine();
//   				if(decide.compareTo("N")==0)
//   					is_true0 = false ;
//           }//end while for is_true0
//       }
       /***********辅助功能：update中修改数据功能***********/
       public static void change(int num){
    	   // unpublished
           if (DataBase.flight_list.get(num).flightStatus == Flight.flightStatusENU.UNPUBLISHED)
           	reset_UNPUBLISh_Flight(DataBase.flight_list.get(num));
     // available or full
           else {
           if (DataBase.flight_list.get(num).flightStatus == Flight.flightStatusENU.AVAILABLE ||DataBase.flight_list.get(num).flightStatus == Flight.flightStatusENU.FULL)
           	reset_PUBLISHED_Flight(DataBase.flight_list.get(num));
     // terminated
           else
                   System.out.printf("Sorry, the flight you choose to reset is already terminate.\n");
           }
       }
       /********* 辅助功能:用flightID查找其在arraylist中的位置*********/
       public static int flightNum(String str){
    	   int k=0;//返回k
    	   boolean is_true = true;
       while (is_true) {
           int counter = 0;
           for (Flight flight : DataBase.flight_list) {
               if (flight.flightID.compareTo(str) == 0) {
                   System.out.printf("Succeed in finding the flight %s\n", str);
                   is_true = false;
                   break;
               }
               counter++;
           }

          
               k = counter;
           }
                    return k;
       }
    	   
       


       /***** 管理员功能： 修改航班信息 *****/
       // 若unpublished 则用这个方法
       public static void reset_UNPUBLISh_Flight(Flight selectedFlight) {
        //   flightAutoCheck();  update里面做了
           Scanner input = new Scanner(System.in);
          boolean is_true =true;
          while(is_true){
               System.out.printf("Choose the inform you want to reset:\n");
               System.out.printf("1. Flight ID\n2. Departure Time\n3.Arrival Time\n" +
                       "4. Flight Date\n5. Start Ciy\n6. Stop by City\n7. Arrival City\n8. Airline Company\n9. Price\n10. Seat Capacity\n" +
                       "11. Flight State(input Publish)\n(Input 'Q' to quit)\n");
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
                               System.out.printf("Selected state doesn't exist\n");
                           break;
                   }
                   System.out.printf("The information has been updated.\nNow, do you want to 'going on resetting the flight' or'quit resetting the flight'? \nEnter 'Y' for going on resetting the flight %s.  'N' for quit resetting the flight %s\n",selectedFlight.flightID,selectedFlight.flightID);
                     String decide = input.nextLine();
                     if (decide.compareTo("N")==0)
                   	  is_true = false;
               }else
                   break;
            }
           }
       
   /***** 如果AVAILABLE 或者FULL 则用这个方法 *****/
       public static void reset_PUBLISHED_Flight(Flight selectedFlight){
             //  flightAutoCheck();
               Scanner input = new Scanner(System.in);
   			boolean is_true = true;
               while (is_true) {
                   System.out.printf("Choose the inform you want to reset:\n");
                   System.out.printf("1. Price \n2. Seat Capacity\n(Input 'Q' to quit)\n");
                   String origin_function = "Price;Seat Capacity";
                   String[] function_array = origin_function.split(";");
                   String choiceStr = input.nextLine();
                   if (choiceStr.compareTo("Q") != 0) {
                       int choiceNum = Integer.parseInt(choiceStr);
                       System.out.printf("The information you choose to change is %s\n", function_array[choiceNum - 1]);
                       System.out.printf("Please Input the new Information\nInform:>>");
                       String newInform = input.nextLine();
                       switch (choiceNum) {
                           case 1:
                               selectedFlight.price = newInform;
                               break;
                           case 2:
                               int new_SeatCap = Integer.parseInt(newInform);
                               selectedFlight.seatCap = new_SeatCap;
                               break;
                       }
                   } else
                       break;
   				 System.out.printf("Enter 'Y' for going on resetting the flight %s.  'N' for quit resetting the flight %s",selectedFlight.flightID,selectedFlight.flightID);
                      String decide = input.nextLine();
                    // if (decide.compareTo("N")==0)
                   	 // is_true = false;
   				  is_true = (decide.compareTo("N")==0?false :true);
               }
           }
   //如果terminate 不能修改任何信息
       /***** 显示航班信息， 并可选择航班修改信息 *****/
   /*    public static void showAndReset() {
           while (true) {
               Scanner input = new Scanner(System.in);
               System.out.printf("The list of the planes are:\n");
               System.out.printf("FlightID\tFlightStatus\tExistence\tDeparture City\t\tArrival City\t\tFlight Date\n");
                   /* 显示航班信息*/
       /*        for (Flight everyflight : DataBase.flight_list) {
                   everyflight.disp_flight_inform();
                   Graphing.sepreate__Line_sharp_50();
                   System.out.println();
               }// inform displaying end
                   /*选择所要修改的航班*/
      /*         System.out.printf("Input the flight ID for the flight you want to modify (Input 'Q' to quit)\nFlightID:");
               String deleting_ID = input.nextLine();
               if (deleting_ID.compareTo("Q") != 0) {
                   for (Flight everyflight : DataBase.flight_list) {
                       if (everyflight.flightID.compareTo(deleting_ID) == 0) {
                           System.out.printf("Are you sure to modify this flight?(input \"Y\" for yes and \"N\" for No)\n");
                           String choice = input.nextLine();
                           if (choice.compareTo("Y") == 0){
                               //如果航班未发布，可修改所有信息
                               if(everyflight.flightStatus == Flight.flightStatusENU.UNPUBLISHED){
                                   Admin.reset_UNPUBLISh_Flight(everyflight);
                               }
                               //如果航班终结，则无法修改，会提示是否删除
                               else if(everyflight.flightStatus == Flight.flightStatusENU.TERMINATE){
                                   System.out.printf("Sorry, the flight you choose to reset is already terminate.\n");
                                   System.out.printf("Do you want to delete it ?\n(Input 'Y' for delete, and 'N' for ending modify)");
                                   String b_choice  = input.nextLine();
                                   if(b_choice.compareTo("Y") == 0){
                                       Admin.delete_aimFlight(everyflight.flightID);
                                   }
                                   //如果航班已发布，未终结，可修改部分信息
                                   else
                                       Admin.reset_PUBLISHED_Flight(everyflight);
                                       break;
                               } else{

                               }
                           }
                           else
                               System.out.printf("Modify Canceled.");
                       }
                   }
               }//modify process end
                   /*是否继续修改作业？*/
     /*        System.out.printf("Do you want to continue to delete flights ?(Input \"Y\" for Yes, and \"N\" for no)\n");
               String choice = input.nextLine();
               if (choice.compareTo("Y") == 0)
                   continue;
               else
                   Graphing.sepreate__Line_sharp_50();
               Graphing.a_Empty_Line();
               break;
           }// Modify Flight End
       }  

       /***** 根据时间修改所有航班的状态 *****/
       public static void flightAutoCheck() {
           for(Flight everyFlight : DataBase.flight_list){
               everyFlight.check_and_change();
           }
       }
    /***** 辅助功能： 时间处理 *****/
    public static int get_total_minutes(String origin_time)
    {
        int tot_time = 0;
        int tot_hour = 0;
        int tot_minute = 0;
        for(int i = 0; i< origin_time.length(); i++){
            char k = origin_time.charAt(i);
            String k2 = String.valueOf(k);
            if(k2.compareTo("0") != 0 ){
                if(i != 2){
                    int num = Integer.parseInt(k2);
                    switch (i) {
                        case 0 :
                            tot_hour += num * 10;
                            break;
                        case 1:
                            tot_hour += num;
                            break;
                        case 3:
                            tot_minute += num * 10;
                            break;
                        case 4:
                            tot_minute += num;
                            break;
                    }
                }
            }
        }
        tot_time = tot_hour * 60 + tot_minute;
        return tot_time;
    }

    /***** 辅助功能：比较日期 *****/
    public static boolean is_the_same_date(String inputDate1, String inputDate2){
        int Year2=Integer.parseInt(String.valueOf(inputDate2.charAt(0)))*1000+Integer.parseInt(String.valueOf(inputDate2.charAt(1)))*100+Integer.parseInt(String.valueOf(inputDate2.charAt(2)))*10+Integer.parseInt(String.valueOf(inputDate2.charAt(3)));
        int month2=Integer.parseInt(String.valueOf(inputDate2.charAt(5)))*10+Integer.parseInt(String.valueOf(inputDate2.charAt(6)));
        int Day2=Integer.parseInt(String.valueOf(inputDate2.charAt(8)))*10+Integer.parseInt(String.valueOf(inputDate2.charAt(9)));

        int Year1=Integer.parseInt(String.valueOf(inputDate1.charAt(0)))*1000+Integer.parseInt(String.valueOf(inputDate1.charAt(1)))*100+Integer.parseInt(String.valueOf(inputDate1.charAt(2)))*10+Integer.parseInt(String.valueOf(inputDate1.charAt(3)));
        int month1=Integer.parseInt(String.valueOf(inputDate1.charAt(5)))*10+Integer.parseInt(String.valueOf(inputDate1.charAt(6)));
        int Day1=Integer.parseInt(String.valueOf(inputDate1.charAt(8)))*10+Integer.parseInt(String.valueOf(inputDate1.charAt(9)));
        if(Year1 == Year2 &&  month1 == month2 && Day1 == Day2){
            return true;
        }
        return false;
    }
}







