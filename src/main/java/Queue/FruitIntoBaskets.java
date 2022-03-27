package Queue;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[] {1,2,3,2,2}));
    }

    public static int totalFruit(int[] fruits) {
        if(fruits == null || fruits.length == 0)
            return 0;

        int startIndex = 0;
        int endIndex = 0;
        int totalFruit = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(endIndex=0; endIndex<fruits.length; endIndex++){
            int frequency = map.containsKey(fruits[endIndex]) ? map.get(fruits[endIndex])+1 : 1;
            map.put(fruits[endIndex], frequency);

            while (map.size() > 2){
                int fruitToRemove = fruits[startIndex];
                int fruitToRemoveFrequency = map.get(fruitToRemove)-1;

                if(fruitToRemoveFrequency == 0)
                    map.remove(fruitToRemove);
                else
                    map.put(fruitToRemove, fruitToRemoveFrequency);

                startIndex++;
            }

            totalFruit = Math.max(totalFruit, endIndex-startIndex+1);
        }

        return totalFruit;
    }
}
