/**
8. String to Integer (atoi)
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/
public class Solution {
    public int myAtoi(String str) {
        if (str == null)
        {
            return 0;
        }
        
        String toConvert = str.trim();
        final boolean isNegative = toConvert.startsWith("-");
        
        if(isNegative||toConvert.startsWith("+"))
        {
            toConvert = toConvert.substring(1);
        }
        
        if(toConvert.isEmpty())
        {
            return 0;
        }
        long value = 0;
        for(char c:toConvert.toCharArray())
        {
            if(!Character.isDigit(c))
            {
                break;
            }
            value = 10*value+(c-'0');
            if(value>=2147483648l&&isNegative)
            {
                return -2147483648; 
            }
            else if(value>=2147483647&&!isNegative)
            {
                return 2147483647;
            }
        }
        return ((int)(isNegative?0-value:value));
    }
}

//Improvement
public class Solution {
    public int myAtoi(String str) {
        if (str == null)
        {
            return 0;
        }
        
        String toConvert = str.trim();
        final boolean isNegative = toConvert.startsWith("-");
        
        if(isNegative||toConvert.startsWith("+"))
        {
            toConvert = toConvert.substring(1);
        }
        
        if(toConvert.isEmpty())
        {
            return 0;
        }
        int value = 0;
        for(char c:toConvert.toCharArray())
        {
            final int digit = c - '0';
            if(digit < 0 || digit > 9)//If it's not digit
            {
                break;
            }
            if(Integer.MAX_VALUE/10 < value || Integer.MAX_VALUE/10 == value && Integer.MAX_VALUE %10 < digit)
            {
              return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            value = 10*value+digit;
        }
        return isNegative?0-value:value;
    }
}

//Fastest solution
public class Solution {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;
    
        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;
    
        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        
        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
    
            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    
            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}

