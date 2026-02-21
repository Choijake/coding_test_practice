import java.util.*;

class PG_삼각달팽이 {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] triangle = new int[n][n];

        int r = -1;
        int c = 0;
        int num = 1;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0){
                    r++;
                }
                else if(i%3==1){
                    c++;
                }
                else if(i%3==2){
                    r--;
                    c--;
                }

                triangle[r][c] = num++;
            }
        }

        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(triangle[i][j]==0)break;
                answer[idx++] = triangle[i][j];
            }
        }

        return answer;
    }
}