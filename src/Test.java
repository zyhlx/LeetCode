import java.util.*;

public class Test {
    public static void main(String[] args){
      openLock(new String[]{"0201","0101","0102","1212","2002"},"0202");
        Set<Character> b = new LinkedHashSet<>();
        b.add('c');
        for (Character character : b) {
            System.out.print(character);
        }
    }


    public static int GCD(int a,int b){
        int r = 0;
        while(b>0){
            r = a%b;
            a=b;
            b=r;
        }
        return a;
    }

    public static int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer("0000");
        Set<String> set = new HashSet<String>(Arrays.asList(deadends));
        while(queue.size()!=0){
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String cur = queue.poll();
                if(cur.equals(target)){
                    return step;
                }
                int a = Integer.valueOf(cur.charAt(0))-48;
                int a1 = a+1==10?0:a+1;
                int a2 = a-1<0?9:a-1;
                int b = Integer.valueOf(cur.charAt(1))-48;
                int b1 = b+1==10?0:b+1;
                int b2 = b-1<0?9:b-1;
                int c = Integer.valueOf(cur.charAt(2))-48;
                int c1 = c+1==10?0:c+1;
                int c2 = c-1<0?9:c-1;
                int d = Integer.valueOf(cur.charAt(3))-48;
                int d1 = d+1==10?0:d+1;
                int d2 = d-1<0?9:d-1;
                if(!set.contains(a1+""+b+""+c+""+d)){
                    queue.offer(a1+""+b+""+c+""+d);
                }
                if(!set.contains(a2+""+b+""+c+""+d)){
                    queue.offer(a2+""+b+""+c+""+d);
                }
                if(!set.contains(a+""+b1+""+c+""+d)){
                    queue.offer(a+""+b1+""+c+""+d);
                }
                if(!set.contains(a+""+b2+""+c+""+d)){
                    queue.offer(a+""+b2+""+c+""+d);
                }
                if(!set.contains(a+""+b+""+c1+""+d)){
                    queue.offer(a+""+b+""+c1+""+d);
                }
                if(!set.contains(a+""+b+""+c2+""+d)){
                    queue.offer(a+""+b+""+c2+""+d);
                }

                if(!set.contains(a+""+b+""+c+""+d1)){
                    queue.offer(a+""+b+""+c+""+d1);
                }
                if(!set.contains(a+""+b+""+c+""+d2)){
                    queue.offer(a+""+b+""+c+""+d2);
                }
                set.add(cur);
            }
            step +=1;
        }
        return -1;
    }

}
