/**
150. Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public class Solution {
    private static final List<String> operation = Arrays.asList("+","-","*","/");
    public int evalRPN(String[] tokens) {
        final Stack<Integer> eval = new Stack<>();
        for(int i = 0;i<tokens.length;i++)
        {
            if(!operation.contains(tokens[i]))
            {
                eval.push(Integer.parseInt(tokens[i]));
            }
            else
            {
                int b = eval.pop();
                int a = eval.pop();
                int result = 0;
                switch(tokens[i])
                {
                    case "+":
                        result=a+b;
                        break;
                    case "-":
                        result=a-b;
                        break;
                    case "*":
                        result=a*b;
                        break;
                    case "/":
                        result=a/b;
                        break;
                }
                eval.push(result);
            }
        }
        return eval.pop();
    }
}
//Optimise a bit
public class Solution {
    private static final List<String> operation = Arrays.asList("+","-","*","/");
    public int evalRPN(String[] tokens) {
        final Stack<Integer> eval = new Stack<>();
        int b;
        int a;
        for(String token:tokens)
        {
            switch(token)
            {
                case "+":
                    eval.push(eval.pop()+eval.pop());
                    break;
                case "-":
                    b = eval.pop();
                    a = eval.pop();
                    eval.push(a-b);
                    break;
                case "*":
                    eval.push(eval.pop()*eval.pop());
                    break;
                case "/":
                    b = eval.pop();
                    a = eval.pop();
                    eval.push(a/b);
                    break;
                default:
                    eval.push(Integer.parseInt(token));
            }
        }
        return eval.pop();
    }
}