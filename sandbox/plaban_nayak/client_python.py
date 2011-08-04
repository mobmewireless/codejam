from socket import *
import sys
import threading
import commands
import time


class background(threading.Thread):
    """Runs the filecreate task"""
    def __init__ (self,ADDR):
        threading.Thread.__init__(self)
        self.ADDR=ADDR
        
    def run(self):
        clientsock = socket(AF_INET, SOCK_STREAM)
        #connecting to server
        try:
            clientsock.connect(self.ADDR)
        except :
            print "Server refusing connection..."
            sys.exit(1)
        while True:
            clientsock.send("create")
            if clientsock.recv(1024) == "stop":
                print "unable to create file"
                break
            
            time.sleep(60)
        
        
        
        
        
if __name__== "__main__":
    #variables
    HOST = 'localhost'
    PORT = 7898
    BUFFER_SIZE = 1024000
    ADDR = (HOST, PORT)
    
    print "Attempting connection to server"
    #creating socket
    clientsock = socket(AF_INET, SOCK_STREAM)
    #connecting to server
    try:
        clientsock.connect(ADDR)
    except :
        print "Server refusing connection..."
        sys.exit(1)
    
    print "connected"
    
    # details about the client shell
    
    print "Prompt is -> . Start entering command"
    print """Enter "help" to see list of commands"""
    print "Enter 'create' to create files with server time in background"
    print "Enter Ctrl-C to end session"
    
    
    
    #starting input of command
    while 1:
        try:
            data = raw_input("-> ")
            if data == "create":
                obj = background(ADDR)
                obj.start()
            else:
                clientsock.send(data)
                recieve = clientsock.recv(BUFFER_SIZE)
                print recieve
        except KeyboardInterrupt :
            print "\nEnding session .Bye"
            clientsock.send("close_session")
            break
        
       
    clientsock.close()
    sys.exit(1)
    
        
        
