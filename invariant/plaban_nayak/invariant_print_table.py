def print_table(iter_dict):
    """Prints the dictionary containing no of iterations and count of numbers"""
    print "The frequency distribution table \n\n"
    if not iter_dict:
        raise ValueError,"There is no element in dictionary to print"

    print "Iterations".rjust(15), "Total Count of Numbers".rjust(35)
    for key in iter_dict.keys():
        print "%10d%30d" %(key,iter_dict[key])

