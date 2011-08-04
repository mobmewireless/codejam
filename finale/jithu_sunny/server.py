#!/usr/bin/python
from socket import *
import commands, sys, string, time, re

def get_info(input_chunk):
    ''' Extract the parameters from request'''
    mobile_no_match = re.search(r'(?<=mobile_no=)[0-9]+', input_chunk)
    session_id_match = re.search(r'(?<=session_id=).*(?=&mobile)', input_chunk)
    user_input_match = re.search(r'(?<=user_input=)[0-9]+', input_chunk)
    if user_input_match:
        user_input = user_input_match.group()
    else:
        user_input = None
    if mobile_no_match:
        mobile_no = mobile_no_match.group()
    else:
        mobile_no = None
    if session_id_match:
        session_id = session_id_match.group()
    else:
        session_id = None
    return mobile_no, session_id, user_input

host = '127.0.0.1'
port = int(sys.argv[1])
buf = 4092

server = socket(AF_INET, SOCK_STREAM)

server.bind((host, port))
server.listen(1)

print 'Listening...'

client, addr = server.accept()
ip = client.getpeername()[0]
port = client.getpeername()[1]

print 'Connnection with port', port, 'of client with ip', ip, 'established..!'

#Sample request: GET /?session_id=TOX75MCOSP&mobile_no=9876543210&user_input=2HTTP/1.0Host: localhost:6421User-Agent: Python-urllib/1.17

state = '0'
  
while True:
    try:
        try:
            f = open('file' + state, 'r') #Generic menu file reader code that goes on reading submenu's according to the input files
            menu = f.read()
            client.send(menu)

            input_chunk = client.recv(buf).strip()
            
            mobile_no, session_id, user_input = get_info(input_chunk)
            
            if not user_input:
                pass
            elif user_input == 'q':
                sys.exit(0)
            else:
                state += '.' + str(user_input)
        finally:
            f.close()
    except IOError:
        client.send('Invalid choice. File Error. Exiting..!')
        sys.exit(0)

print 'Exiting'
server.close()
