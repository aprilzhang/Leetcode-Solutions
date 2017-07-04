/**
294. Flip Game II
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.
*/
//My solution doesnt work
//e.g. "+++++++++++" should be true
public class Solution {
    public boolean canWin(String s) {
        if(s==null)
        {
            return false;
        }
        return canWin(s,0);
    }
    
    
    public boolean canWin(String s, int start) {
        if(start>=s.length())
        {
            return false;
        }
        
        int i =start;
        while(i<s.length())
        {
            if(s.startsWith("+++",i))
            {
                return !canWin(s,i+2)||!canWin(s,i+3);
            }
            else if (s.startsWith("++",i))
            {
                return !canWin(s,i+3);
            }
            i++;
        }
        return false;
    }
}

//Backtracking
//o(n!!)
public class Solution {
    public boolean canWin(String s) {
      if (s == null || s.length() < 2) {
        return false;
      }

      for (int i = 0; i < s.length() - 1; i++) {
        if (s.startsWith("++", i)) {
          String t = s.substring(0, i) + "--" + s.substring(i + 2);

          if (!canWin(t)) {
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