#!/usr/bin/python
import random

try:
    while True:
        rnd = random.random()
        if rnd==0.0:
            continue
        x = str(int(rnd*(10**10)))
        print x.zfill(10)
except KeyboardInterrupt:
    print "0000000000" 

