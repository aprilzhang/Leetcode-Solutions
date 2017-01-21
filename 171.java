/¡Á¡Á
171. Excel Sheet Column Number
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
¡Á/
public class Solution {
    public int titleToNumber(String s) {
        final char[] chars = s.toCharArray();
        int columnNumber = 0;
        for(char c:chars)
        {
            columnNumber = columnNumber*26+(c-'A'+1);
        }
        return columnNumber;
    }
}