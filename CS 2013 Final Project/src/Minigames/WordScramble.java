package Minigames;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
    1) Class Name: WordScramble

    2) How will this class work?:
        The player is presented with a set of random letters (Ex. abdoc), and the player is prompted to write out
        as many words as possible using those letters (coda, cab, bad, dab, cod, etc.
            --> https://wordfinder.yourdictionary.com/unscramble/yeabhdo/?dictionary=US

        Programming wise, we would have 5 different set of random letters where each set conveys to a total
        of 10 words

    3) Class made by: Keyvan M. Kani & MD Islam

    4) Course: Java 2013 Programming with Data Structures
 */
public class WordScramble
{
    //1) Data Fields

    //A variable to choose what set of letters the player will receive that will help them come up with the words
    private String setOfLetters;

    /*Each set of letters will have up to 10 words where each word has a specific amount of points they could
      receive. They must receive 70 out of 100 points to pass the minigame:
        1) Word 1 (3 letters) -->    5 points
        2) Word 2 (3 letters) -->    5 points
        3) Word 3 (3 letters) -->    5 points
        4) Word 4 (3 letters) -->    5 points
        5) Word 5 (4 letters) -->   10 points
        6) Word 6 (4 letters) -->   10 points
        7) Word 7 (4 letters) -->   10 points
        8) Word 8 (4 letters) -->   10 points
        9) Word 9 (5 letters) -->   20 points
        10) Word 10 (5 letters) --> 20 points

    Note: The Hashmap key will store the word the player is trying to guess and the points will be stored as its value
          the player could win to add to their total amount of points.*/
    private HashMap<String, Integer> setOfWords = new HashMap<>();

    /*To loop through our list of words when printing it inside of the table we will show to the player,
      we need to copy the keys to an array that will help us keep the set of words in order by the amount
      of letters each word has.

      Note: A hashmap doesn't have its keys in sorted order when printed out so that is why we need to
            use an array to copy the keys and display them in the table we show the player*/
    String[] setOfWordsArray;

    //A variable to keep track of the player's total amount of points
    private int totalPoints;

    //A variable to keep track of the player's number of lives
    private int numLives;

    //2) Constructors

    //Default Constructor
    public WordScramble()
    {
        this.totalPoints = 0;
        this.numLives = 3;

        //A Random instance to help choose a random set of letters
        Random random = new Random();

        /*A randomizer variable and a method that will choose which set of letters the player will receive
          for the minigame:
            1 --> AERTS
            2 --> LOVES
            3 --> DRIVE
            4 --> CATHE
            5 --> PLAYS
        */
        int setOfLettersChooser = random.nextInt(1, 6);

        System.out.println(setOfLettersChooser);

        initializeSetOfLetters(setOfLettersChooser);

        //A method to initialize our HashMap setOfWords & setOfWordsArray based on the setOfLetters chosen
        initializeSetOfWords();
    }

    //3) Methods

    public boolean play()
    {
        //A scanner to allow input for the player
        Scanner input = new Scanner(System.in);

        //A boolean we return that will decide if the player wins the minigame or not
        boolean minigameDecision;

        System.out.println("\n----------------------------------------");
        System.out.println("|  Title of Minigame:  WORD SCRAMBLE!  |");
        System.out.println("----------------------------------------");

        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("__DESCRIPTION__");
        System.out.println("Welcome to Word Scramble! Get ready to exercise your word-making skills! \nYou'll be " +
                           "presented with a set of random letters, and your goal is to \ncreate 10 words for each " +
                           "set using only those letters. Be cautious, \nthough! You have 3 lives and for every word " +
                           "you guess that isn't on the \nlist you'll lose a life.");

        System.out.println("\nBut here's the twist: for every word you correctly guess from the \nprovided letters, " +
                           "you'll earn points that will add to  your total \nscore. The longer the word, the more " +
                           "points you'll receive *so you \nhave to acheive at least 50 points to win the game*.");

        System.out.println("\n__EXAMPLE__");
        System.out.println("1) Word 1 (3 letters) -->    5 points\n" +
                           "2) Word 2 (3 letters) -->    5 points\n" +
                           "3) Word 3 (3 letters) -->    5 points\n" +
                           "4) Word 4 (3 letters) -->    5 points\n" +
                           "5) Word 5 (4 letters) -->   10 points\n" +
                           "6) Word 6 (4 letters) -->   10 points\n" +
                           "7) Word 7 (4 letters) -->   10 points\n" +
                           "8) Word 8 (4 letters) -->   10 points\n" +
                           "9) Word 9 (5 letters) -->   20 points\n" +
                           "10) Word 10 (5 letters) --> 20 points");

        System.out.println("\nNote that, running out of lives doesn't mean you lose the game. It just \nmeans you " +
                           "out of chances to guess a word from the list. With that being \nsaid, good luck! " +
                           "[]~(￣▽￣)~*");
        System.out.println("------------------------------------------------------------------------");

        //A while loop to print out table of words and prompt the player to input the correct words
        while(!this.setOfWords.isEmpty())
        {
            /*We print out a table of words given the set of letters for every time the player tries
              to guess a word. Most words are filled with "#", but as soon as they guess a word, the
              actual word is revealed*/
            printTable();

            //Shows the player their total # of points and their # of lives
            System.out.println("\n--> Total number of points: " + this.totalPoints);
            System.out.println("--> Number of lives: " + this.numLives);

            //Prompts the player to guess a word
            System.out.print("\nGuess a word given the letters!: ");
            String userInput = "#" + input.next().toUpperCase();

            /*An if statement that checks if the player guessed the correct word from the list.
                If so --> We add the amount of points the word was worth to our total # of points, remove the word
                          from our HashMap setOfWords list since we don't need it anymore, and remove the "#" at the
                          beginning of our word in the setOfWords array so that the word is visible to the player in
                          the printed table.

                else -->  We prompt the player that the word they guessed was not in the list & remove a point in
                          their number of lives.*/
            if(this.setOfWords.containsKey(userInput))
            {
                this.totalPoints += this.setOfWords.get(userInput);

                this.setOfWords.remove(userInput, this.setOfWords.get(userInput));

                for(int i = 0; i < this.setOfWordsArray.length; i++)
                {
                    if(this.setOfWordsArray[i].equals(userInput))
                    {
                        //Debug code
                            //System.out.println("This if statement runs");

                        this.setOfWordsArray[i] = userInput.substring(1);

                        break;
                    }
                }

                System.out.println("\n------------------------------------------------------------------------------");
                System.out.println("Good job on guessing the correct word! Keep going to guess the rest ( •̀ ω •́ )✧");
                System.out.println("------------------------------------------------------------------------------");
            }
            else
            {
                System.out.println("\n------------------------------------------------------------------------------");
                System.out.println("Woah! The word you tried to guess is not on the list or has already been " +
                                   "\nfound! You have been deducted a life from your number of lives. >:(");
                System.out.println("------------------------------------------------------------------------------");

                this.numLives--;
            }

            /*An if statement that checks if the player is at 0 lives. If so, we break out of the while loop and
              prompt them that they cannot guess anymore words*/
            if(this.numLives == 0)
            {
                System.out.println("\n------------------------------------------------------------------------------");
                System.out.println("ATTENTION!: You have lost all of your lives! You don't have anymore chances to " +
                                   "\nguess, so let's hope you have enough points to win the minigame. O_O");
                System.out.println("------------------------------------------------------------------------------");

                break;
            }
        }

        //We print the table one last time to show all the words the player was able to guess
        printTable();

        String minigameDecisionString = "";

        if(totalPoints >= 50)
        {
            minigameDecisionString = "you won the minigame!!! ヾ(≧▽≦*)o";

            minigameDecision = true;
        }
        else
        {
            minigameDecisionString = "you lost the minigame. ┌( ´_ゝ` )┐";

            minigameDecision = false;
        }

        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println("Now that you have guessed the words to the best of your ability, your total " +
                           "\npoints is: " + this.totalPoints + "/100. Which means... " + minigameDecisionString);
        System.out.println("------------------------------------------------------------------------------");


        //Returning true indicates that we passed the minigame!
        return minigameDecision;
    }

    //A method to choose the set of letters for the player based on the random number given in the constructor
    public void initializeSetOfLetters(int setOfLettersChooser)
    {
        switch(setOfLettersChooser)
        {
            case 1: this.setOfLetters = "AERTS"; break;
            case 2: this.setOfLetters = "LOVES"; break;
            case 3: this.setOfLetters = "DRIVE"; break;
            case 4: this.setOfLetters = "CATHE"; break;
            case 5: this.setOfLetters = "PLAYS"; break;
            default: System.out.println("Something went wrong with the setOfLettersChooser variable");
        }
    }

    //A method to choose the set of words the player has to guess based on the set of letters given
    public void initializeSetOfWords()
    {
        if(this.setOfLetters == "AERTS")
        {
            this.setOfWords.put("#SET", 5);
            this.setOfWords.put("#RAT", 5);
            this.setOfWords.put("#EAR", 5);
            this.setOfWords.put("#ERA", 5);
            this.setOfWords.put("#REST", 10);
            this.setOfWords.put("#TEAR", 10);
            this.setOfWords.put("#SEAR", 10);
            this.setOfWords.put("#RATE", 10);
            this.setOfWords.put("#STARE", 20);
            this.setOfWords.put("#TEARS", 20);

            this.setOfWordsArray = new String[]{"#SET", "#RAT", "#EAR", "#ERA", "#REST",
                                                "#TEAR", "#SEAR", "#RATE", "#STARE", "#TEARS"};
        }
        else if(this.setOfLetters == "LOVES")
        {
            this.setOfWords.put("#SOL", 5);
            this.setOfWords.put("#VOLE", 5);
            this.setOfWords.put("#LOVE", 5);
            this.setOfWords.put("#SEL", 5);
            this.setOfWords.put("#LOSE", 10);
            this.setOfWords.put("#SOLE", 10);
            this.setOfWords.put("#VOLE", 10);
            this.setOfWords.put("#VOES", 10);
            this.setOfWords.put("#LOVES", 20);
            this.setOfWords.put("#SOLVE", 20);

            this.setOfWordsArray = new String[]{"#SOL", "#VOLE", "#LOVE", "#SEL", "#LOSE",
                                                "#SOLE", "#VOLE", "#VOES", "#LOVES", "#SOLVE"};
        }
        else if(this.setOfLetters == "DRIVE")
        {
            this.setOfWords.put("#DIE", 5);
            this.setOfWords.put("#RED", 5);
            this.setOfWords.put("#RID", 5);
            this.setOfWords.put("#IRE", 5);
            this.setOfWords.put("#DIRE", 10);
            this.setOfWords.put("#RIDE", 10);
            this.setOfWords.put("#RIVE", 10);
            this.setOfWords.put("#DIVE", 10);
            this.setOfWords.put("#DRIVE", 20);
            this.setOfWords.put("#DIVER", 20);

            this.setOfWordsArray = new String[]{"#DIE", "#RED", "#RID", "#IRE", "#DIRE",
                                                "#RIDE", "#RIVE", "#DIVE", "#DRIVE", "#DIVER"};
        }
        else if(this.setOfLetters == "CATHE")
        {
            this.setOfWords.put("#CAT", 5);
            this.setOfWords.put("#HAT", 5);
            this.setOfWords.put("#ACT", 5);
            this.setOfWords.put("#ATE", 5);
            this.setOfWords.put("#HEAT", 10);
            this.setOfWords.put("#ACHE", 10);
            this.setOfWords.put("#EACH", 10);
            this.setOfWords.put("#TECH", 10);
            this.setOfWords.put("#TEACH", 20);
            this.setOfWords.put("#CHEAT", 20);

            this.setOfWordsArray = new String[]{"#CAT", "#HAT", "#ACT", "#THE", "#HEAT",
                                                "#ACHE", "#EACH", "#TECH", "#TEACH", "#CHEAT"};
        }
        else if(this.setOfLetters == "PLAYS")
        {
            this.setOfWords.put("#LAP", 5);
            this.setOfWords.put("#PAL", 5);
            this.setOfWords.put("#SAY", 5);
            this.setOfWords.put("#SPA", 5);
            this.setOfWords.put("#PLAY", 10);
            this.setOfWords.put("#SLAP", 10);
            this.setOfWords.put("#SPAY", 10);
            this.setOfWords.put("#SLAY", 10);
            this.setOfWords.put("#PLAYS", 20);
            this.setOfWords.put("#SALTY", 20);

            this.setOfWordsArray = new String[]{"#LAP", "#PAL", "#SAY", "#SPA", "#PLAY",
                                                "#SLAP", "#SPAY", "#SLAY", "#PLAYS", "#SALTY"};
        }
    }

    //A method to print the entire list of words
    public void printTable()
    {
        System.out.println("\n---------------------------");
        System.out.println("Set of letters given: " + this.setOfLetters);
        System.out.println("---------------------------");

        //A inner for loop to print out all of the words in the list
        for(int listIndex = 0; listIndex < this.setOfWordsArray.length; listIndex++)
        {
            String word = "";

            /*All keys in the HashMap & in the setOfWords array start with "#" because, when we print out the table
            of words to the player, we need to check if the word has been guessed or not.

            If the word has not been guessed, then the current word we are looking at in the loop will have a "#" in
            the beginning of the word (as indicated by the if statement below).

            If it doesn't, then we would be able to print out the word itself (as indicated by the else statement
            below).*/
            if(this.setOfWordsArray[listIndex].contains("#"))
            {
                for(int wordIndex = 1; wordIndex < this.setOfWordsArray[listIndex].length(); wordIndex++)
                {
                    word += "#";
                }

                System.out.println((listIndex + 1) + ") " + word);
            }
            else
            {
                System.out.println((listIndex + 1) + ") " + this.setOfWordsArray[listIndex]);
            }
        }
    }
}
