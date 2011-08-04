import time
i=1
while i==1:
	try:
		num_of_1 = sum(1 for line in open('1.txt'))#opening the file for getting the number of 10 digit number starts with 1
	except IOError:
		print 'run filter.py before running watch.py or nothin in file 1.txt'
	else:
		print 'No. of numbers in 1.txt',num_of_1 #print the number of 10digit number start with 1 
	try:
		num_of_2 = sum(1 for line in open('2.txt'))
	except IOError:
		print 'run filter.py before running watch.py or nothin in file 2.txt'
	else:
		print 'No. of numbers in 2.txt',num_of_2
	
	try:
		num_of_3 = sum(1 for line in open('3.txt'))
	except IOError:
		print 'run filter.py before running watch.py or nothin in file 3.txt'

	else:
		print 'No. of numbers in 3.txt',num_of_3
		

	try:
		num_of_4 = sum(1 for line in open('4.txt'))
	except IOError:
		print 'run filter.py before running watch.py or nothin in file 4.txt'
	else:
		print 'No. of numbers in 4.txt',num_of_4
		
	try:
		num_of_5 = sum(1 for line in open('5.txt'))
	except IOError:
		print 'run filter.py before running watch.py or nothin in file 5.txt'
	else:
		print 'No. of numbers in 5.txt',num_of_5
	
	try:
		num_of_6 = sum(1 for line in open('6.txt'))
	except IOError:
		print 'run filter.py before running watch.py or nothin in file 6.txt'	
	else:
		print 'No. of numbers in 6.txt',num_of_6
	
	try:
		num_of_7 = sum(1 for line in open('7.txt'))
	except IOError:
		print 'run filter.py before running watch.py or nothin in file 7.txt'
	else:
		print 'No. of numbers in 7.txt',num_of_7
	
	try:
		num_of_8 = sum(1 for line in open('8.txt'))
	except IOError:
		print 'run filter.py before running watch.py or nothin in file 8.txt'	
	else:
		print 'No. of numbers in 8.txt',num_of_8
	
	try:
		num_of_9 = sum(1 for line in open('9.txt'))
	except IOError:
		print 'run filter.py before running watch.py or nothin in file 9.txt'	
	else:
		print 'No. of numbers in 9.txt',num_of_9
	time.sleep(1) #creating 1 second delay as per the question
