package suiteA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TempDate {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString());//Mon Oct 26 18:12:38 EDT 2026
		String date_selected = "12-04-2018";
		
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date dateToSelected = sd.parse(date_selected);
			System.out.println(dateToSelected.toString());//Thu Apr 12 00:00:00 EDT 2018
			//compare dates-
			System.out.println(d.compareTo(dateToSelected));
			String day = new SimpleDateFormat("dd").format(dateToSelected);
			String month = new SimpleDateFormat("MM").format(dateToSelected);
			String monthMMM = new SimpleDateFormat("MMM").format(dateToSelected);
			String monthMMMM = new SimpleDateFormat("MMMM").format(dateToSelected);
			String year = new SimpleDateFormat("yyyy").format(dateToSelected);
			
			System.out.println("Simplified Date is: "+day+"-"+month+"-"+year);//12-04-2018
			System.out.println("Simplified Date is: "+day+"-"+monthMMM+"-"+year);//12-Apr-2018
			System.out.println("Simplified Date is: "+day+"-"+monthMMMM+"-"+year);//12-April-2018
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println();

	}

}
