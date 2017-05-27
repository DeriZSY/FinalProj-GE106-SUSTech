import java.util.ArrayList;

public class Order {
    /************ Variables ********/
    private String pass_name;
    private String pass_IDs;
    private int seatNum;
    private String flightID;
    private String createDate;
    private String specialDemand;
    private String orderID;
    public  enum orderstates{PAID, UNPAID,};
    orderstates orderstatus;

    public String getPass_name() {
        return pass_name;
    }

    public void setPass_name(String pass_name) {
		this.pass_name = pass_name;
	}

	public void setPass_IDs(String pass_IDs) {
		this.pass_IDs = pass_IDs;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setSpecialDemand(String specialDemand) {
		this.specialDemand = specialDemand;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setOrderstatus(orderstates orderstatus) {
		this.orderstatus = orderstatus;
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




    public Order( String name, String IDs, int seat_num,
                  String flight_num, String create_date, String special_demand){
        pass_name     =     name;
        pass_IDs      =     IDs;
        seatNum       =     seat_num;
        flightID      =     flight_num;
        createDate    =     create_date;
        specialDemand =     special_demand;
        orderstatus   = orderstates.UNPAID;}

    /***** 传入一个Order的参数列表，并显示其中所有的Order信息*****/
    public static void orderlist_disp(ArrayList<Order> giveOrderList){
        System.out.printf("OrderID\t\tCreate Date\t\tFlight ID\t\tSeat Number\t\tSpecial Demands\t\t");
        for(Order everyOrder : giveOrderList)
        System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t",everyOrder.orderID,everyOrder.createDate,everyOrder.flightID,everyOrder.seatNum,everyOrder.specialDemand);
        Graphing.sepreate__Line_sharp_50();
        Graphing.sepreate__Line_underLine_50();
    }

    /***** 传入一个Order，并显示其信息 *****/
    public static void order_disp(Order aimOrder){
//		System.out.printf("OrderID\t\tCreate Date\t\tFlight ID\t\tSeat Number\t\tSpecial Demands\t\t\n");
//        System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t",aimOrder.orderID,aimOrder.createDate,aimOrder.flightID,aimOrder.seatNum,aimOrder.specialDemand);
    	System.out.printf("Create Date\t\tFlight ID\t\tSeat Number\t\tSpecial Demands\t\t\n");
        System.out.printf("%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\n",aimOrder.createDate,aimOrder.flightID,aimOrder.seatNum,aimOrder.specialDemand);
	}

    }




