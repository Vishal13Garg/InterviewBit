package Queue;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("BBBBQQQAAAA", "BAQ"));
    }

    public static String minWindow(String sourceString, String targetString) {
        if(sourceString == null || targetString == null || sourceString.length() < targetString.length())
            return "";

        Map<Character, Integer> target = new HashMap<>();
        for (int i=0; i<targetString.length(); i++){
            Character ch = targetString.charAt(i);
            int frequency = target.getOrDefault(ch, 0)+1;
            target.put(ch, frequency);
        }

        int minLength = sourceString.length()+1;
        int startIndexResult = 0;
        int endIndexResult = 0;


        int matchCount=0;
        int targetMatchCount = target.size();

        Map<Character, Integer> map = new HashMap<>();
        int startIndex=0;

        for (int endIndex=0; endIndex<sourceString.length(); endIndex++){
            Character charToAdd = sourceString.charAt(endIndex);
            Integer charToAddFrequency = map.getOrDefault(charToAdd, 0)+1;
            map.put(charToAdd, charToAddFrequency);

            if(target.containsKey(charToAdd) && charToAddFrequency == target.get(charToAdd).intValue())
                matchCount++;

            while (startIndex<=endIndex && matchCount == targetMatchCount){
                if(endIndex-startIndex+1 <minLength){
                    minLength = endIndex-startIndex+1;
                    startIndexResult = startIndex;
                    endIndexResult = endIndex;
                }

                Character charToRemove = sourceString.charAt(startIndex);
                Integer charToRemoveFrequency = map.getOrDefault(charToRemove, 0)-1;
                map.put(charToRemove, charToRemoveFrequency);
                startIndex++;

                if(target.containsKey(charToRemove) && target.get(charToRemove).intValue() == charToRemoveFrequency+1)
                    matchCount--;
            }
        }


        String result = "";
        if(minLength <= sourceString.length())
            result = sourceString.substring(startIndexResult, endIndexResult+1);

        return result;
    }
}
