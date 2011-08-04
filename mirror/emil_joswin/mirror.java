import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class ImageBand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Input link1 :: ");
		String url1 = scan1.nextLine();
		System.out.println("Input link2 :: ");
		String url2 = scan1.nextLine();

		BufferedImage img0 = null;
		BufferedImage img1 = null;
		int scale = 0;
		
		try {
		    img0 = ImageIO.read(new URL(url1));
		    img1 = ImageIO.read(new URL(url2));
		} catch (IOException e) {
		    System.out.println("image not found");
		}
		Raster r1 = img0.getData();
		Raster r2 = img1.getData();
		if (r1.getNumBands() != r2.getNumBands() ||
				  r1.getWidth() != r2.getWidth() ||
				  r1.getHeight() != r2.getHeight()) {
			System.out.println("similarity :: "+ 0);	
			System.exit(0);
		}
				  
				  
		double count= 0;
		double count1 = 0;
		
		for (int i=0; i<r1.getNumBands(); ++i) {
		    for (int x=0; x<r1.getWidth(); ++x) {
		      for (int y=0; y<r1.getHeight(); ++y) {
		        if (r1.getSample(x, y, i) == r2.getSample(x, y, i)) {
		          // At least one sample differs so result is false;
//		          ret = false;
		          // Use labeled break to terminate all loops.
		          count++;
		        }else count1++;		        
		      }
		    }
		}
		System.out.println("similarity :: "+ (int)(count/(count+count1) * 100));	

	}

}
