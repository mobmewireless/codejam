import httplib
import json
import logging
import socket
import time
import urllib
from matplotlib import pyplot
from matplotlib.dates import date2num
from datetime import datetime, timedelta
initial=0.0
X = []
Y = []
delta=0
max_total=0
time_max=str()

pyplot.plot_date( X, Y, '-', xdate=True )
pyplot.title( 'Plotting no of \"I love you\"' )
pyplot.ylabel( 'Hits' )
pyplot.xlabel( 'Time' )
pyplot.show()

SEARCH_HOST="search.twitter.com"
SEARCH_PATH="/search.json"

def plotting(time_val):
    global X
    global Y
    global initial
    global max_total
    global delta
##  v=[initial,date2num(datetime.today()+timedelta(days=1)),0,max_total]
    pyplot.clf()
    pyplot.cla()
    pyplot.axes()
    X=X+[date2num(datetime.today()+timedelta(seconds=delta))]
    Y=Y+[time_val]
    #print X
    #print Y    
    pyplot.plot_date( X, Y, '-', xdate=True )
##    pyplot.axis(v)
##    pyplot.axis('tight')
##    pyplot.axis('equal')
##    pyplot.axis('scaled')
    pyplot.title( 'Plotting no of \"I love you\"' )
    pyplot.ylabel( 'Hits' )
    pyplot.xlabel( 'Time' )
    pyplot.draw()

    
class TagCrawler(object):
    def __init__(self, tag, interval):
        self.max_id = None
        self.tag = tag
        self.interval = interval
        
    def search(self):
        #print 'max_id'+'='+str(self.max_id)
        c = httplib.HTTPConnection(SEARCH_HOST)
        params = {'q' : self.tag}
        if self.max_id is not None:
            params['since_id'] = self.max_id
            path = "%s?%s" %(SEARCH_PATH, urllib.urlencode(params))
        else:
            path = "%s?%s" %(SEARCH_PATH, urllib.urlencode(params))
        try:
            c.request('GET', path)
            r = c.getresponse()
            data = r.read()
            c.close()
            try:
                result = json.loads(data)
            except ValueError:
                return None
            if 'results' not in result:
                return None
            self.max_id = result['max_id']
            return result['results']
        except (httplib.HTTPException, socket.error, socket.timeout), e:
            logging.error("search() error: %s" %(e))
            #print "search() error: %s" %(e)
            return None

    def loop(self):
        logging.info("Starting search")
        #print "Starting search"
        data = self.search()
        if data:
            logging.info("%d new result(s)" %(len(data)))
            #print "%d new result(s)" %(len(data))
            return len(data)
        
        else:
            logging.info("No new results")
            #print "No new results"
            return 0
        logging.info("Search complete sleeping for %d seconds"
                %(self.interval))
        #print "Search complete sleeping for %d seconds" %(self.interval)
        time.sleep(float(self.interval))


def main():
    global initial
    global max_total
    global time_max
    global delta

    total=0
    a=TagCrawler("I love you",.1)
    prev_timer=time.time()
    initial=date2num(datetime.today())
    delta=0
    plotting(total)
    delta=10
    while True:
        total=total+a.loop()
        #print total
        if time.time()- prev_timer > delta:
            prev_timer=time.time()
            plotting(total)
            if total > max_total:
                max_total=total
                time_max=str(datetime.time(datetime.now()))
                print "max hits at " + time_max
            total=0

if __name__ == "__main__":

    main()
