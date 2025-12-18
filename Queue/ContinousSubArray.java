package Queue;

import java.util.*;

public class ContinousSubArray {

    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > 2) {
                int val = nums[left];
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) map.remove(val);
                left++;
            }
            count += (right - left + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        ContinousSubArray sol = new ContinousSubArray();

        int[] nums1 = {5,4,2,4};
        System.out.println(sol.continuousSubarrays(nums1)); 

        int[] nums2 = {1,2,3};
        System.out.println(sol.continuousSubarrays(nums2));
    }
}

