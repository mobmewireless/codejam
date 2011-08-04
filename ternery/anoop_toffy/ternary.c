/*
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%    Copyright (C) 2011         CODEJAM					   %	
%									   %
%	Author : Anoop Toffy <anoop.toffy90@gmail.com>			   %
%									   %
%    This program is free software: you can redistribute it and/or modify  %
%    it under the terms of the GNU General Public License as published by  %
%    the Free Software Foundation, either version 3 of the License, or     %
%    (at your option) any later version.				   %
%									   %
%    This program is distributed in the hope that it will be useful,       %
%    but WITHOUT ANY WARRANTY; without even the implied warranty of        %
%    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         %
%    GNU General Public License for more details.              		   %
%									   %
%    You should have received a copy of the GNU General Public License     %
%    along with this program.  If not, see <http://www.gnu.org/licenses/>. %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
*/

#include <stdio.h>
#include <string.h>
#include <time.h>

static char *command1 = "./filter.exe";
static char *command2 = "./count.exe";  // commands to be executed by pipes
void waitFor (unsigned int secs) {
	int retTime;
	retTime = time(0) + secs;     // Get finishing time.
	while (time(0) < retTime);    // Loop until it arrives.
}
main()  // program execution starts here
{
	long int n; //declare variables
	n = 1000000000;
	system("rm *.txt"); // remove files to create  a new copy
	FILE *fp,*fp1,*fp2; // declare file pointers
	remove("output");
	for(;n<=9999999999;n++) // for loop of cource the main loop
	{
		waitFor(1);     //  a delay is given 
		fp = fopen("output","w"); // open file for reading
		putw(n,fp); // put into the file long int numbers
		fclose(fp);		// close the file
		printf("%ld\n",n); // output the number used
		fp1 = popen(command1,"r"); // pipe1 to execute command 1
		pclose(fp1); // close pipe 1
		fp2 = popen(command2,"w"); // pipe 2 to execute commmand 2
		pclose(fp2); // close pipe 2
	}
	printf("\n");
	return 0;
}// end of main funtion . Program ends here

// --------------HAPPY HACKING------------//
