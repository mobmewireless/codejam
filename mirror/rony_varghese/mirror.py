from PIL import Image
from PIL import ImageChops
import urllib2
import math, operator
import cStringIO

def rmsdiff(im1, im2):
    h = ImageChops.difference(im1, im2).histogram()
    return math.sqrt(reduce(operator.add,
        map(lambda h, i: h*(i**2), h, range(256))
    ) / (float(im1.size[0]) * im1.size[1]))

im1_url = raw_input("Enter url 1:")
im1_data = urllib2.urlopen(im1_url).read()
im1 = Image.open(cStringIO.StringIO(im1_data)).convert("L")

im2_url = raw_input("Enter url 2:")
im2_data = urllib2.urlopen(im2_url).read()
im2 = Image.open(cStringIO.StringIO(im2_data)).convert("L")

diff = rmsdiff(im1,im2)*100/255
if diff == 0.0:
    sim = "entirely different"
elif int(diff) in range(0,45):
    sim = "almost different"
elif int(diff) in range(45,55):
    sim = "almost half similar and half different"
elif diff == 100.0:
    sim = "exactly the same"
elif int(diff) in range(55,100):
    sim = "almost similar"
print "The images are " + str(round(diff,2)) + "% similar"
print "The images are " + sim

