	Design:
Question:-
Write a program which first collects all word-level trigrams in a novel-length story. Then, choosing any arbitrary trigram as the starting point, generate a short story which is between 200 to 300 words. The next trigram in the chain must always have the first two words same as that of the previous trigram's last two words.

What is a trigram you ask? The sentence "The quick red fox jumps over the lazy brown dog" has the following trigrams - "The quick red", "quick red fox", "red fox jumps", "fox jumps over", "jumps over the", "over the lazy", "the lazy brown", "lazy brown dog".

This program generates a story after removing all formats and special characters like('"','!','-',',') and then generate the story from the given trigram position till the end of a sentence( denoted by '.') taking care the length lies between 200 to 300 words.
If the length exceeds 300 words or length is less than 200, the story is INCOMPLETE and this is added to the end of the story.

Dependencies: python 2.7.2

Usage: python ngram.py <file-name> <ngram position>

Read the sample output.txt for more details. The book.txt contains 1st chapter of tom sawyer for testing puposes. Output contains the output of:
python ngram.py book.txt 100
