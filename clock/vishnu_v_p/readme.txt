				FUZZY CLOCK
			    Contest ID: clock
1.DESIGN

The program implements a clock with fuzziness. It consists of the following :

	1.1 Time Retreival Module
	
	This module is responsible to get the current time from the system clock and to pass it to the time announce module. 
	
	1.2 Time Announce Module
	
	This module announces the time in proper fuzzy format. It uses the Time Rounding Module and Conversion module to fulfil its resposibilities. The time is announced in a fuzzy way as either almost, exact, nearly or hardly and is provided as an English text rather than digits or numbers.
	
	1.3 Time Rounding Module
	
	This module rounds off the minutes to the nearest tenth or fifth minute. This module is used by the Time Announce Module to round off the time to provide fuzziness.
	
	1.4 Conversion Module
	
	This module performs the conversion of the number to English text. 
	
2. DEPENDENCIES

	2.1 Linux  2.6 or higher
		The code was succesfully compiled and executed on GNU Linux i686 platform using Ubuntu 11.04.
	2.2 GNU project C compiler
		The compiler used is gcc( GNU C Compiler) version 4.5.2.
	So on a linux terminal install gcc.
		
3. USAGE

	Compile the code using gcc as gcc <filename> -o <output_filename> 
	Execute the code in a terminal as ./<output_filename>
		

	

	
