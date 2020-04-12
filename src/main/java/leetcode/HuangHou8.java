package leetcode;

import java.util.ArrayList;
import java.util.List;

public class HuangHou8 {
    private static List<int[][]> res = new ArrayList<>();
    public static void main(String[] args){
        int n = 8;
        int[][] board = new int[n][n];
        putQueue(n,board);
        System.out.println(res.size());
    }
    private static void putQueue(int n, int[][] board) {
       // System.out.println("putQueue");
        printBoard(board);
        //n 还剩几个皇后
        if(n == 0){
            res.add(cloneBoard(board));
            printBoard(board);
            return;
        }
        //当前应该放第几个皇后
        int num = board.length - n;
        for(int i=0;  i<board.length;i++){
            board[num][i] = 1;

            if(isValid(board, num, i)){
                putQueue(n-1,board);
                board[num][i] = 0;
            } else {
                board[num][i] = 0;
            }

        }

    }

    private static boolean isValid(int[][] board, int num, int i) {
        int n = board.length;
        //竖方向
        for(int j=0; j<num; j++){
            if(board[j][i] == 1){
                return false;
            }
        }
        //正斜线 /
        int j=num-1;
        int k=i+1;
        while(j>=0 && k <n){
            if(board[j][k] == 1){
                return false;
            }
            j--;
            k++;
        }
        //反斜线 \
        j=num-1;
        k=i-1;
        while(j>=0 && k >=0){
            if(board[j][k] == 1){
                return false;
            }
            j--;
            k--;
        }
        return true;
    }
    private static int[][] cloneBoard(int[][] board){
        int n = board.length;
        int[][] newBoard = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }
    private static void printBoard(int[][] board){
        int n = board.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
}
