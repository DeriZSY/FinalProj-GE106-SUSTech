import javax.xml.crypto.Data;
import java.util.Scanner;

/**
 * Created by DeriZsy on 4/25/17.
 */
public class Testing {
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
//        System.out.printf("username:\n ");
//        String uName = input.nextLine();
//        System.out.printf("password for:\n");
//        String pWord = input.nextLine();
////        String[] inform_list = origin_inform.split(";");
//        Admin new_admin = new Admin(uName,pWord);
//
//        Admin.create_newAdmin();
//        DataBase.adminLogin();
        Flight k = new Flight("11111","D","d","a","a","a","5","3","v");
        Flight a1 = new Flight("ZG001", "12:00", "2017-03-22", "13:22", "NewYork",
                "Beijing ", "Moscow", "UA", "$230", "Boying 777");
        Flight a2 = new Flight("ZG002", "14:00", "2017-03-23", "15:22", "Shenzhen",
                "Moscow ", "St.Petersburg", "Airplot", "$300", "AirBus A380");
        Flight a3 = new Flight("ZG003", "11:00", "2017-04-12", "17:22", "HongKong",
                "null ", "Beijing", "South Airline", "$100", "Boying 757");
        DataBase.flight_list.add(k);
        DataBase.flight_list.add(a1);
        DataBase.flight_list.add(a2);
        DataBase.flight_list.add(a3);
//         Admin.superQuery();
//        Flight k = new Flight("11111","D","d","a","a","a","5","3","v");


//        k.dis_full_inform();

        Passenger.queryFlight();
//        Admin.superQuery();
//                    for (Flight everyFlight : DataBase.flight_list) {
//                        if (everyFlight.flightID == fID) {
//                            System.out.printf("The flight you are looking for is" + everyFlight.flightID + "; the Price is " + everyFlight.price + "; the flight Sate is" + everyFlight.flightStatus);
//                            System.out.printf("Input 'Y' to book it, and Input 'N' to continue your check");
//                            String choice = input.nextLine();
//                            if (choice.compareTo("Y") == 0) {
//                                confirmPasword();
//                                /**************** add an order **************/
//                                System.out.printf("Book Success!");
//                            }else{
//                                continue;
//                            }
//                        }
//            }
//        char [] input_for_search = new char[fID.length()];
//        for(int i = 0; i < fID.length(); i++){
//            input_for_search[i] = fID.charAt(i);
//        }
//        for(int i = 0; i < fID.length(); i++){
//            System.out.println(input_for_search[i]);
//        }
//
//        for (Flight everyFlight : DataBase.flight_list){
//            int i = 0;
//            int j = 0;
//            boolean is_result = false;
//            do{
//                System.out.printf("While on Run\n");
//                if (input_for_search[i] == everyFlight.flightID.charAt(j)) {
//                    System.out.printf("if is running\n");
//                    i++;
//                }
//                j++;
//                if(i == fID.length() )
//                    is_result = true;
//            }while(j < everyFlight.flightID.length() && i<fID.length());
//            if(is_result)
//                System.out.printf("The Flight you are looking for is %s\n\n",everyFlight.flightID);
//        }
    }
}
