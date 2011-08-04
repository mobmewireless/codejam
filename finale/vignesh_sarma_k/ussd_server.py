from BaseHTTPServer import BaseHTTPRequestHandler
import SocketServer,re
from urlparse import parse_qs
import threading

options=[]  #the stores the current options
session_dict={} #all the sesion object
acc=True

class SerstoperThread(threading.Thread):
	def __init__(self):
		super(SerstoperThread, self).__init__()

	def run ( self ):
		global acc
		while raw_input('>>')!='q':pass
		acc=False

class USSDHttpServer(BaseHTTPRequestHandler):
	""" The ussd server that handles the requests"""
	def do_GET(self):
		"""All requests comes to this function"""
		global options
		global session_dict
		self.send_response(200) ##successfull httprequest
		
		self.send_header('Content-type','text')
		self.end_headers()
		
		parm=parse_qs(self.path[2:])
		
		options=[]
		if parm['session_id'][0] in session_dict.keys():
			options=session_dict[parm['session_id'][0]]
		
		if 'user_input' in parm and options :
			index=int(parm['user_input'][0])-1
			print options,options[index]
			if len(options[index])==3:
				f=open(options[index][2],'r')
			print f
			
		else:
			f=open("start",'r')
			
		for each in f:
			print each
			mat = re.search(r'(\d+)\S\s((\w+\s)*)',each)
			temp=[]
			if mat:
				temp.append(mat.group(1))
				temp.append(mat.group(2))
				self.wfile.write(temp[0]+" " + temp[1]+"\n")
			mat = re.search(r'<(\w*)>',each)
			if mat:
				temp.append(mat.group(1))
			options.append(temp)
		print options
		session_dict[parm['session_id'][0]]=options
		
		
def main():
	PORT = 8000
	httpd = SocketServer.TCPServer(("", PORT), USSDHttpServer)
	print 'started'
	#httpd.serve_forever()
	thre=SerstoperThread().start()
	while acc:
		httpd.handle_request()
	
if __name__=="__main__":
	main()
	
