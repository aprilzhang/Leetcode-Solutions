/**
320. Generalized Abbreviation
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/
public class Solution {
    public List<String> generateAbbreviations(String word) {
                final List<String> result = new ArrayList<>();
        if(word==null)
        {
            return result;
        }
        result.add(word);
        final int length = word.length();
        for(int i = 0;i<length;i++)
        {
            final String front = word.substring(0,i);
            for(int j = 1;j<=length-i;j++)
            {
                String half = front+j;
                if(i+j==length)
                {
                    result.add(half);
                }
                else
                {   half = half+Character.toString(word.charAt(i+j));
                    for(String s:generateAbbreviations(word.substring(i+j+1,length)))
                    {
                        result.add(half+s);
                    }
                }
            }
        }
        return result;
    }
}
//Better solution
public class Solution {
  public List<String> generateAbbreviations(String word){
        final List<String> ret = new ArrayList<>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos+1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }
}