package Stack;

import java.util.Stack;

public class BalancedParantheses {
    public static int solve(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<input.length(); i++){
            if(input.charAt(i) == '(')
                stack.push('(');
            else {
                if(stack.isEmpty() || stack.peek() != '(')
                    return 0;
                else
                    stack.pop();
            }
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}
