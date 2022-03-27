package Stack;

import java.util.Stack;

public class SimplifyDirectoryPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../../c/d"));
    }

    public static String simplifyPath(String input) {
        if(input == null || input.length() == 0)
            return input;

        String[] argument = input.split("/");
        Stack<String> stack = new Stack<>();

        if(input.startsWith("/"))
            stack.push("/");

        for (int i=0; i<argument.length; i++){
            String current = argument[i];

            if(current.equalsIgnoreCase("") || current.equalsIgnoreCase("."))
                continue;
            else if(current.equalsIgnoreCase("..")){
                if(!stack.isEmpty() && stack.peek().equalsIgnoreCase("/"))
                    continue;
                else {
                    if(stack.isEmpty() || stack.peek().equalsIgnoreCase(".."))
                        stack.push(current);
                    else
                        stack.pop();
                }
            }
            else
                stack.push(current);
        }

        String result = "";
        String delimiter = "";

        while (stack.size() > 1){
            String current = stack.pop();
            result = current + delimiter + result;
            delimiter = "/";
        }

        if(stack.peek().equalsIgnoreCase("/"))
            result = "/" + result;
        else
            result = stack.peek() + delimiter + result;

        return result;
    }
}
