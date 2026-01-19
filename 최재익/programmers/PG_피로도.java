import java.util.*;

class PG_피로도 {
    static boolean[] visited;
    static int[] seq;
    static int k;
    static int[][] dungeons;
    static int max;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        seq = new int[dungeons.length];
        this.k = k;
        this.dungeons = dungeons;
        max = -1;

        permutation(0);

        return max;
    }

    public void permutation(int depth){
        if(depth==dungeons.length){
            max = Math.max(max, process());
            return;
        }

        for(int i=0; i<dungeons.length; i++){
            if(visited[i])continue;
            visited[i] = true;
            seq[depth] = i;
            permutation(depth+1);
            visited[i] = false;
        }
    }

    public int process(){
        int point = k;
        int result = 0;

        for(int idx : seq){
            int[] fatigue = dungeons[idx];
            int open = fatigue[0];
            int close = fatigue[1];

            if(point >= open){
                result++;
                point-=close;
            }
        }

        return result;
    }
}