import java.io.*;
import java.util.*;

public class BOJ_17141 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static List<int[]> virus;
    static boolean[] visited;
    static int[] arr;
    static int[][] copyMap;
    static int[][] map;
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        virus = new ArrayList<>();
        map = new int[N][N];
        copyMap = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new int[]{i, j});
                }
            }
        }

        arr = new int[M];
        visited = new boolean[virus.size()];

        answer = Integer.MAX_VALUE;
        permutation(0, 0);

        answer = (answer==Integer.MAX_VALUE)?-1:answer;
        System.out.print(answer);
    }

    static void permutation(int depth, int start){
        if(depth == M){
//            for(int i=0; i<arr.length; i++){
//                System.out.print(arr[i]+ " ");
//            }
//            System.out.println();
            bfs();
            return;
        }

        for(int i=start; i<virus.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                permutation(depth+1, start+1);
                visited[i] = false;
            }
        }
    }

    static void copy(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==2){
                    copyMap[i][j] = 0;
                }
                else copyMap[i][j] = map[i][j];
            }
        }
    }

    static boolean check(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(copyMap[i][j]==0)return false;
            }
        }
        return true;
    }

    static void bfs(){
        copy();
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        for(int i=0; i<arr.length; i++){
            queue.add(new int[]{virus.get(arr[i])[0], virus.get(arr[i])[1], 0});
            visited[virus.get(arr[i])[0]][virus.get(arr[i])[1]] = true;
            copyMap[virus.get(arr[i])[0]][virus.get(arr[i])[1]]=2;
        }

        int day = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            day = Math.max(day, cur[2]);

            for(int i=0; i<4; i++){
                int nextRow = cur[0]+dr[i];
                int nextCol = cur[1]+dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=N || nextCol>=N)continue;
                if(visited[nextRow][nextCol])continue;

                if(copyMap[nextRow][nextCol]==0){
                    copyMap[nextRow][nextCol] = 2;
                    queue.add(new int[]{nextRow, nextCol, cur[2]+1});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        if(check()){
//            System.out.println("in");
            answer = Math.min(answer, day);
        }
    }
}
