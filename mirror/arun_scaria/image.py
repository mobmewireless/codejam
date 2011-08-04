#!/usr/bin/python

import math, operator, sys
import urllib2 #for web request for url
from PIL import Image
import ImageChops
import time

def rmsdiff(im1, im2):
    "Calculate the root-mean-square difference between two images"
    diff = ImageChops.difference(im1, im2)
    h = diff.histogram()
    sq = (value*((idx%256)**2) for idx, value in enumerate(h))
    sum_of_squares = sum(sq)
    rms = math.sqrt(sum_of_squares/float(im1.size[0] * im1.size[1]))
    return rms


def download(url):
	file_name = url.split('/')[-1]
	u = urllib2.urlopen(url)
	f = open(file_name, 'w')
	meta = u.info()
	file_size = int(meta.getheaders("Content-Length")[0])
	print "Downloading: %s Bytes: %s" % (file_name, file_size)
	file_size_dl = 0
	block_sz = 4096
	while True:
    		buffer = u.read(block_sz)
    		if not buffer:
        		break
    		file_size_dl += len(buffer)
    		f.write(buffer)
    		status = "%6d K -  [%3.2f%%]" % (file_size_dl, file_size_dl * 100. / file_size)
    		status = status + chr(8)*(len(status)+1)
    		print "   downloaded:",status

	f.close()
	return file_name

messages = [
	"WOW! They are same.",
	"Seems like you got a bit of deviations",
	"Sorry, No match.",
	"Are you kidding? they are completly different",
	"Oh! It looks like you got an ant and elepahant to compare"
	]

if len(sys.argv)!=3:
	print "USAGE ERROR : ",sys.argv[0]," url1 url2 "
	exit(1)

file1 = download(sys.argv[1])
file2 = download(sys.argv[2])
im1 = Image.open(file1)
im2 = Image.open(file2)
time.sleep(1)
comp = rmsdiff(im1,im2)
print "\nSTATUS of comparison :",comp
count = 0
comp = int(comp)
print "RESULT : ",
if comp == 0:
	count = 0
elif comp >0 and comp<20:
	count=1
elif comp >=20 and comp<60:
	count=2
elif comp>=60 and comp<130:
	count=3
else:
	count=4

print messages[count]
exit(0)


#END
	
	



