from invariant_algorithm import dynamic_prog , lookup_sorted
from invariant_print_table import print_table




def main_method(number_list):
    
    #checking if all numbers are 4 digit numbers
    if max(number_list) > 9999 or min(number_list) < 1000:
        raise ValueError, "all numbers are not 4 digit numbers"
    
    #dictionary to hold (Iterations:Total count of numbers)
    iter_dict = {}
    
    for number in number_list:
        if number % 1111 != 0 and number!=6174:
            no_of_iter = dynamic_prog(number)
            # putting it into a dictionary
            iter_dict[no_of_iter] = iter_dict.get(no_of_iter,0) + 1

    # when the number is 6174 ,the no of iterations is zero
    iter_dict[0] = 1
    return iter_dict
   

if __name__ == "__main__":
    try:
        iter_dict =  main_method(range(1000,9999))       
        print_table(iter_dict)
        
        
    except ValueError ,e:
        print e
        
