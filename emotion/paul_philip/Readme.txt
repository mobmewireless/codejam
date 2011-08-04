Design:
Question:-
Write a program that counts the number of occurrences of the words “I love you” on Twitter and/or Facebook every ten seconds and plots it on an attractive graph.

This program uses the twitter api to search the number of occurances of "I love you" on Twitter every 10 seconds and plot it

Dependencies: python 2.7.2
modules used:httplib,json,logging,socket,time,urllib,matplotlib, datetime

Acknoledgemnent:
This code is based on the example from http://niallohiggins.com/2009/09/27/simple-python-twitter-search-api-crawler-class/

Usage: 
1) ensure all the modules are installed
2) to run, execute:- python emotion.py
3) close the Figure1 dummy graph that opens up first
4) The realtime graph now opens up

P.S:- This code is crude and is only useful to understand the working
