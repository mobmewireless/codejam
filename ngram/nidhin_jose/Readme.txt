The code compiled and worked successfully in the gcc compiler. Entire code is strictly following the ANSI C standards.

DESIGN:
-------
The program has two important parts:
Trigram generator and the short story generator

(i)
The program read a file named novel.txt-assumed to have the novel-and then create the trigram for the novel in a
file named trigram.txt
Algorythm is such that each word is read only once to improve efficiency.

Required: An input file named novel.txt which contain the original novel.

OUTPUTS: In files trigram.txt and story.txt

(ii)
Assuming that the question is to generate a short story from the earlier generated trigram, the prgram open the trigram.txt
in read mode. A random function is used to obtain a aribitary starting point inside the file trigram.txt as well as to 
get a arbitary wordlimit between 200 and 300. The file trigram is then sequencially read and every 1 out of the 3 words read 
is printed into the file story.txt till the wordlimit. Its been made sure that the short story actually starts and ends
as true sentence follwing grammars.


DEPENDENCIES:
-------------

Any standard C compiler


USAGE:
-----
The program can read any text file of whatever length and could create its trigram and also arbitarily generate a
short story of about 200-300 words.

