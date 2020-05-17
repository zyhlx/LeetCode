package Training.DP;

public class NO_1025 {

//    动态规划 dp[]代表一个长度为n+1的数组，如果 dp[n-x]为false,则Alice会减去x,即 Bob==dp[n-x]==false, Alice胜。否则Alice输，因为不管x是多少，dp[n-x]为true, 则dp[n]==Alice==false.

        //假设布尔数组P存储用户最优选择下最终胜利结果.
        //p[i] = true表示如果当前用户的选择范围为0~i,则在自己与对手均以最佳状态参与时,她将胜利
        //p[i] = false表示如果当前用户的选择范围为0~i,则在自己与对手均以最佳状态参与时,她将失败

        //当N=1时,用户无法选择有效值,因此p[1] = false
        //当N=2时,该用户当前步选择1,对手最优结果为p[1] = false,因此该用户胜利,因此p[2] = true
        //当N=3时,该用户当前步只能选择2,对手最优结果为p[1] = true,因此该用户失败,因此p[3] = false
        //当N=4时,该用户当前步可以选择1,2,如果选择1,对手最优结果为p[3] = false, 如果选择2,对手最优结果为p[2] = true,
        //因此他当前步最优选择为1,p[4] = true


        public boolean divisorGame(int N) {
            boolean[] play = new boolean[N+1];
            play[1] = false;

            for(int i = 2; i <= N; i++){
                for(int j = 1; j < i; j++){
                    if(i % j == 0){ //如果可以选择j
                        if(play[i-j] == false) //如果下一步对手的最优执行结果为false,则当前步执行结果为true
                        {
                            play[i] = true;
                            break;
                        }
                    }
                }
            }
            return play[N];
        }

}
