/**
 * Created by DeriZsy on 5/17/17.
 */
public class Test {
    public static void main(String []args){
        Flight a1 = new Flight("ZG001", "12:00", "2017-03-22", "13:22", "NewYork",
                "Beijing ", "Moscow", "UA", "$230", DataBase.Mig_MniJet);
        Flight a2 = new Flight("ZG002", "14:00", "2017-03-23", "15:22", "Shenzhen",
                "Moscow ", "St.Petersburg", "Airplot", "$300",DataBase.Airbus251);
        Flight a3 = new Flight("ZG003", "11:00", "2017-04-12", "17:22", "HongKong",
                "null ", "Beijing", "South Airline", "$100", DataBase.Airbus251);
        DataBase.flight_list.add(a1);
        DataBase.flight_list.add(a2);
        DataBase.flight_list.add(a3);
        Passenger.queryFlight();
    }
}
