import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Invariant {
    
	/**
	 * @param args
	 */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int k = -1;//for representing the kth element
	int[] count = new int[8991];//for storing the iteration count for various numbers 
	
	try {
		//opens the output file "resultOutput.txt"
	    PrintWriter result_Output = new PrintWriter(new FileWriter("resultOutput.txt"));
	    result_Output.println("Iteration     Total Count of Numbers");
	    
	    for(int i = 1000; i < 9999; i++){
		String str = Integer.toString(i);
		char[] small_Char = str.toCharArray();
		Arrays.sort(small_Char);
		String small_No = new String(small_Char);
		
		boolean distinct = false;
		for(int j = 0; j < 3; j++){//finding whether atleast two elements are distinct.
		    if(small_No.charAt(j)!= small_No.charAt(j+1)){
			distinct = true;
		    }
		}
		if(!distinct){//if not atleast two elements are distinct we cant proceed with the number (xxxx- xxxx = 0). Therefore we find next number.
		    continue;
		}

		k++;	
		char[] big_Char = new char[4];
		for(int j = 0; j < 4; j++) big_Char[j] = small_Char[3-j];
		
		count[k] = 0;//intitialise count[k] to be zero.
		int smallInt = 0;//smallest integer possible by rearranging the digits
		int big_Int = 0;//largest integer possible by rearranging the digits
		int diff =0;
		boolean a = true;
		while(a){// finds out the count of the number of iterations and stores in count[k]
		    smallInt = Integer.parseInt(new String(small_Char));
		    big_Int = Integer.parseInt(new String(big_Char));
		    
		    diff = big_Int - smallInt;//finds the difference
		    count[k]++;
		    
		    if(diff == 6174) {//when the diff = 6174 we have reached the required number of iterations
			a = false;
			break;
		    }
		    else{
		    	//if the diff is not a four digit number make it so by repeatedly multiplying with 10
			while(diff < 1000){
				
			    diff = diff*10;
			}
			
			str = Integer.toString(diff);
			small_Char = str.toCharArray();
			Arrays.sort(small_Char);//finds the smallest number possible with the digits in diff
			
			for(int j = 0; j < 4; j++) big_Char[j] = small_Char[3-j];//similarly finds the largest possible number
		    }                                                        
		    
		}		
	    }
	    Arrays.sort(count);//sorting the array containing the count of iterations so that similar counts[k] are grouped. For simple grouping of count values.
	    	
	    int resultCount = 1;//for finding no of numbers having similar count
	    int j = 0;
	    		
	    for(j = 1; j < count.length; j++){
		if(count[j-1] == count[j]){//until the count is similar the number is incremented
		    resultCount++;
		    continue;
		}
		result_Output.println(count[j-1] + "             " +resultCount);
		resultCount = 1;//reintializing since the count value has changed.
	    }
	    result_Output.println(count[j-1] + "             " +resultCount);//printing output to the output stream.
	    
	    result_Output.close();
	   
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    System.out.println("The file could not be created.");	
	}
	
    }
    
}
