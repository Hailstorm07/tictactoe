import java.util.Scanner;

class TicTacToe {
    private static final int SIZE = 3;
    private static char[][] board = new char[SIZE][SIZE];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        while (true) {
            printBoard();
            playerMove();
            if (isWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isDraw()) {
                printBoard();
                System.out.println("The game is a draw!");
                break;
            }
            switchPlayer();
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid");
            }
        }
    }

    private static boolean isWin() {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    private static boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
