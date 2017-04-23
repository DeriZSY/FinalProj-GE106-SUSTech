public class Order {
    /************ Variables ********/
    private String pass_name;
    private String pass_IDs;
    private String seatNum;
    private String flightNum;
    private String createDate;
    private String specialDemand;
    public  enum orderstates{PAID, UNPAID,CANCLED};
    orderstates orderstatus;

    /*********** Method ***********/

    public Order( String name, String IDs, String seat_num,
                  String flight_num, String create_date, String special_demand){
        pass_name     =     name;
        pass_IDs      =     IDs;
        seatNum       =     seat_num;
        flightNum     =     flight_num;
        createDate    =     create_date;
        specialDemand =     special_demand;
        orderstatus   = orderstates.UNPAID;

        //Add to Array List;
//        Main.pass_Names.add(name);
//        Main.pass_IDs.add(IDs);
//        Main.pass_seats.add(seat_num);
//        Main.pass_bookTime.add(create_date);
//        Main.pass_orderStatus.add(orderstatus);
    }


}

