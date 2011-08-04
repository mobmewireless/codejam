#!/usr/bin/python
#producer.py
#renjithforever@gmail.com
"""
mobme codejam : Ternery
---------------------
PRODUCER:

A basic number generator.
Can generate upto 10 didgit numbers.But generating the full set of 10 digit numbers will take hours so the default lenght used is 6.
Pls change var `lenghth` to any size upto 10.If more than 10 digits are required change the var `number` (add more 0s to the list).
To support upto 10 digits,list `number` should have 10 items and all should be initially 0s.
The generated numbers are tranfered to `Sorter` through tcp-socket.
"""

import sys
import socket


length=6							#give any value upto 10


number=[0,0,0,0,0,0,0,0,0,0]					#structure that holds a number, add more 0s to support more than 10 digits.
maxLen=len(number)						


def gen(pos):
	"""
	Does the actual process of Generating numbers..
	I suppose 000000001,0000000002 etc are the numbers you are looking for and not 1,2,3 etc! 
	"""
	if pos==maxLen-length:
		sys.exit("producer: Done!")
	number[pos-1]+=1
	if number[pos -1]>9:
		number[pos -1]=0
		gen(pos-1)


if __name__=='__main__':
	try:
		server_socket=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
		server_socket.bind(("",4444))
		server_socket.listen(5)
	except socket.error, (value,message):
		sys.exit("could not open socket: "+message+"\nTry again..after 10 or more seconds")

	print "waiting to run Sorter..."
	client_socket, address=server_socket.accept()
	print "connected to Sorter..."
	print "Generating",length,"digit (default value) numbers and tranfering to Sorter"
	print "check Sorters's output..",
	while True:
		num=''.join(str(n) for n in number[maxLen-length:])
		client_socket.send(num)	
		client_socket.recv(512)			#for Ack
		gen(maxLen)

	
