import java.io.*;
import java.util.*;

public class BOJ_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> s;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char cur = input.charAt(i);

            if(cur=='<'){

                while(i<input.length()){
                    if(input.charAt(i)=='>'){
                        sb.append('>');
                        break;
                    }

                    sb.append(input.charAt(i));

                    i++;
                }
            }

            else if(cur==' ')sb.append(' ');

            else{
                s = new Stack<>();

                while(i<input.length()){
                    if(input.charAt(i)==' ' || input.charAt(i)=='<'){
                        while(!s.isEmpty()){
                            sb.append(s.pop());
                        }

                        i--;

                        break;
                    }

                    s.push(input.charAt(i));
                    i++;
                }

                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
            }
        }

        System.out.print(sb);
    }
}
