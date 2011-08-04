import time
import random
def approx(minute,mid):
    """ returns the string that is to be prefixed to the time and it choosed randomly among the available options"""

    near =  ["nearly ","almost "]
    exact = ["exactly ","precisely ","now ",""]
    after = ["after ","about ","around "]
    
    
    
    if minute == mid:
        return random.choice(exact)
    elif minute < mid:
        
        return random.choice(near)
    else:
        return random.choice(after)
    

def fuzzy_clock(hour,minute):
    """ This function returns fuzzy time in string format """
    
    prefix = [ "five","ten", "quarter", "twenty", "twenty-five", "half" ]
    position = [ " past ", " to " ]
    hours  = { 0: "midnight", 1: "one", 2: "two", 3: "three", 4: "four", 5: "five", 6: "six", 7: "seven",\
                      8: "eight", 9: "nine", 10: "ten", 11: "eleven", 12: "noon"}

    # string to contain fuzzy time
    fuzzy_time = ""
    
    
    if 0 <= minute < 3:

        fuzzy_time = approx(minute,0)        
        fuzzy_time += str(hour) + " o' clock"
        return fuzzy_time
    
    elif 3 <= minute < 8:
        fuzzy_time = approx(minute,5)          
        fuzzy_time += prefix[0] + position[0]
            
    elif 8 <= minute < 13:
        fuzzy_time = approx(minute,10)  
        fuzzy_time  += prefix[1] + position[0]

    elif 13 <= minute < 18:
        fuzzy_time = approx(minute,15)              
        fuzzy_time  += prefix[2] + position[0]
            
    elif 18 <= minute < 23:
        fuzzy_time = approx(minute,20)
        fuzzy_time += prefix [3] + position[0]
            
    elif 23 <= minute < 28:
        fuzzy_time = approx(minute,25)  
        fuzzy_time  += prefix [4] + position[0]

    elif 28 <= minute < 33:
        fuzzy_time = approx(minute,30)       
        fuzzy_time += prefix [5] + position[0]

    elif 33 <= minute < 38:
        fuzzy_time = approx(minute,35)
        fuzzy_time  += prefix[4] + position[1]

    elif 38 <= minute < 43:
        fuzzy_time = approx(minute,40)        
        fuzzy_time += prefix[3] + position[1]
            
    elif 43 <= minute < 48:
        fuzzy_time = approx(minute,45)  
        fuzzy_time += prefix[2] + position[1]
        
    elif 48 <= minute < 53:
        fuzzy_time = approx(minute,50)  
        fuzzy_time += prefix[1] + position[1]
        
    elif 53 <= minute < 58:
        fuzzy_time = approx(minute,55)          
        fuzzy_time += prefix[0] + position[1]
    else :
        fuzzy_time = approx(minute,60)  
        fuzzy_time += str(hour+1) + " o' clock"
        return fuzzy_time
    

       
    if minute >= 33:
	    fuzzy_time += hours[hour + 1]
    else:
	    fuzzy_time += hours[ hour ]

    return fuzzy_time

def main_method():
    """function to display time with fuzziness , 12 hour format is followed"""
    # at these minutes call is made to fuzzy_clock function
    calltime = [0 ,1, 3, 5,6, 8, 10,11,13,15,16,18,20,21,23,25,26,28,30,31,33,35,36,38,40,41,43,45,46,48,50,51,53,55,56,58]
    
    called = False
    
    while True:
        # present time
        present = time.localtime()
        
        minute = int(present[4])
        
        hour = int(present[3])
        if hour == 24:
            hour = 0
        elif hour == 12:
            hour = 12
        else:
            hour = hour % 12
        if called == False:
            print "It's ",fuzzy_clock(hour,minute),"."
            called = True
        elif minute in calltime:
            print "It's ",fuzzy_clock(hour,minute),"."

        # sleeps until next minute   
        time.sleep(60-int(time.localtime()[5]))
        
        
            
            


if __name__ == "__main__":
	main_method()
