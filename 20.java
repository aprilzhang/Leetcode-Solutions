/**
20. Valid Parentheses
Given a string containing JUST THE CHARACTERS '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    private static final Map<Character,Character> parentheses = new HashMap<>();
    static
    {
        parentheses.put(')','(');
        parentheses.put(']','[');
        parentheses.put('}','{');
    }
    public boolean isValid(String s) {
        final Stack<Character>  parenthesesStack= new Stack<>();
        for(char c:s.toCharArray())
        {
            if (parentheses.values().contains(c))
            {
                parenthesesStack.push(c);
            }
            else if(parentheses.keySet().contains(c))
            {
                if(parenthesesStack.empty()||parenthesesStack.pop()!=parentheses.get(c))
                {
                    return false;
                }
            }
        }
        return parenthesesStack.empty();
    }
}
//Slightly better solution
public class Solution {
    private static final Map<Character,Character> parentheses = new HashMap<>();
    static
    {
        parentheses.put('(',')');
        parentheses.put('[',']');
        parentheses.put('{','}');
    }
    public boolean isValid(String s) {
        final Stack<Character>  parenthesesStack= new Stack<>();
        for(char c:s.toCharArray())
        {
            if (parentheses.keySet().contains(c))
            {
                parenthesesStack.push(parentheses.get(c));
            }
            else if(parenthesesStack.empty()||parenthesesStack.pop()!=c)
            {
                return false;
            }
        }
        return parenthesesStack.empty();
    }
}