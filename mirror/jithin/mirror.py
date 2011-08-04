
#!/usr/bin/python2.7

import urllib2, math, operator
from PIL import Image

def rmsdiff(h1, h2):
    # Calculates the rms value of two images
    # h1 -> histogram value of image1
    # h2 -> histogram value of image2
    rms = math.sqrt( reduce( operator.add,
    map(lambda a,b: (a-b)**2, h1, h2))/len(h1))
    return rms

def download_image(url):
    file = urllib2.urlopen(url)
    # Extracting the image name from the URL,
    # url.split('/') splits the URL string with '/' and returns a list
    # url.split('/')[-1] returns the last item in the list
    file_name = url.split('/')[-1]
    # 'wb' enables write file in binary mode
    output = open( file_name,'wb')
    output.write(file.read())
    output.close()
    return file_name

url1 = raw_input('Enter URL of Image1 : ')
url2 = raw_input('Enter URL of Image2 : ')
image1 = download_image(url1)
print "downloading image1"
image2 = download_image(url2)
print "downloading image2"
h1 = Image.open(image1).histogram()     # opens image1 and returns histogram value
h2 = Image.open(image2).histogram()     # opens image2 and returns histogram value
s = rmsdiff(h1,h2)                      

print "comparing images"

rank = int (((30000 - s)*100) / 30000)

print "Rank : {}".format(rank)

if ( rank == 100 ):
    print "Exactly the same"
    
elif (rank < 10 ):
    print "Very Different"
    
