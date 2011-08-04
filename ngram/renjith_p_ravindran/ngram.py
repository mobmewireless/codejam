#!/usr/bin/python
#renjithforever@gmail.com | MOBME CODE JAM | NGRAM
"""
Contest ID: ngram
Write a program which first collects all word-level trigrams in a novel-length story. Then, choosing any arbitrary trigram as the starting point, generate a short story which is between 200 to 300 words. The next trigram in the chain must always have the first two words same as that of the previous trigrams last two words.
What is a trigram you ask? The sentence "The quick red fox jumps over the lazy brown dog" has the following trigrams - "The quick red", "quick red fox", "red fox jumps", "fox jumps over", "jumps over the", "over the lazy", "the lazy brown", "lazy brown dog".
"""

import string,random,re

if __name__=='__main__':
	input=open("input.txt",'r')
	input=input.read()
	input=re.sub("\W"," ",input)				# removes all punctuatiouns special chars etc.
	input=string.lower(input)
	
	input =input.split(" ")					# the string is now split into words and put into a python list
	
	inputT=[]
	for index in range(len(input)):				# performs some more cleansing on the input..could have done this with regex though :P
		if input[index]=='':
			continue
		elif len(input[index])==1 and input[index] !='a' and input[index]!='i':
			continue
		inputT.append(input[index])
	input=inputT

	trigram=[]
	i=0
	#trigramify!
	for index in range(len(input)-2):			#every trigram is found linerly
		trigram.append(input[index]+" "+input[index+1]+" "+input[index+2])

	"""
	two more trigrams are added so that the last trigrams seemlessly connect to the first trigram,
	when the trigrams are wrapped to front
	"""
	trigram.append(input[len(input)-2]+" "+input[len(input)-1]+" "+input[0])
	trigram.append(input[len(input)-1]+" "+input[0]+" "+input[1])

		
	position=random.randrange(0,len(trigram) - 1)			#a random psotion to start the story
#	position=len(trigram)-5
	#uncomment the above line to start the story from one of the last trigram and still get a 250 word story...it wraps to the first trigram..

	storyWordCount=0
	story=''
	while storyWordCount <=250:					#average of the range u ppl gave :)
		sentenceLength=random.randrange(4,12)			# choosing a random word lenght for every sentence
		sentence=trigram[position].capitalize()			#capitalizing the first word of the sentence
		sentenceWordCount=len(trigram[position].split(" "))
		i=0	 						#offset to `position` ie.. i th trigram form `position` th trigram 
		while sentenceWordCount <= sentenceLength: 		#adding more and more trigrams untlill sentenceLenght is reached
			i=i+1
			if position + i==len(trigram):			# when the last trigram is reached it is wraped to the first one.
				position=0
				i=0
			nextTrigram=trigram[position + i]
			sentenceWordCount+=len(trigram[position].split(" "))
			sentence+=" "+nextTrigram

		position=position+i+1

		storyWordCount+=len(sentence.split(" "))
		sentence+=". "						#finishing a sentence!
		
		story+=sentence						#adding the finished sentence to the story...
				
	print story
	#print len(story.split(" "))

