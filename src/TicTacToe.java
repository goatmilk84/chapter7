import java.util.Scanner;
class TicTacToe {
    static int[][] board = { /** Creating my game board. I created a 3x3 array on which the game will be played.*/
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };
    void gameSetup() {/** Details of the game board. */
        System.out.println("-------------"); /**Horizontal lines of the game board.*/
        for (int i = 0; i < 3; i++) { /** Since we have a 3x3 grid, I created 3 rows and columns
         of small lines, to act as the borders to my board squares.*/
        //Increment operator in "i++" allows u to move from box to box.
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");}
            //[i] corresponds to the current row and [j] is the current row, so board[i][j] will = board[1][1] on our first iteration for example.
            System.out.println();
            System.out.println("-------------");/**Horizontal lines of the game board.*/
        }
    }
    int[] chosenMove(int playerSymbol) { /** The chosenMove method logs the player symbol to the
     player's desired space(row, column). */
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = new int[2]; // Array value 0 and 1(inputted by user) stored in the variable "coordinates".
        //Together, the two form a coordinate pair in which to place a user symbol.

        System.out.print("Player " + playerSymbol + ", select a row (0, 1, or 2): ");
        coordinates[0] = scanner.nextInt();

        System.out.print("Player " + playerSymbol + ", select a column (0, 1, or 2): ");
        coordinates[1] = scanner.nextInt();

        return coordinates;
    }
    boolean checkWinner(int row, int col, int playerSymbol) { /**There are only so many ways to win
     a game of Tic Tac Toe - 4, to be exact: by rows, columns, and the 2 diagonals. The checkWinner method checks to see if any player has satisfied
     those ways of winning. */
        return (
                board[row][0] == playerSymbol /**Checks if there are 3 like rows. */
                && board[row][1] == playerSymbol
                && board[row][2] == playerSymbol

                || board[0][col] == playerSymbol /**Checks if there are 3 like columns.*/
                && board[1][col] == playerSymbol
                && board[2][col] == playerSymbol

                || row == col
                && board[0][0] == playerSymbol /**Checks if the first diagonal has been unified.*/
                && board[1][1] == playerSymbol
                && board[2][2] == playerSymbol

                || row + col == 2
                && board[0][2] == playerSymbol /**Checks if the second diagonal has been unified. */
                && board[1][1] == playerSymbol
                && board[2][0] == playerSymbol);
    }
}