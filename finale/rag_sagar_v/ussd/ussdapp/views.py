from django.http import HttpResponse
from ussdapp.models import Country_Capital

# To change error messages just changes the values in ERROR_MSGS dict in errors module
# No need to edit send_data view
from errors import set_error, ERROR_MSGS

# To retrieve different datas just change the retrieve_data() in data module. No need to edit send_data view
from data import retrieve_data



			   




def send_data(request):
	""" View to return the list of options if user_input is empty, otherwise sends the capital of the
		country with corresponding user_input id.
		Returns invalid input message if the length of the mobile is not equal to 10 or 11 or the session
		id is empty.
		Fetches the country capital data from the sqlite database file ~/code/ussd/country_capital_db
	"""
	# Retrieving data given through url
	session_id = request.GET.get('session_id')
	mobile_no = request.GET.get('mobile_no')
	response = ''
	error = ''
	user_input = ''
	
	# Checking if user input. Value error is raised if user_input is empty.
	# Type error is raised if no user_input value is given.
	
	try:
		user_input = int(request.GET.get('user_input'))
	except ValueError:
		# Blank user_input option is given
		db_items = Country_Capital.objects.all()
		response = retrieve_data(db_items)
	except TypeError:
		# No user_input parameter in url
		error = set_error(error, ERROR_MSGS['NO_USER_INPUT'])
	
	# To check if a country with corresponding user_input exists and set error if not.
	# If user_input value is zero it will return false for if user_input: 
	# So we are making an exception to occur if user_input is zero. 
	if user_input or user_input == 0: 
		try:
			# Getting item with corresponding user_input
			searched_item = Country_Capital.objects.get(id__exact=user_input)
			response = searched_item.__dict__['capital']
		except:
			# No item with corresponding id.
			error = set_error(error, ERROR_MSGS['INVALID_USER_INPUT'])
	
	
	# Checking if the given mobile number is valid 
	if len(mobile_no) not in (10,11):
		error = set_error(error, ERROR_MSGS['INVALID_MOBILENO'])
	else:
		request.session['mobile_no'] = mobile_no	
		
	# Checks if the given session id is valid and setting it	
	if session_id :
		request.session['id'] = session_id
	else:
		error = set_error(error, ERROR_MSGS['INVALID_SESSIONID'])

			
	# If there is an error return it, otherwise return the country list or capital of selected country	
	if error:
		return HttpResponse(error)
	else:
		return HttpResponse(response)	
	
	
	
