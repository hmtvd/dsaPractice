package Queue;

import java.util.*;

public class MaxPower {

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stations[i];
        }
        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            power[i] = pref[R + 1] - pref[L];
        }

        long low = 0, high = pref[n] + k;
        long ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canReach(power, r, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
    private boolean canReach(long[] power, int r, long k, long target) {
        int n = power.length;

        long[] diff = new long[n]; 
        long curAdded = 0;
        long used = 0;

        for (int i = 0; i < n; i++) {
            curAdded += diff[i];
            long currPower = power[i] + curAdded;

            if (currPower < target) {
                long need = target - currPower;
                used += need;
                if (used > k) return false;
                curAdded += need;
                int end = i + 2 * r + 1;
                if (end < n) {
                    diff[end] -= need;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        MaxPower sol = new MaxPower();

        int[] stations = {1, 2, 4, 5, 0};
        int r = 1;
        int k = 2;

        System.out.println(sol.maxPower(stations, r, k));
    }
}

