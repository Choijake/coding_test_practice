import java.util.*;

class PG_자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;

        for(int r=0; r<4; r++){
            int[][] extendedKey = extendKey(key, n);

            // 이동 및 체크
            for(int i=0; i<=extendedKey.length-n; i++){
                for(int j=0; j<=extendedKey.length-n; j++){
                    if(check(extendedKey, lock, i, j)) return true;
                }
            }

            // 회전
            key = turnKey(key);
        }

        return false;
    }

    static int[][] turnKey(int[][] key){
        int m = key.length;
        int[][] turnedKey = new int[m][m];

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                turnedKey[i][j] = key[m-j-1][i];
            }
        }

        return turnedKey;
    }

    static boolean check(int[][] extendedKey, int[][] lock, int startRow, int startCol){
        int n = lock.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(extendedKey[startRow+i][startCol+j] + lock[i][j] != 1) return false;
            }
        }

        return true;
    }

    static int[][] extendKey(int[][] key, int n){
        int m = key.length;
        int size = m + 2 * (n - 1);
        int[][] extendedKey = new int[size][size];

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                extendedKey[i+n-1][j+n-1] = key[i][j];
            }
        }

        return extendedKey;
    }
}