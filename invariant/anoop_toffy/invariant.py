#!/usr/bin/python

'''		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		%    Copyright (C) 2011         CODEJAM					   %	
		%									   %
		%	Author : Anoop Toffy <anoop.toffy90@gmail.com>			   %
		%									   %
		%    This program is free software: you can redistribute it and/or modify  %
		%    it under the terms of the GNU General Public License as published by  %
		%    the Free Software Foundation, either version 3 of the License, or     %
		%    (at your option) any later version.				   %
		%									   %
		%    This program is distributed in the hope that it will be useful,       %
		%    but WITHOUT ANY WARRANTY; without even the implied warranty of        %
		%    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         %
		%    GNU General Public License for more details.              		   %
		%									   %
		%    You should have received a copy of the GNU General Public License     %
		%    along with this program.  If not, see <http://www.gnu.org/licenses/>. %
		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 	'''

from pychart import *
theme.get_options() # To change the default theme of pychart .
theme.output_file = "graph.png" #The graph developed by this code is saved to graph.png in the same folder. Open to view it .
theme.reinitialize()	# reinitialze the pychart theme .

def rev(x):  #To find the reverse of a number
        result=0
        i=0
        while x/10 > 0:
                result = (result * 10) + (x % 10)
                x = x/10
        result = (result * 10) + (x % 10)
        return result
        
def main():
	''' Program Starts here'''
	i = 1000 # Range to start with
	final = [] # stores the final list of selected numbers
	sort = [] # stores the list of invariants
	freq = [] # stores the freqency of iterations
	chart = [] # holds data for chart
	while i <= 9998:	# checking for the particular 4 digit number
		l = []
		li = []
		lis = []
		j = 0
		num = rev(i)
		while j < 4:
			rem = num%10
			l.append(rem)
			num/=10
			j = j + 1
		li.append(l.count(0))
		li.append(l.count(1))
		li.append(l.count(2))
		li.append(l.count(3))
		li.append(l.count(4))
		li.append(l.count(5))
		li.append(l.count(6))
		li.append(l.count(7))
		li.append(l.count(8))
		li.append(l.count(9))		

		lis.append(li.count(0))
		lis.append(li.count(1))
		lis.append(li.count(2))
		lis.append(li.count(3))
		lis.append(li.count(4))
		if lis[0] != 9 :
			final.append(i)
#		print lis
		i = i + 1					
		
#	print final	# Uncomment to get the list of particular 4 digit numbers
	count = len(final)
#	print count
	i = 0
	while i < count: # Next loop calculate the iteration to get 6174
		c = 0
		r = 0
		num = []
		no = final[i]
		dup = no
		j = 0
		while j < 4 :
			r = no%10
			num.append(r)
			j = j+1		
			no = no/10										
		
		while 1  :
			s = 0
			num_rev = []
			num.sort()
			j = 3
			while j >= 0:
				num_rev.append(num[j])
				j = j - 1  
			j = 0
			m = 0 			#second number
			while j < 4:
				m = m*10 + num[j]
				j = j + 1		
			j = 0
			n = 0
			while j < 4:
				n = n*10 +num_rev[j]
				j = j + 1
#			print n		#first number		
#			print m		#second number			
			if n > m:
				s = n-m
			else:
				s = m-n
			c = c + 1
			if s == 6174:
				break
			r = 0
			j = 0
			num = []
			if s < 1000 :
				while j < 3:
					r = s%10
					num.append(r)
					j = j+1		
					s = s/10
				num.append(0)
			else :
				while j < 4 :
					r = s%10
					num.append(r)
					j = j+1		
					s = s/10
#		print dup," ",c # Uncomment for testing each numbers iteration taken
		sort.append(dup)
		freq.append(c)
		i = i + 1
#	print freq	#uncomment to see the obtained frequencies
	
#	print freq.count(0)," ",freq.count(1)," ",freq.count(2)," ",freq.count(3)," ",freq.count(4)," ",freq.count(5)," ",freq.count(6)," ",freq.count(7)," ",freq.count(8)," ",freq.count(9) 
							#uncomment to see count of each frequencies
	j = 0
	z = 0
	while j < 10: # Sorting the data for making chart.
		tlist = []
		tlist.append(j)
		z = freq.count(j)
		tlist.append(z)
		chart.append(tlist)	
		j = j+1
	print "			CODEJAM		"
	print "		contest_id : invariants "
	print ""
	print "       Frequency Distribution Table"
	print "     --------------------------------"
	print "    Iteration  -  Total count of numbers"
	print " 	0 ","	- 	",freq.count(0)
	print " 	1 "," 	-	",freq.count(1)
	print " 	2 "," 	-	",freq.count(2)
	print " 	3 "," 	-	",freq.count(3)
	print " 	4 "," 	- 	",freq.count(4)
	print " 	5 "," 	-	",freq.count(5)
	print " 	6 "," 	- 	",freq.count(6)
	print " 	7 "," 	- 	",freq.count(7)
	print " 	8 "," 	- 	",freq.count(8)
	print " 	9 "," 	- 	",freq.count(9)
	print " NOTE :The Graph corresponding to the frequency table" 
	print " can be seen in the same folder in the name graph.png"
	print ""
	ar = area.T(x_coord = category_coord.T(chart, 0),
            y_range = (0, None),
            x_axis = axis.X(label = "Iteration"),
            y_axis = axis.Y(label = "Count(In Numbers)"),legend = legend.T())
	ar.add_plot(bar_plot.T(label= "Frequency",data = chart,data_label_format="/8{}%d"))
	ar.draw()
	
main() 			# Program End . Execution Starts here 

			#### HAPPY HACKING #####
