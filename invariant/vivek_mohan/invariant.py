import os 
import string 
import sys 
i=1 
j=1000 
a=[0]*10 
def itera_v(x):
	z=0
	itr=0
	org=x
	while (z!=6174): 
		itr+=1
		jd=[(i)for i in x]
		jd.sort()
		s= ''.join(jd)
		jd.reverse()		
		ds= ''.join(jd)
		z=abs(int(s)-int(ds))
		x=(str(z)).rjust(4,'0')
	stri= str(org)+" Required "+str(itr)+" number of Iteration" 
	savefl("itration",stri)# or print stri
	savetbl(int(itr))
def savetbl(it):
	a[it]+=1
def savefl(fil,data):
        FILE = open(fil, "a")
        FILE.writelines(data + '\n')
        FILE.close 
total=0
for c in xrange(9):
        i=i+1110
	
        for k in range(j,i):
                st=str(k)
                itera_v(st)
		total+=1
        j=k+2
        i=j
print "Total Numbers Generated", total
print "Iterations           Total Count of Numbers\n==============         ====================="

for count in range(0,10):
	print str(count)+"                                  "+str(a[count])
	if sum(a)==total:
		break


