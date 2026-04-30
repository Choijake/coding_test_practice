import java.util.*;

class PG_단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2)->{
            return o1[0]-o2[0];
        });

        int answer = 1;

        int cursor = routes[0][1];
        for(int i=1; i<routes.length; i++){
            int nx = routes[i][0];
            int ny = routes[i][1];

            if(ny < cursor){
                cursor = ny;
            }
            else if(cursor < nx){
                answer++;
                cursor = ny;
            }
        }

        return answer;
    }
}