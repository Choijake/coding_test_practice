import java.util.*;

class PG_불량사용자 {
    static HashSet<HashSet<String>> result = new HashSet<>();
    static boolean[] visited;
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];

        dfs(0, new HashSet<>(), user_id, banned_id);

        return result.size();
    }

    static void dfs(int depth, HashSet<String> cur, String[] user_id, String[] banned_id){
        if(depth == banned_id.length){
            result.add(new HashSet<>(cur));
            return;
        }

        for(int i=0; i<user_id.length; i++){
            if(visited[i])continue;

            if(isMatch(user_id[i], banned_id[depth])){
                visited[i] = true;
                cur.add(user_id[i]);
                dfs(depth+1, cur, user_id, banned_id);
                visited[i] = false;
                cur.remove(user_id[i]);
            }
        }
    }

    static boolean isMatch(String user, String ban){
        if(user.length() != ban.length())return false;


        for(int i=0; i<user.length(); i++){
            if(ban.charAt(i)!='*' && user.charAt(i)!=ban.charAt(i)){
                return false;
            }
        }

        return true;
    }
}