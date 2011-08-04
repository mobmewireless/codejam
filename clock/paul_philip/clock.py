# -*- coding: utf-8 -*-

import random
import sys
import time
from datetime import datetime

HOURS = ['twelve','one','two','three','four','five','six',
         'seven','eight','nine','ten','eleven']
MINUTES = {
  '0':  '',  
  '5':  'five past',
  '10': 'ten past',
  '15': 'quarter past',
  '20': 'twenty past',
  '25': 'twenty-five past',
  '30': 'half past',
  '35': 'twenty-five to',
  '40': 'twenty to',
  '45': 'quarter to',
  '50': 'ten to',
  '55': 'five to',
  '60': ''
}
PREPOSITIONS = {
  '-1': ['almost', 'nearly'],
  '0': ['exactly', 'precisely', 'now', ''],
  '1': ['after', 'about', 'around']
}
roundAbout = 'it’s ’round about midnight.'

SPECIAL_CASES = {
  '23:58': roundAbout,
  '23:59': roundAbout,
  '00:00': 'it’s midnight.',
  '00:01': roundAbout,
  '00:02': roundAbout,
  '12:00': 'it’s noon.'
}

def print_time(hrs,mins,prep):
    if mins==0:
        print "It’s %s o’clock." %(HOURS[hrs])
    else:
        print "Its %s %s %s" %(PREPOSITIONS[str(prep)][random.randrange(0,len(PREPOSITIONS[str(prep)]))],MINUTES[str(mins)],HOURS[hrs])



def system_time():
    local=str(datetime.time(datetime.now()))
    return local[0:5]

def time_conv(tim_word):
    t=time.strptime(tim_word,"%H:%M")
    return t

def main():
    f=0
    if len(sys.argv)==1:
        clock=system_time()
        print clock
        a=time_conv(clock)
    else:
        clock=sys.argv[1]
        print clock
        a=time_conv(clock)
        

    hrs=a.tm_hour
    mins=a.tm_min

    if SPECIAL_CASES.has_key(clock):
        print SPECIAL_CASES[clock]
        sys.exit(0)
    if hrs > 12:
        hrs=hrs-12
    if mins==30 or mins ==0:
        prep=0
    elif mins > 30:
        prep=-1
        hrs=hrs+1
    else:
        prep=1

    k=mins%5
    if k==0:
        mins=mins
    elif k > 2.5:
        mins=int((mins/5)+1)*5
    elif k<2.5:
        mins=int(mins/5)*5
    if mins==60:
        mins=55
    print_time(hrs,mins,prep)

if __name__ == "__main__":
    main()





