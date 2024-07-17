import java.util.Scanner;

public class TicTacToe {
    // This is will help to check that player won or not
    public static boolean haveWon(char[][] board, char player){
        // checking the rows 
        for (int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true; 
            }
        }

        // checking columns 
        for (int col = 0; col < board[0].length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true; 
            }
        }


        // checking for diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true; 
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true; 
        }

        return false; 

    }
    // This will help to print the board
    public static void printBoard(char[][] board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                    System.out.print(board[row][col] + " | "); 
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // creating 3 x 3 board. 
        char[][] board = new char[3][3];
        
        // initializing it as empty. 
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = ' '; 
            }
        }

        char player = 'X';  // This will track the player. which can be X or O. 
        boolean gameOver = false;  // this will track that game is over or not.

        Scanner sc = new Scanner(System.in); 

        while(!gameOver){
            printBoard(board); 

            // taking entries
            System.out.print("Player " + player + " enter : ");
            int row = sc.nextInt();
            int col = sc.nextInt(); 
            System.out.println();

            if(board[row][col] == ' '){
                board[row][col] = player; 
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println(player + " has won.");
                }else{
                    player = (player == 'X')? 'O':'X';
                }
            }else{
                System.out.println("Invalid move. Try again!");
            }
        }
        printBoard(board); 
        sc.close();
    }
}
