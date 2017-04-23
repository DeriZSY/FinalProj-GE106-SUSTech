import java.util.Scanner;

public class Passenger {
    /******variables********/
	public String passengerID;//used for registration.
	public String passengerPassword;
	public String realName;
	public String realID;//passenger's own ID.
	public String orderList;
	public enum passengerStat{VIP,nonVIP};
	passengerStat passengerStatus = passengerStat.nonVIP;
	Scanner input = new Scanner(System.in);
	/*****methods*****/
	
	//constructor
	public Passenger (String name, String ID){
		realName = name;
		realID = ID;
	}
	//register and methods in register
	public void register (){
		//input passengerID
		System.out.print("Enter your ID used for Log in");
		passengerID = input.nextLine();
		//input password , confirm twice 
		 System.out.print("Enter your password please");
			String password1 = input.nextLine();
			System.out.print("Enter your password again please");
			String password2 = input.nextLine();
			while (decidePassword(password1,password2) == false){
				System.out.print("Different password,plase try again");
				 System.out.print("Enter your password please");
					 password1 = input.nextLine();
					System.out.print("Enter your password again please");
					 password2 = input.nextLine();}
			System.out.println("You have succeeded in setting your password");
		passengerPassword = password1;
		// input passenger's status
		System.out.println("Willing to become a VIP? (100$ per year)");
		System.out.println("Type 1 for yes, Type 2 for no");
		int decide = input.nextInt();
		switch (decide){
		case 1: passengerStatus = passengerStat.VIP;break;
		case 2: passengerStatus = passengerStat.nonVIP;break;
			
		}
			// 还缺少对VIP功能的描述以及如何处理VIP的会费问题
		/****not yet finished ****/
		
		}
	//decidePassword is used in register for determining the 2 passwords are the same or not
	public boolean decidePassword(String passwordA,String passwordB){
		boolean a=false;
	if (passwordA ==passwordB){
		a = true;
	} return a;
	}
	
	//end register and methods involved
}
