import time
import random

#Uses the same dictionaries and list defined in http://helvetictoc.com/css/main.css
HOURS = ['twelve','one','two','three','four','five','six','seven','eight','nine','ten','eleven']
MINUTES = {'5':  'five past','10': 'ten past','15': 'quarter past','20': 'twenty past','25': 'twenty-five past','30': 'half past','35': 'twenty-five to', '40': 'twenty to','45': 'quarter to','50': 'ten to','55': 'five to'}
PREPOSITIONS = {'-1': ['almost', 'nearly'],'0': ['exactly', 'precisely', 'now', ''],'1': ['after', 'about', 'around']}
roundAbout = 'Its around midnight'
SPECIAL_CASES = {'23:58': roundAbout,'23:59': roundAbout,'0:0': 'Its midnight','0:1': roundAbout,'0:2': roundAbout,'12:0': 'its noon.'}

#Get Fuzzy Factor. 
def getFuzzyFactor(m):
 	ff = m % 5
	if ff==1:
		return '1'
	elif ff==2:
		return '1'
	elif ff==3:
		return '-1'
	elif ff==4:
	        return '-1'
	else:
		return '0'

#Get prepositions given the time. Uses Fuzzy Factor for calculation
def getPrep(m):
	ff = getFuzzyFactor(m)
	p = PREPOSITIONS[ff]
	r =random.randrange(0, len(p)-1)
	return p[r]

#Get the rounded time
def getRM(m):
	ff = getFuzzyFactor(m)
	if ff=='1' or ff=='0':
		mf = (int(m/5) * 5) 
	else:
		mf = int(m/5) * 5 + 5
	return mf



time_now = time.localtime()
h=time_now.tm_hour
m=time_now.tm_min
stc = str(h) + ":" + str(m)
print stc


try:
	result = SPECIAL_CASES[stc]
	print "result" ,result
except KeyError:
	if h>=12:
		h=h-12
	p = getPrep(m)
	RM = str(getRM(m))
	mw = str(MINUTES[RM])
	if m<=32:
		hw = HOURS[h]
	else:
		if h==11:
			hw = HOURS[0]
		else:
			hw = HOURS[h+1]
	result = "Its " + p + " " + mw + " " + hw
	print result

	
	




