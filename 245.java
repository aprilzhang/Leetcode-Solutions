/**
245. Shortest Word Distance III
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.
*/
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int indexWord1 = -1;
        int indexWord2 = -1;
        for(int index = 0;index< words.length;index++)
        {
            if(words[index].equals(word1))
            {
                if(indexWord2>=0)
                {
                    distance = indexWord1==-1
                            ?Math.abs(indexWord2-index)
                            :Math.min(Math.abs(indexWord2-index),distance);
                }
                if(indexWord1>=0&&word1.equals(word2))
                {
                    distance = Math.min(Math.abs(indexWord1-index),distance);
                }
                indexWord1 = index;
            }
            else if(words[index].equals(word2))
            {
                if(indexWord1>=0)
                {
                    distance = indexWord2==-1
                            ?Math.abs(indexWord1-index)
                            :Math.min(Math.abs(indexWord1-index),distance);
                }
                indexWord2 = index;
            }
        }
        return distance;
    }
}
//faster solution
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = words.length;
        int i1 = dist;
        int i2 = dist;
        final boolean same = word1.equals(word2);
        
        for (int i=0; i<words.length; i++) 
        {
            final boolean equalToWord1 = words[i].equals(word1);
            final boolean equalToWord2 = words[i].equals(word2);
            if (equalToWord1) 
            {
                i1 = i;
            } 
            if (equalToWord2) 
            {   
                if (same) 
                {
                    //swap to word2 record
                    i1 = i2;
                } 
                i2 = i;
            }
            if(equalToWord1||equalToWord2)
            {
                dist = Math.min(dist, Math.abs(i1 - i2));
            }
        }
        return dist;
    }
}