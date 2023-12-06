package Minigames;
/*
    1) Class Name: Node

    2) How will this class work?:
        - A Node will represent a cell on the board that is created when instantiating the CardMatch class.
          The Node class will have getters and setters for letter manipulations and random letter shuffling.

    3) Class made by: Md R. Islam

    4) Course: Java 2013 Programming with Data Structures
 */
public class Node {
    private char character;
    public Node nextRow;
    public Node nextCol;
    public Node() {

    }
    public Node(char character) {
        this.character = character;
    }
    public char getCharacter() {
        return character;
    }
    public void setCharacter(char character) {
        this.character = character;
    }
}
