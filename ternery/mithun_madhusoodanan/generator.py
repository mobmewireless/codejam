import random
import time
file=open('random.txt','a')
#opening file for reading
i=1
while i==1:
	ranz=random.randrange(1000000000,10000000000)# to find random 10 digit number
	file.write(str(ranz)+'\n') #writing the number to file
	time.sleep(0.000001)#creating delay to keep up with filter
