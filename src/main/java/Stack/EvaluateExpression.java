package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        //4", "13", "5", "/", "+
        input.add("2");
        input.add("2");
        input.add("/");

        System.out.println(evalRPN(input));
    }

    public static int evalRPN(ArrayList<String> expression) {
        Stack<Integer> operand = new Stack<>();

        for (int i=0; i<expression.size(); i++){
            String input = expression.get(i);

            if(input.equalsIgnoreCase("+")){
                int operator1 = operand.pop();
                int operator2 = operand.pop();
                operand.push(operator1+operator2);
            }
            else if(input.equalsIgnoreCase("-")){
                int operator1 = operand.pop();
                int operator2 = operand.pop();
                operand.push(operator2-operator1);
            }
            else if(input.equalsIgnoreCase("*")){
                int operator1 = operand.pop();
                int operator2 = operand.pop();
                operand.push(operator2*operator1);
            }
            else if(input.equalsIgnoreCase("/")){
                int operator1 = operand.pop();
                int operator2 = operand.pop();
                operand.push(operator2/operator1);
            }
            else {
                int newOperator = Integer.parseInt(input);
                operand.push(newOperator);
            }
        }
        return operand.peek();
    }
}
