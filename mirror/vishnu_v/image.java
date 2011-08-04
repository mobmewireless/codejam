/**************Comparing images with rgb intensity*****************/
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import javax.swing.ImageIcon;

public class image 
{
   ImageIcon ii;
   ColorModel cm;
   String fnme;
   
   double[] getFeature(Image img)
   {
   
    try
    {
    Image im= img;
    int w=im.getWidth(null);
    int h=im.getHeight(null);
    int n=w*h;
    int pix[]=new int[n];
    PixelGrabber pg=new PixelGrabber(im,0,0,w,h,pix,0,w);
    
    cm=ColorModel.getRGBdefault();
    try
    {
     pg.grabPixels();
     int ppix[][]=new int[w][h];
     int gs[][]=new int[w][h];
     int temp[][]=new int[w][h];
     int posv[][]=new int[w][h];
     double cocc[][]=new double[w][h];
     int i=0,j=0;
     int l=0;
     for(i=0;i<w;i++)
     for(j=0;j<h;j++)
      {
        ppix[i][j]=pix[l++];
      
     	int px=ppix[i][j];
	int r=cm.getRed(px);
	int g=cm.getGreen(px);
	int b=cm.getBlue(px);
	int m=Math.max(Math.max(r,g),b);
	gs[i][j]=m;
	temp[i][j]=(gs[i][j]*2)/255;
     }      
     
       int mi=0,mj=0,sumposv=0;
       for(mi=0;mi<3;mi++)
       for(mj=0;mj<3;mj++)
        {
	 int count=0;
	 for(i=0;i<w-1;i++)
         for(j=0;j<h-1;j++)
	  { 
	   if (temp[i][j]==mi && temp[i+1][j+1]==mj)
	      {
	       count++;
	       //System.out.println(count);
	       
	     }
	   }
	    posv[mi][mj]=count;
	     //System.out.println(posv[mi][mj]);
	    sumposv=sumposv+posv[mi][mj]; 
	    
	 }  
       double f1=0,s,f2=0,f3=0,big=cocc[0][0],f4=0;
       double fture[]=new double[4];
       for(mi=0;mi<3;mi++)
       for(mj=0;mj<3;mj++)
	 {
	 	cocc[mi][mj]=(double) posv[mi][mj]/sumposv;
	 	//System.out.println(cocc[mi][mj]);
	 	s=((mi-mj)*(mi-mj))*cocc[mi][mj];
	 	f1=f1+s;
	 	fture[0]=f1;
	 
	 	if(mi!=mj)
	 	{
	 		s=cocc[mi][mj]/((mi-mj)*(mi-mj));
	 		f2=f2+s;
	 	}
	 	fture[1]=f2;
	 
	 	s=(cocc[mi][mj]*cocc[mi][mj]);
	 	f3=f3+s;
	 	fture[2]=f3;
	 
 	 	//big=Math.max(cocc,cocc[mi+1][mj+1]);
		if (cocc[mi][mj]>big)
		  big=cocc[mi][mj];
	  	f4=big;
	  	fture[3]=f4;
      	 }
 	    
      return fture;
       }
    
    catch(Exception e)
    {
    System.out.println(e);
    } 
    }
   catch(Exception e)
   {
   System.out.println(e);
   }
    return null;
   
}     
   
      
 } 
  
  
