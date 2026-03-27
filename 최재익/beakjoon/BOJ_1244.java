import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1244 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken())-1;

            //남
            if(sex==1){
                for(int j=idx; j<N; j+=(idx+1)){
                    if(arr[j]==0)arr[j]=1;
                    else arr[j] = 0;
                }
            }
            //여
            else {
                int left = idx-1;
                int right = idx+1;
                while(true){
                    if(left<0 || right >=N){
                        left++;
                        right--;
                        break;
                    }

                    if(arr[left]!=arr[right]){
                        left++;
                        right--;
                        break;
                    }

                    left--;
                    right++;
                }

                if(left==right){
                    if(arr[idx]==0)arr[idx]=1;
                    else arr[idx]=0;
                }
                else{
                    for(int s=left; s<=right; s++){
                        if(arr[s]==0)arr[s]=1;
                        else arr[s]=0;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(i>0 && i%20==0){
                sb.append("\n");
            }
            sb.append(arr[i]).append(" ");
        }

        System.out.print(sb);
    }
}
