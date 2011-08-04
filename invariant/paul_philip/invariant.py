from matplotlib import pyplot
count=dict()

def rev_sub(n):
    lst=list(str(n))
    lst.sort(reverse=True)
    b=lst[0]+lst[1]+lst[2]+lst[3]
    d=lst[3]+lst[2]+lst[1]+lst[0]
    k=str(int(b)-int(d))
    while(len(k)<4):
        k='0'+k
    return k

def cnt(a):
    l=str(a)
    t=l
    cntr=0
    while(int(l)!=6174):
        k=rev_sub(l)
        if(k=='0000'):
            break
        cntr=cntr+1
        l=k
    if(count.has_key(str(cntr))):
        count[str(cntr)]=str(int(count[str(cntr)])+1)
    else:
        count.update({str(cntr):'1'})

def main():
    for i in xrange(1000,9999):
        cnt(i)    
    X=count.keys()
    X.sort()
    Y=list()
    for m in X:
        Y=Y+[str(count[m])]
    X=X[1:]
    Y=Y[1:]
    print "Frequency Distribution"
    print "Iteration Total Count of Numbers"
    i=0
    for m in X:
        print m.rjust(9)+'\t\t'+Y[i].rjust(8)
        i=i+1
    pyplot.plot( X, Y,)
    pyplot.title( 'Frequency Distribution' )
    pyplot.ylabel( 'Total Count of Numberscount' )
    pyplot.xlabel( 'Iterations' )
    pyplot.show()

if __name__ == "__main__":
    main()
