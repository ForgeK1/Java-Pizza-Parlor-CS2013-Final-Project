package Minigames;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
    1) Class Name: Card Match

    2) How will this class work?:
        - This class will work mainly with the interactions defined by the player. For example, the player will have the choice to
          create a board of their size and dimensions. Once created, the user must select a spot on the board and will see a random letter.
          To win, the player must match all the shown letters at least twice in the board to win the game.
          The player will lose the minigame if they run out of "lives", which can happen if they failed to match the letter.
          This class uses another class called "Node" - representing each cell on the board.
          The class board is implemented in the background using a 2D LinkedList with a head reference.

    3) Class made by: Md R. Islam

    4) Course: Java 2013 Programming with Data Structures
 */
public class CardMatch {
    Scanner input = new Scanner(System.in);

    // contains each character twice in the array
    private char[] randomCharacters = {'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H',
            'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H'};
    private Node head;
    private Node lastRowHead;
    private int numRows;
    private int numCols;
    private int numGuesses = 0;
    private final int GUESS_LIMIT = 15; // a static guess limit that will not change

    public CardMatch(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;

        this.head = new Node('_');
        this.lastRowHead = this.head;
        Node currForFirstRow = this.head;

        // Create the singly linked list for the first row
        for(int cols = 1; cols < numCols; cols++) {
            currForFirstRow.nextCol = new Node('_');
            currForFirstRow = currForFirstRow.nextCol;
        }
        // create the rest of the linked list rows for the board
        for(int rows = 1; rows < numRows; rows++) {
            addLastRow();
            this.numRows--;
        }

    }
    public void play() {
        // keeps running until the player exceeds the guess limit
        while(numGuesses < GUESS_LIMIT) {
            try {
                System.out.print("Pick a row: ");
                int rowChoice = input.nextInt();
                System.out.print("Pick a column: ");
                int colChoice = input.nextInt();

                if((rowChoice > this.numRows || rowChoice <= 0) || (colChoice > this.numCols || colChoice <= 0)) {
                    System.out.println("~~ Please enter a valid location on the grid! ~~");
                    continue;
                }

                if(isSpotOpen(rowChoice, colChoice)) {
                    placeMove(rowChoice, colChoice);
                    numGuesses++;
                    display();
                }
                else {
                    System.out.println("~~ Spot is already taken! ~~");
                    System.out.println();
                }
            }
            catch (InputMismatchException ime) {
                input.next();
                System.out.println("Invalid operand. Try again: ");
            }
            catch (Exception e) {
                input.next();
                System.out.println("Unexpected error.");
            }

        }
    }
    private void placeMove(int row, int col) {
        Node gridLocation = this.head;

        for(int r = 1; r < row; r++) {
            gridLocation = gridLocation.nextRow;
        }
        for(int c = 1; c < col; c++) {
            gridLocation = gridLocation.nextCol;
        }
        int randomCharIndex = (int)(Math.random() * this.randomCharacters.length);
        gridLocation.setCharacter(this.randomCharacters[randomCharIndex]);
    }
    private void addLastRow() {
        if(this.numRows == 0) {
            this.head = new Node('_');
            this.numRows = 1;
            this.numCols = 1;
        }
        else {
            Node newRow = createRow();
            zipRows(this.lastRowHead, newRow);
            this.lastRowHead = newRow;
            this.numRows++;
        }
    }
    private Node createRow() {
        Node head = new Node('_');
        Node curr = head;
        for(int col = 1; col < this.numCols; col++) {
            curr.nextCol = new Node('_');
            curr = curr.nextCol;
        }
        return head;
    }
    private void zipRows(Node top, Node bottom) {
        for(int i = 0; i < this.numCols; i++) {
            top.nextRow = bottom;
            bottom = bottom.nextCol;
            top = top.nextCol;
        }
    }
    private boolean isSpotOpen(int row, int col) {
        Node gridLocation = this.head;

        for(int r = 1; r < row; r++) {
            gridLocation = gridLocation.nextRow;
        }
        for(int c = 1; c < col; c++) {
            gridLocation = gridLocation.nextCol;
        }

        if(gridLocation.getCharacter() == '_') {
            return true;
        }
        return false;
    }

    public void display() {
        if(this.head == null) {
            System.out.println("This instance of Card Match is empty.");
            return;
        }

        Node currRow = this.head;
        //System.out.println(" + -- -- -- -- -- -- +");
        while(currRow != null) {
            Node currCol = currRow;
            System.out.print("|");
            while(currCol != null) {
                System.out.printf("%5s ", currCol.getCharacter());
                currCol = currCol.nextCol;
            }
            System.out.print("   |");
            System.out.println();
            currRow = currRow.nextRow;
        }
        //System.out.println(" + -- -- -- -- -- -- +");
    }

}
