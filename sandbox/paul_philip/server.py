import SocketServer
import os
import sys
import random
from datetime import datetime
from string import split
cmd=str()
gen=list()
def generate(t):
    global gen
    try:
            gen.index(t)
            return False
    except ValueError:
            return True

class MyTCPHandler(SocketServer.BaseRequestHandler):
    """
    The RequestHandler class for our server.

    It is instantiated once per connection to the server, and must
    override the handle() method to implement communication to the
    client.
    """

    def handle(self):
        global cmd
        # self.request is the TCP socket connected to the client
        self.data = self.request.recv(1024).strip()
        print "%s wrote:" % self.client_address[0]
        print self.data
        data=split(self.data)
        if data[0]=="list":
                cmd=os.listdir(os.getcwd())
        elif data[0]=="pwd":
                cmd=os.getcwd()
        elif data[0]=="cat":
                try:
                        fil = open(data[1],"r")
                        cmd=str(fil.readlines())
                        fil.close()
                except IOError:
                        cmd="The file does not exist"
        elif data[0]=="rm":
                try:       
                        os.remove(data[1])
                        cmd="file deletion successful"
                except OSError:
                        cmd="file deletion failed"
        elif data[0]=="touch":
                try:
                        fil = open(data[1],"w")
                        for a in data[2:]:
                            fil.write(a+" ")
                        cmd="file succesfully created"
                        fil.close()
                except IOError:
                        cmd="The creation of file failed"
        elif data[0]=="time":
                cmd=str(datetime.time(datetime.now()))
        elif data[0]=="create":
                try:
                        create=random.randrange(0,9999)
                        if generate(create):
                                create=random.randrange(0,9999)
                        s="file"+str(create)+".txt"                                                
                        fil = open(s,"w")
                        fil.writelines(str(datetime.time(datetime.now())))
                        cmd="file succesfully created"
                        fil.close()
                except IOError:
                        cmd="The creation of file failed"
        
        print str(cmd)
        self.request.send(str(cmd))

if __name__ == "__main__":
    HOST, PORT = "localhost", 9990

    server = SocketServer.TCPServer((HOST, PORT), MyTCPHandler)

    # Activate the server; this will keep running until you
    # interrupt the program with Ctrl-C
    server.serve_forever()
