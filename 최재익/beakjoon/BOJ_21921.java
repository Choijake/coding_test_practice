import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_21921 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<X; i++){
            sum += arr[i];
        }

        int max = sum;
        int count = 1;

        for(int i=1; i<=N-X; i++){
            sum -= arr[i-1];
            sum += arr[i+X-1];

            if(sum>max){
                max = sum;
                count = 1 ;
            }
            else if(sum==max){
                count++;
            }
        }

        if(max==0){
            System.out.print("SAD");
            return;
        }

        System.out.print(max+"\n"+count);
    }
}
