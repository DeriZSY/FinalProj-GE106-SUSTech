import javax.xml.crypto.Data;
import java.util.Scanner;
import java.util.ArrayList;

public class Passenger {
    /****** variables ********/
    public static String passengerID;//used for registration.
    public static String passengerPassword;
    public static String realName;
    public static String realID;//passenger's own ID.
    public static ArrayList<Order> orderList = new ArrayList<Order>();
    public static String demand;

    public enum passengerStat {VIP, nonVIP}
    public passengerStat passengerStatus = passengerStat.nonVIP;

    
    Scanner input = new Scanner(System.in);

    public enum logingSatus {LGOING, UNLOGIN}

    ;
    logingSatus loginStates = logingSatus.UNLOGIN;

    /***** Constructor *****/
	public Passenger (String realname, String realID){
		this.realName = realname;
		this.realID = realID;
		
	}


    /***** 辅助功能： 确认密码 *****/
    public static void confirmPasword(String passengerID) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please Input your password to confirm :\n password:");
        String pWord = input.nextLine();
        for (Passenger everypassenger : DataBase.passengers_lilst) {
            if (everypassenger.passengerID.compareTo(passengerID) == 0) {
                if (pWord.compareTo(everypassenger.passengerPassword) == 0) {
                    System.out.printf("Confirm Success !\n");
                }
            }
        }
    }

    /***** 乘客功能 ： 查询航班 *****/
    public static void queryFlight() {
        Admin.flightAutoCheck();
        Scanner input = new Scanner(System.in);
        //选择需要搜索的方式，1、通过细节信息查询航班，2、通过航班ID查询信息（支持模糊查找），3、查看整个订单列表
            System.out.printf("Do you want to check by detailed information or by flightID?" +
                    "\n(Input \"1\" for check by detailed information and \"2\" for check by flightID, Input \"3\" to check "
                    +"the whole order list)"+"\nInput:");
            int choic = input.nextInt();
            input.nextLine();
            switch (choic) {
                //按照细节信息查询航班
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
                                System.out.printf("Please Input Your PassengerID :\n>>");
                                String passengerID = input.nextLine();
                                confirmPasword(passengerID);
                                Passenger.reserveFlight();
                                System.out.printf("Book Success!");
                            } else {
                                continue;
                            }
                        }
                    }
                    break;
                //通过航班ID查询航班
                case 2:
                    System.out.printf("Please Input the flightID\nFlight Id:");
                    String fID = input.nextLine();

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
                    break;
                //显示整个订单列表
                case 3:
                    System.out.printf("Please Input your Username");
                    String passengerID = input.nextLine();
                    Passenger.confirmPasword(passengerID);
                    for(Passenger everyPassenger : DataBase.passengers_lilst){
                        if(everyPassenger.passengerID.compareTo(passengerID) == 0){
                            Order.orderlist_disp(everyPassenger.orderList);
                        }
                    }
            }
    }



    /***** 乘客功能： 预订航班*****/
   public static void reserveFlight(){
       Admin.flightAutoCheck();
	   Scanner input = new Scanner (System.in);
	   int num=0;//用于调用user输入ID对应的航班
    	// 查询各个flight的信息  显示除开unpublished的所有信息
    	System.out.println("The flight information:");
    	for (Flight flight : DataBase.flight_list){
    		flight.check_and_change();
    	}
    	 for (Flight flight : DataBase.flight_list) {
    		 if (flight.flightStatus != Flight.flightStatusENU.UNPUBLISHED) {
    			 System.out.printf("the flight ID:%s\nthe flight status:", flight.flightID);
    			 System.out.println(flight.flightStatus+"   you can only reserve the available ones");
    			 System.out.printf("start city:%s  stopbycity:%s  arrival city:%s\n", flight.startCity,flight.stopByCity,flight.arrivalCity);
    			 System.out.printf("departure time:%s  arrival time:%s\n", flight.departureTime,flight.arrivalTime);
    			 System.out.printf("original price:%s  (VIP will enjoy a 10percent off)\n",flight.price);
    			 System.out.printf("airline company:%s\n",flight.airlineCompany );
    		 }
             }
  //预定航班
    	 System.out.println("please enter the flight ID that you want to reserve.You can only reserve the available ones");
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
    	demand = input.nextLine();
        Order newOrder = new Order (realName,passengerID,seatNum,ID,"做pre的那一天的日期",demand);
        newOrder.orderstatus = Order.orderstates.PAID;
        DataBase.order_list.add(newOrder);
       //输入乘客ID，并将订单添加到对应乘客的订单列表
        boolean is_true = true;
        while(is_true) {
            System.out.printf("Please input your passengerID\n");
            String aim_name = input.nextLine();
            for (Passenger everyPassenger : DataBase.passengers_lilst) {
                if (everyPassenger.passengerID.compareTo(aim_name) == 0) {
                    everyPassenger.orderList.add(newOrder);
                    is_true =false;
                }else
                    System.out.printf("The passengerID you input does not exist, please try again.\n");
            }
        }
        //预订成功
    	System.out.printf("You have successfully reserved the flight %s\n"
    			,DataBase.flight_list.get(num).flightID);
    }

   /***************退订功能*************/
   public static void unsubscribeFlight (){
       Admin.flightAutoCheck();
       Scanner input = new Scanner(System.in);
	   boolean is_true = true;
	   while (is_true){
	   System.out.println("Your order's info：");
	   int i = 0;
	   for (Order a : orderList){
		   i++;
		   System.out.printf(i+" Flight ID:"+a.getFlightID()+"  Order status:"+a.getOrderstatus()+"\n");
		   
	   }
	   System.out.println("Enter the num of the order you want to unsubscribe");
		   int decide = input.nextInt();
		   int b = DataBase.order_list.indexOf(orderList.get(decide-1));
		   System.out.println("You have succeeded in unsubsribing the flight "+orderList.get(decide-1).getFlightID());
		   orderList.remove(decide-1);//在Passenger的order中删除
		    DataBase.order_list.remove(b);//在数据库中将它删除
		    System.out.println("Enter 1.go on subscribing 2.quit");
		    decide = input.nextInt();
		    if (decide == 2){
		    	is_true = false;
		    }
	   }
   }
}
