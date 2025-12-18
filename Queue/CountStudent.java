package Queue;

import java.util.*;

public class CountStudent {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int s : students) {
            queue.add(s);
        }

        int index = 0; 
        int rotations = 0; 

        while (!queue.isEmpty() && rotations < queue.size()) {
            int student = queue.poll();
            if (student == sandwiches[index]) {
                index++;
                rotations = 0; 
            } else {
                queue.add(student);
                rotations++;
            }
        }
        return queue.size();
    }
    public static void main(String[] args) {
        CountStudent sol = new CountStudent();

        int[] students1 = {1,1,0,0};
        int[] sandwiches1 = {0,1,0,1};
        System.out.println(sol.countStudents(students1, sandwiches1)); 

        int[] students2 = {1,1,1,0,0,1};
        int[] sandwiches2 = {1,0,0,0,1,1};
        System.out.println(sol.countStudents(students2, sandwiches2)); 
    }
}

