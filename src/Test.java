import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static void main(String[] args){
        test();
    }


    public static void test(){
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("8");
        lList.add("6");
        lList.add("4");
        lList.add("5");
        System.out.println(lList);
        List<String> list = lList.subList(2, 4);
        System.out.println(list);
    }
}
