import socket
import sys

#create socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

#connect to server
host = sys.argv[1] #server address
port = int(sys.argv[2]) #server port
s.connect((host, port))
command = raw_input('CodeJam$>') #executes the codejam server prompt
while(1):
	s.send(command) #sends  command to server
	data = s.recv(1000000)
	print data
	if command == 'quit': #Oops time to go
		break
	command = raw_input('CodeJame$>') 
