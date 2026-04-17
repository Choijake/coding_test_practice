import java.util.*;

class LT_122 {
    public int maxProfit(int[] prices) {
        int s = prices.length-1;
        int e = prices.length-1;
        int answer = 0;
        int diff = 0;

        while(e>0){
            if(prices[e-1]<prices[e] && prices[e]<=prices[s]){
                e-=1;
                diff = prices[s]-prices[e];
            }
            else{
                e-=1;
                s=e;
                answer+=diff;
                diff=0;
            }
        }

        answer += diff;

        return answer;
    }
}