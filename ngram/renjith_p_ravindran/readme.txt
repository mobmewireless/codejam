DESIGN:
nothing sort of design :) ... just staright forward stuff.
first the input is cleansed of all punctuations spl chars etc, leaving only the words and numbers.
Every word in this Input is looped over and joined with the neighbours to form the trigrams.

Next a random trigram is chosen as the start position and following trigrams are added to form a sentence, because the trigrams are joined linerly all trigrams naturally follow  the "trigram forming rule".

Since start position is random there is chance that last trigrams in the input gets chosen and the story fails to reach 200-300 word requirement.To solve this when the last trigram in the input is reached its just wraped around to the first. Two extra trigrams are added to comply with the "trigram forming rule".

eg.
input= hai how are you
trigrams= hai how are, how are you,

With this , when the trigrams are wrapped around the rule is broken.
eg 
story=hai how are how are you [hai how are] ....

to solve this two more trigrams are added to the trigram list
eg.
trigrams= hai how are, how are you,[are you hai],[you hai how]. ...the last two are the wrap around trigrams and not found linerly in the input

With the addition of the two wrap-around trigrams a story of any word length can be formed complying to the "rule"





DEPENDENCIES:
nothing special..have just used 3 generally bundled python modules...String,Random,Re


USAGE:
the input comes from `input.txt`..thats all.

