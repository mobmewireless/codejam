Description

The input text should be provided in a file named "text" in the same directory as that containing "spell.c"

In this program we assume the following
1) Words are made up of English alphabets and numbers and are counted case-insensitive.
2) Words separated by a hyphen like "back-end" is regarded as a single word.
3) Words can include an apostrophe like "student's" etc.
4) Words containing any other special characters are considered separate.Ex: "cat&dog" 		 are considered as "cat" and "dog".


function check(string word)
	Checks whether the word is present in the /usr/share/dict/words file.
	If it is not present the corresponding word is printed


DEPENDENCIES

1) GNU/LINUX
2) gcc


USAGE

To run the program :
1. The file 'text.txt' contains the words to be tested.
2. Compile the spellcheck.c file and run the code.(to compile "cc spell.c" to run 	    	 "./a.out")
