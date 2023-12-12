package Minigames;


// Mini Game Made by: Shambhavi Bhandari & Rana Ashour
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 10;
    private LinkedList<int[]> snake;
    private int[] meal = new int[2];
    private String currentDirection = "R";
    private boolean isGameOver = false;
    private int applesEaten = 0; // New variable to track apples eaten
    private final Scanner userInputScanner = new Scanner(System.in);

    // Constructor to initialize the game
    // Constructor to initialize the game

    // Main game loop
    // Main game loop
    public boolean play() {
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("Welcome to the Snake Game! Win 3 apples without colliding with yourself or the walls to win the game!");

        initializeGame(); // Moved initialization to play method

        while (!isGameOver) {
            displayGame();
            getUserInput();
            updateGame();
        }

        // the updateGame() method can return true if the player has either won or has collided with itself or the wall.
        // We know the player has won if they collected 3 apples AND the updateGame() method returns true.
        // Without the second conditon, the method will return true, but the player may have lost by colliding
        // with itself or the wall.
        if (updateGame() && applesEaten >= 3) {
            System.out.println("Hooray! You have collected three apples!");
            return true;
        } else {
            System.out.println("Game Over! You lost.");
        }

        return false;
    }

    // Initialize the game state
    private void initializeGame() {
        snake = new LinkedList<>();
        snake.add(new int[]{BOARD_WIDTH / 2, BOARD_HEIGHT / 2});
        spawnMeal();
    }

    // Get user input for the snake's movement direction
    private void getUserInput() {
        System.out.print("Enter move (WASD): ");
        String input = userInputScanner.nextLine().toUpperCase();
        if (input.equals("W") || input.equals("A") || input.equals("S") || input.equals("D")) {
            currentDirection = input;
        }
    }

    // Update the game state based on user input and current conditions
    private boolean updateGame() {

            int[] newHead = Arrays.copyOf(snake.getFirst(), snake.getFirst().length);

            // Update the new head position based on the current direction
            if ("W".equals(currentDirection)) {
                newHead[1]--;
            } else if ("A".equals(currentDirection)) {
                newHead[0]--;
            } else if ("S".equals(currentDirection)) {
                newHead[1]++;
            } else if ("D".equals(currentDirection)) {
                newHead[0]++;
            }

            // Check for collisions with walls or the snake itself
            if (checkCollision(newHead)) {
                isGameOver = true;
                return isGameOver;
            }

            // Update the snake's position
            snake.addFirst(newHead);

            // Check if the snake has eaten the meal
            if (Arrays.equals(newHead, meal)) {
                eatFood();
                spawnMeal();
            } else {
                snake.removeLast();
            }

            // Check for the win condition
            if (applesEaten >= 3) {
//                System.out.println("You won! You ate 3 apples!");
                isGameOver = true;
                return isGameOver;
            }
            return false;
        }

        // Display the current state of the game
        private void displayGame () {
            for (int y = 0; y < BOARD_HEIGHT; y++) {
                for (int x = 0; x < BOARD_WIDTH; x++) {
                    char cell = getCellContent(x, y);
                    System.out.print(cell);
                }
                System.out.println();
            }
        }

        // Get the content of a cell based on its position
        private char getCellContent ( int x, int y){
            if (x == 0 || x == BOARD_WIDTH - 1 || y == 0 || y == BOARD_HEIGHT - 1) {
                return '#'; // Wall
            } else if (Arrays.equals(new int[]{x, y}, meal)) {
                return '*'; // Meal
            } else if (contains(snake, new int[]{x, y})) {
                return 'O'; // Snake body
            } else {
                return ' '; // Empty space
            }
        }

        // Check for collisions with walls or the snake itself
        private boolean checkCollision ( int[] newHead){
            return newHead[0] < 0 || newHead[1] < 0 || newHead[0] >= BOARD_WIDTH || newHead[1] >= BOARD_HEIGHT || contains(snake, newHead);
        }

        // Spawn a new meal at a random position
        private void spawnMeal () {
            Random random = new Random();
            meal[0] = random.nextInt(BOARD_WIDTH - 2) + 1;
            meal[1] = random.nextInt(BOARD_HEIGHT - 2) + 1;
            if (contains(snake, meal)) {
                spawnMeal();
            }
        }

        // Check if a list contains a specific item
        private boolean contains (LinkedList < int[]>list,int[] item){
            for (int[] element : list) {
                if (Arrays.equals(element, item)) {
                    return true;
                }
            }
            return false;
        }

        // Increment the count of apples eaten
        private void eatFood () {
            applesEaten++;
        }
    }