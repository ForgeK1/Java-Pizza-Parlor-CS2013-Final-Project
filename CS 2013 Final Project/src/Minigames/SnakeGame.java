package Minigames;

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

    public SnakeGame() {
        initializeGame();
    }

    public boolean play() {

        while (!isGameOver) {
            displayGame();
            getUserInput();
            updateGame();
        }

        System.out.println("Game Over!");
        return false;
    }

    private void initializeGame() {
        snake = new LinkedList<>();
        snake.add(new int[]{BOARD_WIDTH / 2, BOARD_HEIGHT / 2});
        spawnMeal();
    }

    private void getUserInput() {
        System.out.print("Enter move (WASD): ");
        String input = userInputScanner.nextLine().toUpperCase();
        if (input.equals("W") || input.equals("A") || input.equals("S") || input.equals("D")) {
            currentDirection = input;
        }
    }

    private void updateGame() {
        int[] newHead = Arrays.copyOf(snake.getFirst(), snake.getFirst().length);

        if ("W".equals(currentDirection)) {
            newHead[1]--;
        } else if ("A".equals(currentDirection)) {
            newHead[0]--;
        } else if ("S".equals(currentDirection)) {
            newHead[1]++;
        } else if ("D".equals(currentDirection)) {
            newHead[0]++;
        }

        if (checkCollision(newHead)) {
            isGameOver = true;
            return;
        }

        snake.addFirst(newHead);
        if (Arrays.equals(newHead, meal)) {
            eatFood();
            spawnMeal();
        } else {
            snake.removeLast();
        }

        if (applesEaten >= 3) { // Check for the win condition
            System.out.println("You won! You ate 3 apples!");
            isGameOver = true;
        }
    }

    private void displayGame() {
        for (int y = 0; y < BOARD_HEIGHT; y++) {
            for (int x = 0; x < BOARD_WIDTH; x++) {
                char cell = getCellContent(x, y);
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private char getCellContent(int x, int y) {
        if (x == 0 || x == BOARD_WIDTH - 1 || y == 0 || y == BOARD_HEIGHT - 1) {
            return '#';
        } else if (Arrays.equals(new int[]{x, y}, meal)) {
            return '*';
        } else if (contains(snake, new int[]{x, y})) {
            return 'O';
        } else {
            return ' ';
        }
    }

    private boolean checkCollision(int[] newHead) {
        return newHead[0] < 0 || newHead[1] < 0 || newHead[0] >= BOARD_WIDTH || newHead[1] >= BOARD_HEIGHT || contains(snake, newHead);
    }

    private void spawnMeal() {
        Random random = new Random();
        meal[0] = random.nextInt(BOARD_WIDTH - 2) + 1;
        meal[1] = random.nextInt(BOARD_HEIGHT - 2) + 1;
        if (contains(snake, meal)) {
            spawnMeal();
        }
    }

    private boolean contains(LinkedList<int[]> list, int[] item) {
        for (int[] element : list) {
            if (Arrays.equals(element, item)) {
                return true;
            }
        }
        return false;
    }

    private void eatFood() {
        applesEaten++;
    }
}
