#   Text Document Created in ubuntu 10.10

Design :

First Step to Create useful data:

Tuple for hour is created - total 12 elements (index: 0-11) - we will convert the 24-hr clock into 12-hr clock thats why 12 elements.

Dictionary for Minutes - Total 11 elements (keys : 5n, where n=1...11) 
		        
Dictionary for Special Cases - Total 6 elements (can add more)

Dictionary for prepostions - Three types 1 : when minutes%5 == 0 or minutes exact multiple of 5
					 2 : When minutes%5 == 1 and 2  or minutes like 31-32 
					 3 : when minutes%5 == 3 and 4  or minutes like 33-34
				 

Next Step is to get the time. Using datetime module we get the hours - minutes - seconds.

Defining Function getfuzzytime(hours,minutes,seconds)

First check the given time is a special case if yes print fuzzy time and return

if not special case :
	Check minute > 32 if yes then hours = hours + 1 { We created minutes dict according to this ; }
Find fuzy factor = minute % 5

if fuzzyfactor == 1 and fuzzyfactor == 2 then fuzzyfactor = 1 { real }
if fuzzyfactor == 3 and fuzzyfactor == 3 then fuzzyfactor = -1 { real }
else fuzzyfactor = 0

Then convert minutes to a multiple of 5 which is near to the current minutes value. 

Convert the 24hrs -> 12hr clock

Then form the fuzzy time according to the calculated values.


Dependencies : 
	Nothing

Usage :
	1: Without arguments - system time will taken  - python clock.py
	2: With three arguments - hh mm ss	       - python clock.py 3 23 20   - For Debugging

