/**
 * Created by DeriZsy on 5/17/17.
 */
public class Test {
    public static void main(String []args){
   
//      	Admin.createFlight();
    	
    	 Flight a1 = new Flight("ZG001", "12:00", "2017-03-22", "13:22", "NewYork",
                 "Beijing ", "Moscow", "UA", "$230", DataBase.Mig_MniJet);
         Flight a2 = new Flight("ZG002", "14:00", "2017-03-23", "15:22", "Shenzhen",
                 "Moscow ", "St.Petersburg", "Airplot", "$300",DataBase.Airbus251);
         Flight a3 = new Flight("ZG003", "11:00", "2017-04-12", "17:22", "HongKong",
                 "null ", "Beijing", "South Airline", "$100", DataBase.Airbus251);
         a1.flightStatus = Flight.flightStatusENU.AVAILABLE;
         a2.flightStatus = Flight.flightStatusENU.AVAILABLE;
         a3.flightStatus = Flight.flightStatusENU.AVAILABLE;
         DataBase.flight_list.add(a1);
         DataBase.flight_list.add(a2);
         DataBase.flight_list.add(a3);
         Order order = new Order("s","s",2,"s","s","s");
         order.setCreateDate("1234");
         order.setOrderstatus( Order.orderstates.PAID);
         DataBase.order_list.add(order);
//         System.out.printf("%s\t\t%s\t\t%s%20s\t\t\t%s\n","FlightID","State","Departure City","Arrial City","Flight Date");
         a3.dis_full_inform();
//         System.out.print("Index\tPassenger Name\tPassenger ID\tSeat Number\t Fight ID\tCreate Date\tState\n");
//         for(Order everyOrder : DataBase.order_list){
//             System.out.printf("%d\t%s\t\t%s\t\t%s\t\t %s\t\t%s\t\t%s\n",DataBase.order_list.indexOf(everyOrder),everyOrder.getPass_name(),everyOrder.getPass_IDs(),everyOrder.getSeatNum(),everyOrder.getFlightID(),everyOrder.getCreateDate(),everyOrder.getOrderstatus());
//         }
        
//            Passenger.reserveFlight0("ZG001");
//     
////        Order order = new Order("1","2",2,"3","2","2");
////        order.setSpecialDemand("hha");
////        order.order_disp(order);
////        Admin.deleteFlight();
//        Admin.superQuery();
//<<<<<<< HEAD
//////         Admin.updateFlight();
    Admin.createFlight();
//         Admin.updateFlight();
////    Admin.createFlight();
////        Admin.create_newAdmin();
//=======
////         Admin.updateFlight();
////    Admin.createFlight();
//>>>>>>> Jaken
////        String d1  = "2017-01-01";
////        String d2  = "2018-02-02";
////        String time = "03:00";
////        if(Admin.is_the_same_date(d1,DataBase.present_date)&& Admin.get_total_minutes(time) - Admin.get_total_minutes(DataBase.present_time) >= 120){
////            System.out.printf("true");
////        }
////        String a = "2017-01-02";
////        if(Admin.is_the_same_date(a)){
////            System.out.printf("Yes");
////        }
////    	DataBase.passengerLogIn();
////    	System.out.println();
////    	for (Passenger x :DataBase.passengers_lilst){
////    		System.out.print("ID:"+x.passengerID+x.passengerPassword);
////    	}
////    	System.out.println();
//    	
////    	Passenger.reserveFlight();
////    	Passenger.unsubscribedFlight();
//      
////        Admin.deleteFlight()
////        Admin.create_newAdmin();
////        Admin.delete_aimFlight("ZG002");
//  //        Passenger.queryFlight();
//
//

    }
}
