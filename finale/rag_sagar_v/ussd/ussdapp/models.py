from django.db import models




class Country_Capital(models.Model):
	country = models.CharField(max_length=100)
	capital = models.CharField(max_length=100)
	
	class Meta:
		ordering = ["id"]
	
	def __unicode__(self):
		return u'%s . %s : %s ' % (self.id, self.country, self.capital)
