import scipy
from scipy.misc import imread
from scipy.signal.signaltools import correlate2d

import warnings
import sys
import urllib
def get(filename):
	#get image as Scipy array
	data = scipy.misc.imread(filename)
	#convert to grey-scale
	data = scipy.inner(data,[299,587,114])/1000.0
	#normalize
	return (data - data.mean())/data.std()

def compare(image1, image2):
	norm_image_1 = get(image1)
	norm_image_2 = get(image2)
	base = correlate2d(norm_image_1,norm_image_1,mode='same') #baseline
	score = correlate2d(norm_image_1,norm_image_2,mode='same') #score
	#get  similarity
	base = base.max()
	score = score.max()
	return (int)((1-abs(base-score)/base)*100) #ranking it in a scale

#with warnings.catch_warnings():
warnings.simplefilter('ignore') #supress warnings
image_url_1 = sys.argv[1]
image_url_2 = sys.argv[2]
image_url_1 = urllib.urlretrieve(image_url_1) #retrieve remote file as localfile
image_url_2 = urllib.urlretrieve(image_url_2)
print 'Similarity Scale:',compare(image_url_1[0],image_url_2[0])