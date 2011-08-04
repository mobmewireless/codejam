import java.io.*;
import java.util.*;

class clock
{

	float hours, mins, seconds, RoundedMins, Period;
	Calendar calendar;
	HashMap wordsMins, wordsHours;
	String Preposition, TimeInWords, PrevTimeInWords;
	Boolean FisrtTime;

	
	void init()
	{
		FisrtTime=true;
	
		wordsMins = new HashMap();
		wordsMins.put(0,new String(""));
		wordsMins.put(5,new String("FIVE PAST"));
		wordsMins.put(10,new String("TEN PAST"));
		wordsMins.put(15,new String("QUARTER PAST"));
		wordsMins.put(20,new String("TWENTY PAST"));
		wordsMins.put(25,new String("TWENTY-FIVE PAST"));
		wordsMins.put(30,new String("HALF PAST"));
		wordsMins.put(35,new String("TWENTY-FIVE TO"));
		wordsMins.put(40,new String("TWENTY TO"));
		wordsMins.put(45,new String("QUARTER TO"));
		wordsMins.put(50,new String("TEN TO"));
		wordsMins.put(55,new String("FIVE TO"));
		wordsMins.put(60,new String(""));
		
		wordsHours = new HashMap();
		wordsHours.put(1,new String("ONE"));
		wordsHours.put(2,new String("TWO"));
		wordsHours.put(3,new String("THREE"));
		wordsHours.put(4,new String("FOUR"));
		wordsHours.put(5,new String("FIVE"));
		wordsHours.put(6,new String("SIX"));
		wordsHours.put(7,new String("SEVEN"));
		wordsHours.put(8,new String("EIGHT"));
		wordsHours.put(9,new String("NINE"));
		wordsHours.put(10,new String("TEN"));
		wordsHours.put(11,new String("ELEVEN"));
		wordsHours.put(12,new String("TWELEVE"));
	}
	
	public clock()
	{
	
		init();
	
		while(true)
		{
		
			// Get the current time
			calendar = Calendar.getInstance(); // new GregorianCalendar(2011, 6, 18, 23, 58, 0); 
			Period = calendar.get(Calendar.HOUR_OF_DAY); // An easier way to find AM or PM
			hours = calendar.get(Calendar.HOUR);
			mins = calendar.get(Calendar.MINUTE);
			seconds = calendar.get(Calendar.SECOND);

			
			// If minutes > 30, increment the hour so that to change the syntax form "IT ISXXX PAST" to "IT ISXXX TO"
			if(mins>30)
			{
				calendar.add(Calendar.HOUR, 1);
				hours = calendar.get(Calendar.HOUR);
				Period = calendar.get(Calendar.HOUR_OF_DAY);
			}

			// Decide the suitable prepostion, ALMOST or AFTER for rouding the time
			if(mins%5==0)
				Preposition=" ";
			else if(mins%5>=3)
				Preposition=" ALMOST ";
			else Preposition=" AFTER ";
			
			// Round the minutes to nearest multiple of 5 so as to map the key in Hashmap
			RoundedMins = Math.round(mins/5)*5;
			
			
			if(Period==0) // If anywhere near midnight ie. 0:00 
				if(mins==0)
					TimeInWords = "IT ISMIDNIGHT";
				else TimeInWords = "IT is" + Preposition + wordsMins.get( (int)RoundedMins ) + "MIDNIGHT";
			else if(Period==12) // If anywhere near noon ie. 12:00 
				if(mins==0)
					TimeInWords = "IT ISNOON";
				else TimeInWords = "IT is" + Preposition + wordsMins.get( (int)RoundedMins ) + " NOON";
			else if(mins==0) // if the time ISXX:00
				TimeInWords = "IT IS"  + wordsHours.get((int)hours) + "'O CLOCK";
			else if(mins>56 || mins<3) // If the time ISanywhere near XX:00
				TimeInWords = "IT IS" + Preposition + wordsMins.get( (int)RoundedMins ) + " " + wordsHours.get((int)hours) + "'O CLOCK";
			else
				TimeInWords = "IT IS" + Preposition + wordsMins.get( (int)RoundedMins ) + " " + wordsHours.get((int)hours);
			
			//Tadaa! Time in words!
			if(!TimeInWords.equals(PrevTimeInWords))
				System.out.println(TimeInWords); // Do you know how to clear console in java? I couldnt find a function!

			PrevTimeInWords = TimeInWords; // Another tweak to ignore duplicate time statemnts
			
			try
			{
			
				//To synchronize the clock seconds
				if(FisrtTime)
				{
					// Sleep for x e seconds to next minute
					Thread.sleep((60-(int)seconds)*1000);
					FisrtTime=false;
				}
				else Thread.sleep(60*1000); // and this line will reduce the CPU usage!
			}
			catch(Exception e){ }
			
			
		}
	}
	
	public static void main(String args[])
	{
		
		clock me = new clock();

	}
}