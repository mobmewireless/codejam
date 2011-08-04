import socket
import sys
import time
import random
#create socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

#connect to server
host = sys.argv[1] #server address
port = int(sys.argv[2]) #server port
s.connect((host, port))
while(1):
	number = random.choice('1234567890') #selects a number from 0-9
	letter = random.choice('abcdefghijklmnopqrstuvwxyz') #selects a letter from a-z
	filename = letter+number #combining the two strings  to get filename
	s.send('time') #sends a request to get server time
	my_time = s.recv(1000000) #recive time
	print 'Creating file with name:\t'+filename+'\nWith content:\t\t\t'+my_time
	s.send ('touch '+filename+' '+my_time)
	data = s.recv(1000000) #recive filecreation status
	print data
	time.sleep(60) #sleeps for 1 minute 