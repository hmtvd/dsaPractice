package Stack;

import java.util.*;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); 
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : nums[stack.peek()];

         
            stack.push(i);
        }

        return res;
    }
    public static void main(String[] args) {
        NextGreaterElement sol = new NextGreaterElement();

        int[] nums = {2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums)));
        int[] nums2 = {1, 3, 2, 4};
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums2)));
    }
}

