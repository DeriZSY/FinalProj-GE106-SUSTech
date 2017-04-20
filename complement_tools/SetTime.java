import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
class SetTime{
public static void main(String []args){
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String time = dateFormat.format(now);
//	System.out.printf(time);	
	
	//get current time
	Calendar cld = Calendar.getInstance();
	int year = cld.get(Calendar.YEAR);
	int month = cld.get(Calendar.MONTH);
	int date = cld.get(Calendar.DATE);
	int hour = cld.get(Calendar.HOUR_OF_DAY);
	int minute = cld.get(Calendar.MINUTE);
//	int second = cld.get(Calendar.SECOND);
//	time =(String)time;

	}
}