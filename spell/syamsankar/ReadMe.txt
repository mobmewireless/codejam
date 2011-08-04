Design (without bloom filter)
The program is designed such the class 'spellchecker' first loads a dictionary into its Hashtable. Then it parses the input from a textfile using 
String.split() which is then checked for spelling errors  by test membership with the Hash Table database. If there is any token with error, the 
selected token is passed to another function of a new 
class 'spellingsuggest' whose contructor intialises a huge database of words, thus by calculating the probability of other possible corrections, the best 
one is send as the suggestion. So if there is error in any of the tokens, immediately its suggestions are computed.

Dependancies
1. Dictionary used by spellchecker(dictionary.txt)
2. Word Database used by spellingsuggest(wordprobabilityDatabase)
3. Input Text File used by spellchecker(inputtext.txt)

Usage
The source files along with the dependancies have been sent. Compile the source code($javac spellchecker.java) and then run its class($java spellchecker).

Design (with bloom filter)
The program is designed such the class 'spellchecker' first loads a dictionary into an Bloom Filter object. Then it parses the input from a textfile using 
String.split() which is then checked for spelling errors by test membership with the Bloom Filter database. If there is any token with error, the selected 
token is passed to another function of a new class 'spellingsuggest' whose contructor intialises a huge database of words, thus by calculating the 
probability of other possible corrections, the best one is send as the suggestion. So if there is error in any of the tokens, immediately its 
suggestions are computed.

Dependancies
1. Dictionary used by spellchecker(dictionary.txt)
2. Word Database used by spellingsuggest(wordprobabilityDatabase)
3. Input Text File used by spellchecker(inputtext.txt)
4. Bloom Filter Class used by spellchecker(bloomfilter12.java)

Usage
The source files along with the dependancies have been sent. Compile the source code($javac spellchecker.java) and then run its class($java spellchecker).


     

