/**
401. Binary Watch
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/
public class Solution {
    private static final int HOUR_LED = 4;
    private static final int MINUTE_LED = 6;
    public List<String> readBinaryWatch(int num) {
        final List<String> results = new ArrayList<>();
        for(int = 0;i<=num;i++)
        {
            results.addAll(possibleHours(i));
            results.addAll(possibleMinutes(num-i));
        }
        return results;
    }
    
    private static List<String> possibleHours(int num)
    {
        
    }
    private static List<String> possibleMinutes(int num)
    {
        
    }
}