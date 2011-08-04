DESIGN

There are 3 programs.

1) print_numbers.py

It prints random 10 digit numbers. It diplays the number using standard output.


2) filter.py

It filters the ouput of the first program 'print_numbers.py' and save the numbers to different files depending on the first digit of the number.
First of all it creates a pipe to the standard output of the first program. Then the output of the first program is fed as the input of this 
program through the pipe.It takes the numbers one by one from the standard input and checks the first digit of the number. 
It saves the numbers to the corresponding file.


3) watchdog.py

It keeps watching on the count of numbers in each file and displays it in every 1 second. 
It opens all the files one by one and reads all the lines in a file at once.
It creates a list of all the lines. 
Length of the list is the count of numbers in that file. It displays the length of the list. Then it sleeps for 1 second.
	

EPENDECIES

1) print_numbers.py
depends on 'random' and 'sys' modules

2)filter.py
depends on 'subprocess' and 'sys' modules

3)watchdog.py
depends on 'time' module

All these modules are in standard python library



USAGE

First execute filter.py
Then execute watchdog.py
print_numbers.py will be automatically executed from filter.py. No need to execute it manually.	
