
import numpy as np
import matplotlib.mlab as mlab
import matplotlib.pyplot as plt

freq  = [[],[]]
for i in range(1000,9999):
    diff = 0
    iterations = 0
    s = str(i)
    asc = "".join(sorted(s))
    des = "".join(sorted(s,reverse=True))
    if asc == des:
        continue
    while diff != 6174:
        iterations += 1
        diff = int(des) - int(asc)
        #print diff
        asc = "".join(sorted(str(diff).zfill(4)))
        des = "".join(sorted(str(diff).zfill(4),reverse=True))
    if iterations in freq[0]:
        freq[1][freq[0].index(iterations)] += 1 
    else:
        freq[0].append(iterations)
        freq[1].append(1)
print freq
print "Iterations \tTotal Count of Numbers"
finx = []
finy = []
for i in range(len(freq[0])):
    finx.append(freq[0][freq[0].index(i+1)])
    finy.append(freq[1][freq[0].index(i+1)])
    print freq[0][freq[0].index(i+1)],"\t\t",freq[1][freq[0].index(i+1)]
plt.plot(finx,finy)
plt.axis([0,8,0,2200])
plt.xlabel('Iterations')
plt.ylabel('Count')
plt.show()

