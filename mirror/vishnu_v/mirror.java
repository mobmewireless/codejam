/**********************************************************
This is a program to findout similarity between two images 
Here the rgb intensity of images are calculated to findout 
similarity rank
***********************************************************/
import java.awt.Image;
import java.io.*;;
import javax.imageio.*;
import java.net.*;


public class mirror {


	public void mirrorImages(String url1,String url2){
		match ma=null;
		image im=new image();
		URL url =null;
		Image im2=null,im1=null;
		try{
			url= new URL(url1); 
			im1 = ImageIO.read(url);
			url = new URL(url2); 
			im2 = ImageIO.read(url); 
		}catch(Exception E){
			System.out.println("Exception in loading image"+E);
			return;
		} 
		double d1[]=im.getFeature(im1);
		double d2[]=im.getFeature(im2);
		ma=new match();
		double mat= ma.distance(d1,d2);
		if (mat>1){
			mat=1;
		}
	        int perc=(int)((1-mat)*100); 
		System.out.println("Similarity="+perc);
	}
	public static void main(String args[]){
		mirror CI=new mirror();
		String url1=null,url2=null;
		System.out.println("Enter url of first image");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*getting url of images*/
		try{
			url1=br.readLine();
			System.out.println("Enter url of second image");
			url2=br.readLine();
		}catch(Exception E){
			System.out.println("Exception "+E);
		}
		CI.mirrorImages(url1,url2);
	}
}
	 
            
    
