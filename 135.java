/**
135. Candy
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors. （NOTE THIS! Equal ratings can have different candies)
What is the minimum candies you must give?
*/
public class Solution {
    public int candy(int[] ratings) {
        final int[] candies=new int[ratings.length];
        for(int i =1;i<ratings.length;i++)
        {
		    if(ratings[i]>ratings[i-1])
		    {
			    candies[i]=candies[i-1]+1;
		    }
        }
        for (int i= ratings.length-1; i>0 ; i--)
    	 {
    		 if(ratings[i-1]>ratings[i])
    		 {
    			 candies[i-1]=Math.max(candies[i]+1,candies[i-1]);
    		 }
    	 }
    	 
    	 int result=0;
    	 for (int i = 0; i <  ratings.length; i++)
    	 {
    		 result+=candies[i]+1;
    	 }
    	 return result;
    }
}