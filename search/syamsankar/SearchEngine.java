import java.util.*;
import java.io.*;
import java.util.regex.*;
 
// This class indexes the stored webpage and then performs a query operation     
public class SearchEngine
{
    Hashtable<String, ArrayList<String> > ht = new Hashtable<String, ArrayList<String> >();

    public static void main(String [] args)
    {
        new SearchEngine().go();
    }


    public void go()
    {
        
        String[] keywords = {"CTO","ANOOP SHANKAR","CodeJam","MobME","VISHNU GOPAL",};
        System.out.println("Keywords are "+keywords[0]);
        System.out.println("Indexing all the downloaded files. ");
        BufferedReader br = null;
        Pattern pattern;
        
        try
        {
            for(int i = 0; i < LinkDownloader.fileName.length; i++)
            {
                br = new BufferedReader(new FileReader(LinkDownloader.fileName[i]));//reads information from the downloaded files
                System.out.println("The "+LinkDownloader.fileName[i]+" is being read. Processing information, please wait...");
     
               while(br.ready())
               {//should repeat until there are no more lines to read
                   String line = br.readLine();//assigns the line read by the reader to line
                   
                        for(int j = 0; j < keywords.length; j++)
                        {
                              pattern = Pattern.compile(keywords[j]);      
                              Matcher matcher = pattern.matcher(line);      
                              if(matcher.find() || !ht.containsKey(keywords[j]) ) 
                              {
                                 ArrayList<String> temp = new ArrayList<String>(1);
                                 temp.add(LinkDownloader.fileName[i]);
                                 ht.put(keywords[j],temp);//assigns a key to anonymous ArrayList that stores the value
                              }
                            else 
                            {
                                  ArrayList<String> temp = (ArrayList<String>)ht.get(keywords[j]);//if the key has already been assigned, then
                                  temp.add(LinkDownloader.fileName[i]); //just add the argument to the ArrayList!
                            }
                        }                   
                }
            }
            br.close();
            ask();
        }
        catch(Exception e)
        {
              System.out.println("Exception occured"); 
              e.printStackTrace(); 
              System.out.println(e);
             System.exit(1);
        }

        //System.out.println(ht);

    }//end go method

    void ask()
    {
        try{
        Scanner kb = new Scanner(System.in);
           do
        {
            System.out.println("Enter a key to search for the sites it is associated with.\n");
            System.out.println("* "+ht.get(kb.nextLine()));
            System.out.println("\nKeep searching? Enter any key to continue, or type <NO> to end the process");
        }
        while(!kb.nextLine().equalsIgnoreCase("<NO>"));
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }

}//end class
