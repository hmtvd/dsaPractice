package Stack;

import java.util.*;

public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        Stack<Character> st = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!st.isEmpty() && st.peek() > c && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        RemoveKdigits sol = new RemoveKdigits();

        System.out.println(sol.removeKdigits("1432219", 3)); 
        System.out.println(sol.removeKdigits("10200", 1));   
        System.out.println(sol.removeKdigits("10", 2));      
        System.out.println(sol.removeKdigits("123456", 3)); 
    }
}

