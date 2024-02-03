
import java.util.Scanner;
        import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';

        // Initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false; // Invalid move
        }

        board[row][col] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Row win
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Column win
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Diagonal win
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Diagonal win
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Board is not full
                }
            }
        }
        return true; // Board is full
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        Random random = new Random();

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("To make a move, enter the row and column numbers i.e, from (0 to 2).");

        while (true) {
            game.printBoard();

            int row, col;
            if (game.currentPlayer == 'X') {
                System.out.println("Player X's turn:");
                System.out.print("Enter the row: ");
                row = scanner.nextInt();
                System.out.print("Enter the column: ");
                col = scanner.nextInt();
            } else {
                System.out.println("Player O's turn:");
                if (random.nextBoolean()) {
                    row = random.nextInt(3);
                    col = random.nextInt(3);
                    System.out.println("Computer chooses row " + row + " and column " + col + ".");
                } else {
                    System.out.print("Enter the row: ");
                    row = scanner.nextInt();
                    System.out.print("Enter the column: ");
                    col = scanner.nextInt();
                }
            }

            if (game.makeMove(row, col)) {
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a draw!");
                    break;
                } else {
                    game.switchPlayer();
                }
            } else
            {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }
}
