package util;

import java.sql.Date;

public class DateConverter {

	@SuppressWarnings("deprecation")
	public static String convertDate(Date D)  //Date d=rs.getDate(1);  TO get output in DD-MON-YYYY format
	{
		String MON[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		int DD,MM,YYYY;
		
		DD = D.getDate();

		MM = D.getMonth();

		YYYY = D.getYear();

		YYYY=YYYY+1900;
		
		String Date = DD+"-"+MON[MM]+"-"+YYYY;
		return Date;
	}
	@SuppressWarnings("deprecation")
	public String convertDate2(Date D)  //Date d=rs.getDate(1);    TO get output in YYYY-MM-DD format
	{
		int DD,MM,YYYY;
		
		DD = D.getDate();

		MM = D.getMonth()+1;

		YYYY = D.getYear();

		YYYY=YYYY+1900;
		
		String Date = YYYY+"-"+MM+"-"+DD;
		return Date;
	}
	
}