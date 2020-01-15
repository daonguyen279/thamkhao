import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class main {
	public static String getDepartmentDay() {
		 DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(new Date());
		    cal.add(Calendar.DATE, 2);
		    String newDate = dateFormat.format(cal.getTime());
		    return newDate;
	}
	public static void main(String[] args) {
		
String a = getDepartmentDay();
System.out.println(a);
	}

}
