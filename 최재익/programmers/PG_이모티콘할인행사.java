import java.util.*;

class PG_이모티콘할인행사 {
    static int joinCount;
    static int price;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] combi = new int[emoticons.length];

        combination(0, combi, users, emoticons);

        return new int[]{joinCount, price};
    }

    static void combination(int depth, int[] combi, int[][] users, int[] emoticons){
        if(depth==combi.length){
            calc(combi, users, emoticons);
            return;
        }

        for(int i=10; i<=40; i+=10){
            combi[depth] = i;
            combination(depth+1, combi, users, emoticons);
        }
    }

    static void calc(int[] combi, int[][] users, int[] emoticons){
        //각 유저마다 할인율 조건에 맞는 이모티콘 구매 비용 계산
        //이모티콘 플러스 여부 확인
        //이모티콘 플러스 여부 적용된 구매 비용 합산

        int j = 0;
        int p = 0;
        for(int i=0; i<users.length; i++){
            int discount = users[i][0];
            int standard = users[i][1];

            int sum = 0;
            for(int e=0; e<emoticons.length; e++){
                if(discount<=combi[e]){
                    sum += emoticons[e]*(100-combi[e])/100;
                }
            }

            if(sum>=standard){
                j++;
            }
            else p+=sum;
        }

        if(j>joinCount){
            joinCount = j;
            price = p;
        }
        else if(j==joinCount && p>price){
            price = p;
        }
    }
}