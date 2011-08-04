#!/usr/bin/python
import time
import commands

while True:
    for f in range(10):
        code, lines =  commands.getstatusoutput('wc -l %d.txt'% f)
        if code != 0:
            print "File not yet created for %d starting numbers, may be empty"% f
        else:
            print f, "with", lines.split()[0], "lines"
    print
    time.sleep(10)
        
