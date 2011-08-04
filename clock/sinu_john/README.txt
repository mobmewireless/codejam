Contest ID: clock
Developer:
            Sinu John
            email : sinuvian@gmail.com
            blog  : www.sinujohn.wordpress.com
            mobile: +91 9747632404

1. DESIGN
	Basically the structure of the sentence given by the clock has 5 words. The first word is "It's". Let the remaining words be s1, s2, s3 and s4. The possibilities for these remaining words are:
	s1 - [almost, exactly, around]
	s2 - Shows the minute part like [five, ten, quarter] etc.
	s3 - [past, to]
	s4 - Shows the hour part
	When time is almost near the hour, s2 and s3 becomes null.
	
	The program supports 2 degrees (levels) of fuzziness (see usage below).
	When degree=1, base value becomes 5. And when degree=2, base value becomes 15.
	To find the value of s1, we perform (minute%base) and thus find required s1.

2. DEPENDENCIES
	The program is coded in Python 2.7.1. But even though not tested, it should run on Python 2.5+

3. USAGE
	Usage:
       		python clock.py [degree [time]]

	           'degree' is the degree of fuzziness - can have values of 1 or 2
	           'time' - give time in the format hour:minute (24-hour format)
	                               example: 9:45, 11:30, 14:25
	            Default value of 'degree' is 1, and 'time' is System time.
	            
	            If 'time' is not given, then the program runs in an endless loop, until it is terminated, displaying current time.
	Example:
		python clock.py
				Runs the clock with degree=1

		python clock.py 2
				Runs the clock with degree=2
		
		python clock.py 1 13:21
				Shows the fuzzy description of time 13:21 with degree=1

