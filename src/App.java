import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static String[] board;

    private static void printBoard(){
        System.out.println("|-----------|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " | ");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " | ");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " | ");
        System.out.println("|-----------|");
    }

    private static String checkWinner(){
        int[][] winPos = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
        String winner = "";

        for(int i = 0; i < winPos.length; i++){
            if(board[winPos[i][0]].equals(board[winPos[i][1]]) && board[winPos[i][0]].equals(board[winPos[i][2]])){
                winner = board[winPos[i][0]];
                return winner;
            }
        }

        return winner;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        String winner = "";
        int turns = 1;
 
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");

        printBoard();
 
        System.out.println("X will play first. Enter a slot number to place X in: ");
        
        String turn = "X";

        while(winner.equals("")){
            int numInput;

            try{
                numInput = in.nextInt();
                if(numInput < 0 || numInput > 9){
                    System.out.println("Invalid Input. Re-enter slot number: ");
                    continue;
                }
            }catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input; re-enter slot number:");
                continue;
            }

            if(board[numInput - 1].equals(String.valueOf(numInput))){
                board[numInput - 1] = turn;

                if(turn.equals("X")){
                    turn = "O";
                }else{
                    turn = "X";
                }
                printBoard();
                winner = checkWinner();
                turns++;
                if(turns > 9) break;
            }

            System.out.println(turn + "'s turn. Enter a slot number to place O in: ");
        }

        if(!winner.equals("")){
            System.out.println(winner + " has won! Congratulations!");
        }else{
            System.out.println("Its a draw!");
        }

        in.close();
    }
}
