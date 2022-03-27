package Stack;

import LinkedList.common.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RainWaterTrapped {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2);
        System.out.println(trap(input));
    }

    public static int trap(final List<Integer> input) {
        if(input == null || input.size() == 0)
            return 0;

        int size = input.size();
        Integer maxELementTowardsRight = input.get(size-1);

        Integer[] greatestElementIndexTowardsRight = new Integer[size];
        greatestElementIndexTowardsRight[size-1] = -1;


        for (int i=input.size()-2; i>=0; i--){
            greatestElementIndexTowardsRight[i] = maxELementTowardsRight > input.get(i) ? maxELementTowardsRight : -1;
            if(input.get(i) > maxELementTowardsRight){
                maxELementTowardsRight = input.get(i);
            }
        }

        Integer maxELementTowardsLeft = input.get(0);
        Integer[] greatestElementIndexTowardsLeft = new Integer[size];
        greatestElementIndexTowardsLeft[0] = -1;


        for (int i=1; i<size; i++){
            greatestElementIndexTowardsLeft[i] = maxELementTowardsLeft > input.get(i) ? maxELementTowardsLeft : -1;
            if(input.get(i) > maxELementTowardsLeft){
                maxELementTowardsLeft = input.get(i);
            }
        }

        int result = 0;
        for (int i=0; i<size; i++){
            result += (greatestElementIndexTowardsRight[i] != -1 && greatestElementIndexTowardsLeft[i] != -1) ? Math.min(greatestElementIndexTowardsRight[i], greatestElementIndexTowardsLeft[i]) - input.get(i) : 0;
        }

        return result;
    }
}
