package Minigames;

import java.util.Scanner;

/*
    1) Class Name: WordScrambleTestClass

    2) How will this class work?:
        This serves as a tester class to test the methods from the Word Scramble minigame

    3) Class made by: Keyvan M. Kani

    4) Course: Java 2013 Programming with Data Structures
 */
public class WorldScrambleTestClass
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        WordScramble wordScramble = new WordScramble();

        wordScramble.play();
    }
}
