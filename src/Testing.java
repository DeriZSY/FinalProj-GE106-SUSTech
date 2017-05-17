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
//      Passenger p = new Passenger("","");
//      p.reserveFlight();
//      p.unsubscribeFlight();

      Passenger.reserveFlight();

    }
}