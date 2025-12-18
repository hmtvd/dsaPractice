package Queue;

import java.util.*;

public class MinimumCoin {

    public int minimumCoin(int[] prices) {
        int n = prices.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int p : prices) queue.add(p);

        int totalCoins = 0;

        while (!queue.isEmpty()) {
            int price = queue.poll(); 
            totalCoins += price;
            int takeFree = price;
            Queue<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int nextPrice = queue.poll();
                if (takeFree > 0) {
                    takeFree--; 
                } else {
                    temp.add(nextPrice); 
                }
            }
            queue = temp;
        }

        return totalCoins;
    }
    public static void main(String[] args) {
        MinimumCoin sol = new MinimumCoin();

        int[] prices1 = {3,1,2};
        System.out.println(sol.minimumCoin(prices1)); 

        int[] prices2 = {1,10,1,1};
        System.out.println(sol.minimumCoin(prices2)); 

        int[] prices3 = {26,18,6,12,49,7,45,45};
        System.out.println(sol.minimumCoin(prices3)); 
    }
}

