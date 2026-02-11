import java.io.*;
import java.util.*;

public class BOJ_20055_2 {
    static class Belt{
        int durability;
        boolean robot;

        public Belt(int durability, boolean robot){
            this.durability = durability;
            this.robot = robot;
        }
    }

    static Belt[] belt;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new Belt[N*2];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N*2; i++){
            belt[i] = new Belt(Integer.parseInt(st.nextToken()), false);
        }

        int step = 0;
        while(true){
            System.out.println(step+1);
            step++;

            rotate();

            move();

            //up
            if(belt[0].durability > 0){
                belt[0].robot = true;
                belt[0].durability--;
            }

            System.out.println("상차 후");
            for(int i=0; i<N*2; i++){
                System.out.print(belt[i].durability+"("+belt[i].robot+")  ");
            }
            System.out.println();
            System.out.println();

            if(check())break;
        }

        System.out.print(step);
    }

    static boolean check(){
        int count = 0;
        for(int i=0; i<2*N; i++){
            if(belt[i].durability==0)count++;
        }

        return count>=K;
    }

    static void move(){
        for(int i=N-2; i>=1; i--){
            if(belt[i].robot && belt[i+1].durability>0 && !belt[i+1].robot){
                belt[i].robot = false;
                belt[i+1].robot = true;
                belt[i+1].durability--;
            }
        }

        System.out.println("이동 후");
        for(int i=0; i<N*2; i++){
            System.out.print(belt[i].durability+"("+belt[i].robot+")  ");
        }
        System.out.println();

        down();
    }

    static void rotate(){
        Belt tmp = belt[N*2-1];

        for(int i=N*2-2; i>=0; i--){
            belt[i+1] = belt[i];
        }

        belt[0] = tmp;

        System.out.println("로테이트 후");
        for(int i=0; i<N*2; i++){
            System.out.print(belt[i].durability+"("+belt[i].robot+")  ");
        }
        System.out.println();

        down();
    }

    static void down(){
        if(belt[N-1].robot){
            belt[N-1].robot = false;
        }

        System.out.println("하차 후");
        for(int i=0; i<N*2; i++){
            System.out.print(belt[i].durability+"("+belt[i].robot+")  ");
        }
        System.out.println();
    }
}
