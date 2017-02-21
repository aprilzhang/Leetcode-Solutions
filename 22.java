/**
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        final List<String> result = new ArrayList<>();
        generateParenthesis(result,"",n,n);
        return result;
    }
    
    private static void generateParenthesis(List<String> result,String current, int left,int right)
    {
        if(left==0&&right==0)
        {
           result.add(current); 
           return;
        }
        else if(left>right)
        {
            return;
        }
        if(left>0)
        {
            generateParenthesis(result,current+"(",left-1,right);
        }
        generateParenthesis(result,current+")",left,right-1);
    }
}