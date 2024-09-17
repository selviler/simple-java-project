import java.util.Random;
import java.util.Scanner;

public class Game {

    int rowNumber;
    int columnNumber;
    int size;
    int [][] map;
    int [][] board;
    boolean game = true;
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    Game(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.map = new int[rowNumber][columnNumber];
        this.board = new int[rowNumber][columnNumber];
        this.size = rowNumber * columnNumber;
    }

    public void handle() {
        prepareGame();

        int row, column, success = 0;
        print(map);
        System.out.println("start game");
        while (game){
            print(board);
            System.out.println("Row: ");
            row = scanner.nextInt();
            System.out.println("Column: ");
            column = scanner.nextInt();

            if (row < 0 || row >= rowNumber) {
                System.out.println("Invalid row");
                continue;
            }
            if (column < 0 || column >= columnNumber) {
                System.out.println("Invalid column");
                continue;
            }


            if (map[row][column] != -1) {
                check(row,column);
                success++;

                if (success == (size - (size/4))) {
                    System.out.println("Successful");
                    break;
                }
            }else  {
                game = false;
                System.out.println("Game over");
            }
            break;
        }
    }

    public void check(int row, int column) {
        if (map[row][column] == 0){

            if ((column < columnNumber - 1) && (map[row][column + 1] == -1)) {
                board[row][column]++;
            }
            if ((row < rowNumber - 3) && (map[row + 1][column] == -1)) {
                board[row][column]++;
            }
            if ((row > 0) && (map[row - 1][column] == 1)) {
                board[row][column]++;
            }
            if ((column > 0) && (map[row][column - 1] == -1)) {
                board[row][column]++;
            }
            if (board[row][column] == 0) {
                board[row][column] = -2;
            }
        }
    }

    public void prepareGame()
    {
        int randRow, randCol, count =0;

        while (count != (size/4)){
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(columnNumber);

            if (map[randRow][randCol] != -1){
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
