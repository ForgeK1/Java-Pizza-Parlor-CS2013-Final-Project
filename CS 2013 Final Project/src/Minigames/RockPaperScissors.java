package Minigames;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static int playerWins = 0;
    private static int computerWins = 0;



    public boolean play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------");

        System.out.println("Welcome to Rock, Paper, Scissors Game!");
        System.out.println("------------------------------------");
        System.out.println("You need to win 3 times to win the game. If the computer wins 3 times, you lose.");
        System.out.println("------------------------------------");

        while (true) {
            System.out.println("Enter your move (Rock, Paper, Scissors) or 'exit' to end the game:");
            String playerMove = scanner.nextLine().toUpperCase();

            if (playerMove.equals("EXIT")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            if (!isValidMove(playerMove)) {
                System.out.println("Invalid move. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            String computerMove = generateComputerMove();
            System.out.println("Computer's move: " + computerMove);

            displayMoves(playerMove, computerMove);
            determineWinner(playerMove, computerMove);

            System.out.println("Player Wins: " + playerWins + " | Computer Wins: " + computerWins);

            if (playerWins >= 3) {
                System.out.println("Congratulations! You won the game!");
                return true;

            } else if (computerWins >= 3) {
                System.out.println("Sorry! Computer won the game. Better luck next time!");
                return false;
            }
        }
        scanner.close();

        return false; //this will never happen but needs to return to compile :D
    }


    private static boolean isValidMove(String move) {
        return move.equals("ROCK") || move.equals("PAPER") || move.equals("SCISSORS");
    }

    private static String generateComputerMove() {
        String[] moves = {"ROCK", "PAPER", "SCISSORS"};
        int index = new Random().nextInt(moves.length);
        return moves[index];
    }

    private static void displayMoves(String playerMove, String computerMove) {
        System.out.println("Player's move:");
        displayMoveArt(playerMove);

        System.out.println("Computer's move:");
        displayMoveArt(computerMove);

        System.out.println();
    }

    private static void displayMoveArt(String move) {
        switch (move) {
            case "ROCK":
                System.out.println("    _______");
                System.out.println("---'   ____)");
                System.out.println("      (_____)");
                System.out.println("      (_____)");
                System.out.println("      (____)");
                System.out.println("---.__(___)");
                break;
            case "PAPER":
                System.out.println("    _______ ");
                System.out.println("---'   ____)____");
                System.out.println("          ______)");
                System.out.println("          _______)");
                System.out.println("         _______)");
                System.out.println("---.__________)");
                break;
            case "SCISSORS":
                System.out.println("    _______ ");
                System.out.println("---'   ____)____");
                System.out.println("          ______)");
                System.out.println("       __________)");
                System.out.println("      (____)");
                System.out.println("---.__(___)");
                break;
        }
    }

    private static void determineWinner(String playerMove, String computerMove) {
        System.out.println("Player's move: " + playerMove);

        if (playerMove.equals(computerMove)) {
            System.out.println("It's a tie!");
        } else if (
                (playerMove.equals("ROCK") && computerMove.equals("SCISSORS")) ||
                        (playerMove.equals("PAPER") && computerMove.equals("ROCK")) ||
                        (playerMove.equals("SCISSORS") && computerMove.equals("PAPER"))
        ) {
            System.out.println("You win!");
            playerWins++;
        } else {
            System.out.println("Computer wins!");
            computerWins++;
        }

        System.out.println();
    }
}