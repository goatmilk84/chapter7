import java.util.Scanner;

public class TicTacTester {

    public static void main(String[] args) {
        TicTacToe newGame = new TicTacToe();// Calling my new TicTacToe class
        int playerSymbol = 1; /* playerSymbol holds the integer value passed to chosenMove. Player 1 will have the first
        move, but playerSymbol will switch depending on whose turn it is(later on in the code).
        */

        System.out.println("Welcome to the greatest Tic Tac Toe program in human history!");

        int totalMoves = 0; /* We have a totalMoves integer in order to keep track of how many moves have been
        taken so far. A TicTacToe game can only have 9 moves, so we keep track of the amount of moves in order
        to limit the game at 9 moves(the game can be won, but the program might keep running even though all spaces
        have been taken up.
        */
        boolean gameWon = false; /* I have a boolean "gameWon" created, so that if the game is found to
        have been won, it will end. The moment 3 in a row are found, gameWon should kick in and print a short
        winner's dialogue.
        */

        while (!gameWon && totalMoves < 9) { // Simply using the variables I described above.
            newGame.gameSetup(); // Creating the game board using the gameSetup function

            int[] coordinates = newGame.chosenMove(playerSymbol);
            int col = coordinates[1];
            int row = coordinates[0];

            if (newGame.board[row][col] == 0) { /* If the spot the user selects is empty(has a zero),
            the spot will be written as the playerSymbol - the symbol of the player who chose that spot.
            */
                newGame.board[row][col] = playerSymbol;
                gameWon = newGame.checkWinner(row, col, playerSymbol); /*After every new selection we run the checkWinner
                function as described in my class initialization.
                */
                playerSymbol = (playerSymbol == 1) ? 2 : 1; /* Using a ternary operator to decide which player
                will go next after each turn. If playerSymbol = 1, it will become 2, signifying that it's player 2's turn.
                If playerSymbol does not currently equal 1, it must equal 2, and will subsequently switch back to 1.
                */
                totalMoves++; // Add one to the totalMoves tally.
            } else {
                System.out.println("Spot already taken. Please pick again \uD83D\uDE10");
                /* If the spot has already been taken, the computer will simply inform the user, and they pick
                again.
                 */
            }
        }
        newGame.gameSetup();
        if (gameWon) {
            System.out.println("Player " + playerSymbol + " wins!\uD83C\uDF89");
        } else {
            System.out.println("We have a tie \uD83D\uDE12");
        }
    }
}