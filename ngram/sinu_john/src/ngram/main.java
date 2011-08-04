package ngram;
import java.io.*;

/**
 *
 * @author Sinu John
 *     sinuvian at gmail dot com
 *     www.sinujohn.wordpress.com
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        if(args.length<1) {
            System.out.println("Usage:\tjava -jar ngram.jar sourcefile [--debug]");
            return;
        }

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        int BUFFERSIZE = 16384;
        char[] buffer = new char[BUFFERSIZE];
        int chRead = 1;

        String str = "", s;
        int x=0; //For showing / or \ to indicate responsiveness while reading large files
        System.out.print("\\");
        
        while(chRead>0) { //Reading the file contents into str
            if(x%2==0) System.out.print("\b\\");
            else System.out.print("\b/");
            x++;

            chRead = br.read(buffer, 0, BUFFERSIZE);
            if(chRead>0) {
                s = new String(buffer, 0, chRead);
                str = str + s + " ";
            }
        }

        trigrams tg = new trigrams();
        String strList[] = str.split(" "); //Word lists

        //Add trigrams to tg
        for(int i=0; i<strList.length-2; i++) {
            tg.populate(strList[i], strList[i+1], strList[i+2]);
        }

        if(args.length>=2) //DEBUG option: To display the trigrams 
            if(args[1].equalsIgnoreCase("--debug")) {
                System.out.println("\n\n");
                tg.display();
            }
        
        System.out.println("\n\n\tTHE TRIGRAM STORY!\n\n"+tg.getStory());
    }

}
