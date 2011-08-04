#!/usr/bin/env python
import datetime,random,string,sys


# Tuples and Dictionaries for hours,minutes,prepostions and special cases

HOURS = [
  'twelve',
  'one',
  'two',
  'three',
  'four',
  'five',
  'six',
  'seven',
  'eight',
  'nine',
  'ten',
  'eleven'
];

MINUTES = {
  '5' :  'five past',
  '10': 'ten past',
  '15': 'quarter past',
  '20': 'twenty past',
  '25': 'twenty-five past',
  '30': 'half past',
  '35': 'twenty-five to',
  '40': 'twenty to',
  '45': 'quarter to',
  '50': 'ten to',
  '55': 'five to'
}

PREPOSITIONS = {
  '-1': ['almost', 'nearly'],
  '0': ['exactly', 'precisely', 'now', ''],
  '1': ['after', 'about', 'around']
};

roundAbout = "It's round about midnight"

SPECIAL_CASES = {
  '23:58': roundAbout,
  '23:59': roundAbout,
  '00:00': "It's midnight.",
  '00:01': roundAbout,
  '00:02': roundAbout,
  '12:00': "It's noon."
};

# Fuzzy Time Generator

def getfuzzytime(hour,minute,second,fuzzyfactor):

	
	# Checking Current time is special case 
	
	if SPECIAL_CASES.has_key(str(hour)+":"+str(minute)):
		print SPECIAL_CASES[str(hour)+":"+str(minute)]
		return
	
	
	# Incrementing hours if minutes > 32 { We created our Minutes dictionaries according to this }
	if minute > 32 : 
		if hour == 23 :
			hour = 0    # There is no 24:00 :)
		else :
			hour = hour + 1  
	
	fuzzyfactor = minute % 5   # Finding Fuzzyfactor which is used to select preposition
	
	if fuzzyfactor == 1 or fuzzyfactor ==2 :
		fuzzyfactor = 1
	elif fuzzyfactor == 3 or fuzzyfactor == 4 :
		fuzzyfactor = -1
	else :fuzzyfactor = 0
	
	# Finding minute as a multiple of 5 eg:  1)   if 32 -> 30    2) 34 -> 35
	
	minute = round(float(minute)/5.0)*5
	
	if minute == 60 :
		minute = 0       # No xx:60 :)
	
	if hour > 11 :
		hour = hour - 12  # Converting 24-hr to 12-hr
	
	# Creating the fuzzytime according to hour minute second and FuzzyFactor using tuples and dictionaries
	output=["It's"]
	output.append(PREPOSITIONS[str(fuzzyfactor)][int(random.random() * len(PREPOSITIONS[str(fuzzyfactor)]))])
	if minute != 0 :
		output.append(MINUTES[str(int(minute))])
	output.append(HOURS[int(hour)])
	
	if minute == 0 :
		output.append("O'Clock")
	
	# joining all the tuple contents
	print string.join(output," ")
	return
	


if __name__=="__main__" :

	if len(sys.argv) == 4 :
		getfuzzytime(int(sys.argv[1]),int(sys.argv[2]),int(sys.argv[3]),0)
		
		#Usage : python clock.py <hour(0-23)> <minute(0-59)> <second(0-59)>
		#For Testing...:)
		
	else :
		now = datetime.datetime.now()     # Get The time using datetime module
	
		hr = now.hour 			  # Hour 	
		sec = now.second		  # Second
		mint = now.minute		  # Minute
	
		getfuzzytime(hr,mint,sec,0)	  # Main Function

























