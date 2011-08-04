Contest ID: ngram
Developer:
            Sinu John
            email : sinuvian@gmail.com
            blog  : www.sinujohn.wordpress.com
            mobile: +91 9747632404

1. DESIGN
	The trigrams are stored using HashMaps and ArrayLists. The storage can be viewed as 3 levels. The first 2 levels are implemented using HashMaps and the 3rd level is implemented using ArrayLists.
	The Level 1 has all the words once. Each of these words act as as Key to obtain its corresponding value which is another HashMap. By following the key (a word) in Level 1 we can obtain another HashMap which contains all the words which are preceded by the key word of Level 1. This HashMap forms the Level 2.
	In Level 2, the keys consist of all those words which are successors to the key word of Level 1. Each key of Level 2 has a corresponding value which is made up of by the ArrayList, and this is Level 3.
	Level 3 contains all the words which are successors of the key word in Level 2, which is in turn the successor of key word in Level 1.

	To illustrate a small portion of this trigram storage, consider the following trigrams (which is incomplete ofcourse):
Trigrams: (a b c), (a c b), (a c e), (b a b)

		Level 1		Level 2 	Level 3
		   a--------------b---------------c
		           |------c---------------b
				 	   |------e

		   b--------------a---------------b

For another example please see "block.jpg".

2. DEPENDENCIES
	The code is done in Java. So it requires only JDK to be installed. I have done this in Netbeans IDE, and have included the Netbeans Project as such. So it could be easily opened in Netbeans.

3. USAGE
	Usage:
		java -jar ngram.jar sourcefile [--debug]

	To run ngram.jar :
		java -jar ngram.jar sourcefile
				Here 'sourcefile' is the text file from which trigrams are first obtained.

	To run in DEBUG mode (be careful if the trigrams are large in number it could printout loads of output):
		java -jar ngram.jar sourcefile --debug