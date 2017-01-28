/**
6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
        {
            return s;
        }
        final List<List<Character>> rows = new ArrayList<List<Character>>(numRows);
        for(int i = 0;i<numRows;i++)
        {
            rows.add(new ArrayList<Character>());
        }
        final int trip = 2*(numRows-1);
        for(int index = 0; index<s.length();index++)
        {
            int row = index%trip;
            if(row>=numRows)
            {
                row = trip-row;
            }
            rows.get(row).add(s.charAt(index));
        }
        
        final StringBuilder builder = new StringBuilder();
        for(List<Character> row:rows)
        {
            for(char c:row)
            {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}