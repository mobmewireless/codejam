import socket
import os
import time
ss=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
ss.bind(("",54321))
ss.listen(5)
while 1:
	cs,address=ss.accept()
	data=cs.recv(512)
	arg=data.split(" ")
	op=""
	if(arg[0]=="pwd"):
		op=os.getcwd()
	elif(arg[0]=="cat"):
		fp=open(arg[1],"r")
		op=fp.read()
		fp.close()
	elif(arg[0]=="rm"):
		op=os.remove(arg[1])
		op="file removed"
	elif(arg[0]=="touch"):
		fp=open(arg[1],"w")
		for i in range(2,len(arg)):
			fp.write(arg[i])
			fp.write(" ");
		
		if(fp!=""):
			op="file created";
		fp.close()
	elif(arg[0]=="list"):
		ans=os.listdir('.')
		for i in range(0,len(ans)):
			op=op+"\n"+ans[i]
	elif(arg[0]=="time"):
		op=time.strftime("%d-%m-%Y\t%H:%M:%S")
	else:
		op="command not found"	
	cs.send(op)
ss.close()
ss.flush();			

		
			


