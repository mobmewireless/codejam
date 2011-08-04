import random
import sys
while 1:
    number = random.randint(0,9999999999)
    #Add leading zeros to numbers less than 10 digits and display it
    sys.stdout.write( str( '%0*d' %( 10, number) ) )
    sys.stdout.write('\n')    
