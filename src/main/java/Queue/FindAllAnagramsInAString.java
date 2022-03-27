package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String source, String input) {
        List<Integer> anagramIndex = new LinkedList<>();
        if(source == null || input == null || source.length() < input.length())
            return anagramIndex;

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();

        for (int i=0; i<input.length(); i++){
            Character ch = input.charAt(i);
            int frequency = target.containsKey(ch) ? target.get(ch)+1 : 1;
            target.put(ch, frequency);
        }

        int matchCount = 0;
        int targetMatchCount = target.size();
        int startIndex = 0;

        for (int endIndex=0; endIndex<source.length(); endIndex++){
            if(endIndex-startIndex >=input.length()){
                Character charToRemove = source.charAt(startIndex);
                Integer charToRemoveFrequency = current.get(charToRemove)-1;
                current.put(charToRemove, charToRemoveFrequency);
                if(target.containsKey(charToRemove) && charToRemoveFrequency+1 == target.get(charToRemove))
                    matchCount--;
                startIndex++;
            }

            Character charToAdd = source.charAt(endIndex);
            int charToAddFrequency = current.containsKey(charToAdd) ? current.get(charToAdd)+1 : 1;
            current.put(charToAdd, charToAddFrequency);
            if(target.containsKey(charToAdd) && charToAddFrequency == target.get(charToAdd))
                matchCount++;

            if(matchCount == targetMatchCount){
                anagramIndex.add(startIndex);
            }
        }
        return anagramIndex;

    }
}
