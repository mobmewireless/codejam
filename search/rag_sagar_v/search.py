#!/usr/bin/env python

__author__ = "Rag Sagar.V"
__email__ = '@'.join(['ragsagar','.'.join([_ for _ in ['gmail','com']])])

import re
import urllib2
import sys

from optparse import OptionParser
from data_extractor import html2text
from database import CreateDb

URL = ["http://mobme.in", "http://mobme.in/products", "http://mobme.in/people", 
	   "http://mobme.in/news", "http://mobme.in/careers", "http://mobme.in/contact",
	   "http://mobme.in/life"]


def populate_index(db):
	""" Populates the database with data from each url in URL."""
	for url in URL:
		print url
		request = urllib2.Request(url)
		try :
			response = urllib2.urlopen(request)
		except urllib2.URLError:
			print "Network Unreachable "
			sys.exit()	
		text = html2text(response.read())
		db.generate_index(text,url)
	

def search_word(word,db):
	""" Searches the database for the given word and returns url and its
	related text if found. if multiple words are given queries the database
	for both words """
	results = {}
	for w in word.split(' '):
		temp = db.search(w)
		for count,url,found_text in temp:
			if results.has_key(url):
				results[url][0] += count
				if results[url][1] == "None":
					results[url][1] = found_text
			else:
				results[url] = [count,found_text]	
	# sort the results according to the occurence
	if results:
		print "Results for '%s'" % word
		for url in sorted(results, key=results.get, reverse=True):
			if results[url][1] != "None":
				print url, " [ ",results[url][1], " ] "
			else:
				print url
	else:
		print "No Results Found."	
		
	

def main():
	""" The main function. Creates db object and parses arguments. According 
	to arguments corresponding functions are called. """
	# Parsing the command line arguments
	parser = OptionParser()
	parser.add_option("-u","--update",action="store_true",dest="update",default=False,help="to index the pages and update database ")
	parser.add_option("-s","--search",dest="word",type="string",default=None,help="search for the given word")
	(options, args) = parser.parse_args()
	db = CreateDb()
	# if update option is selected
	if options.update:
		print "Indexing.."
		db.update_database()
		populate_index(db)
		print "Completed."
	# if search option is selected	
	if options.word:
		if db.has_updated():
			search_word(options.word,db)
		else:
			print "Please update the index before trying to search. To display help \npython search.py --help "
			sys.exit()
		
		


if __name__ == '__main__':
	main()
			
