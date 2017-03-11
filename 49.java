/**
49. Group Anagrams
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/
//Somehow cannot use int[] here, maybe the hashcode method is not good for array
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String,List<String>> anagramsMap = new HashMap<>();
        Arrays.sort(strs);
        for(String word:strs)
        {
            final char[] chars = word.toCharArray();
            Arrays.sort(chars);
            final String keyStr = String.valueOf(chars);
            
            final List<String> list = anagramsMap.getOrDefault(keyStr,new ArrayList<String>());
            list.add(word);
            anagramsMap.put(keyStr,list);
        }
        return new ArrayList<List<String>>(anagramsMap.values());
    }
}

//Best solution
public class Solution {
    private static final int[] PRIME = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//×î¶à10609¸öz
    public static List<List<String>> groupAnagrams(String[] strs) { 
        
                final List<List<String>> res = new ArrayList<>();
                final Map<Integer, Integer> map = new HashMap<>();
                for (String s : strs) {
                    int key = 1;
                    for (char c : s.toCharArray()) 
                    {
                        key *= PRIME[c - 'a'];
                    }
                    List<String> t;
                    if (map.containsKey(key)) 
                    {
                        t = res.get(map.get(key));
                    } 
                    else {
                        t = new ArrayList<>();
                        res.add(t);
                        map.put(key, res.size() - 1);
                    }
                    t.add(s);
                }
                return res;
    }
}