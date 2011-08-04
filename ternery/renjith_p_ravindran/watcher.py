#!/usr/bin/python
#watcher.py
#renjithforever@gmail.com
"""
mobme codejam : Ternery
-----------------------
WATCHER:

shows the number of numbers in files 1.txt, 2.txt etc every second.
"""

import time
import os
import sys

count_0=0
count_9=0

if __name__=='__main__':
	while True:
		time.sleep(1)
		os.system("clear")
		print "---------------------WATCHER------------------------"
		print "Shows the count of numbers in each file every second"
		print "____________________________________________________"
		for i in range(10):
			filename=str(i)+".txt"
			file=open(filename,"r")
			numbers=file.read()
			numbers=numbers.split("\n")
			count=len(numbers)-1
			sys.stdout.write( str(i)+".txt: "+str(count)+"\n")
			print "____________________________________________________"
			if i==0:	
				count_0=count
			elif i==9:
				count_9=count

			if count_0==count_9 and count_9!=0:			#method to check when `Sorter` has finished its job.
				sys.exit("done!")
	
	
