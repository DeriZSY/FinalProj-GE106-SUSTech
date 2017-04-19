import java.util.Scanner;
public class Admin{
	
//Variables
	public String userName = admin;
	public String password = java;
//Methods

	//Constructor
	pubilc Admin(String uName, String pWord){
		userName = uName;
		password = pWord;
	}
	//SetCurrentTime
	public void setCurrentTime(int Time){
		time = Time;
	}
	//adminLgoin
	public void adminLogin(){
		Scanner input = new Scanner(System.in);
		System.out.printf("Please input the userName\nusername:");
		String uName = input.nextLine;
		System.out.printf("Please input the password\npassword:");
		String pWord = input.nextLine;
		if(uName = userName||pWord=password){
		System.out.printf("Login Success! Welcome, %c",userName);
		}
	}
}
