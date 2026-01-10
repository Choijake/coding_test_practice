import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] arr = new Stack[7];
        for(int i=1; i<7; i++){
            arr[i] = new Stack<>();
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken());
            int input = Integer.parseInt(st.nextToken());
            Stack<Integer> stack = arr[line];

            if(stack.isEmpty()){
                stack.push(input);
                answer++;
            }
            else if(stack.peek()<input) {
                stack.push(input);
                answer++;
            }
            else if(stack.peek()>input){
                while(!stack.isEmpty() && stack.peek()>input){
                    stack.pop();
                    answer++;
                }

                if(!stack.isEmpty() && stack.peek()==input)continue;

                stack.push(input);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
