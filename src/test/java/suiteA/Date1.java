package suiteA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date1 {

	public static void main(String[] args) {
		String date="12-04-2018";
		SimpleDateFormat sd = new SimpleDateFormat("d-MM-yyyy");
		try {
			Date formattedDate = sd.parse(date);
			System.out.println(formattedDate.toString());
			String day = new SimpleDateFormat("d").format(formattedDate);
			String month = new SimpleDateFormat("MM").format(formattedDate);
			String year = new SimpleDateFormat("yyyy").format(formattedDate);
			
			System.out.println("Date is "+date+" "+month+" "+year);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

	}

}
