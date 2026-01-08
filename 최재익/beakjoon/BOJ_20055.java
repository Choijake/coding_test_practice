import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055 {
    static int N, K;
    static Belt[] belt;

    static class Belt{
        int strength;
        boolean robot;

        Belt(int strength, boolean robot){
            this.strength = strength;
            this.robot = robot;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new Belt[2*N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=2*N; i++){
            int strength = Integer.parseInt(st.nextToken());
            belt[i] = new Belt(strength, false);
        }

        int answer = 1;
        while(true){
            //rotate
            Belt tmp = belt[2*N];
            for(int i=2*N; i>=2; i--){
                belt[i] = belt[i-1];
            }
            belt[1] = tmp;

            if(belt[N].robot){
                belt[N].robot = false;
            }

            //move
            for(int i=N-1; i>=1; i--){
                if(belt[i].robot && belt[i+1].strength>0 && !belt[i+1].robot){
                    belt[i].robot = false;
                    belt[i+1].robot = true;
                    belt[i+1].strength--;
                }
            }

            if(belt[N].robot){
                belt[N].robot = false;
            }

            //up
            if(belt[1].strength>0){
                belt[1].robot = true;
                belt[1].strength--;
            }

            //check
            int count = 0;
            for(int i=1; i<=2*N; i++){
                if(belt[i].strength==0)count++;
            }

            if(count==K)break;

            answer++;
        }

        System.out.println(answer);
    }
}
