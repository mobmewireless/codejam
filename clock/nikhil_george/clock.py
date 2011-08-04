from datetime import datetime
class clock:
	def calctime(self,hr,mn):
		hr=hr%12
		if mn>=3 and mn<=7:
			s1='five past'
		elif mn>=8 and mn<=12:
			s1='ten past'
		elif mn>=13 and mn<=17:
			s1='fifteen past'
		elif mn>=18 and mn<=22:
			s1='twenty past'
		elif mn>=23 and mn<=27:
			s1='twenty five past'
		elif mn>=28 and mn<=32:
			s1='half past'
		elif mn>=33 and mn<=37:
			s1='twenty five to'
		elif mn>=38 and mn<=42:
			s1='twenty to'
		elif mn>=43 and mn<=47:
			s1='fifteen to'
		elif mn>=48 and mn<=52:
			s1='ten to'
		elif mn>=53 and mn<=57:
			s1='five to'
		elif mn>=58 and mn<=2:
			s1="o'Clock"
		t1=mn%5
		if t1==0:
			s2='precisely'
		elif t1==1:
			s2='about'
		elif t1==2:
			s2='after'
		elif t1==3:
			s2='almost'
		elif t1==4:
			s2='almost'
		if (hr==1 and mn<=32) or (hr==12 and mn>=33):
			s3='one'
		elif (hr==2 and mn<=32) or (hr==1 and mn>=33):
			s3='two'
		elif (hr==3 and mn<=32) or (hr==2 and mn>=33):
			s3='three'
		elif (hr==4 and mn<=32) or (hr==3 and mn>=33):
			s3='four'
		elif (hr==5 and mn<=32) or (hr==4 and mn>=33):
			s3='five'
		elif (hr==6 and mn<=32) or (hr==5 and mn>=33):
			s3='six'
		elif (hr==7 and mn<=32) or (hr==6 and mn>=33):
			s3='seven'
		elif (hr==8 and mn<=32) or (hr==7 and mn>=33):
			s3='eight'
		elif (hr==9 and mn<=32) or (hr==8 and mn>=33):
			s3='nine'
		elif (hr==10 and mn<=32) or (hr==9 and mn>=33):
			s3='ten'
		elif (hr==11 and mn<=32) or (hr==10 and mn>=33):
			s3='eleven'
		elif (hr==0 and mn<=32) or (hr==11 and mn>=33):
			s3='twelve'
		if mn>=58 and mn<=2:
			s="It's " + s2 + ' '+s3+' '+s1
		else:
			s="It's " + s2 + ' '+s1+' '+s3
		print s
a1=str(datetime.now())
a2=a1[11]+a1[12]
a2=int(a2)
a3=a1[14]+a1[15]
a3=int(a3)
c=clock()
c.calctime(a2,a3)

