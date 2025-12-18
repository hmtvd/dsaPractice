package Stack;
import java.util.*;
public class DailyTemperature {

    public int[] dailyTemperature(int[] temperatures) {
        int n  = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int prevIndex = st.pop();
                result[prevIndex] = i - prevIndex; 
            }
            st.push(i);
        }

        return result;
    }
    public static void main(String[] args) {
        DailyTemperature sol = new DailyTemperature();

        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(sol.dailyTemperature(temps1))); 

        int[] temps2 = {30, 40, 50, 60};
        System.out.println(Arrays.toString(sol.dailyTemperature(temps2)));

        int[] temps3 = {30, 60, 90};
        System.out.println(Arrays.toString(sol.dailyTemperature(temps3))); 
    }
}
