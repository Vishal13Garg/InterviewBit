package Stack;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        System.out.println(braces("((a+b))"));
        System.out.println(braces("(a+(a+b))"));
    }

    public static int braces(String string) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<string.length(); i++){
            Character ch = string.charAt(i);

            if(ch == ')'){
                boolean isCurrentExpressionContainsOperator = false;
                while (stack.peek() != '('){
                    Character insideExpression = stack.pop();
                    if(insideExpression == '+' || insideExpression == '-' || insideExpression == '*' || insideExpression == '/')
                        isCurrentExpressionContainsOperator = true;
                }
                if(!isCurrentExpressionContainsOperator)
                    return 1;

                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        return 0;
    }
}
