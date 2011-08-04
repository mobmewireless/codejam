#! /usr/bin/env python

import random

str= raw_input("enter a story: " )


list= str.split(' ')

limit = len(list)
end= limit/3 + 1
k=0
i=0

new= [[]for m in range(end)]

while(k<end-1):
    for j in range(0,3):
        new[k].append(list[i])
        i=i+1
    k=k+1
print 'triagrams:'
print new

count= len(new)
wow=[]
val=0
length=0
story=''
k=1

wow.insert(val,new[random.randint(0,count-1)])
val= len(wow)

while(k<count):

	boolean = False

#	for i in range(0,count-1):		
#		if ((wow[k][1]==new[i][0]) and (wow[k][2]==new[i][1])):
#			wow.insert(val,new[k])
#			val= len(wow)
#			boolean= True			
#			k=k+1
#			break

#		i=0

#		if (boolean!=True):
#			if ((wow[k][1]==new[i][0]) or (wow[k][2]==new[i][1])):
#						wow.insert(val,new[k])
#						val= len(wow)
#						boolean= True			
#						k=k+1
#						break

	if (boolean== False):
		wow.insert(val,new[random.randint(0,count)])
		val= len(wow)
		k=k+1
		break


	for i in range(len(new)):
	     for j in range(len(new[i])):
		 length=length+len(new[i][j])


	
	if (length>200):
		break

for i in range(len(wow)):
	story=story+' '+ ' '.join(wow[i])

print story


