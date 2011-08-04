from socket import *
import threading
import os
import time
import commands

def execute(command):
    # executing commands
    command_result = commands.getoutput(command)
    if command_result == '':
        return " "
    return command_result

    
def available():
    try:
        # file that contains the available commands that can run on server
        fil = open("available_command.txt","r")
    except IOError:
        return "File containing command list not found"
        
    
    lines = fil.readlines()
    
    returndata = "\nCOMMAND  LIST\n\n"
    for line in lines:
        returndata += line + "\n"

    returndata = returndata.rstrip()
    return returndata + "\n"
    
        
        
        
    
class run_command(threading.Thread):
    
    def __init__ (self,clientsock):
        self.clientsock = clientsock
        threading.Thread.__init__(self,name = "no name")
        
    def run(self):
        
        while 1:
            try:
                command = self.clientsock.recv(BUFFER_SIZE)
                parts = command.split()
                data = parts[0]
                contents = ""
                for i in range(2,len(parts)):
                    contents += parts[i]+" "
                    
                if data == "help":
                   self.clientsock.send(available())
                   
                elif data == "list":
                    self.clientsock.send(execute("ls -l"))
                    
                elif data == "time":
                    self.clientsock.send(execute("date | awk '{ print $4 }'"))
                    
                elif data == "cat" or data == "rm" or  data == "pwd":
                    self.clientsock.send(execute(command))
                    
                elif data == "create":
                    present = execute("date | awk '{ print $4 }'")
                    try:
                        fil = open(present+".txt","w")
                        print >> fil, present
                        self.clientsock.send("")
                        fil.close()
                    except IOError:
                        self.clientsock.send("stop")
                    
                    
                elif data == "touch":
                    try:
                        filename = parts[1]
                        fil = open(filename,"w")
                        print >> fil, contents
                        self.clientsock.send("File successfully created")
                        fil.close()
                    except IOError:
                        self.clientsock.send("Unable to create file")
                    
                    
                    
                elif data == "close_session":
                    self.clientsocket.close()
                    break
                
                else :
                    self.clientsock.send(data + ": command not found")
            except :
                pass
            
                
        
        

if __name__== "__main__":
    HOST = 'localhost'
    PORT = 7898
    BUFFER_SIZE = 1024
    ADDR = (HOST, PORT)
    serversocket = socket(AF_INET, SOCK_STREAM)
   
    serversocket.bind(ADDR)
    
    
    while 1:
        serversocket.listen(1)
        print 'waiting for connection...'
        clientsock, addr = serversocket.accept()
        print "connected from:", addr
        obj = run_command(clientsock)
        obj.start()
    serversock.close()
       
        
        
