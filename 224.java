/**
224. Basic Calculator
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/
//My solution using two stacks
public class Solution {
    public int calculate(String s) {
        final Stack<Integer> stack = new Stack<>();
        final Stack<Character> operators = new Stack<>();
        
        stack.push(0);
        operators.push('+');
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c ==' ')
            {
                continue;
            }
            else if(c == '+'||c=='-')
            {
                operators.push(c);
            }
            else if(c == '(')
            {
                stack.push(0);
                operators.push('+');
            }
            else if(c == ')')
            {
                int number = stack.pop();
                int previousNumber = stack.pop();
                char operator = operators.pop();
                stack.push(evaluate(previousNumber,number,operator));
            }
            else
            {
                int j = i;
                while(j<s.length()&&s.charAt(j)>='0'&&s.charAt(j)<='9')
                {
                    j++;
                }
                int number = Integer.parseInt(s.substring(i,j));
                int previousNumber = stack.pop();
                char operator = operators.pop();
                stack.push(evaluate(previousNumber,number,operator));
                i = j-1;
            }
        }
        
        return stack.pop();
    }
    
    private int evaluate(int previousNumber, int number, char operator)
    {
        if(operator=='+')
        {
            return previousNumber+number;
        }
        else if(operator=='-')
        {
            return previousNumber-number;
        }
        throw new IllegalArgumentException();
    }
}

//Much faster solution using one stackpublic class Solution {
    public int calculate(String s) {
    	int sign = 1;
    	int result = 0;
        final Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c ==' ')
            {
                continue;
            }
            else if (c == '+')
            {
			    sign = 1;
            }
            else if (c == '-')
            {
			    sign = -1;
            }
            else if(c == '(')
            {
                stack.push(result);
                stack.push(sign);
                //reinitiliase
    			result = 0;
    			sign = 1;
            }
            else if(c == ')')
            {
                result = result * stack.pop() + stack.pop();
            }
            else
            {
        		int sum = c - '0';
        		while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
        			sum = sum * 10 + s.charAt(i + 1) - '0';
        			i++;
        		}
        		result += sum * sign;
            }
        }
        
        return result;
    }
}