import java.io.*;
import java.util.*;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i=1; i<W-1; i++){
            int leftHigh = 0;
            int rightHigh = 0;

            for(int l=0; l<i; l++){
                leftHigh = Math.max(leftHigh, height[l]);
            }

            for(int r=i+1; r<W; r++){
                rightHigh = Math.max(rightHigh, height[r]);
            }

            if(height[i]<leftHigh && height[i]<rightHigh){
                answer += (Math.min(leftHigh, rightHigh)-height[i]);
            }
        }

        System.out.print(answer);
    }
}
