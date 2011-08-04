import random
import time
#Function to generate random number with n digits
def random_with_N_digits(n):
	#Generating a random numnber between zero and maximum number which can be formed with n digits
	range_start = 0
	range_end = (10**n)-1
	num = str(random.randint(range_start, range_end))

	#Calculating length and adding zeros at the front if the length of the number is less than n
	length = len(num)
	if length < n:
		num = "0" * (n - length) + num
	num = num
	return num

#Infinite Loop which prints the numbers
while 1:
	print random_with_N_digits(10)

