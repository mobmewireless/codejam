import os

def read():
		
	while(1):
		line = raw_input() #takes input
		nump = int(line)
		if(not line):
			break
		nfile = nump/1000000000 #finds the first digit
		print 'Writing to, '+str(nfile)+'.txt value ',nump
 		numf = open(str(nfile)+'.txt','a') #opens the file
		numf.write(line+'\n') #write the filtered data
		numf.close()
		

read() #read the file and write the filter files