package Queue;

import javax.print.CancelablePrintJob;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("ababacccccc"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int startIndex = 0;
        int endIndex = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(endIndex =0; endIndex<s.length(); endIndex++){
            Character charToAdd = s.charAt(endIndex);
            Integer charToAddFrequency = map.containsKey(charToAdd) ? map.get(charToAdd) + 1 : 1;
            map.put(charToAdd, charToAddFrequency);

            while (map.size() > 2){
                Character charToRemove = s.charAt(startIndex);
                int charToRemoveFrequency = map.get(charToRemove)-1;

                if(charToRemoveFrequency == 0)
                    map.remove(charToRemove);
                else
                    map.put(charToRemove, charToRemoveFrequency);

                startIndex++;
            }

            maxLength = Math.max(maxLength, endIndex-startIndex+1);
        }

        return maxLength;
    }
}
