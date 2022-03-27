package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationAllWords {

    public static void main(String[] args) {
        String s = "a";
        String[] words = {"a"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            int frequency = map.getOrDefault(words[i],0)+1;
            map.put(words[i], frequency);
        }

        int wordLength = words[0].length();
        for(int startIndex=0; startIndex<s.length()- (wordLength*words.length)+1; startIndex++){
            Map<String, Integer> current = new HashMap<>();
            int matchCount=0;
            for(int i=0; i<words.length; i++){
                String word = s.substring(startIndex+i*wordLength, startIndex+(i+1)*wordLength);
                int frequency = current.getOrDefault(word,0)+1;
                int targetFrequency = map.getOrDefault(word,0);
                current.put(word, frequency);

                if(targetFrequency==frequency)
                    matchCount++;

                if(frequency > targetFrequency)
                    break;
            }
            if(matchCount == map.size())
                result.add(startIndex);
        }

        return result;
    }
}
