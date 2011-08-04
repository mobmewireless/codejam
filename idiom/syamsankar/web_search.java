import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.*;
import java.text.MessageFormat;


public class web_search 
{
// Need to have an application ID to call the Yahoo! services.
    private static final String APPLICATION_ID = "insert app ID";

// URL format for the request(will display 15 result) 
    private static final String WEB_SEARCH_URL_FORMAT ="http://api.search.yahoo.com/WebSearchService/V1/webSearch?appid={0}&query={1}";
/**
*   Main program that takes a query and executes it as a web search
*   using the Yahoo! Web Search Service.
*   @param args Command line arguments. There should be at least 1. 
*/ 
    public static void main(String[] args) throws UnsupportedEncodingException,MalformedURLException, XPathExpressionException,
    ParserConfigurationException 
    {
        // Making sure a query was given.
        String query = null;
        if(args.length == 0) 
        {
	        System.out.println("Usage: java WebSearch <query>");
	        System.exit(1);
        }
        else 
        {
    	// Constructing the query from the command line arguments. 
	        query = prepareQuery(args); 
	    }

        // Constructing the URL by Injecting the URL encoded application ID and the search query.
        URL url = new URL(MessageFormat.format(WEB_SEARCH_URL_FORMAT,new Object[]{URLEncoder.encode(APPLICATION_ID, "utf-8"), 
        URLEncoder.encode(query, "utf-8")}));        

        System.out.println("Request URL = " + url.toString());

        // Creating an XPath engine.
        XPath xpath = XPathFactory.newInstance().newXPath( );

        // For Executing the query.
        Document responseDocument = null;
       try 
       {
    
    	    // We need a Document to use XPath.            
    	    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
           responseDocument = builder.parse(url.openStream()); 
       } 
       catch (IOException e) 
       {
    	    // Error calling the service.
    	    System.err.println("Error calling the service(IO Exception): " + e.toString());
           e.printStackTrace(System.err);
           System.exit(1);
       }
       catch (SAXException e) 
       {
           // Error parsing the XML.
    	    System.err.println("Error parsing the XML(SAXException): " + e.toString());
    	    e.printStackTrace(System.err);
    	    System.exit(1);
       }
       // Query the XML for the total results available.
       String totalResultsAvailable = (String) xpath.evaluate("/ResultSet/@totalResultsAvailable",responseDocument,XPathConstants.STRING);
       System.out.println("Total results available for '" + query + "' is "+ totalResultsAvailable);
    
       // Query the XML for the URLs. 
       NodeList urls = (NodeList) xpath.evaluate("/ResultSet/Result/Url", responseDocument, XPathConstants.NODESET);
       // Initialising Word Analyser class class
       word_analyser analyser = new word_analyser();
       for(int i = 0; i < urls.getLength(); i++) 
       { 
    	    Node urlNode = urls.item(i); 
    	    String url123 = urlNode.getTextContent();
    	    System.out.println("URL " + (i + 1) + ": "+ url123 +"\n\n" );
    	    analyser.go(url123,args);
       }

    }   

/**
* Simple method that stitches together an array of strings into
* a single string. Used to take multiple command line arguments
* and turn it into a single query string.
*
*@param args The individual strings to stitch together.
*@return A new string containing each of the strings passed in, all
*seperated by spaces. 
*/
    private static String prepareQuery(String[] args) 
    {
    	String query="";
    	StringBuffer queryBuffer = new StringBuffer();
    	for (int i = 0; i < args.length; i++) 
    	{
    		queryBuffer.append(args[i]);
		    if((i + 1) < args.length) 
		    {
    			queryBuffer.append(" ");
		    }
	    }
    	query = queryBuffer.toString();

    	return query;

    }

}
