import ImageChops,math, operator,Image,sys,urllib
def root_mean_square_difference(im1, im2):
	try:
	
		diff = ImageChops.difference(im1, im2) #Returns the absolute value of the difference between the two images
		h = diff.histogram()
		sq = (value*(idx**2) for idx, value in enumerate(h))
		sum_of_squares = sum(sq)
		rms = math.sqrt(sum_of_squares/float(im1.size[0] * im1.size[1]))
	except ValueError:
		return -1
	else:
		return rms
def comparing_histograms(img1,img2):
	h1 = img1.histogram()
	h2 = img2.histogram()
	#finding the root mean square  in histograms of two images
	try:    
		rms = math.sqrt(reduce(operator.add,map(lambda a,b: (a-b)**2, h1, h2))/len(h1))
	except TypeError:
		return -1
	except ValueError:
		return -1
	else:
    		return rms
	
if __name__=='__main__':	
	image = urllib.URLopener()
	raw1=raw_input('Enter the 1st url:')
	raw2=raw_input('Enter the 2nd url:')
	ext1=raw1[-4:]#extracting the extension
	ext2=raw2[-4:]
	extm1="img1"+ext1
	extm2="img2"+ext2
	image.retrieve(raw1,extm1)#saving the image
	image.retrieve(raw2,extm2)
	im1=Image.open(extm1)
	im2=Image.open(extm2)
	si1=im1.size
	si2=im2.size
	cmr=root_mean_square_difference(im1,im2)
	rms=comparing_histograms(im1,im2)
	print cmr,rms
	if si1[0] != si2[0] or si1[1] != si2[1]:#comparing the size
		print 'Images are of Different sizes'
	else:
		if cmr==0.0 and rms==0.0:
			print 'Images are Exactly Equal'
		elif cmr>0 and cmr <=40:
			print 'Images are Equal but not exactly equal'
		elif cmr>40 and cmr <=70:
			print 'Images are Equal, Yet there is some differences'
		else:
			print 'Images are Not Equal'
	

