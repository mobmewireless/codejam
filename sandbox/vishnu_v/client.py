import socket
print "Enter IP of server "
IP=raw_input()
while 1:	
	cs=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
	cs.connect((IP,54321))
	print "$",
	data=raw_input()
	if(data=='exit'):
		cs.close()
		exit
	cs.send(data)	
	data=cs.recv(512)
	print data
	cs.close()
	

	

