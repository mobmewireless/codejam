import sys
import random
	
filename = sys.argv[1]

plwords =[]
fr = open(filename, "r")
fw = open("trigans.txt" , "w")


#Regenerating trigram and writing them to file
for line in fr.readlines():
	line = line.strip()
	words = line.split(" ")	
	for word in words:
		if word== '':
			words.remove('')
	now = len(words)
	if now>0:
		words = plwords + words
		now = len(words)
		plwords = words[now-2:now]
		for i in range(0,now-2):
			tri = words[i:i+3]
			wl = str(tri[0]) + " " + str(tri[1]) + " " + str(tri[2]) +"\n"
			fw.write(wl)


fr.close()
fw.close()

fr = open("trigans.txt", "r")
short = ""
count = 0
skipcount =1 
for line in fr.readlines():
	choice =  random.randrange(1,3)
	if choice == 1:
		skipcount = skipcount - 1
		continue
	elif skipcount<=0:
		short = short + line.strip() + " "
		count = count + 3
		skipcount = 4
	
	if count > 200 and count < 297:
		choice = random.randrange(1,3)
		if choice ==1:
			break
		else:
			continue

print short
		
		



