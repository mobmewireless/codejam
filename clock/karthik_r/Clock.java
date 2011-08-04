//package codejam;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock {
	
	/**
	 * A Time class is created for manipulating the system Time
	 * @author Karthik
	 *
	 */
	public class Time {
		public int hour,min,sec,am_pm;
		
		Time() {
			updateTime();
		}
		
		/*
		 * Obtains the current system Time using Calendar class
		 */
		public void updateTime() {
			  Calendar calendar = new GregorianCalendar();
			  hour  = calendar.get(Calendar.HOUR);
			  min   = calendar.get(Calendar.MINUTE);
			  sec   = calendar.get(Calendar.SECOND);
			  am_pm = calendar.get(Calendar.AM_PM);
		}

		/*
		 * @param increment When Time reaches 55min past X, the hour value 
		 * is increased by 1 and hence, the message shown becomes :
		 * "its almost X+1"
		 */
		public String hourInWords(int increment) {
			String[] hours={"TWELVE", "ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN","ELEVEN"};
			//hour=min/5;       //FOR TESTING
			return hours[(hour + increment)%12];
			
		}
		
		/*
		 * Similarly for minutes
		 */
		public String approxMin() {
			String[] mins = {"FIVE","TEN","QUARTER","TWENTY","TWENTYFIVE","HALF","THIRTYFIVE","FORTY","FORTYFIVE","FIFTY","FIFTYFIVE"};
			String msg="";
			//min=sec;        // FOR TESTING
			
			if (min == 0) msg="EXACTLY ";
			
			else if(min > 55) msg="ALMOST ";
			else if(min > 45) { 
				min = 60 -min;
				msg="ALMOST "+ mins[min/5 - 1]+" TO ";
			}
			else if (min%5 ==0) {
				msg = mins[min/5 - 1]+" PAST ";
			}
			
			else {
				msg = "ABOUT "+ mins[min/5] +" PAST ";
			} 
			return msg;
	}
		/*
		 * To make it fancier, the AM-PM info is used to add a tail message
		 */
		public String timeOfDay() {
			String msg = "";
			if (am_pm == 0) {   // AM
				if(hour < 2)
					msg=" AT MIDNIGHT!";
				else
					msg=" IN THE MORNING";
			}
			
			else {
				if(hour<4)
					msg=" IN THE AFTERNOON";
				else if(hour<7)
					msg=" IN THE EVENING";
				else
					msg=" IN THE NIGHT!";
		}
		
		return msg;
	}	
	}
	
	public static Time time;
	Clock() {
		time = new Time();
	}
	
	/*
	 * Displays the time
	 */
	public void showTime() {
		
		String head = "ITS ";
		String tail;
		String mid = time.approxMin();
		if (mid.contains("ALMOST ")) 
			tail = time.hourInWords(1);
		else
			tail = time.hourInWords(0);
		String aftertail = time.timeOfDay();
		System.out.println(head + mid + tail + aftertail);
		return;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Clock clock = new Clock();
		//infinite Loop
		while(true) {
			time.updateTime();
			clock.showTime();
			Thread.sleep(3000);
		}
			
		}
	}

