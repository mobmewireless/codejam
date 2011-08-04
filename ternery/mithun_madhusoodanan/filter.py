i=1
count=0
while i==1:
	try:
		file=open('random.txt','r')#opening the file
	except IOError:
		print 'run generator.py before running filter.py'
		break
	else:
		numb=file.readlines()#reading the numbers from file
		if count==len(numb):
			break
		for m in range(count,len(numb)):
			num=numb[count]
			
			number=int(num[0]) #finding the 1st digit
			#if condition finds the respective file to put the 10 digit number
			if number==1:
				digi=open('1.txt','a')
				digi.write(num)
				file.close()
				count=count+1
			if number==2:
				digi=open('2.txt','a')
				digi.write(num)
				file.close()
				count=count+1
			if number==3:
				digi=open('3.txt','a')
				digi.write(num)
				file.close()
				count=count+1
			if number==4:
				digi=open('4.txt','a')
				digi.write(num)
				file.close()
				count=count+1
			if number==5:
				digi=open('5.txt','a')
				digi.write(num)
				file.close()
				count=count+1
			if number==6:
				digi=open('6.txt','a')
				digi.write(num)
				file.close()
				count=count+1
			if number==7:
				digi=open('7.txt','a')
				digi.write(num)
				file.close()
				count=count+1
			if number==8:
				digi=open('8.txt','a')
				digi.write(num)
				file.close()
				count=count+1
			if number==9:
				digi=open('9.txt','a')
				digi.write(num)
				file.close()
				count=count+1

