package Minigames;


// Mini Game Made by: Shambhavi Bhandari & Rana Ashour
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    // Track the number of wins for the player and computer
    private static int playerWins = 0;
    private static int computerWins = 0;

    // Method to play the Rock, Paper, Scissors game
    public boolean play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------------------------------");

        // Display welcome and game rules
        System.out.println("Welcome to Rock, Paper, Scissors Game!");
        System.out.println("------------------------------------");
        System.out.println("You need to win 3 times to win the game. If the computer wins 3 times, you lose.");
        System.out.println("------------------------------------");

        // Game loop
        while (true) {
            System.out.println("Enter your move (Rock, Paper, Scissors) or 'exit' to end the game:");
            String playerMove = scanner.nextLine().toUpperCase();

            if (playerMove.equals("EXIT")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            // Validate the player's move
            if (!isValidMove(playerMove)) {
                System.out.println("Invalid move. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            // Generate computer's move
            String computerMove = generateComputerMove();
            System.out.println("Computer's move: " + computerMove);

            // Display moves and determine the winner
            displayMoves(playerMove, computerMove);
            determineWinner(playerMove, computerMove);

            // Display the current score
            System.out.println("Player Wins: " + playerWins + " | Computer Wins: " + computerWins);

            // Check for game end conditions
            if (playerWins >= 3) {
                System.out.println("Congratulations! You won the game!");
                return true;
            } else if (computerWins >= 3) {
                System.out.println("Sorry! Computer won the game. Better luck next time!");
                return false;
            }
        }
        scanner.close();

        return false; // This will never happen but needs to return to compile :D
    }

    // Check if the player's move is valid
    private static boolean isValidMove(String move) {
        // Use case-insensitive comparison to check if the move is valid
        return move.equalsIgnoreCase("ROCK") || move.equalsIgnoreCase("PAPER") || move.equalsIgnoreCase("SCISSORS");
    }


    // Generate a random move for the computer
    private static String generateComputerMove() {
        String[] moves = {"ROCK", "PAPER", "SCISSORS"};
        int index = new Random().nextInt(moves.length);
        return moves[index];
    }

    // Display the moves of the player and computer
    private static void displayMoves(String playerMove, String computerMove) {
        System.out.println("Player's move:");
        displayMoveArt(playerMove);

        System.out.println("Computer's move:");
        displayMoveArt(computerMove);

        System.out.println();
    }

    // Display ASCII art for a given move
    private static void displayMoveArt(String move) {
        switch (move) {
            case "ROCK":
                // ASCII art for Rock
                System.out.println("    _______");
                System.out.println("---'   ____)");
                System.out.println("      (_____)");
                System.out.println("      (_____)");
                System.out.println("      (____)");
                System.out.println("---.__(___)");
                break;
            case "PAPER":
                // ASCII art for Paper
                System.out.println("    _______ ");
                System.out.println("---'   ____)____");
                System.out.println("          ______)");
                System.out.println("          _______)");
                System.out.println("         _______)");
                System.out.println("---.__________)");
                break;
            case "SCISSORS":
                // ASCII art for Scissors
                System.out.println("    _______ ");
                System.out.println("---'   ____)____");
                System.out.println("          ______)");
                System.out.println("       __________)");
                System.out.println("      (____)");
                System.out.println("---.__(___)");
                break;
        }
    }

    // Determine the winner of the round
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