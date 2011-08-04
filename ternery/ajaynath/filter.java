import java.io.*;
import java.net.*;
import javax.naming.*;
class filter
		{
		public static void main(String[] args)throws IOException
		  {
		  ServerSocket welcomeSocket = new ServerSocket(6789);
System.out.println("Run the generator");
			

             while(true)
         		{ 
            
            	try{Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient =
               new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            	String cs = inFromClient.readLine();
         		char[] cc=cs.toCharArray();
			String fn=Character.toString(cc[0]);
			
			System.out.println("Got "+cs);
			System.out.println("Printing to "+fn+".txt");
			
			FileWriter outFile = new FileWriter(fn+".txt",true);
                PrintWriter out = new PrintWriter(outFile);
                out.println(cs);
			out.close();
			}
			catch(SocketException dd)
				{//System.exit(0);
				}
            	

         		}
        	 }
		}