/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mirror;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanoob
 */
public class mirror_main {



    public String load_img(String path , String name , Component comp){
     String filename = null;
     String namef = null;
    if((path.toLowerCase().contains(".jpg")) || (path.toLowerCase().contains(".jpeg")) || (path.toLowerCase().contains(".gif")) || (path.toLowerCase().contains(".png")) || (path.toLowerCase().contains(".bmp"))){
    try{

    URL u = new URL(path);
    URLConnection uc = u.openConnection();
    String contentType = uc.getContentType();
    int contentLength = uc.getContentLength();
    String fname = u.getFile();
    System.out.println("content type: "+contentType+" :::"+fname);
    String fk = fname.substring(fname.length()-4);
    System.out.println("sfs:"+fk);
    InputStream raw = uc.getInputStream();
    InputStream in = new BufferedInputStream(raw);
    BufferedImage img;
    byte[] data = new byte[contentLength];
    int bytesRead = 0;
    int offset = 0;
    while (offset < contentLength) {
      bytesRead = in.read(data, offset, data.length - offset);
      if (bytesRead == -1)
        break;
      offset += bytesRead;
    }

    in.close();
    File f = new File("temp_san");
    f.mkdir();
    filename = "temp_san/"+name+""+fk.trim();
    FileOutputStream out = new FileOutputStream(filename);
    out.write(data);
    out.flush();
    out.close();
    namef = name+fk.trim();
    }catch(Exception e){
        e.printStackTrace();
    }
    return(namef);
    }
    else{
        JOptionPane.showMessageDialog(comp, "Please enter valid image links","Invalid link",JOptionPane.ERROR_MESSAGE);
        return(null);
    }
     
    }

    public Image ret_img(String fname){
        Image img = null;

        img = Toolkit.getDefaultToolkit().getImage("temp_san/"+fname);
        System.out.println("image:"+img.toString());

        return(img);

    }


    public void create_html(){

        String s = null ;
        try{

        FileWriter fstream = new FileWriter("temp_san/image1.html");
        BufferedWriter out = new BufferedWriter(fstream);
        s="<html><body><img src=\"imagea.jpg\"></img></body></html>";

        out.write(s);

        out.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
  }


}


