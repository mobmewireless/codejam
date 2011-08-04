



# Change the values of following error messages dict to reflect it every where

ERROR_MSGS = { 
			   "NO_USER_INPUT" : "didn't give user input parameter",
			   "INVALID_USER_INPUT" : "invalid user input parameter",
			   "INVALID_MOBILENO" : "invalid mobile number",
			   "INVALID_SESSIONID" : "invalid session id"
			  }


def set_error(error,msg):
	""" To check if there is more than one error in the query. If there is more than
		one error, joins them with 'and'.
	"""
	if error:
		error =	' and '.join([error,msg])
	else:
		error = msg.capitalize()
	return error		
