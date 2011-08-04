import java.io.*;
import java.util.*;
import java.net.*;

// Class which will download webpage from the URL passed.
class LinkDownloader
{
        static int i = 0;          // to iterate through file name in the while loop.
       
        
        // This is the name of the page to be created.        
        public static String [] fileName = {"main.html","products.html","people.html","news.html","careers.html","life.html","contact.html","todo.html"};
  
        void downloadLinkPage(URL downloadURL) 
        {
    
            try
            {
                   System.out.println("The URL link- "+downloadURL.toString()+ " from the main page are being downloaded, please wait... :-) ");
                    URLConnection connection = downloadURL.openConnection();
                    BufferedReader breader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                   // String line = "";
                   String line;
     
            
                   // String [] keywords = {"CTO","Anoop Sankar","CodeJam","MobME"}
                    //Boolean []check = new Boolean[keywords.length];
                    
                    FileWriter writer;
                    writer = new FileWriter(fileName[i]);          
                    i++; // next time the net file name will be used as this is a static int.
        
        
                    while (breader.ready())
                    {
                        line = breader.readLine();
                     //   System.out.println(line);
                        writer.write(line);
                            
                    }
                    breader.close();
                    writer.close();
              }
              catch(MalformedURLException e)
              {
                System.out.println("Error in given URL");
                return;
              }
              catch(UnknownHostException e)
              {
                System.out.println("Unknown Host");
                return;
              }
              catch(IOException e)
             {
                System.out.println("Error in opening URLConnection, Reading or Writing");
                return;
             }   
        }
}        
    
    
    
