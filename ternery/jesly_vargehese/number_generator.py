import random
import os

def numberGenerator():
	number = ''
	for i in range(0,10):
		number += str(random.randrange(0,10,1)) #generate the 10 digit number
	return number
													 

def writeToFile():
	while(1):
		number = numberGenerator() #calls numberGenerator to obtain the 10 digit numer
		print number               #print the generated number to screen
		
writeToFile() #starts the procedure