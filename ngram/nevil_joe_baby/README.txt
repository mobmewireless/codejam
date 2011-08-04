Design

This program reads a novel-length story from the file 'input.txt'.
Then all the words in it are sperated using regular expression.
It created a list of words. Then it creates a list of trigrams by taking
all adjacent 3 words in the list of words. Then It chooses an arbitrary trigram to start with using the random function.
That arbitrary trigram is first loaded to the story. Then it searches for 
trigram in the whole list of trigrams that matches the condition to be added to the story. If it matches,
then the third word in the trigram is added to the story. Because the first two words of that trigram will
be the last two words of the story.  At last the story is printed in a paragraph format. For achieving a paragraph format,
the words upto the first dot(.) are ignored. Because it will be a fresh sentence after the dot. So that a new paragraph can be started.
After 3 sentences a blank line is printed. This program displays different stories at different times for the same input.



Dependencies

It uses two inbuilt library modules of python-  're' for regular expression and 'random' for random function



Usage

Copy the novel length story in txt format to the folder that contain the python file. Then rename the novel length story to 'input.txt'
Then run the Python file. It will continuosly display the length of the short story generated. It will run untill the number of words of the short story reaches 300.
