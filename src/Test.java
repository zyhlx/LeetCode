import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] args){
//        getFruits();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> priorityQueue = new PriorityQueue<>((Integer i1, Integer i2) -> Integer.compare(i2, i1));
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println(priorityQueue.peek());
        int[] a = new int[]{1,2,4,3};
        Arrays.sort(a);
        System.out.println(a[0]);
    }


    public static int getFruits(int m,PriorityQueue<Integer> queue,int len){
        int res = queue.peek();



        return res;
    }
}
