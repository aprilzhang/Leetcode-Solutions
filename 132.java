/**
132. Palindrome Partitioning II
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
//My solution, time limit exceed
class Solution {
    public int minCut(String s) {
        final int[][] minCuts = new int[s.length()][s.length()];
        for(int i =0;i<s.length();i++)
        {
            for(int j =i+1;j<s.length();j++)
            {
                minCuts[i][j] = -1;
            }
        }
        
        computeMinCuts(s,0,s.length()-1,minCuts);
        return minCuts[0][s.length()-1];
    }
    
    public int computeMinCuts(String s,int start, int end,int[][] minCuts) {
        
        if(isPalindrome(s,start,end,minCuts)||start>=end)
        {
            return 0;
        }
        
        if(minCuts[start][end]>=0)
        {
            return minCuts[start][end]; 
        }
        
        int min = Integer.MAX_VALUE;
        for(int cutPosition = end-1;cutPosition>=start;cutPosition--)
        {
            min = Math.min(min,computeMinCuts(s,start,cutPosition,minCuts)+1+computeMinCuts(s,cutPosition+1,end,minCuts)); 
        }
        minCuts[start][end] = min;
        return min;
    }
    
    private boolean isPalindrome(String s, int start, int end,int[][] minCuts)
    {
        if(minCuts[start][end]>=0)
        {
            return minCuts[start][end]==0;
        }
        
        int low = start;
        int high = end;
        while(low<high)
        {
            if(s.charAt(low)!=s.charAt(high))
            {
                return false;
            }
            low++;
            high--;
        }
        
        for(int i = 0;i<=(end-start)/2;i++)
        {
           minCuts[start+i][end-i] = 0; 
        }
        return true;
    }
}