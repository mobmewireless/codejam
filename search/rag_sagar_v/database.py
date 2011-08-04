#!/usr/bin/env python

__author__ = "Rag Sagar.V"
__email__ = '@'.join(['ragsagar','.'.join([_ for _ in ['gmail','com']])])

import sqlite3
import os
import re
import string



class CreateDb:
	""" Class that contains methods to instantiate database, populate and search it """
	def __init__(self):
		self.dbfile = os.path.join( os.path.dirname( os.path.realpath( __file__ ) ) ,'data' )
		# Creating database connection
		self.conn = sqlite3.Connection(self.dbfile)
		self.conn.text_factory = str
		# Creating cursor
		self.cursor = self.conn.cursor()
		
	
	def update_database(self):
		""" To delete old index it exists and create new table. """
		if self.has_updated() and os.path.exists(self.dbfile):
			self.cursor.execute("drop table search_index")
		query = "create table search_index (id integer primary key, word text, count integer, url text,found_text text)"
		self.cursor.execute(query)
						
	
	def generate_index(self,text,url):
		""" Generates search index from given text """
		# word_dict will contain a list of its occurence/count and found_text
		words_dict = {} # words_dict[word] = [count,found_text]
		for line in text.split('\n'):
			if line:
				words = re.split(r"[" + string.punctuation + string.whitespace + "]",line.strip())
				for word in words:
					index = line.find(word)
					try:
						found_text = line[index-20:index+20].split()
						if len(found_text[0]) == 1:
							found_text = ' '.join(found_text[1:])
						elif len(found_text[-1]) == 1:
							found_text = ' '.join(found_text[:-1])	
						else:
							found_text = ' '.join(found_text)	
					except IndexError:
						# if the word found is at the top or bottom
						if index < 20:
							found_text = line[index:index+20]		
						else:
							found_text = line[index-20:index]
					word = word.lower()
					if re.match(r"^[" + string.lowercase + "]+$", word):
						if words_dict.has_key(word):
							words_dict[word][0] = words_dict[word][0]+1
						else:
							words_dict[word] = [1, found_text]
		# if NULL is given for primary key column it will auto increment					
		query = "insert into search_index values(NULL,?,?,?,?)"
		for word in sorted(words_dict):
			count = words_dict[word][0]
			found_text = words_dict[word][1]
			self.cursor.execute(query,(word,count,url,found_text))			
		self.conn.commit()
	
		
	def search(self,word):
		""" Searches for the given word in the database and returns a list """
		query = "select count,url,found_text from search_index where word=? order by count desc"
		self.cursor.execute(query,(word.lower(),))
		return self.cursor.fetchall()
	
	def has_updated(self):
		""" To check if the table already exists  """
		status = False
		try:
			self.cursor.execute("select * from search_index")
			status = True
		except :
			pass	
		return 	status
				
	

