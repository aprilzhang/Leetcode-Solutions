/**
294. Flip Game II
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.
*/
public class Solution {
    public boolean canWin(String s) {
        if(s==null||s.length()<2)
        {
            return false;
        }

        for(int i =0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='+'&&s.charAt(i+1)=='+')
            {
                final String newString = new StringBuilder()
                                        .append(s.substring(0,i))
                                        .append("--")
                                        .append(s.substring(i+2))
                                        .toString();
                if(!canWin(newString))
                {
                    return true;
                }
            }
        }
        return false;
    }
}

//Best solution
public boolean canWin(String s) {
	s = s.replace('-', ' ');
    int G = 0;
    final List<Integer> g = new ArrayList<>();
    for (String t : s.split("[ ]+")) {
        int p = t.length();
        if (p == 0) continue;
        while (g.size() <= p) {
            final char[] x = t.toCharArray();
            int i = 0;
            int j = g.size() - 2;
            while (i <= j)
            {
                x[g.get(i++) ^ g.get(j--)] = '-';
            }
            g.add(new String(x).indexOf('+'));
        }
        G ^= g.get(p);
    }
    return G != 0;
}