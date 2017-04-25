import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Main {
    /************ Variables ********/
    public static void main(String[] args) {
        Admin.create_newAdmin();
        //Login

        Scanner input = new Scanner(System.in);
        boolean system_On = true;
//        while(true) {
        while (system_On) {
            System.out.printf("                       Welcome to the Ticket System\n");
            System.out.printf("Input \"admin\" to login as administer, and \"passenger \" to login as passenger\n");
            String status = input.nextLine();
            if (status.compareTo("admin") == 0) {
                //管理员模式
                System.out.printf("##################################################\n");
                DataBase.adminLogin();
                System.out.println();
                System.out.printf("###################################################################################");
                System.out.printf("\nFunction Menu\n");
                boolean admin_moode_on = true;

                while (admin_moode_on) {
                    String origin_function = ";create new Administer;create a new flight;delete flight;superQuery;Renew Flight inform and display;Log Out;";
                    String[] function_array = origin_function.split(";");
                    System.out.printf("#1 create new Administer\n#2 create a new flight\n#3 delete flight\n#4 superQuery\n"
                    +"#5 Renew Flight inform and display\n#6 Log Out\n");
                    System.out.printf("#################################################\n");
                    System.out.printf("Please input the number for function\n");
                    int chocieNum = input.nextInt();
                    System.out.println();
                    System.out.printf("The function you are going to enter is %s, are you Sure? ", function_array[chocieNum]);
                    System.out.printf("Input \"Y\" for YES and \"N\" for NO ");
                    String confirm = input.next();

                    if (confirm.compareTo("N") == 0)
                        continue;
                    switch (chocieNum) {
                        case 1:
                            Admin.create_newAdmin();
                            continue;
                        case 2:
                            Admin.createFlight();
                            continue;
                        case 3:
                            Admin.deleteFlight();
                            continue;
                        case 4:
                            Admin.superQuery();
                            continue;
                    }//end Switch
                    System.out.printf("Are you sure to Log Out?");
                    System.out.printf("Input \"Y\" for YES and \"N\" for NO ");
                    String confirm_out = input.nextLine();
                    if (confirm_out.compareTo("Y") == 0)
                        admin_moode_on = false;
                }//end Admin Function
            }//end Admin Mood
            else if (status.compareTo("passenger") == 0) {
                //乘客模式
                boolean passenger_mode_on = true;
                while (passenger_mode_on) {
                    System.out.printf("Do you need to register first? (input \"Y\" for Yes and \"N\" for No)");
                    String choice = input.nextLine();
                    if (choice.compareTo("Y") == 0) {
                        DataBase.register();
                    } else {
                        System.out.printf("Now, you are logging in !");
                        DataBase.passengerLogIn();
                    }

                }
            }// end passenger mode;
//        }// end system
        }//end system
    }
}


