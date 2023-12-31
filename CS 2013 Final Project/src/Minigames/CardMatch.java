package Minigames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
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
	// data fields and structures
    private ArrayList<Character> randomLetters = new ArrayList<>();
    Map<Integer, Character> hashmap = new HashMap<>();
    private Node head;
    private Node lastRowHead;
    private int numRows;
    private int numCols;
    private int numGuesses = 0;
    private final int GUESS_LIMIT = 15; // a static guess limit that will not change
    // constructor 
    public CardMatch(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        fillArrayList();

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
    // methods
    private void fillArrayList() {
        this.randomLetters.add('A');
        this.randomLetters.add('B');
        this.randomLetters.add('C');

        this.randomLetters.add('A');
        this.randomLetters.add('B');
        this.randomLetters.add('C');

    }
    private void resetGridSpot(int row, int col) {
        Node gridLocation = this.head;

        for(int r = 1; r < row; r++) {
            gridLocation = gridLocation.nextRow;
        }
        for(int c = 1; c < col; c++) {
            gridLocation = gridLocation.nextCol;
        }
        // This method will reset the given grid location
        // on the board if the player fails to match the letter twice
        gridLocation.setCharacter('_');
    }
    private char getNodeChar(int row, int col) {
        Node gridLocation = this.head;

        for(int r = 1; r < row; r++) {
            gridLocation = gridLocation.nextRow;
        }
        for(int c = 1; c < col; c++) {
            gridLocation = gridLocation.nextCol;
        }

        return gridLocation.getCharacter();
    }
    public boolean play() {
        System.out.println("------------------------------------");
        System.out.println("| Title of Minigame: CARD MATCH! |");
        System.out.println("------------------------------------");
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("__DESCRIPTION__\n");
        System.out.println(" Welcome to Card Match! You will be given a set of letters (A-C),\n and the goal is to " +
                " match each letter in the set twice on the board.\n You are given 15 attempts, but don't let" +
                " that number fool you.\n This is an entirely luck-based game. Good luck, you'll need it...\n");

        System.out.println(" LETTERS: " + this.randomLetters + "\n");
        display();

        // keeps running until the player exceeds the guess limit
        while((numGuesses < GUESS_LIMIT && !allSpotsFilled()) && !this.randomLetters.isEmpty()) {
            try {
                // ============================FIRST INPUT==================================
                System.out.println("\n Number of guesses: " + numGuesses);
                // 1st input for letter
                System.out.print(" Pick a row: ");
                int rowChoice1 = input.nextInt();
                System.out.print(" Pick a column: ");
                int colChoice1 = input.nextInt();
                // an edge case to check if the player enters an out of bounds grid location
                if((rowChoice1 > this.numRows || rowChoice1 <= 0) || (colChoice1 > this.numCols || colChoice1 <= 0)) {
                    System.out.println("~~ Please enter a valid location on the grid! ~~");
                    display();
                    continue;
                }

                int numberOnBoard = rowAndColToNumberOnBoard(rowChoice1, colChoice1);
               
                
                if(isSpotOpen(rowChoice1, colChoice1)) {
                    // every time the placeMove() method is called the letter is removed from the arraylist  
                
                    placeMove(rowChoice1, colChoice1);
                    hashmap.put(numberOnBoard, getNodeChar(rowChoice1, colChoice1));
                    // put both the row and col into the hashmap so we know
                    // which spot has already been guessed and we can use that information
                    // to save the chosen character
                    
                    
                    System.out.println(" Key: " + hashmap);
                    System.out.println("\n LETTERS: " + this.randomLetters + "\n");

                    numGuesses++;
                    display();
                }
                else {
                    System.out.println("~~ Spot is already taken! Choose another location!~~");
                    System.out.println("\n LETTERS: " + this.randomLetters + "\n");
                    System.out.println();
                    continue;
                }
                // ============================SECOND INPUT====================================
                // 2nd input for letter to check if it matches the first input
                System.out.print("\n Pick a row: ");
                int rowChoice2 = input.nextInt();
                System.out.print(" Pick a column: ");
                int colChoice2 = input.nextInt();
                // an edge case to check if the player enters an out of bounds grid location
                if((rowChoice1 > this.numRows || rowChoice1 <= 0) || (colChoice1 > this.numCols || colChoice1 <= 0)) {
                    System.out.println("~~ Please enter a valid location on the grid! ~~");
                    display();
                    continue;
                }

                
                int numberOnBoard2 = rowAndColToNumberOnBoard(rowChoice2, colChoice2); // 1
                
                if(isSpotOpen(rowChoice2, colChoice2) ) {
                    // every time the placeMove() method is called the letter is removed from the arraylist
                	
                    placeMove(rowChoice2, colChoice2);
                    hashmap.put(numberOnBoard2, getNodeChar(rowChoice2, colChoice2));
                      
                    System.out.println(" Key: " + hashmap);
                    System.out.println("\n LETTERS: " + this.randomLetters + "\n");
                    // check if the previous letter and the latest letter match, if they do, then continue with the
                    // updated board filled with the letters
                    char letter1 = getNodeChar(rowChoice1, colChoice1);
                    char letter2 = getNodeChar(rowChoice2, colChoice2);

                    if(letter1 == letter2) {
                        display();
                        System.out.println("\n Correct! You have matched the letter!");
                    }
                    else {
                        display();
                        System.out.println("\n Nope! Not the same letter!");
                        // add the letters back so that the they don't get removed from the arraylist everytime
                        // the placeMove() method is called
                        this.randomLetters.add(letter1);
                        this.randomLetters.add(letter2);
                        System.out.println("\n LETTERS: " + this.randomLetters + "\n");
                        // reset the board back to the original board since the letters didn't match
                        resetGridSpot(rowChoice1, colChoice1);
                        resetGridSpot(rowChoice2, colChoice2);
                        display();
                    }
                }
                else {
                    /*
                     decrement the value so that the turn doesn't count if the player
                     chooses the same spot twice
                     */
                    numGuesses--;
                    System.out.println("~~ Spot is already taken! Choose another location! ~~");
                    this.randomLetters.add(getNodeChar(rowChoice1, colChoice1));
                    resetGridSpot(rowChoice1, colChoice1);
                    System.out.println("\n LETTERS: " + this.randomLetters + "\n");
                    //System.out.println();

                    display();
                    continue;
                }
                
                System.out.println(" Key: " + hashmap);

                // ================================================================
            }
            catch (InputMismatchException ime) {
                input.next();
                System.out.println(" Invalid operand. Try again: ");
            }
            catch (Exception e) {
                input.next();
                System.out.println(" Unexpected error.");
            }

        }
        // IF THE ARRAYLIST IS EMPTY, THAT MEANS THE PLAYER HAS GUESSED ALL THE LETTERS TWICE IN THE BOARD
        // AND HAVE BEEN REMOVED
        if(this.randomLetters.isEmpty()) {
            System.out.println(" Congratulations! You have matched all the letters!");
            return true;
        }
        else {
            System.out.println(" Better luck next time...");
        }

        return false;
    }
    private boolean allSpotsFilled() {
        Node currRow = this.head;

        while(currRow != null) {
            Node currCol = currRow;
            while(currCol != null) {
                if(currCol.getCharacter() == '_') {
                    return false;
                }
                currCol = currCol.nextCol;
            }
            currRow = currRow.nextRow;
        }
        return true;
    }
    private void placeMove(int row, int col) {
    	Node gridLocation = this.head;
    	
    	int numberOnBoard = rowAndColToNumberOnBoard(row, col);
   
        //Node gridLocation = this.head;

        for(int r = 1; r < row; r++) {
            gridLocation = gridLocation.nextRow;
        }
        for(int c = 1; c < col; c++) {
            gridLocation = gridLocation.nextCol;
        }
        
        if(hashmap.containsKey(numberOnBoard)) {
        	gridLocation.setCharacter(hashmap.get(numberOnBoard));
        	this.randomLetters.remove(hashmap.get(numberOnBoard));
        	return;
        }
         
        int randomCharIndex = (int)(Math.random() * this.randomLetters.size());
        gridLocation.setCharacter(this.randomLetters.get(randomCharIndex));
        this.randomLetters.remove(randomCharIndex);
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

    private int rowAndColToNumberOnBoard(int row, int col) {
    	
    	int numberOnBoard = 0;
    	
    	if(row == 1 && col == 1) {
    		numberOnBoard = 1;
    	}
    	else if(row == 1 && col == 2) {
    		numberOnBoard = 2;
    	}
    	else if(row == 1 && col == 3) {
    		numberOnBoard = 3;
    	}
    	else if(row == 2 && col == 1) {
    		numberOnBoard = 4;
    	}
    	else if(row == 2 && col == 2) {
    		numberOnBoard = 5;
    	}
    	else if(row == 2 && col == 3) {
    		numberOnBoard = 6;
    	}
    	else if(row == 3 && col == 1) {
    		numberOnBoard = 7;
    	}
    	else if(row == 3 && col == 2) {
    		numberOnBoard = 8;
    	}
    	else if(row == 3 && col == 3) {
    		numberOnBoard = 9;
    	}
    	else {
    		return 0;
    	}
    	
    	return numberOnBoard;	
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
            System.out.print(" |");
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
