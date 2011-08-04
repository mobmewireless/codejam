#!/usr/bin/python

def main():
    '''Depending on the 'first' digit, the 'number' is stored into the respective file.'''

    while 1:
        number = raw_input() 
        first_digit = int(number)/1000000000
        
        try:
            f = open(str(first_digit) + '.txt', 'a')
            f.write(number + '\n')
        finally:
            f.close()

main()
