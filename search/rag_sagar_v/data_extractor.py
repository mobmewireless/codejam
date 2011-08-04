#!/usr/bin/env python

__author__ = "Rag Sagar.V"
__email__ = '@'.join(['ragsagar','.'.join([_ for _ in ['gmail','com']])])

from HTMLParser import HTMLParser
from traceback import print_exc
import re
import sys

class TextExtractor(HTMLParser):
    def __init__(self):
        HTMLParser.__init__(self)
        self.text = []

    def handle_data(self, data):
        temp = data.strip()
        if len(temp) > 0:
            temp = re.sub('[ \t\r\n]+', ' ', temp)
            self.text.append(temp + ' ')

    def handle_starttag(self, tag, attrs):
        if tag == 'p':
            self.text.append('\n\n')
        elif tag == 'br':
            self.text.append('\n')

    def handle_startendtag(self, tag, attrs):
        if tag == 'br':
            self.text.append('\n\n')

    def get_text(self):
        return ''.join(self.text).strip()

def html2text(html):
	""" Converts given html to text. """
	try:
		parser = TextExtractor()
		parser.feed(html)
		parser.close()
		return parser.get_text()
	except:
		print_exc(file=sys.stderr)
        return html	
