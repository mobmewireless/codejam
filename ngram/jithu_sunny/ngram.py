from string import capitalize, join, upper
from random import choice, shuffle

def Trigram_Match(current, next):
    return current[1] == next[0] and current[2] == next[1]

def Neighborhood(iterable):
    iterator = iter(iterable)
    prev = None
    item = iterator.next()
    for next in iterator:
        yield (prev,item,next)
        prev = item
        item = next
    yield (prev,item,None)

new_story = []
trigram_list = []
current_trigram = []
word_count = 3
shuffle_count = 0

file = raw_input('Enter the story name: ')
fp = open(file)
story = fp.read()

for prev, item, next in Neighborhood(story.split()):
    if prev and next:
        trigram_list.append((prev, item, next))

shuffle(trigram_list)

current_trigram = choice(trigram_list)
title = choice(trigram_list)

print '"', upper(join(title)), '"'
print

new_story.append(capitalize(current_trigram[0]))
new_story.append(current_trigram[1])
new_story.append(current_trigram[2])

while word_count <= 300:
    for item in trigram_list:
        if Trigram_Match(current_trigram, item):
            new_story.append(item[2])
            current_trigram = item
            word_count += 1
                
new_story = join(new_story)

print new_story
