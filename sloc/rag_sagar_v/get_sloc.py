#!/usr/bin/env python

import simplejson
import httplib2
import sys

SLOC_DICT = {}

LANG_DICT = { 'application/python': 'python', 
			  'application/ruby': 'ruby',
			  'application/c': 'C',
			  'text/css': 'CSS',
			  'application/php': 'PHP',
			  'application/clojure' : 'clojure',
			  'application/perl': 'perl',
			  'text/html': 'html'
			  }

if len(sys.argv) == 3:
	username = sys.argv[1]
	repo = sys.argv[2]
else:
	print "Usage python %s username repo" % sys.argv[0]
		


def get_loc(text=''):
	text = text.split('\n')
	count = len(text)
	return count


def save_count(mime_type,count):
	if mime_type in SLOC_DICT:
		SLOC_DICT[mime_type] += count
	else:
		SLOC_DICT[mime_type] = count
	


def get_data(url):
	sock = httplib2.Http(timeout=4)
	try:
		headers, response = sock.request(url)
	except socket.timeout:
		raise ValueError("Socket timed out")
	status = int(headers.pop('status', 200))
	if status != 200:
		raise ValueError('Returned status: %s' % (status))
	data = simplejson.loads(response)
	return data

def get_sha():
	commit_url = 'http://github.com/api/v2/json/commits/list/%s/%s/master' % (username,repo)
	data = get_data(commit_url)
	return data['commits'][0]['id']	
			
def get_tree(sha):
	tree_url='http://github.com/api/v2/json/tree/show/%s/%s/%s' % (username, repo, sha)
	data = get_data(tree_url)
	return [ [ node['name'], node['type'], node['sha'] ] for node in data['tree'] ]

def get_fileinfo(sha,filepath):
	blob_url = 'http://github.com/api/v2/json/blob/show/%s/%s/%s/%s' % (username, repo, sha, filepath)
	data = get_data(blob_url)
	return (data['blob']['mime_type'],data['blob']['data'])
	
def check_tree(sha,tree=''):
	for name,typ,new_sha in get_tree(sha):
		if not tree:
			tree = '/'.join([tree,name])
		else:
			tree = name	
		if typ == 'tree':
			check_tree(new_sha,tree)
		else:
			try:
				mime_type, text = get_fileinfo(sha,tree)
				save_count(mime_type, get_loc(text))
			except:
				pass	
					

if __name__ == '__main__':
	sha = get_sha()
	check_tree(sha)
	for langcode in SLOC_DICT:
		if LANG_DICT.has_key(langcode):
			print LANG_DICT[langcode], SLOC_DICT[langcode]
	


