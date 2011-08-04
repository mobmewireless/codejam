#Function to plot graph. A Dictionary is passed.
def graph(dic):
	import pylab as p
	fig = p.figure()
	fig.set_label('Frequency Distribution')
	ax1 = fig.add_subplot(1,1,1)
	x = []
	y = []
	for element in dic:
		x.append(element)
		y.append(dic[element])
	ax1.bar(x,y, facecolor='red')
	ax1.set_ylabel('Number of Numbers')
	ax1.set_xlabel('Iteration Count')
	p.show()


distrib = {}
for i in range(1000,9999):
	count = 0
	num = i
	tmp = num
	digits =[]

	#Extracting Digits
	while tmp>0:
		digits.append(tmp%10)
		tmp= tmp/10

	#Checking for unique digits and exiting
	if len(set(digits)) == 1:
		continue

	#Loop for iterations
	while num!= 6174:
		#Adding zeros to make number 4 digit
		while len(digits)<4:
			digits.append(0)
		
		#Calculation of larger and smaller number from given digits
		ln=0
		sn =0		
		digits.sort()
		for digit in digits:
			sn= sn * 10 + digit
		digits.reverse()
		for digit in digits:
			ln = ln * 10 + digit
		
		num = ln -sn
		count = count +1
		
		#Extraction of digits. Optimized to avoid duplicate processing on same number.
		tmp = num
		digits = []
		while tmp>0:
			digits.append(tmp % 10)
			tmp = tmp/10

	#Adding Entry to dictionary. Since number of iteration is not known at first. Using dictionary is the best approach. Can add entries as we want
	try:
		distrib[count] = distrib[count] + 1
	except KeyError:
		distrib[count] = 1

#Output
print "Iteration\t\tTotal Count of Numbers" 
for entry in distrib:
	print "%d\t\t\t%d" % (entry,distrib[entry])
graph(distrib)




