package Queue;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int endIndex = 0;
        int maxLength = 0;

        for (; endIndex<s.length(); endIndex++){
            Character current = s.charAt(endIndex);
            if(map.containsKey(current) && map.get(current) >= startIndex)
                startIndex = map.get(current)+1;

            map.put(current, endIndex);
            maxLength = Math.max(maxLength, endIndex-startIndex+1);
        }

        return maxLength;
    }
}
