/**
17. Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
public class Solution {
    private static final Map<Character,List<String>> DIGIT_2_LETTER= new HashMap<>();
    static
    {
        DIGIT_2_LETTER.put('0',Collections.emptyList());
        DIGIT_2_LETTER.put('1',Collections.emptyList());
        DIGIT_2_LETTER.put('2',Arrays.asList("a", "b", "c"));
        DIGIT_2_LETTER.put('3',Arrays.asList("d", "e", "f"));
        DIGIT_2_LETTER.put('4',Arrays.asList("g", "h", "i"));
        DIGIT_2_LETTER.put('5',Arrays.asList("j", "k", "l"));
        DIGIT_2_LETTER.put('6',Arrays.asList("m", "n", "o"));
        DIGIT_2_LETTER.put('7',Arrays.asList("p", "q", "r", "s"));
        DIGIT_2_LETTER.put('8',Arrays.asList("t", "u", "v"));
        DIGIT_2_LETTER.put('9',Arrays.asList("w", "x", "y", "z"));
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
        {
            return new ArrayList<>();
        }
        return combinations(letterCombinations(digits.substring(1)),DIGIT_2_LETTER.get(digits.charAt(0)));
    }
    
    private static List<String> combinations(List<String> inputs, List<String> possibles)
    {
        if(inputs.isEmpty())
        {
            return new ArrayList<>(possibles);
        }
        final List<String> result = new ArrayList<>();
        for(String input:inputs)
        {
            for(String possible:possibles)
            {
                result.add(possible+input);
            }
        }
        return result;
    }
}
//Slightly faster solution
public class Solution {
   public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    if(digits.isEmpty())
    {
        return ans;
    }
    if(digits.equals("0")||digits.equals("1"))
    {
        return Collections.emptyList();
    }
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for(int i =0; i<digits.length();i++){
        int x = Character.getNumericValue(digits.charAt(i));
        while(ans.peek().length()==i){
            String t = ans.remove();
            for(char s : mapping[x].toCharArray())
                ans.add(t+s);
        }
    }
    return ans;
}
}