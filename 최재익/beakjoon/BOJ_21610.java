import java.io.*;
import java.util.*;

public class BOJ_21610 {
    static int N, M;
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[][]bucket;
    static List<int[]> cloud;
    static List<int[]> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bucket = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                bucket[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud = new ArrayList<>();
        cloud.add(new int[]{N,1});
        cloud.add(new int[]{N,2});
        cloud.add(new int[]{N-1,1});
        cloud.add(new int[]{N-1,2});

        visited = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            //cloud move
            boolean[][] nextCloud = new boolean[N+1][N+1];
            for(int idx=0; idx<cloud.size(); idx++){
                int r = cloud.get(idx)[0];
                int c = cloud.get(idx)[1];
                int nr = (((r-1)+dr[d]*s)%N+N)%N+1;
                int nc = (((c-1)+dc[d]*s)%N+N)%N+1;

                nextCloud[nr][nc] = true;
            }

            //raining
            for(int r=1; r<=N; r++){
                for(int c=1; c<=N; c++){
                    if(nextCloud[r][c]){
                        bucket[r][c]++;
                    }
                }
            }

            //delete cloud
            cloud = new ArrayList<>();

            //copy water
            for(int r=1; r<=N; r++){
                for(int c=1; c<=N; c++){
                    if(nextCloud[r][c]){
                        int count = 0;
                        for(int dir=2; dir<=8; dir+=2){
                            int nr = r+dr[dir];
                            int nc = c+dc[dir];

                            if(nr<1 || nc<1 || nr>N || nc>N)continue;
                            if(bucket[nr][nc]>0)count++;
                        }

                        bucket[r][c] += count;
                    }
                }
            }

            //update water
            for(int r=1; r<=N; r++){
                for(int c=1; c<=N; c++){
                    if(nextCloud[r][c])continue;

                    if(bucket[r][c]>=2){
                        bucket[r][c]-=2;
                        cloud.add(new int[]{r, c});
                    }
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                answer += bucket[i][j];
            }
        }

        System.out.println(answer);
    }
}
