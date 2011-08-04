import time

while 1:
    print '\n\n'
    print 'filename \t\t count of numbers' 

    for i in range(0,10):
        #accessing different files by changing the filename
	filename = str(i) + '.txt'
	file_object = open(filename,'r')
	#crating a list of 10 digit numbers in the file
	ten_digit_numbers = file_object.readlines()
	print filename + '\t\t\t ' +  str(len(ten_digit_numbers))
	file_object.close()

    time.sleep(1)
