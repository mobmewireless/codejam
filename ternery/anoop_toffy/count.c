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

main()
{
	int count,input;				//declare necessary variable
	FILE *fp,*fp0,*fp1,*fp2,*fp3,*fp4,*fp5,*fp6,*fp7,*fp8,*fp9; // declare function pointers
	count = 0; 			// initialize variables
	
	fp0 = fopen("0.txt","r"); 
	fp1 = fopen("1.txt","r");
	fp2 = fopen("2.txt","r");
	fp3 = fopen("3.txt","r");	//open file necessary to read and count
	fp4 = fopen("4.txt","r");
	fp5 = fopen("5.txt","r");
	fp6 = fopen("6.txt","r");
	fp7 = fopen("7.txt","r");
	fp8 = fopen("8.txt","r");
	fp9 = fopen("9.txt","r");
						// counting starts here. When newline ecountered count is incremented
	while ((input = fgetc(fp0)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 0.txt = %d\n",count);
	count = 0;		// re initialize count to count next file
	while ((input = fgetc(fp1)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 1.txt = %d\n",count);
	count = 0;
	while ((input = fgetc(fp2)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 2.txt = %d\n",count);
	count = 0;
	while ((input = fgetc(fp3)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 3.txt = %d\n",count);
	count = 0;	
	while ((input = fgetc(fp4)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 4.txt = %d\n",count);
	count = 0;
	while ((input = fgetc(fp5)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 5.txt = %d\n",count);
	count = 0;
	while ((input = fgetc(fp6)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 6.txt = %d\n",count);
	count = 0;
	while ((input = fgetc(fp7)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 7.txt = %d\n",count);
	count = 0;
	while ((input = fgetc(fp8)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 8.txt = %d\n",count);
	count = 0;
	while ((input = fgetc(fp9)) != EOF)
	{	
		if(input == '\n')
			count++;
	}
	printf("\nNo: Of Numbers in 9.txt = %d\n",count);

	fclose(fp0);
	fclose(fp1);
	fclose(fp2);
	fclose(fp3);
	fclose(fp4);		// close all opened files
	fclose(fp5);
	fclose(fp6);
	fclose(fp7);
	fclose(fp8);
	fclose(fp9);			
	printf("\n");
	return 0;
}// end of main
