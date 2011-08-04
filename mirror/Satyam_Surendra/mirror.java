import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;



public class mirror extends Frame{
	
	Image img;
//	static String theImgFile = "img1.jpg";
	 MediaTracker tracker; 
	 int c=0;
	 int r=0;
	 int[][][] threeDPix;
	  int[][][] threeDPixMod;
	  int[] oneDPix;
	 
	 public mirror(String url) throws MalformedURLException
	 { 
		 try{
		 
		 
		 img = Toolkit.getDefaultToolkit().getImage(new URL(url));
		 tracker = new MediaTracker(this);
		    tracker.addImage(img,1);

		   
		      if(!tracker.waitForID(1,10000)){
		        System.out.println("Load error.");
		        System.exit(1);
		      }//end if
		    }catch(InterruptedException e){
		      e.printStackTrace();
		      System.exit(1);
		    }//end catch

		    //Make certain that the file was successfully
		    // loaded.
		    if((tracker.statusAll(false)
		                   & MediaTracker.ERRORED
		                   & MediaTracker.ABORTED) != 0){
		      System.out.println(
		                      "Load errored or aborted");
		      System.exit(1);
		    }//end if
		 
	c = img.getWidth(this);
		   r = img.getHeight(this);
		 
		   oneDPix = new int[c*r];
		   
		   try{
		   PixelGrabber pgObj = new PixelGrabber(
                   img,0,0,c,r,
                           oneDPix,0,c);
		  
		   
		   
		   
		   
		   if(pgObj.grabPixels() &&
                   ((pgObj.getStatus() &
                   ImageObserver.ALLBITS)
                                  != 0)){
			   
			   
			   threeDPix = convertToThreeDim(
                       oneDPix,c,r);
 
			   
		   }
		   
		   }
		   catch(Exception e)
		   {
			   
			   
		   }
		   
		   
		   
	 }
	
	 int[][][] convertToThreeDim(
	          int[] oneDPix,int imgCols,int imgRows){
	    //Create the new 3D array to be populated
	    // with color data.
	    int[][][] data =
	                    new int[imgRows][imgCols][4];

	    for(int row = 0;row < imgRows;row++){
	      //Extract a row of pixel data into a
	      // temporary array of ints
	      int[] aRow = new int[imgCols];
	      for(int col = 0; col < imgCols;col++){
	        int element = row * imgCols + col;
	        aRow[col] = oneDPix[element];
	      }//end for loop on col

	      //Move the data into the 3D array.  Note
	      // the use of bitwise AND and bitwise right
	      // shift operations to mask all but the
	      // correct set of eight bits.
	      for(int col = 0;col < imgCols;col++){
	        //Alpha data
	        data[row][col][0] = (aRow[col] >> 24)
	                                          & 0xFF;
	        //Red data
	        data[row][col][1] = (aRow[col] >> 16)
	                                          & 0xFF;
	        //Green data
	        data[row][col][2] = (aRow[col] >> 8)
	                                          & 0xFF;
	        //Blue data
	        data[row][col][3] = (aRow[col])
	                                          & 0xFF;
	      }//end for loop on col
	    }//end for loop on row
	    return data;
	  }
	 
	// public static void main(String[] args)throws MalformedURLException
	// {
		 
	 //}
	 
	 
	
}