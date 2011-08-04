from django.conf.urls.defaults import patterns, include, url
from ussdapp.views import send_data

# Uncomment the next two lines to enable the admin:
from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'ussd.views.home', name='home'),
    # Uncomment the next line to enable the admin:    
    url(r'^admin/', include(admin.site.urls)),
    url(r'^$', send_data),
    #url(r'^', send_options),

    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    
    
)
