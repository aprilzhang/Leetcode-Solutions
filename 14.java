/**
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
        {
            return "";
        }
        for(int i =0;i<strs[0].length();i++)
        {
            final char sampleChar = strs[0].charAt(i);
            for(int strIndex = 1;strIndex<strs.length;strIndex++)
            {
                if(i>=strs[strIndex].length()
                ||strs[strIndex].charAt(i)!=sampleChar)
                {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}

//using sort
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0)
        {
            return "";
        }
        
        Arrays.sort(strs);
        
        final char [] a = strs[0].toCharArray();
        final char [] b = strs[strs.length-1].toCharArray();
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length; i ++){
            if (b.length > i && b[i] == a[i]){
                result.append(b[i]);
            }
            else {
                return result.toString();
            }
        }
        return result.toString();
    }
	
	
//best solution
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0)
        {
            return "";
        }
        
        String pre = strs[0];
        for(int i = 1;i < strs.length;i++)
        {
            while(strs[i].indexOf(pre) != 0)
            {
                pre = pre.substring(0,pre.length()-1);
            }
        }
        return pre;
    }