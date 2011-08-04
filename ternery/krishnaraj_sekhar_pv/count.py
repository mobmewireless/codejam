import os
from time import sleep

#Function to count number of lines
def countlines(filename):
	fp = open(filename, "r")
	lines = fp.readlines()
	return len(lines)


#Infinite Loop to refresh count of lines every second
while 1:
	if os.name == 'posix':	
		os.system('clear')
	for i in range(0,10):
		filename =  str(i) + ".txt"
		nol =countlines(filename)
		print "File " + filename + " has %d numbers " % nol
	sleep(1)
