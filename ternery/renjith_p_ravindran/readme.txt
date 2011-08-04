DESIGN:
The number generator uses recursion to generate number.
I suppose 00000001,000000002 etc are the numbers you are looking for and not 1,2,3 etc.

a python list hold 10 items.[0,0,0,0,0,0,0,0,0,0,0] to support upto 10 digit numbers.
Generating 10 digit numbers will take hours therefore the default length given is 6.
Change value of var `length` as per need,upto 10

in a for loop the last item in the list is incremented.
eg:
[0,0,0,0,0,0,0,0,0,0,1]
[0,0,0,0,0,0,0,0,0,0,2]etc

when the last item becomes 9, it is reset to 0 and the second last item is incremented once(recursion is used)
eg:
[0,0,0,0,0,0,0,0,0,0,9]
[0,0,0,0,0,0,0,0,0,1,0]

this carries on to produce all the numbers.

All numbers generated are given to Sorter, that sorts out and writes to respective file as per requiremnet.

The watcher shows the count on each file every second.
-----------------------------------------------------------------------

DEPENDENCIES:
mainly uses time,os,sytem,socket python modules. All three files should run on windows too. I tested this only in gnu/Linux.

----------------------------------------------------------------------

USAGE:
run order-
	producer.py
	sorter.py
	watcher.py
watcher will create 10 file 0.txt,1.txt etc.
----------------------------------------------------------------------

