/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sandboxserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Sanoob
 */
public class sandbox_file {

    public boolean remove_file(String fname){
        File f = new File(fname);
        if(f.delete()){
            return true;
        }

        else{
            return false;
        }
    }

 public boolean create_file(String fname , String content){
    try{

         FileWriter fwrtr = new FileWriter(fname);
         BufferedWriter out = new BufferedWriter(fwrtr);
         out.write(content);
         out.close();
         return true;
    }catch (Exception e){
        e.printStackTrace();
        return false;
    }


 }


}
