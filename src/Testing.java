import java.util.Scanner;

/**
 * Created by DeriZsy on 4/25/17.
 */
public class Testing {
    public static void main(String []args){
//        Scanner input = new Scanner(System.in);
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
        DataBase.flight_list.add(k);

         Admin.superQuery();
//        Flight k = new Flight("11111","D","d","a","a","a","5","3","v");


//        k.dis_full_inform();

    }
}
