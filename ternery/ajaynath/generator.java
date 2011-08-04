import java.io.*;
import java.util.Random;
import java.net.*;
class generator
		{
		public static void main(String s[])throws IOException
			{
			Random rand = new Random();
			while(true)
				{
			
				long drandd = (long)(rand.nextDouble()*10000000000L);
				if(drandd>1000000000)
				    {
				     System.out.println("Random number is"      +drandd);
					try{
 						Socket clientSocket = new Socket("localhost", 6789);
						DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
						outToServer.writeBytes(drandd+"\n");
  
					    }
				      catch(ConnectException wws)
						{
						//System.out.println("Failure");
						}
					}
				}//
			}
		}
