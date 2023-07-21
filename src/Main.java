import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] table;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        table = new int[9][9];

        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                int next = Integer.parseInt(st.nextToken());
                table[i][j] = next;
            }
        }

        sudoku(0, 0);

    }

    public static void sudoku(int row, int col){
        if(col == 9){
            sudoku(row + 1, 0);
            return;
        }

        if(row == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(table[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        if(table[row][col] == 0){
            for(int i = 1; i <= 9; i++){
                if(possibility(row, col, i)){
                    table[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            table[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    public static boolean possibility(int row, int col, int value){
        for(int i = 0; i < 9; i++){
            if(table[row][i] == value){
                return false;
            }
        }

        for(int i = 0; i < 9; i++){
            if(table[i][col] == value){
                return false;
            }
        }

        int ract_row = (row/3) * 3;
        int ract_col = (col/3) * 3;

        for(int i = ract_row; i < ract_row + 3; i++){
            for(int j = ract_col; j < ract_col + 3; j++){
                if(table[i][j] == value){
                    return false;
                }
            }
        }

        return true;
    }

}