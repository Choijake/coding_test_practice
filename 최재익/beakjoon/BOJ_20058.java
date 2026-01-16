import java.io.*;
import java.util.*;

public class BOJ_20058 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N, Q;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        N = (int)Math.pow(2, N);
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++){
            int L = Integer.parseInt(st.nextToken());
            int size = (int)Math.pow(2, L);

//            System.out.println("사이즈가 "+ size +"일 때");

            int[][] nextMap = new int[N][N];
            for(int r = 0; r<=N-size; r+=size){
                for(int c=0; c<=N-size; c+=size){
                    rotate(r, c, size, nextMap);
                }
            }

//            for(int r=0; r<N; r++){
//                for(int c=0; c<N; c++){
//                    System.out.print(nextMap[r][c]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//
            map = meltDown(nextMap);
//            for(int r=0; r<N; r++){
//                for(int c=0; c<N; c++){
//                    System.out.print(map[r][c]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        int sum = 0;
        int big = 0;

        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sum+=map[i][j];

                if(!visited[i][j] && map[i][j]>0){
                    big = Math.max(big, bfs(i,j));
                }
            }
        }

        System.out.println(sum+"\n"+big);

    }

    static int bfs(int row, int col){
        Queue<int[]> queue = new ArrayDeque<>();
        visited[row][col] = true;
        queue.add(new int[]{row, col});

        int size = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i=0; i<4; i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];

                if(nr<0 || nc<0 || nr>=N || nc>=N)continue;
                if(map[nr][nc]==0)continue;
                if(visited[nr][nc])continue;

                size++;
                queue.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return size;
    }

    static void rotate(int r, int c, int size, int[][] nextMap){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                nextMap[r+i][c+j] = map[r+size-1-j][c+i];
            }
        }
    }

    static int[][] meltDown(int[][] map){
        int[][] nextMap = new int[N][N];
        for(int i=0; i<N; i++)nextMap[i]=Arrays.copyOf(map[i], N);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0)continue;

                int count = 0;
                for(int d=0; d<4; d++){
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc]==0)continue;

                    count++;
                }

                if(count<3){
                    //System.out.println(i+", "+j);
                    nextMap[i][j]--;
                }
            }
        }

        return nextMap;
    }
}
