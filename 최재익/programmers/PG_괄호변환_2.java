import java.util.*;

class PG_괄호변환_2 {
    public String solution(String p) {
        return process(p, 0);
    }

    static String process(String p, int depth){
        if(p.length()==0)return "";

        //u, v 분리
        String[] uv = separate(p);

        //u 올바른 문자열 여부 판단
        boolean flag = isAlright(uv[0]);

        //u가 올바른 문자열일 경우
        if(flag){
            return uv[0]+process(uv[1], depth+1);
        }
        //u가 올바른 문자열이 아닐 경우
        return '(' + process(uv[1], depth+1) + ')' + changeWhenNotAlright(uv[0]);
    }

    static String changeWhenNotAlright(String u){
        String newU = "";

        for(int i=1; i<=u.length()-2; i++){
            if(u.charAt(i)=='(')newU+=')';
            else newU+='(';
        }

        return newU;
    }

    static boolean isAlright(String u){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<u.length(); i++){
            char cur = u.charAt(i);

            if(cur=='(')stack.push(cur);
            else if(!stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    static String[] separate(String p){
        Stack<Character> stack = new Stack<>();

        stack.push(p.charAt(0));
        int idx=1;
        while(true){
            if(stack.isEmpty() || idx>=p.length())break;

            char cur = p.charAt(idx);

            if(cur=='(' && stack.peek()==')')stack.pop();
            else if(cur==')' && stack.peek()=='(')stack.pop();
            else stack.push(cur);

            idx++;
        }

        return new String[]{p.substring(0, idx), p.substring(idx, p.length())};
    }
}