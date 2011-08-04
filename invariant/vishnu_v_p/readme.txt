				Contest ID: invariant
1.DESIGN

The problem is to find the frequency distribution of numbers which when applied a transformation yields 6174. The transformation is as follows:Take a four digit number which has at least 2 different digits like 2221 or 1234, but not 4444 or 2222.Arrange the digits first in descending order to get another 4 digit number and then in ascending order to get one more four digit number. Add leading zeroes if necessary. Subtract smaller number from the larger number. Repeat the process till the difference is 6174. The problem is implemented in C, and it prints the frequency distribution table with count value and frequency as columns.
	
2. DEPENDENCIES

	2.1 Requires gcc(version 4.5.2) 

		
3. USAGE

	Compile the source file using gcc: $gcc invariant.c -o invariant
	Execute the code in  a terminal: $./invariant
		

	

	
