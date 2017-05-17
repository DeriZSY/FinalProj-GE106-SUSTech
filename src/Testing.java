import javax.xml.crypto.Data;
import java.util.Scanner;

/**
 * Created by DeriZsy on 4/25/17.
 */
public class Testing {
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
        
    /******    passenger/ database test ******/
        
      Admin.createFlight();
      Admin.updateFlight();
<<<<<<< HEAD
      Passenger p = new Passenger("","");
      p.reserveFlight();
      p.reserveFlight();
      p.reserveFlight();
      p.reserveFlight();
      p.unsubscribeFlight();
      
        
      //  Admin.create_newAdmin();
       // Admin.create_newAdmin();
     //   DataBase.adminLogin();
//        Admin.create_newAdmin();
//        Admin.create_newAdmin();
//       System.out.print(DataBase.admin_list.get(1).adminUserName);
       
        
        /*for(Admin a :  DataBase.admin_list){
        	System.out.println(a);}
        	 Admin.create_newAdmin();
        	 for(Admin a :  DataBase.admin_list){
             	System.out.println(a);
             	}
       // DataBase.adminLogin();
       // DataBase.register();
        
//        System.out.printf("username:\n ");
//        String uName = input.nextLine();
//        System.out.printf("password for:\n");
//        String pWord = input.nextLine();
////        String[] inform_list = origin_inform.split(";");
//        Admin new_admin = new Admin(uName,pWord);
//
//        Admin.create_newAdmin();
//        DataBase.adminLogin();
        
   /*     Flight k = new Flight("11111","D","d","a","a","a","5","3","v");
        Flight a1 = new Flight("ZG001", "12:00", "2017-03-22", "13:22", "NewYork",
                "Beijing ", "Moscow", "UA", "$230", "Boying 777");
        Flight a2 = new Flight("ZG002", "14:00", "2017-03-23", "15:22", "Shenzhen",
                "Moscow ", "St.Petersburg", "Airplot", "$300", "AirBus A380");
        Flight a3 = new Flight("ZG003", "11:00", "2017-04-12", "17:22", "HongKong",
                "null ", "Beijing", "South Airline", "$100", "Boying 757");
        DataBase.flight_list.add(k);
        DataBase.flight_list.add(a1);
        DataBase.flight_list.add(a2);
        DataBase.flight_list.add(a3);*/
//         Admin.superQuery();
//        Flight k = new Flight("11111","D","d","a","a","a","5","3","v");

=======
//      Passenger p = new Passenger("","");
//      p.reserveFlight();
//      p.unsubscribeFlight();
>>>>>>> origin/master

      Passenger.reserveFlight();

    }
}