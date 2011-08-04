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
#include <ctype.h>
#include <string.h>

main()
{
	int rem;
	long int n,num; // declare variables
	FILE *fp,*fp0,*fp1,*fp2,*fp3,*fp4,*fp5,*fp6,*fp7,*fp8,*fp9; // declare funtion pointers
	rem = 0;
	fp = fopen("output","r");
	fp0 = fopen("0.txt","a");
	fp1 = fopen("1.txt","a");
	fp2 = fopen("2.txt","a");
	fp3 = fopen("3.txt","a");
	fp4 = fopen("4.txt","a");
	fp5 = fopen("5.txt","a");	// Open necessary files
	fp6 = fopen("6.txt","a");
	fp7 = fopen("7.txt","a");
	fp8 = fopen("8.txt","a");
	fp9 = fopen("9.txt","a");
	while(!feof(fp))
	{	
		n = getw(fp);
		num =(long int)n;  // find remainder to get the last digit and enter into file corresponding using switch(){ .. case ..}
		rem = num%10;
		switch(rem)
		{
			case 0: 
				fprintf(fp0,"%ld\n",n);
				break;
			case 1:
				fprintf(fp1,"%ld\n",n);
				break;
			case 2:
				fprintf(fp2,"%ld\n",n);
				break;
			case 3:
				fprintf(fp3,"%ld\n",n);
				break;
			case 4:
				fprintf(fp4,"%ld\n",n);
				break;
			case 5:
				fprintf(fp5,"%ld\n",n);
				break;
			case 6:
				fprintf(fp6,"%ld\n",n);
				break;
			case 7:
				fprintf(fp7,"%ld\n",n);
				break;
			case 8:
				fprintf(fp8,"%ld\n",n);
				break;
			case 9:
				fprintf(fp9,"%ld\n",n);
				break;
			default:
				break;
		}
	}
	fclose(fp);
	fclose(fp0);
	fclose(fp1);
	fclose(fp2);
	fclose(fp3); // close opened files
	fclose(fp4);
	fclose(fp5);
	fclose(fp6);
	fclose(fp7);
	fclose(fp8);
	fclose(fp9);	
	return 0;
}// end of main
