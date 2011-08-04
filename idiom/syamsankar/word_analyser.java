import java.io.*;
import java.net.*;
import java.util.regex.*;

// This class will analyse and otput the usage of the word from the url passed to its go()
public class word_analyser
{
  /*  public static void main(String[] args) throws MalformedURLException
    {
        new word_analyser().go("http://en.wikipedia.org/wiki/Bloom_filter","boolean");
    }*/
    void go(String newURL,String [] args)
    {
        try 
        {
                String lookword="";
    	        StringBuffer queryBuffer = new StringBuffer();
    	        for (int i = 0; i < args.length; i++) 
    	        {
    		        queryBuffer.append(args[i]);
		            if((i + 1) < args.length) 
		            {
    			        queryBuffer.append(" ");
		            }
	            }
    	        lookword = queryBuffer.toString();
        
        
        
        
        
            URLConnection connection = new URL(newURL).openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;Boolean print = true ;
            String word = lookword.toLowerCase();
            System.out.println(word); 
            String HTML_REGEX = "(<.+?>)+"; 
            int i = 0;
            while ((line = br.readLine()) != null && print) 
            {   
                String content;
                if ((content = line.replaceAll(HTML_REGEX, "")) != null) 
                {
                    if (content.toLowerCase().contains(word)) 
                    {
                        i++;
                        System.out.println(content); 
                        if(i > 3)
                        {
                            print = false;
                        }
                     }
                }
            }
            br.close();
        }    
        catch(MalformedURLException e)
        {
            System.out.println("Error in given URL");
            e.printStackTrace();
            return;
        }
        catch(UnknownHostException e)
        {
            System.out.println("Unknown Host");
            e.printStackTrace();
            return;
        }
        catch(IOException e)
        {
            System.out.println("Error in opening URLConnection, Reading or Writing");
            e.printStackTrace();
            return;
        }
        catch(Exception e)
        {
            System.out.println("Exception occured");
            e.printStackTrace();
            return;
        }        

    }
} 
