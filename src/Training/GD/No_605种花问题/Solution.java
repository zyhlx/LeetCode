package Training.GD.No_605种花问题;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int temp = n;
        int len = flowerbed.length;
        for(int i = 0;i<len;){
            if(flowerbed[i]==1){
                i+=2;
            }else{
                if(i==len||(i+1<len && flowerbed[i+1]==0)){
                    temp--;
                    i+=2;
                }else{
                    i=i+1;
                }
            }
        }
        return temp<=0;
    }
    public static void main(String[] args){
        int[] a = {1,0,0,0,1,0,0};
        int b = 2;
        System.out.println(new Solution().canPlaceFlowers(a,b));
    }
}
