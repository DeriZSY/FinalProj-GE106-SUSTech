
public class debug {
	public static void main(String[] args) {
		int YearP=Integer.parseInt(String.valueOf(DataBase. present_date.charAt(0)))*1000+Integer.parseInt(String.valueOf(DataBase.present_date.charAt(1)))*100+
        		Integer.parseInt(String.valueOf(DataBase.present_date.charAt(2)))*10+Integer.parseInt(String.valueOf(DataBase.present_date.charAt(3)));
        int mouthP=Integer.parseInt(String.valueOf(DataBase.present_date.charAt(5)))*10+Integer.parseInt(String.valueOf(DataBase.present_date.charAt(6)));
        int DayP=Integer.parseInt(String.valueOf(DataBase.present_date.charAt(8)))*10+Integer.parseInt(String.valueOf(DataBase.present_date.charAt(9)));
        System.out.printf("%d\t%d\t%d\t",YearP,mouthP,DayP);
	}
}
