#!/usr/bin/python

from pybloom import BloomFilter

def main():

    bf = BloomFilter(1000000, 0.001) #Creation of bloomfilter

    text = raw_input('Enter the text: ')
    words_list = text.split()

    file = open("./dict")
    for word in file:
        _ = bf.add(word.rstrip())# Add valid words

    for item in words_list: #Checks for invalid words & displays them.
        if item not in bf:
            print 'Spelling error:', item

    file.close()

main()
