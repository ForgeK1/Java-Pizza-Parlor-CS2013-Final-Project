package Minigames;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
    1) Class Name: TicTacToe

    2) How will this class work?:
        - This class will work by returning a boolean value in the play() method that will indicate whether the player has won or lost the minigame.
          The player is 'X' and the computer is 'O'. You must beat the computer in the classic game of TicTacToe. Safety features have been implemented,
          including invalid user input, index exceptions, etc.

    3) Class made by: Md R. Islam

    4) Course: Java 2013 Programming with Data Structures
 */

public class TicTacToe {
  private Scanner input = new Scanner(System.in);
    private char[][] board = {{' ', ' ', ' '},
                              {' ', ' ', ' '},
                              {' ', ' ', ' '}};
    public TicTacToe() {

    }
    public void display(char[][] board) {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("--+---+--");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("--+---+--");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
    public boolean play() {
        boolean keepPlaying = true;

        System.out.println("\n------------------------------------");
        System.out.println("| Title of Minigame: TIC-TAC-TOE! |");
        System.out.println("------------------------------------");

        do {
            try {
                display(this.board);

                playerMove();
                if(isGameOver(this.board)) {
                    display(this.board);
                    System.out.println("Congratulations! You win!");
                    keepPlaying = false;
                    return true;
                }
                if(isGameTied(this.board)) {
                    keepPlaying = false;
                    display(this.board);
                    System.out.println("Game is tied...");
                    return false;
                }

                computerMove();
                if(isGameOver(this.board) && keepPlaying == true) {
                    keepPlaying = false;
                    display(this.board);
                    System.out.println("Unfortunatley, you lost :(");
                    return false;
                }
                if(isGameTied(this.board)) {
                    keepPlaying = false;
                    display(this.board);
                    System.out.println("Game is tied...");
                    return false;
                }


            }
            catch(InputMismatchException ime) { // handle any bad input entered by the user
                input.next(); // throw away the bad input
                System.out.println("Invalid input. Try again.");
            }
            catch (Exception e) {
                input.next();
                System.out.println("Unexpected error.");
            }
        } while(keepPlaying);
        return false;
    }

    private boolean isGameOver(char[][] board) {
        // checking horizontal wins
        if((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
           (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X' ) ||
           (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||
            // checking vertical wins
           (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
           (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
           (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||
           // checking diagonal wins
           (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
           (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'))
        {
            return true;
        }

        if((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
           (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O' ) ||
           (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||
           // checking vertical wins
           (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
           (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
           (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||
           // checking diagonal wins
           (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
           (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'))
        {
            return true;
        }

        return false;
    }
    private boolean isGameTied(char[][] board) {
        if(!isGameOver(this.board) && isBoardFull(this.board)) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull(char[][] board) {
        int numberOfSpotsTaken = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != ' ') {
                    numberOfSpotsTaken++;
                }
            }
        }
        if(numberOfSpotsTaken == 9) {
            return true;
        }
        return false;
    }

    private void playerMove() {
        System.out.print("Where you would you like to play? (1-9): ");
        int playerChoice;

        while(true) {
            playerChoice = input.nextInt();
            if(isValidMove(playerChoice)) {
                break;
            }
            else {
                System.out.print("Invalid position! Try again: ");
            }
        }

        placeMove(playerChoice, 'X');
    }
    private void computerMove() {

        int computerChoice;

        while(true) {
            // randomly picks a number between 1 and 9 to choose a spot on the board
            computerChoice = (int)(1 + Math.random() * 9);
            if(isValidMove(computerChoice)) {
                break;
            }
        }

        placeMove(computerChoice, 'O');
    }
    private boolean isValidMove(int position) {
        switch (position) {
            case 1: return this.board[0][0] == ' ';
            case 2: return this.board[0][1] == ' ';
            case 3: return this.board[0][2] == ' ';
            case 4: return this.board[1][0] == ' ';
            case 5: return this.board[1][1] == ' ';
            case 6: return this.board[1][2] == ' ';
            case 7: return this.board[2][0] == ' ';
            case 8: return this.board[2][1] == ' ';
            case 9: return this.board[2][2] == ' ';
            default:
                return false;

        }
    }
    private void placeMove(int position, char playerOrComputer) {
        switch (position) {
            case 1: board[0][0] = playerOrComputer; break;
            case 2: board[0][1] = playerOrComputer; break;
            case 3: board[0][2] = playerOrComputer; break;
            case 4: board[1][0] = playerOrComputer; break;
            case 5: board[1][1] = playerOrComputer; break;
            case 6: board[1][2] = playerOrComputer; break;
            case 7: board[2][0] = playerOrComputer; break;
            case 8: board[2][1] = playerOrComputer; break;
            case 9: board[2][2] = playerOrComputer; break;
            default:
                System.out.println("Invalid operand!");
        }
    }

}
