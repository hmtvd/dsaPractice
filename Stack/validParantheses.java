package Stack;

import java.util.Stack;

public class validParantheses{

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {

        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "({[]})";
        String s4 = "(((";

        System.out.println(isValid(s1)); 
        System.out.println(isValid(s2));
        System.out.println(isValid(s3)); 
        System.out.println(isValid(s4)); 
    }
}

