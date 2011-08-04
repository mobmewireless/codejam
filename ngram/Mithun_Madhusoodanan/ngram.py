import random
file=open("story.txt") #Opened the story file for reading
fil=open("shortversion",'w') #file opened for writing the short version
a=[] # List to store the trigrams
f=file.read() #reading the complete file
m=f.split() #splitting the story into individual words. M contains the list of all words
lenm=len(m) #finding the number of words in the story
for i in range(lenm-2): #loop for traversing till the end of story
	strin=m[i]+" "+m[i+1]+" "+m[i+2]+" " #finding the trigram
	a.append(strin) #adding the trigram to a list

file.close() # closing the file opened for reading the story
randigit=lenm/86 # finding a updating digit to take the trigram for short version
rand=random.randrange(0,100) #finding a digit to start the short version
suitable_random=rand+randigit #finding the random key
for k in range(85): #for loop for the creation of short version
	fil.write(a[suitable_random])#writing the short version to file
	suitable_random=suitable_random+randigit#updating for traversing the entire list of trigrams
	
fil.close() # closing the short version of story's file
