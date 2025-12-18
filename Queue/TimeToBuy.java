package Queue;

import java.util.*;

public class TimeToBuy {

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int n = tickets.length;
        for (int i = 0; i < n; i++) {
            queue.add(i); 
        }

        int time = 0;
        while (!queue.isEmpty()) {
            int person = queue.poll();
            tickets[person]--; 
            time++;

            if (tickets[person] > 0) {
                queue.add(person);
            } else if (person == k) {

                break;
            }
        }

        return time;
    }
    public static void main(String[] args) {
        TimeToBuy sol = new TimeToBuy();

        int[] tickets1 = {2,3,2};
        System.out.println(sol.timeRequiredToBuy(tickets1, 2)); 

        int[] tickets2 = {5,1,1,1};
        System.out.println(sol.timeRequiredToBuy(tickets2, 0)); 
    }
}
