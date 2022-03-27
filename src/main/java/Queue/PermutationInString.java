package Queue;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("abd","eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s2.length() < s1.length())
            return false;

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();

        for (int i=0; i<s1.length(); i++){
            Character ch = s1.charAt(i);
            int frequency = target.containsKey(ch) ? target.get(ch)+1 : 1;
            target.put(ch, frequency);
        }

        int matchCount = 0;
        int targetMatchCount = target.size();
        int startIndex = 0;

        for (int endIndex=0; endIndex<s2.length(); endIndex++){
            if(endIndex-startIndex >=s1.length()){
                Character charToRemove = s2.charAt(startIndex);
                Integer charToRemoveFrequency = current.get(charToRemove)-1;
                current.put(charToRemove, charToRemoveFrequency);
                if(target.containsKey(charToRemove) && charToRemoveFrequency+1 == target.get(charToRemove))
                    matchCount--;
                startIndex++;
            }

            Character charToAdd = s2.charAt(endIndex);
            int charToAddFrequency = current.containsKey(charToAdd) ? current.get(charToAdd)+1 : 1;
            current.put(charToAdd, charToAddFrequency);
            if(target.containsKey(charToAdd) && charToAddFrequency == target.get(charToAdd))
                matchCount++;

            if(matchCount == targetMatchCount)
                return true;
        }

        return false;
    }
}
