import java.time.LocalDateTime;
import java.util.*;
class AgeCalculator{

	/*public void getDate(int date, int month, int year)
	{
		this.date=date;
		this.month=month;
		this.year=year;
	}*/
	int dob,yob,mob;
	LocalDateTime now = LocalDateTime.now();
	public void getCurrentDate(String yob)
	{

		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		int dobyear=Integer.parseInt(yob);
		int diff=year-dobyear;
		if(diff<18)
		{
			System.out.println("your account cannot be processed further since your age is below 18\n");
		}
		else
		{
			System.out.println(diff);
		}
		System.out.println();
		//System.out.printf("%d-%02d-%02d %02d:%02d:%02d", year, month, day, hour, minute, second);
	}
	//public static void main(String args[])
	//{
	//	AgeCalculator age=new AgeCalculator();
	//	age.getCurrentDate("2005");

	//}


}