import sys
file=sys.argv[1]
fil=open(file,"r")
a=fil.readlines()
b=""
fil.close()
ngram=list()
for n in a:
  for m in n:
    if m=="\"" or m=="," or m=="-" or m=="!":
      continue
    else:
      b=b+m

b=b.split()
i=0
while i<(len(b)-2):
  ngram=ngram+[b[i],b[i+1],b[i+2]]
  i=i+1
l=int(sys.argv[2])-1
j=l*3
f=1
story=list()
for k in ngram:
  story=story+[ngram[j]]
  if len(story)>200 and len(story)<300:
    #print str (j)+ngram[j] 
    for c in ngram[j]:
      if c == ".":
          f=0
          break       
  elif len(story)>300:
      f=0
      break
  if(f==0):
      break 
  j=j+1
if (j>len(story) and f==1):
  story=story+"\nINCOMPLETE"    
storymain=str()
for a in story:
    storymain=storymain+" "+str(a)
print storymain
