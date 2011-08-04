
import os
def savefile(filena,outpu):
		FILE = open(filena, "a",)
		FILE.write(outpu)
		FILE.close
f=os.popen('python gen.py' , 'r')
while True:
	c=str(f.readline())
	savefile(c[0]+".txt",c)
	

