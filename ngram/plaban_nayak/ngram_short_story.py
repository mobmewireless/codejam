import random
import copy
class novel:
    """ class novel with attributes trigram list,words and word size"""
    def __init__ (self, trigram_list, words, word_size):
        
        self.trigram_list = trigram_list
        self.words = words
        self.word_size = word_size

class dissociation_press:
    """class to make a dissociation press object which runs dissociation press algorithm on the novel object"""

    def __init__(self, novelObject):

        self.novelObject = copy.copy(novelObject)
        self.dictionary = {}
        self.make_dictionary()

    def make_dictionary(self):
        
        """makes a dictionary to store the trigrams in key value pair
            key is the first two words of the trigram and value is the third word """

        for trigram in self.novelObject.trigram_list:
            a , b ,c = trigram
            # making  key using first two words
            key = (a, b)
            # adding the key and value to dictionary
            if self.dictionary.has_key(key):
                self.dictionary[key].append(c)
            else:
                self.dictionary[key] = [c]


    def generate_short_story(self):
        """generates short story of size 300 words using dissociation press"""

        # randomly selecting the position of first word
        start = random.randrange(0, self.novelObject.word_size-3)
        # extracting the first and second word
        start_word, next_word = self.novelObject.words[start], self.novelObject.words[start+1]
        w1, w2 = start_word, next_word
        #story object to hold the words
        story = []
        # loop to generate 300 words to add to story object
        for i in xrange(300):
            #appending the a word to story
            story.append(w1)
            #picking the next word from the dictionary
            w1, w2 = w2, random.choice(self.dictionary[(w1, w2)])
        #appending the final word
        story.append(w2)
        # all the words in story are separated by space and returned
        return ' '.join(story)

def generate_novel_object(fileObject):
    """ function to create novel object .The trigram list is created here .While creating trigrams
    punctuations are retained and trigrams span lines and paragraphs"""

    # reading the whole data from file
    contents = fileObject.read()
    # spliting the contents at blankspaces to make words , punctuations are kept intact
    words = contents.split()
    # generating the trigram list
    trigram_list = []
    for i in range(0,len(words)-2):
        trigram = []
        # generating a particular trigram
        for j in range(i,i+3):
            trigram.append(words[j])
            #append the trigram to the list        
            trigram_list.append(trigram)
                

    # creating novel object 
    novelObject = novel(trigram_list,words,len(words))
    # returning novel object
    return novelObject


def main_method():
    """this method runs when the module is executed and all tasks start here"""
    #opening novel file for reading data 
    fil = open("christmas_carol.txt","r")
    #generating a novel object from the contents of the file
    novelObject = generate_novel_object(fil)
    # creating a dissociation press class to run the  dissociation press algorithm on the novel object
    chain = dissociation_press(novelObject)
    #calling function to generate story and print 
    print chain.generate_short_story()

    

if __name__ == "__main__":
    # if the namespace here is main then run the main method
    main_method()
    
    

        
    

    
