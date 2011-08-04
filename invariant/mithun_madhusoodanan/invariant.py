from pygooglechart import PieChart3D #for creating graph
from collections import Counter
import webbrowser
fd={}
gm=[]
xx=[]#list for graph
yy=[]#list for graph
for x in range(1000,10000):	
	number=map(lambda x: x, str(x).zfill(4)) 
	if number[0]==number[1]==number[2]==number[3]:
		continue
	kc=1 #to find iterations to Kaprekar's constant
	iter=0 #no. of iterations for a number
	while kc!=6174:
		small_digit=sorted(number)
		large_digit=sorted(number,reverse=True)
		small_combained=int(''.join(small_digit))
		large_combained=int(''.join(large_digit))
		kc=large_combained-small_combained
		number=map(lambda x: x, str(kc).zfill(4)) 
		iter=iter+1
	fd[x]=iter
for k,v in fd.iteritems():
	print k, 
	print 'takes',
	print v,
	print 'iterations to reach 6174'
	gm.append(v)
sm=(Counter(gm).items())
sm=sorted(sm)
print 'Iteration 	Total Count of Numbers'
for i in range(len(sm)):
	xx.append(str(sm[i][0])+' iterations')
	yy.append(sm[i][1])
	print sm[i][0], #printing the no. of iterations
	print '\t\t',
	print sm[i][1]
#creating graph
chart = PieChart3D(500,200)
chart.add_data(yy)
chart.set_pie_labels(xx)
chart.download('iter_pie_chart.png') 
webbrowser.open('iter_pie_chart.png',new=0)#Displays the graph in default browser appropriate to the callers environment.
raw_input("Press Enter to continue...")
