import random
import re

file_words = []
trigrams = []
story = []

#reading from file
fil = open('input.txt','r')
file_read = fil.read()
file_words = re.findall(r'\w+,?\.?\'?\w*', file_read,re.I)
fil.close()

# generate trigrams
for i in range(0,(len(file_words) - 3)):
    trigrams.append( [file_words[i], file_words[i + 1], file_words[i + 2]] )
    
arbitrary_trigram = random.randint(0,len(trigrams))

# loading the arbitrary trigram as the starting of the short story
story.append(trigrams[arbitrary_trigram][0])
story.append(trigrams[arbitrary_trigram][1])
story.append(trigrams[arbitrary_trigram][2])

while(len(story) < 300):
    i = 0
    while (i < (len(file_words)-3)):
        # checking the condition of trigrams to add to the short story
        if(story[-2] == trigrams[i][0] and story[-1] == trigrams[i][1]):
            print "Story of %d words generated"%len(story)
            story.append(trigrams[i][2])
            i = i + 1            
        if(len(story) >= 300):
            break
        i = i + 1

story = ' '.join(story)
story = story.split('. ')

print "\n\n\n\t SHORT STORY \n\n\n"
# Arranging the short story in paragraph format
for i in range(1,len(story)):
    if((i%3) == 0):
        print "\n"
    print story[i]+'. ',
