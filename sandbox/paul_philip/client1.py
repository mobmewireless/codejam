import socket
import sys
import threading
import time
prev_timer=float()
datain=str()
test=True
class ConnectionThread ( threading.Thread ):
    def run ( self ):
        global datain
      # Connect to the server:
        client = socket.socket ( socket.AF_INET, socket.SOCK_STREAM )
        client.connect ( ( 'localhost', 9990 ) )
        client.send (str(datain))
        received = client.recv(2048)
        if datain!='create':
            print ">> %s" % received
        # Close the connection
        client.close()

print "q or Q to quit"
print "readme.txt for more details"
prev_timer=time.time()
while test:
    print "enter command"
    data =raw_input()
    datain=data
    if data=='q' or data=='Q':
        datain='q'
        test=False
        ConnectionThread().start()
    else:
        ConnectionThread().start()

    if (time.time() - prev_timer) > 60.0:
        prev_timer=time.time()
        datain='create'
        ConnectionThread().start()

print "exiting"

