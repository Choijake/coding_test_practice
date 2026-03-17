import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1091 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] S = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] cards = new int[N];
        for(int i=0; i<N; i++){
            cards[i] = i%3;
        }

        int answer = 0;
        while(true){
            //check
            boolean same = true;
            for(int i=0; i<N; i++){
                if(cards[i]!=P[i]){
                    same = false;
                    break;
                }
            }

            //shuffle
            if(!same){
                answer++;

                int[] move = new int[N];
                for(int i=0; i<N; i++){
                    move[i] = cards[S[i]];
                }

                cards = move.clone();
            }
            else{
                System.out.println(answer);
                return;
            }


            boolean isOrigin = true;
            for(int i=0; i<N; i++){
                if(cards[i]!=i%3){
                    isOrigin = false;
                    break;
                }
            }

            if(isOrigin){
                System.out.println(-1);
                return;
            }
        }
    }
}