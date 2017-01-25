/**
451. Sort Characters By Frequency
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
public class Solution {
    public String frequencySort(String s) {
        final Map<Character,Integer> counts = new HashMap<>();
        for(char c:s.toCharArray()) 
        {
            Integer newCount = counts.get(c);
            if(newCount == null)
            {
                newCount =0;
            }
            counts.put(c,newCount+1);
        }
        Character[] boxedArray = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new); 
        Arrays.sort(boxedArray,(c1,c2)->
        {
            final int countDiff = counts.get(c2)-counts.get(c1);
            return countDiff != 0?countDiff:c1-c2;
        });
        
        final StringBuilder builder= new StringBuilder();
        for(char c:boxedArray)
        {
            builder.append(c);
        }
        return builder.toString();
    }
}

//Better solution
public class Solution {
    public String frequencySort(String s) {
        final Map<Character,List<Character>> charMap = new HashMap<>();
        for(char c:s.toCharArray()) 
        {
            List<Character> newList = charMap.get(c);
            if(newList == null)
            {
                newList =new ArrayList<Character>();
                charMap.put(c,newList);
            }
            newList.add(c);
        }
        List<List<Character>> chars = new ArrayList<>(charMap.values());
        Collections.sort(chars,(l1,l2)->l2.size()-l1.size());
        final StringBuilder builder= new StringBuilder();
        for(List<Character> list:chars)
        {
            for(char c:list)
            {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
//Best solution
public class Solution {
    public String frequencySort(String s) {
        final Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        final List<Character>[] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >=0; pos--) {
            if (bucket[pos] != null) {
                for (char num : bucket[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
}