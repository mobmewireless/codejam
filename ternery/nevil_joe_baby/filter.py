import subprocess
import sys

#Opening pipe to the program which prints 10 digit numbers
process_object = subprocess.Popen(["python","print_numbers.py"],
					 stdout=subprocess.PIPE)
#output of the program 'print_numbers.py' and is given as input of this program
sys.stdin = process_object.stdout

for line in sys.stdin:
    #creating filenames depending on the first digit of the number
    filename = line[0] + '.txt'
    file_object = open(filename, 'a')
    file_object.write(line)
    file_object.close()

#closing the pipe
process_object.stdout.close()
