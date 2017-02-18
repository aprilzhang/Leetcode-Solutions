/**
425. Word Squares
Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 = k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
*/
public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        final LinkedList<List<String>> queue = new LinkedList<>();
        if(words==null||words.length==0)
        {
            return queue;
        }
        final int length = words[0].length();
        queue.add(new ArrayList<String>());
        while(!queue.isEmpty()&&queue.peek().size()<length)
        {
            final List<String> previousWords = queue.remove();
            for(String word:words)
            {
                if(matchStrings(previousWords,word))
                {
                    final List<String> newList = new ArrayList<>();
                    newList.addAll(previousWords);
                    newList.add(word);
                    queue.add(newList);
                }
            }
        }
        return queue;
    }
    
    private static boolean matchStrings(List<String> words,String word)
    {
        if(words.size()==word.length())
        {
            return false;
        }
        for(int i = 0;i<words.size();i++)
        {
            if(word.charAt(i)!=words.get(i).charAt(words.size()))
            {
                return false;
            }
        }
        return true;
    }
}