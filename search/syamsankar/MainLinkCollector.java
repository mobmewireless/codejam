import java.io.*;
import java.net.*;
import java.util.regex.*;

// This class will collect all the links from the main page
public class MainLinkCollector
{
    public static void main(String[] args) 
    {
        new MainLinkCollector().go(); 
    }
    void go()
    {
        try 
        {
            URL sendURL; 
            URL mainURL = new URL("http://www.mobme.in");
            URLConnection connection = mainURL.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            
            
           /* From the expression below we can identify all links of the type <a href="./">, and this is the output. 
            <a href="./products">
            <a href="./people">
            <a href="./news">
            <a href="./careers">
            <a href="./life">
            <a href="./contact">
            <a href="./todo">*/
            String regexp = "<a\\shref=\"[^\"#h]+\">";   
            Pattern pattern = Pattern.compile(regexp);
            
            
            // We will use the following arrays to trim the above result to the form "/products" which will be concatenated with the main url
            // to form the links from this main page.           
            String link, sidelinkFull,finallink,line = "";
            String [] sidelinkTrim;
            String [] sidelink;
            
            link = mainURL.toString();
            System.out.println("The main link :"+link);
            
          LinkDownloader linkDown = new LinkDownloader();
            
            while ((line = br.readLine()) != null)
            {
                Matcher matcher = pattern.matcher(line);
                if(matcher.find())
                {
                    sidelinkFull = matcher.group();     // this contains the link of the form <a href="./products">
                    sidelinkTrim = sidelinkFull.split("href=\"\\."); // this will split it to /products">
                    sidelink = sidelinkTrim[1].split("\"\\>");      // this will split it to /products
                    
                    finallink= link+sidelink[0]; // this will form the whole link http://www.mobme.in/products
                    
                    System.out.println(finallink);
                    
                    sendURL = new URL(finallink);
                    linkDown.downloadLinkPage(sendURL);
                } 
            }
            br.close();
        
            System.out.println("The downloaded files are :");
            for(int i = 0; i < LinkDownloader.fileName.length; i++)
            {
                System.out.println(LinkDownloader.fileName[i]);
            }
            SearchEngine search = new SearchEngine();
            search.go();
        
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
