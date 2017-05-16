public class Order {
    /************ Variables ********/
    private String pass_name;
    private String pass_IDs;
    private int seatNum;
    private String flightID;
    private String createDate;
    private String specialDemand;
    private String orderID;
    public  enum orderstates{PAID, UNPAID,CANCLED};
    orderstates orderstatus;


    public String getPass_name() {
		return pass_name;
	}

	public String getPass_IDs() {
		return pass_IDs;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public String getFlightID() {
		return flightID;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getSpecialDemand() {
		return specialDemand;
	}

	public String getOrderID() {
		return orderID;
	}

	public orderstates getOrderstatus() {
		return orderstatus;
	}

	/*********** Method ***********/

    public Order( String name, String IDs, int seat_num,
                  String flight_num, String create_date, String special_demand){
        pass_name     =     name;
        pass_IDs      =     IDs;
        seatNum       =     seat_num;
        flightID      =     flight_num;
        createDate    =     create_date;
        specialDemand =     special_demand;
        orderstatus   = orderstates.UNPAID;}

    public void order_disp(){
        System.out.printf("%s",orderID);
    }

    }




