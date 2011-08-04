import os
import socket
import sys
import time

def cat(filename):
	try:
		f = open(filename)
		content = f.readlines() #prints the contents in a file
		f.close()
		return ''.join(content)
	except:
		return 'Could not open file!'

def pwd():
	 #returns current path
	return os.path.abspath(os.path.curdir)
def list_dir():
	 #lists the current directory
	return '\n'.join(os.listdir('.'))

def rm(filename):
	try:
		os.unlink(filename) #delete file
		return 'File deleted sucessfully!'
	except:
		return 'Error! Could not find file.'

def times():
	return time.strftime("%H:%M:%S") #returns time 

def touch(filename, content):
	try:
		f = open(filename, 'w') #creates a file
		f.write(content)
		f.close()
		return 'File created sucessfully!!'
	except:
		return 'File could not be created!'

#creates a socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

#associate socket with a port
host = ''
port = int(sys.argv[1])
s.bind((host, port))

#accept calls from client

s.listen(0) #number of acceptable pending request.. set to zero
conn, addr = s.accept() #accept connection request from client
print "Connected to client:", addr
while(1):
	input_command = conn.recv(10000000)
	split_input = input_command.split(' ')
	if split_input[0] == 'list': #identifying various commands
		conn.send(list_dir())
	elif split_input[0] == 'pwd':
		conn.send(pwd())
	elif split_input[0] == 'cat':
		conn.send(cat(split_input[1]))
	elif split_input[0] == 'rm':
		conn.send(rm(split_input[1]))
	elif split_input[0] == 'touch':
		conn.send(touch(split_input[1],split_input[2]))
	elif split_input[0] == 'time':
		conn.send(times())
	elif split_input[0] == 'quit':
		break
	else:
		conn.send('Invalid command!')
conn.close()
