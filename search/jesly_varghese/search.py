import os
import sys
import re
import string
import urllib2
import urlparse

ToCrawl = []        #Stack for links to crawl
Crawled = []		  #Stack of links already crawled
Results = []			  #this is were results get stored




Search_Type = "AND"         #global variable to determine what type of search is to be done, an OR search or AND search

LinkGrammar = re.compile("<a\s*href=['|\"](.*?)['\"].*?>") #grammar for hyperlinks

def crawler(BaseLink,Query): #the crawler
	ToCrawl.append(BaseLink) #start the list with base link
	while(1): #the loop will break on ToCrawl list getting empty
		try:
			Crawling = ToCrawl.pop() #get link to crawl on
			print 'Crawling at link:',str(Crawling)
		except:
			break
		try:
			ToCrawl.remove(Crawling) #remove all redundancies
		except:
			print 'All instances removed'	
		if Crawled.count(Crawling)>0:
			print 'Multiple instances found!' #forces not to perform any reduntant crawling
			continue	
		URL = urlparse.urlparse(Crawling)
		if not(URL[1]=='mobme.in'): #restrict crawling only to 
			Crawled.append(Crawling) #add the crawling element to list of already crawled links
			continue
		try:
			Response = urllib2.urlopen(Crawling) #open the link
		except:
			continue
		Crawled.append(Crawling)
		if(Crawling.lower().endswith("pdf") or Crawling.lower().endswith("png") or Crawling.lower().endswith("jpg")):
			Crawled.append(Crawling) #restrict crawling to pdf and image docs
			continue
		Content = Response.read() #read the data there
		Links = LinkGrammar.findall(Content) #grammar for getting links,  from one link recursively goto another
		theSearch(Query,Search_Type,Content,Crawling) #perform search on the contents
		for Link in (Links.pop(0) for _ in xrange(len(Links))): #add links for recursve crawling
			if Link.startswith('/'):
				Link = 'http://' + URL[1] + Link
			elif Link.startswith('#'):
				Link = 'http://' + URL[1] + URL[2] + Link
			elif not Link.startswith('http'):
				Link = 'http://' + URL[1] + '/' + Link
			if Link not in Crawled:
				ToCrawl.append(Link)

					
#parseString parses the search query
#groups queries in quote to single query
def parseString(SearchQuery):
	Items = [] #the list of items to be searched
	Buffer = ""
	Inquote = 0 #Inquote is used to represent starting  and ending of quoe
	
	CharList = SearchQuery.strip() #get indviduval characters in search query
	
	for Char in CharList:
		if Char == "\"":
			if Inquote == 0:
				Inquote =1
			else:
				Inquote = 0
				Items.append(Buffer)
		if Char.isspace() or Char=="+": #Adding the parsed strings to Search list, seperators + and white space
			if Inquote == 0:            #checking if the quote syntax is correct, ie if all quotes have been properly been ended
				if len(Buffer)>0:       #checking if the buffer got something in it. If so append it to search list
					Items.append(Buffer)	
					Buffer = ""         #resetting the buffer 
			 	else:
			 		continue
		Buffer += Char

	if len(Buffer)>0:		#something should be left behind
		Items.append(Buffer)
	
	if Inquote==1:     #some quote been left behind
		raise NameError, "Quote Syntax is so wrong!"     #lets raise up an error
	Search_Type = searchType(Items)      #determining the kind of search to be performed
	try: #since list.remove will raise an error if item not found
		Items.remove("OR") #remove OR from list	
	except:
		print 'AND Search'		
	return Items                          #finally the parsed list	

def searchType(Items=[]): #determinr if an OR search MobMe OR Codejam query is given or an AND search Vishnu Gopal is to be done
	for Item in Items:
		if Item == "OR":
			return "OR"
	return "AND"

def stripTags(InputHTML): #since we don't bother about what inside tags we got to renove it
 	InputList = list(InputHTML) #to check char wise
 	i = 0
 	while i<len(InputList):
 		if InputList[i] == "<": #get the tag starting 
 			while InputList[i] != ">": #till tag end
 				InputList.pop(i)
 			InputList.pop(i) #rmove the '>'
 		else:
 			i = i+1
 	return ''.join(InputList) #well, thats the stripped Output :P

def theSearch(Query,SearchType,FileContents,Link):
	#Passing the search queries and file list	
	#only files matching the queries should be returned
	Title = ""	
	TitleSearch = re.compile("<title>.*</title>") #the grammar for <title></title> tags. bit of compiler lessons if you learned any

               
	TempTitle = TitleSearch.search(FileContents) #get the title tag in files
	if TempTitle != None:
		Title = FileContents.strip()[TempTitle.start()+7:TempTitle.end() - 8]

               	
              #after retrieving title we are free to strip out
               	#all tags from the file
	FileContents = stripTags(FileContents)
	FileContents = FileContents.lstrip()
	FileContents = FileContents.rstrip()
                #Processed HTML is used for the actualSearch
	if actualSearch(FileContents,Query):
		Results.append(Title)
		Results.append(Link)
	

def actualSearch(FileContents,Query):
 	FileContents = FileContents.lower() #our search is case insensitive
 	if Search_Type == "AND":
 		Found = True
 		for String in Query:
 			if FileContents.find(String.lower()) == -1:        #AND Search, Found will be true only if all the query strings are found in
 				Found = False
 		if Found == True:
 			return 1
 	else:
 		for String in Query:              #OR search, any query string will return results
 			if FileContents.find(String.lower()) > 1:
 				return 1
 	return -1
 
 
def makeSearchReady(QueryString): #setting start page for crawler and query string for search
	crawler('http://mobme.in',QueryString)
	print ('Results')
 	i = 0
 	while(i<len(Results)):
 		print '-----------------------------------------------------'
 		print 'Title:',Results[i] #Display the title of page
 		print 'Link:',Results[i+1] #link to result page
 		i = i+2

def CUI():
 	Query = raw_input('Enter Query:') #accept search query from user
 	makeSearchReady(Query) #pass query for processing

CUI() #initiate the program