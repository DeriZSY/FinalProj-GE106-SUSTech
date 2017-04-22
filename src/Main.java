import java.util.ArrayList;
import java.util.Date;
/**
 * Created by DeriZsy on 4/21/17.
 */
public class Main {
    //for superQuery
    public static ArrayList<String> flightIDs = new ArrayList<String>();
    public static ArrayList<String> startCitys = new ArrayList<String>();
    public static ArrayList<String> arrivalCitys = new ArrayList<String>();

    //For Display inform
    // all these information should be added to the arraylist when a order created
    public static ArrayList<String> pass_IDs= new ArrayList<String>();
    public static ArrayList<String> pass_Names= new ArrayList<String>();
    public static ArrayList<String> pass_seats= new ArrayList<String>();
    public static ArrayList<String> pass_bookTime= new ArrayList<String>();
    public static ArrayList<Order.orderstates> pass_orderStatus= new ArrayList<Order.orderstates>();

    // Initialize Planes
    public static Plane Airbus251 = new Plane(100,20,80);
    public static Plane Mig_MniJet = new Plane(3,1,2);
    public static void main(String[] args) {
        //Create Plane
        Plane Airbus251 = new Plane(100,20,80);
        Plane Mig_MniJet = new Plane(3,1,2);
        //Create Flight
        /* Flight(String fliID, Date dptTime, Date arrivTime, String stCity,String stpCity,
        String arrivCity, String alCompany, String plType)
         */

    }
}
