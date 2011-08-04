CLOCK
Author : Karthik R
National Institue of Technology, Calicut


Design
-------

	1. The main class (Clock) has a subclass (Time) for managing System Time. The member functions perform fuinctions
		like fetching system time, spells our HOUR, MIN etc
		
	2. Using basic IF-ELSE conditions, personalized messages can be shown as per the time
	3. The main funciton consists of an infinite loop, which constantly updates the time and displays the message
	
	
Dependencies
------------
NONE


Usage
-----

Open promt.

DIR> javac Clock.java
DIR> java Clock

SNAPSHOT HAS BEEN INCLUDED. PLEASE CHECK.


Testing
-------

To check the working of code, make the following changes before compiling :
	1. Change sleep time in line 121 to 800 or lesser.
	2. Un comment line number 49. This updates the minute value like that of seconds. 
	Hence, all possible time range can be seen instanty.