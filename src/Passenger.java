import javax.xml.crypto.Data;
import java.util.Scanner;
import java.util.ArrayList;

public class Passenger {
    /****** variables ********/
    public  String passengerID;//used for registration.
    public  String passengerPassword;
    public  String realName;
    public  String realID;//passenger's own ID.
    public  ArrayList<Order> orderList = new ArrayList<Order>();
    public  String demand;

    public enum passengerStat {VIP, nonVIP}

    public passengerStat passengerStatus = passengerStat.nonVIP;


    Scanner input = new Scanner(System.in);

    public enum logingSatus {LGOING, UNLOGIN}

    ;
    logingSatus loginStates = logingSatus.UNLOGIN;

    /***** Constructor *****/
    public Passenger(String realname, String realID) {
        this.realName = realname;
        this.realID = realID;

    }


    /***** 辅助功能： 确认密码 *****/
//    public static void confirmPasword() {
//        Scanner input = new Scanner(System.in);
//        System.out.printf("Please input your uesrname:\nuesrname:>>\t");
//        String uName = input.nextLine();
//        System.out.printf("Please Input your password to confirm:\npassword>>\t");
//        String pWord = input.nextLine();
//        for (Passenger everypassenger : DataBase.passengers_lilst) {
//            if(uName.compareTo(everypassenger.passengerID) == 0){
//            if (pWord.compareTo(everypassenger.passengerPassword) == 0) {
//                System.out.printf("Success !\n");
//            }
//            }
//        }
//    }

    /***** 乘客功能 ： 查询航班 *****/
    public static void queryFlight() {
        Admin.flightAutoCheck();
        Scanner input = new Scanner(System.in);
        //选择需要搜索的方式，1、通过细节信息查询航班，2、通过航班ID查询信息（支持模糊查找），3、查看整个订单列表
        System.out.printf("Do you want to check by detailed information or by flightID?" +
                "\n(Input \"1\" for check by detailed information and \"2\" for check by flightID, Input \"3\" to check "
                + "the whole order list)" + "\nInput:");
        int choic = input.nextInt();
        input.nextLine();
        switch (choic) {
            //按照细节信息查询航班
            case 1:
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
                    System.out.printf("%s\t\t%s\t\t%s%20s\t\t\t%s\n","FlightID","State","Departure City","Arrival City","Flight Date");
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
                    reserveFlight0();
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
            //通过航班ID查询航班
            case 2:
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
                        System.out.printf("Input 'Y' to book it, and Input 'N' to continue your check\n");
                        String choice = input.nextLine();
                        if (choice.compareTo("Y") == 0) {
                            System.out.printf("Input 'Y' to see  inform, and Input 'N' to continue your check\n");
                            String choice2 = input.nextLine();
                            if (choice2.compareTo("Y") == 0) {
                                everyFlight.disp_flight_inform();
                            }
                        } else {
                            continue;
                        }
                    }
                }
                System.out.printf("Check Over, all available results have been shown");
                break;//case 1 break;
            //显示整个订单列表
            case 3:
//                System.out.printf("Please input your username:\n>>");
//                String aim_name = input.nextLine();
                  String aim_name = DataBase.reserved_PassName;
                System.out.print("Order List\n");
                System.out.print("Index\tPassenger Name\tPassenger ID\tSeat Number\t Fight ID\tCreate Date\tState\n");
                for (Passenger everyPassenger : DataBase.passengers_lilst) {
                    if (everyPassenger.passengerID.compareTo(aim_name) == 0) {
                        for (Order everyOrder : everyPassenger.orderList) {
                            System.out.printf("%d\t%s\t\t%s\t\t%s\t\t %s\t\t%s\t%s\n",DataBase.order_list.indexOf(everyOrder),everyOrder.getPass_name(),everyOrder.getPass_IDs(),everyOrder.getSeatNum(),everyOrder.getFlightID(),everyOrder.getCreateDate(),everyOrder.getOrderstatus());
                        }
                    }
                }
        }
//       }else
//            DataBase.passengerLogIn();
//    //end register and methods involved
    }


    /***** 乘客 搜索3 *****/
    public static void searchThree(Flight aim_Flight) {
        Scanner input = new Scanner(System.in);
//        System.out.printf("The flight you are looking for is" + aim_Flight.flightID + "; the Price is " + aim_Flight.price + "; the flight Sate is" + aim_Flight.flightStatus);
//        System.out.println();
        System.out.printf("Do you want to book any of the flights ?\n(Input flight ID to book or 'Q' to quit)\n");
        String choice = input.nextLine();
        if (choice.compareTo("Q") != 0) {
            for (Flight aimFlight : DataBase.flight_list) {
                if(aim_Flight.flightID.compareTo(choice) == 0) {
                    System.out.printf("Input 'Y' to book it\n");
                    String choice2 = input.nextLine();
                    if (choice2.compareTo("Y") == 0) {
//            confirmPasword();
                        DataBase.confirmPasswordPassenger();
                        Passenger.reserveFlight();
                        System.out.printf("Book Success!");
                    }
                }
            }
        }
    }

    /***** 乘客功能： 预订航班*****/
    //预定航班，并显示所有航班的信息
   public static void reserveFlight(){
       Admin.flightAutoCheck();
       Scanner input = new Scanner(System.in);
    	// 查询各个flight的信息  显示除开unpublished的所有信息
    	System.out.println("The flight information:\nFlightID\tFlightStatus\t\tFlightEX\tStartCity\tArrivalCity\t\t\tFlightDate");
    	    	 for (Flight flight : DataBase.flight_list) {
    		 if (flight.flightStatus != Flight.flightStatusENU.UNPUBLISHED ){  //terminate full按照要求是要打印出来的
    			 flight.disp_flight_inform();}
                 }
                reserveFlight0();
    }
   
   // 预定航班 但不显示航班信息 直接预定
   public static void reserveFlight0(){  //对与每一个object，这个方法都是一样的，跟Object本身无关，可以用static
       Admin.flightAutoCheck();
       Scanner input = new Scanner (System.in);
	 // 查找这个乘客
	   int psnum = 0 ;  //乘客是psnum号
	   boolean is_true = true;
       while(is_true) {
//           System.out.printf("Please input your passengerID\n");
//           String aim_name = input.nextLine();
           int counter = 0;
           for (Passenger everyPassenger : DataBase.passengers_lilst) {
               if (everyPassenger.passengerID.compareTo(DataBase.reserved_PassName) != 0) {
                  counter ++;
               }
               else{
            	   psnum = counter;
            	   is_true = false;
//            	   confirmPasword();

            	   break;
               }
           }
       }
	   
	   int num=0;//用于调用user输入ID对应的航班
  //预定航班
        System.out.println("Please enter the flight ID that you want to reserve.You can only reserve the available ones");
    	String ID = input.nextLine();
    	for (Flight flight : DataBase.flight_list){
    		if (flight.flightID.compareTo(ID)==0){
    			break;
    		}
    		num++;
    		
    	}// 用户选择的是num号flight
    	System.out.println("The following seats are not available:");
    	for (int j : DataBase.flight_list.get(num).seatNumList){
    		System.out.print(j +" ");
    	}
    	System.out.printf("\nWhich seat do you want to take?\n "
    			+ " Enter an integer from 1 to %d.  ",DataBase.flight_list.get(num).plane.seatCapacity);
    	int seatNum = input.nextInt();
    	DataBase.flight_list.get(num).remainingSeat--;//对应航班剩余座位减1；
    	DataBase.flight_list.get(num).seatNumList.add(seatNum);//座位列表中加入对应乘客的座位
    	System.out.println("Do you have any special demand? If any,please enter it.");
    	String demand0 = input.nextLine();

    	demand0 = input.nextLine();   	
        Order newOrder = new Order (DataBase.passengers_lilst.get(psnum).realName,DataBase.passengers_lilst.get(psnum).passengerID,seatNum,ID,DataBase.present_date,demand0);
        System.out.printf("Do you want to pay now?\nInput\"Y\"to pay now, and \"N\"to pay at airport\n");
    	 String status = input.nextLine();
    	 //付款确认
       DataBase.confirmPasswordPassenger();
    	 if (status.compareTo("Y")==0){
        newOrder.orderstatus = Order.orderstates.PAID;}
    	 else if(status.compareTo("N")==0){
    		 newOrder.orderstatus = Order.orderstates.UNPAID;
    	 System.out.printf("remember to pay at airport");
    	 }
    	 

        DataBase.order_list.add(newOrder);
        DataBase.passengers_lilst.get(psnum).orderList.add(newOrder);
       //输入乘客ID，并将订单添加到对应乘客的订单列表  进入付款界面
        // print passenger's order info
        System.out.println("Your lastest order information:");
        for(Order order :DataBase.passengers_lilst.get(psnum).orderList ){
        	order.order_disp(order);
        }
       
        
        //预订成功
    	System.out.printf("\nYou have successfully reserved the flight %s\n"
    			,DataBase.flight_list.get(num).flightID);
    }
   
   /***************退订功能*************/
   
   public  static void unsubscribedFlight (){
       Scanner input = new Scanner(System.in);
	   boolean is_true1 = true;
	   boolean is_true2 =true;
	   while (is_true1){
		   Admin.flightAutoCheck();
		   System.out.println("Enter you ID please");
		   String id = input.nextLine();
		   System.out.println("Enter your password please");
		   String pw = input.nextLine();
		   int passNum = 0;
		    for (Passenger everyPassenger : DataBase.passengers_lilst){
		    	if (everyPassenger.passengerID == id)
		    	{
		    		break;
		    	}passNum ++;
		    }
		   for (Passenger everyPassenger : DataBase.passengers_lilst){
			   if (everyPassenger.passengerID.compareTo(id)== 0 && everyPassenger.passengerPassword.compareTo(pw)==0) {  
	   while (is_true2){
	   System.out.println("Your order's information：");
	   int i = 0;
	   for (Order a : everyPassenger.orderList){
		   i++;
		   System.out.printf(i+" Flight ID:"+a.getFlightID()+"  Order status:"+a.getOrderstatus()+"\n");
		   
	   }
	   System.out.println("Enter the num of the order you want to unsubscribe");
		   int decide = input.nextInt();
		   String name = everyPassenger.orderList.get(decide-1).getFlightID();//所选订单对应的flightID
		   int b = DataBase.order_list.indexOf(everyPassenger.orderList.get(decide-1));// 选择的这个乘客的order在数据库中的位置
		   int seatNum =  DataBase.order_list.get(b).getSeatNum();
		   
		   int number = Admin.flightNum(name);
		   
		   System.out.println("You have succeeded in unsubsribing the flight\n "+everyPassenger.orderList.get(decide-1).getFlightID());
		   System.out.printf("Payment will be credited to your bank account\n");
		   everyPassenger.orderList.remove(decide-1);//在Passenger的order中删除
		    DataBase.order_list.remove(b);//在数据库中将它删除
		    DataBase.flight_list.get(number).remainingSeat--;
		    DataBase.flight_list.get(number).seatNumList.remove((Integer)seatNum);
		    
		    
		    
		    System.out.println("Your lastest order information:");
	        for(Order order :DataBase.passengers_lilst.get(passNum-2
	        		).orderList ){
	        	order.order_disp(order);
	        }
		    System.out.println("\nEnter 1.go on subscribing 2.quit");
		    decide = input.nextInt();
		    if (decide == 2){
		    	is_true2 = false;
		    }
	   }
	   is_true1= false;
	   break;
	   }
			   }
		   if (is_true1 == true)
			   System.out.println("Either your ID or your password is not correct, please try again! ");
		   }
   }



}