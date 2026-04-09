import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> base = new Stack<>();
        String input = br.readLine();

        for(int i=0; i<input.length(); i++){
            base.push(input.charAt(i));
        }

        Stack<Character> ds = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String cmd = br.readLine();

            if(cmd.equals("L")){
                if(base.isEmpty())continue;
                Character pop = base.pop();
                ds.push(pop);
            }
            else if(cmd.equals("D")){
                if(ds.isEmpty())continue;
                Character pop = ds.pop();
                base.push(pop);
            }
            else if(cmd.equals("B")){
                if(base.isEmpty())continue;
                base.pop();
            }
            else{
                Character p = cmd.charAt(2);
                base.push(p);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!ds.isEmpty()){
            base.push(ds.pop());
        }

        for(int i=0; i<base.size(); i++){
            sb.append(base.get(i));
        }

        System.out.print(sb);
    }
}