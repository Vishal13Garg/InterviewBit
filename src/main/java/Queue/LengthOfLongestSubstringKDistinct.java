package Queue;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> characterCount = new HashMap<>();
        int startIndex = 0;
        int maxLength = 0;

        for (int endIndex=0; endIndex<s.length(); endIndex++){
            Character current = s.charAt(endIndex);
            int frequency = characterCount.containsKey(current) ? characterCount.get(current) : 0;
            characterCount.put(current, frequency+1);

            while (characterCount.size() >k){
                Character characterToRemove = s.charAt(startIndex);
                int characterToRemoveFrequency = characterCount.get(characterToRemove);
                characterToRemoveFrequency--;

                if(characterToRemoveFrequency == 0)
                    characterCount.remove(characterToRemove);
                else
                    characterCount.put(characterToRemove, characterToRemoveFrequency);

                startIndex++;
            }

            maxLength = Math.max(maxLength, endIndex-startIndex+1);
        }

        return maxLength;
    }
}
