/**
13. Roman to Integer
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    private static final Map<Character, Integer> ROMAN_TO_INT = new HashMap<>();
    static
    {
        ROMAN_TO_INT.put('M',1000);
        ROMAN_TO_INT.put('D',500);
        ROMAN_TO_INT.put('C',100);
        ROMAN_TO_INT.put('L',50);
        ROMAN_TO_INT.put('X',10);
        ROMAN_TO_INT.put('V',5);
        ROMAN_TO_INT.put('I',1);
    }
    
    public int romanToInt(String s) {
        int length = s.length();
        if(length==0)
        {
            return 0;
        }
        //First is negative if the next one is larger than it.
        final int first = ROMAN_TO_INT.get(s.charAt(0));
        int total =0;
        int last = ROMAN_TO_INT.get(s.charAt(0));
        for(int i =1;i<length;i++)
        {
            int current = ROMAN_TO_INT.get(s.charAt(i));
            if(last>=current)
            {
                total+= last;
            }
            else
            {
                total-= last;
            }
            last = current;
        }
        total+=last;
        return total;
    }
}
//Slightly fast solution
public class Solution {
     public int romanToInt(String s) {
         if(s.isEmpty())
         {
             return 0;
         }
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }
}