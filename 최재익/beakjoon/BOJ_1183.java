import java.io.*;
import java.util.*;

public class BOJ_1183 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] numbers = new int[4];
        for(int i=0; i<4; i++){
            int idx = i;
            String number = "";
            for(int j=0; j<4; j++){
                number += arr[idx%4];
                idx++;
            }

        }
    }
}
