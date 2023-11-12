import java.util.Scanner;

public class TicTacToe3 {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
         Scanner sc = new Scanner(System.in);
         
        Play(board , sc);
       
       System.out.println("type 1 if u want to play again else 0");
        int n = sc.nextInt();
        if(n==1){
            Play(board, sc);
        }else{
            System.out.println("You exited");
            return ;
        }
        //sc.close(); don't close scanner bcoz u can't use it furrther in your code 
    }
    public static void Play(char[][] board , Scanner sc){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
        
        char currentPlayer = 'X';
        System.out.println("Player 1 = X");
        System.out.println("Player 2 = O");
        
        boolean gameOver = false;
        //Scanner sc = new Scanner(System.in);
        
        while (!gameOver) {
            
            printBoard(board);
            System.out.println("Enter 0 if you want to exit from the game!");
            int exit = sc.nextInt();

                    if (exit==0 ) {
                        System.out.println("Thanks for playing!!");
                        return;
                    }
            System.out.println("Player " + currentPlayer + " enter position 1-9");
            
            int position = sc.nextInt();
            if (isValidMove(board, position)) {
                placeMove(board, position, currentPlayer);
                //printBoard(board);
                gameOver =  haveWon(board, currentPlayer) || isBoardFull(board);
                if (gameOver) {
                    
                    if (haveWon(board, currentPlayer)) {
                        System.out.println("Player " + currentPlayer + " has won!");
                    } else {
                        System.out.println("It's a draw! No player wins.");
                    }
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid input. Enter a position between 1-9.");
            }

        }
        printBoard(board);
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.print(" | ");
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(char[][] board, int position) {
        if (!(position >= 1 && position <= 9)) {
            System.out.println("Enter valid choice 0-9");
            return false;
        }

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        return board[row][col] == ' ';
    }

    private static void placeMove(char[][] board, int position, char currentPlayer) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        board[row][col] = currentPlayer;
    }

    public static boolean haveWon(char[][] board, char currentPlayer) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
                return true;
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
                return true;
            }
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }

        return board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer;
    }
    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == ' ') {
                    return false; // There's an empty space, board is not full
                }
            }
        }
        return true; // Board is full
    }
}
