#!/usr/bin/env python

import string
import sys


def get_words(filename="dictfile"):
	"""Extract words from the given dictionary filename and returns it as list ."""
	fileobj = open(filename)
	data = fileobj.read()
	return data.split()



words_dict = get_words("dictfile")
alphabets = string.ascii_lowercase

def get_possible_words(word):
	""" Returns the word after doing splitting, replacing, insertion and deletion
	on it and returns the list of possible corrections """
	# To split word into different combination of tuples
	splitted_list = []
	for i in range(len(word) + 1):
		splitted_list.append((word[:i], word[i:]))
	# To check if the error is because of transposing of letters in word we making all combinations
	transposed_list = []
	for first_part, second_part in splitted_list:
		if len(second_part)>1 :
			transposed_list.append(first_part + second_part[1] + second_part[0] + second_part[2:])  
	# To check if the error is due to the missing of any letter
	deleted_list = []
	for first_part, second_part in splitted_list:
		if second_part:
			deleted_list.append(first_part + second_part[1:])
	# To check if any letter got replaced and check if any unwanted letter got inserted between it
	replaced_list = []
	inserted_list = []
	for first_part, second_part in splitted_list:
		for alphabet in alphabets:
			inserted_list.append(first_part + alphabet + second_part)
			if second_part:
				replaced_list.append(first_part + alphabet + second_part[1:])
	return set(transposed_list + deleted_list + replaced_list + inserted_list)

def get_less_possible(word):
	""" To make take every word returning from get_possible_words and make another
	possible word list using them. To check if the word has 2 letter errors """
	results = []
	for w1 in get_possible_words(word):
		for w2 in get_possible_words(w1):
			if w2 in words_dict:
				results.append(w2)
	return set(results)	
	
def if_exists(words):
	""" To check if any of the word in the list exists in the dictionary and return them """
	existing_words = []
	for word in words:
		if word in words_dict:
			existing_words.append(word)
	return set(existing_words)

def get_correct_word(word):
    suggestions = if_exists([word]) or if_exists(get_possible_words(word)) or get_less_possible(word) or [word]
    for word in suggestions:
		print word

if __name__ == '__main__':
	if len(sys.argv) > 1:
		word = sys.argv[1]
		get_correct_word(word)
	else:
		print "Usage python %s <word> " % sys.argv[0]
		sys.exit()
