/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mirror;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

/**
 *
 * @author Sanoob
 */
public class ImageCompare {

    public int compare(String img1 , String img2){

        String file1 = img1;
        String file2 = img2;
        System.out.println("File 1:"+file1+"File 2:"+file2);
        Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
        Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
        int fin_val = 0;
        int d1l = 0;
         int d2l = 0;
        int count=0;
        int sel = 0;
        try {

            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

            int[] data1 = null;
            if (grab1.grabPixels()) {
                    int width = grab1.getWidth();
                    int height = grab1.getHeight();
                    data1 = new int[width * height];
                    data1 = (int[]) grab1.getPixels();
            }

            int[] data2 = null;
            if (grab2.grabPixels()) {
                int width = grab2.getWidth();
                int height = grab2.getHeight();
                data2 = new int[width * height];
                data2 = (int[]) grab2.getPixels();
            }

            System.out.println("Pixels equal: " +java.util.Arrays.equals(data1, data2));
            d1l = data1.length;
            d2l = data2.length;
            count=0;
            System.out.println("length : d1:"+d1l+"  d2:"+d2l);
            if(d1l<=d2l){
                sel = d1l;
                System.out.println("loop active");
                for(int i = 0;i<d1l;i++){
                    if(data1[i]==data2[i]){
                        count++;
                    }
                }
            }
            else{
                sel = d2l;
                 for(int i = 0;i<d2l;i++){
                    if(data1[i]==data2[i]){
                        count++;
                    }
                }
            }
            System.out.println("result : "+count);


            } catch (InterruptedException e1) {
            e1.printStackTrace();
            }
            fin_val = (count / sel)*100;
            return(fin_val);

    }


    }



