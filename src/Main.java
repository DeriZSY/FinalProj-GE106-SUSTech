import java.util.ArrayList;
import java.util.Date;
public class Main {
    /************ Variables ********/

    public static void main(String[] args) {
        //Login
        Admin DERI = new Admin("derizzzsy","derizhang");
        DataBase.admin_list.add(DERI);
        DataBase.adminLogin();

    }
}
