package Stack;

import java.util.Stack;
import java.util.Arrays;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {

            boolean destroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {

                if (Math.abs(stack.peek()) < Math.abs(ast)) {
                   
                    stack.pop();
                    continue;
                } 
                else if (Math.abs(stack.peek()) == Math.abs(ast)) {
                    stack.pop();
                    destroyed = true;
                    break;
                } 
                else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {

        int[] asteroids = {5, 10, -5};

        int[] result = asteroidCollision(asteroids);

        System.out.println(Arrays.toString(result)); 
    }
}
