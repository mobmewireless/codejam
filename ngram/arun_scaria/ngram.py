#!/usr/bin/python

import sys
import urllib2 #for web request for url
import random #get random

if len(sys.argv)==2:
	response = urllib2.urlopen(sys.argv[1])
else:
	response = urllib2.urlopen("http://www.gutenberg.org/cache/epub/16855/pg16855.txt")
html = response.read()
html=html.rstrip().lstrip().replace("\n"," ").replace("\t"," ").replace("\r"," ").replace("  "," ")
ht=html.split(' ')
ht=filter(None, ht)
len_ht=len(ht)

index = random.randrange(1,(len_ht-1)/2)
first = ht[index]
second = ht[index+1]
third = ht[index+2]
index=index+3

print first,second,third,

i=0
while i<250:
    first=second
    second=third
    third=ht[index]
    print first,second,third,
    index+=1
    if index>len_ht:
        break
    i+=1
    if i%26==0:
	print "\n\t\t\t",
    

print ""
print "\n*** THE END ***\n"

