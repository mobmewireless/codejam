"""To retrieve needed data from given database query set

	To extract more data or different data, just change this function.
"""


def retrieve_data(dbitems=''):
	response = ''
	for item in dbitems:
		response +=	"%d.%s\n" % (item.__dict__['id'], item.__dict__['country'])
	return response
