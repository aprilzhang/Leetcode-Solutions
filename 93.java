/**
93. Restore IP Addresses
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        final List<String> result = new ArrayList<>();
        
        if(s==null||s.length()<4||s.length()>12||!s.matches("[0-9]+"))
        {
            return result;
        }
        
        backtrack(result,s,1,0);
        return result;
    }
    
    private void backtrack(final List<String> result, final String temp, int index, int nDot)
    {
        if(nDot==3)
        {
            if(checkValid(temp))
            {
                result.add(temp);
            }
            return;
        }
        
        for(int i = index;i<temp.length();i++)
        {
            backtrack(result,temp.substring(0,i)+"."+temp.substring(i),i+2,nDot+1);
        }
    }
    
    private boolean checkValid(String solution)
    {
        final String[] split = solution.split("\\.");
        if(split.length!=4)
        {
            return false;
        }
        for(String value:split)
        {
            if(value.length()>3
            ||(value.length()>1&&value.charAt(0)=='0')
            ||Integer.parseInt(value)>255)
            {
                return false;
            }
        }
        return true;
    }
}

//Faster solution
//String append is expensive, so do that as fewer times as possible
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}