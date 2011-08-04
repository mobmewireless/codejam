#!/usr/bin/env python

__author__ = "Rag Sagar.V"
__email__ = '@'.join(['ragsagar','.'.join([_ for _ in ['gmail','com']])])

import random, os, sys

def get_words(filename):
	""" Get the words list from given file """
	f = open(filename,"rb")
	content = f.read()
	words = content.split()
	f.close()
	return words
	
	
def make_trigram(words):
	""" Makes trigrams from the given list of words """
	no_of_words = len(words)
	if no_of_words < 3:
		return
	for i in range(no_of_words-2):
		yield(words[i], words[i+1], words[i+2])
		

def generate_shortstory(words,trigrams,length=250):
	""" Generates a short story (without any semantic meaning) from the given set of words and trigrams from novel """
	transitions = {}
	shortstory_words = []
	no_of_words = len(words)
	for first_word, second_word, third_word in trigrams:   # loop to generate a transition table
		present_state = (first_word, second_word)
		if present_state in transitions:
			transitions[present_state].append(third_word)  # more than one transitions to next state from present state
		else:
			transitions[present_state] = [third_word] 
	random_number = random.randint(0,no_of_words-3)
	first_word, second_word = words[random_number], words[random_number+1]
	for _ in xrange(length):    								# loop to select 'length' number of words for story
		shortstory_words.append(first_word)
		present_state = (first_word, second_word)
		first_word, second_word = second_word, random.choice(transitions[present_state]) # selecting one if the list length is greater than one
	shortstory = ' '.join(shortstory_words)
	return shortstory
	
	
if len(sys.argv) == 2:
	filename = sys.argv[1]
else:
	filename = 'novel.txt'
words = get_words(filename)
trigrams = make_trigram(words)
story = generate_shortstory(words,trigrams,250)
print story.capitalize()
