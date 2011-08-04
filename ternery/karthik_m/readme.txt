Design
______

1. random.php is the number generator that keeps printing out 10 digit numbers, one in each line.
   It uses the mt_rand() which is natively available in PHP to generate random numbers.
2. filter.php does the filtration using the substr() available in PHP. fets() is used to retrieve the number from the file.
3. The storage of the number is achieved by using the switch statement.
4. random_lines.php when executed executes the first(random.php) & the second(filter.php) program respectively in the background. 
5. Please make sure all the files are in the same folder and that the directory has write, read & execute permissions. 
6. The output wont be generated if the script is run using the browser since the time-out set by default will takeplace before you 
   get the results on the screen.
7. The random_lines.php detects how the program is stopped and necessary executions are carried out to stop the background processes.

Dependencies
____________

1. PHP 
2. Linux system depenedent code. Changes necessary if migrating to Windows

Usage
_____

For the program to run, execute "php -q random_lines.php" on the linux shell

Note: 
The processes are automatically killed if the program SIGINT (interrupt), SIGHUP (hang-up), SIGTERM (terminate cleanly).
Since the code is run on the background for the execution of the first two files, it still keeps running even after exiting,
If SIGKILL (terminate immediately, clean or otherwise) is used then to kill the background processes
use  "ps -ef | grep php" command
Find the pid of these two processes & kill them
/usr/bin/php -q random.php
/usr/bin/php -q filter.php