import java.util.*;

class PG_가장긴펠린드롬 {
    public int solution(String s){
        int length = s.length();

        int answer = 0;
        for(int i=length; i>=1; i--){
            if(check(i, s)){
                answer = i;
                break;
            }
        }

        return answer;
    }

    static boolean check(int length, String s){
        int start = 0;
        int end = start+length-1;

        while(end<s.length()){
            if(isPalindrome(s, start, end, length)){
                return true;
            }

            start++;
            end++;
        }

        return false;
    }

    static boolean isPalindrome(String s, int start, int end, int length){
        for(int i=0; i<length/2; i++){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }

        return true;
    }
}