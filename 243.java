/**
243. Shortest Word Distance
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int shortestDistance = words.length;
        int lastWordIndex1=-1;
        int lastWordIndex2=-1;
        for(int i = 0;i<words.length;i++)
        {
            if(words[i].equals(word1))
            {
                shortestDistance = lastWordIndex2==-1
                                    ?shortestDistance
                                    :Math.min( Math.abs(lastWordIndex2-i),shortestDistance);
                lastWordIndex1 = i;
            }
            else if (words[i].equals(word2))
            {
                shortestDistance = lastWordIndex1==-1
                                    ?shortestDistance
                                    :Math.min( Math.abs(lastWordIndex1-i),shortestDistance);
                lastWordIndex2 = i;
            }
        }
        return shortestDistance;
    }
}