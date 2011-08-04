import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class plotter{
	
public static void main(String asd[])throws MalformedURLException

{
	
	InputStreamReader isr= new InputStreamReader(System.in);
	BufferedReader x= new BufferedReader(isr);
	
	double d=0.0;
	System.out.println("Please enter the URL of the first image...");
	
try{
	
	String url1=x.readLine();
	System.out.println("Please enter the URL of the second image...");
	String url2=x.readLine();
	mirror a =new mirror(url1);
	
	mirror  b= new mirror(url2);
	
	
	if((a.c==b.c)||(a.r==b.r))
	{
		d=compare(a,b,a.r,a.c);
		System.out.println("The images are "+d+" % different...");
	}
	else
	{
		
	if(a.r>b.r)
	{
		
		//System.out.println(a.c);
	//	System.out.println(b.c);
		if((int)Math.round((a.r/b.r)+0.5)==(int)Math.round(a.c/b.c))
		{
		
			d=compare(a,b,b.r,b.c);
			if(d<2.0)
			{
				System.out.println("Almost same images...They are technically "+d+" % different but different in resolution only...");
				
			}
			
			
		}
		
	}
	else if(b.r>a.r)
	{
	//System.out.println("Images not appropriate for comparison...");	
		
		if((int)Math.round((b.r/a.r)+0.5)==(int)Math.round(b.c/a.c))
		{
		
			d=compare(a,b,a.r,a.c);
			if(d<2.0)
			{
				System.out.println("Almost same images...They are technically "+d+" % different but different in resolution only...");
				
			}
			
			
		}
		
		
	}
	else {
		System.out.println("Images not appropriate for comparison...");
		
	}
	}
	
	
	
	
	
}
catch(Exception e)
{}
}	
	
public static double compare(mirror a,mirror b,int x,int y){
	
	
	int ds=0;
	int dr=0;
	int dg=0;
	int db=0;
double dps,dpr,dpg,dpb=0;
	for(int i=0;i<x;i++)
	{
		for(int j=0;j<y;j++)
		{
			
			ds=ds+Math.abs(a.threeDPix[i][j][0]-b.threeDPix[i][j][0]);
			dr=dr+Math.abs(a.threeDPix[i][j][1]-b.threeDPix[i][j][1]);
			dg=dr+Math.abs(a.threeDPix[i][j][2]-b.threeDPix[i][j][2]);
			db=dr+Math.abs(a.threeDPix[i][j][3]-b.threeDPix[i][j][3]);
			
			                      
			
		}
		
		
	}
	dps=ds/(255.0*a.r*a.c);
	dpr=dr/(255.0*a.r*a.c);
	dpg=dg/(255.0*a.r*a.c);
	dpb=db/(255.0*a.r*a.c);
	
double ovrdiff=(dps+dpr+dpg+dpb)/4;
return ovrdiff;
	
	
}	
	
}