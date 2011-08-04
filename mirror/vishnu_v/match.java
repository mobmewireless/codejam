/*************************findout the dimensions**********/
public class match
{

 static double distance(double dis1[],double dis2[])
   {
      double d=0;
      for(int i=0;i<4;i++)
      d=d+Math.pow(dis1[i]-dis2[i],2);     
      return d;
    }
    
  }  
