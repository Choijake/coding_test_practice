import java.io.*;
import java.util.*;

public class BOJ_21608_2 {
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N;
    static Map<Integer, int[]> hashMap;

    static class Seat{
        int row;
        int col;
        int friendCount;
        int blankCount;

        Seat(){}

        public Seat(int row, int col, int friendCount, int blankCount){
            this.row = row;
            this.col = col;
            this.friendCount = friendCount;
            this.blankCount = blankCount;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        hashMap = new HashMap<>();

        PriorityQueue<Seat> pq;
        int[] friend;
        for(int i=0; i<N*N; i++) {
            st = new StringTokenizer(br.readLine());

            pq = new PriorityQueue<>((s1, s2) -> {
                if (s1.friendCount != s2.friendCount) return s2.friendCount - s1.friendCount;
                if (s1.blankCount != s2.blankCount) return s2.blankCount - s1.blankCount;
                if (s1.row != s2.row) return s1.row - s2.row;
                return s1.col - s2.col;
            });

            friend = new int[4];
            int number = Integer.parseInt(st.nextToken());
            for (int f = 0; f < 4; f++) {
                friend[f] = Integer.parseInt(st.nextToken());
            }

            hashMap.put(number, friend);

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(map[r][c]!=0)continue;
                    int[] countResult = count(r, c, friend);
                    pq.add(new Seat(r, c, countResult[0], countResult[1]));
                }
            }

            Seat s = pq.poll();
            int sr = s.row;
            int sc = s.col;

            map[sr][sc] = number;
        }

        System.out.print(getSatisfaction());
    }

    static int getSatisfaction(){
        int satisfaction = 0;

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                int[] friend = hashMap.get(map[r][c]);

                int count = 0;
                for(int d=0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(nr<0 || nc<0 || nr>=N || nc>=N)continue;

                    for(int f=0; f<4; f++){
                        if(friend[f]==map[nr][nc]){
                            count++;
                        }
                    }
                }

                switch(count){
                    case 0 : satisfaction+=0;
                        break;

                    case 1 : satisfaction+=1;
                        break;

                    case 2 : satisfaction+=10;
                        break;

                    case 3 : satisfaction+=100;
                        break;

                    case 4 : satisfaction+=1000;
                        break;
                }
            }
        }

        return satisfaction;
    }

    static int[] count(int row, int col, int[] friend){
        int f_count = 0;
        int b_count = 0;
        for(int i=0; i<4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr<0 || nc<0 || nr>=N || nc>=N)continue;
            if(map[nr][nc]==0){
                b_count++;
                continue;
            }

            for(int f=0; f<4; f++){
                if(friend[f]==map[nr][nc]){
                    f_count++;
                }
            }
        }

        return new int[]{f_count, b_count};
    }
}
