package OJ;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =  sc.nextInt();
        while (t-->0) { //判断是否结束
            int a = sc.nextInt();//读入整数
            int b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}
/*
*
*
* import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { //判断是否结束
            long a = sc.nextLong();//读入整数
            long b = sc.nextLong();
            System.out.println(a+b);
        }
    }
}*/
/*
*
* 链接：https://ac.nowcoder.com/acm/contest/320/H
来源：牛客网

题目描述
对输入的字符串进行排序后输出
输入描述:
输入有两行，第一行n

第二行是n个空格隔开的字符串
输出描述:
输出一行排序后的字符串，空格隔开，无结尾空格
示例1
输入
复制
5
c d a bb e
输出
复制
a bb c d e
*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = br.readLine()) != null){
            int count = Integer.parseInt(str);
            str =  br.readLine();
           String[] strArr =  str.split(" ");

            Arrays.sort(strArr);
            for(int i=0;i<count;i++){
                System.out.print(strArr[i]+" ");
            }
        }
    }
}*/
/*
*
* import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = br.readLine()) != null){
            String[] strArr =  str.split(" ");
            int count = strArr.length;
            Arrays.sort(strArr);
            for(int i=0;i<count;i++){
                System.out.print(strArr[i]+" ");
            }
            System.out.println();
        }
    }
}*/
/*
*
* import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) { //判断是否结束
            String a = sc.nextLine();//读入整数
            String[] c = a.split(" ");
            int sum = 0;
            for(String b:c){
                sum += Integer.valueOf(b);
            }
            System.out.println(sum);
        }
    }
}*/
/*
*
* import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = br.readLine()) != null){
            String[] strArr =  str.split(",");
            int count = strArr.length;
            Arrays.sort(strArr);
            System.out.print(strArr[0]);
            for(int i=1;i<count;i++){
                System.out.print(","+strArr[i]);
            }
            System.out.println();
        }
    }
}*/
/*
*
*     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isEnd = false;
        while (!isEnd) { //判断是否结束
            int n = sc.nextInt();//读入整数
            if(n==0){
                isEnd = true;
            }else{
                int sum = 0;
                while(n-->0){
                    sum += sc.nextInt();
                }
                System.out.println(sum);
            }


        }
    }*/