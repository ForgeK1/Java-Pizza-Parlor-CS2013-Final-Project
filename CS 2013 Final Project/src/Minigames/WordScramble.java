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
      of letters each word has*/
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

//        initializeSetOfLetters(setOfLettersChooser);
        this.setOfLetters = "AERTS";

        //A method to initialize our HashMap setOfWords based on the setOfLetters chosen
        initializeSetOfWords();
    }

    //3) Methods

    public boolean play()
    {
        //A scanner to allow input for the player
        Scanner input = new Scanner(System.in);

        System.out.println("\n----------------------------------------");
        System.out.println("|  Title of Minigame:  WORD SCRAMBLE!  |");
        System.out.println("----------------------------------------");

        System.out.println("\n*INSERT PROMPT HERE*");

        //A while loop to print out table of words and prompt the player to input the correct words
        while(!this.setOfWords.isEmpty())
        {
            System.out.println("\n---------------------------");
            System.out.println("Set of letters given: " + this.setOfLetters);
            System.out.println("---------------------------");

            //A inner for loop to print out all of the words in the list
            for(int listIndex = 0; listIndex < this.setOfWordsArray.length; listIndex++)
            {
                String word = "";

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

            System.out.println("\n--> Total number of points: " + this.totalPoints);
            System.out.println("--> Number of lives: " + this.numLives);

            System.out.print("\nGuess a word given the letters!: ");
            String userInput = "#" + input.next().toUpperCase();

            if(this.setOfWords.containsKey(userInput))
            {
                this.totalPoints += this.setOfWords.get(userInput);

                this.setOfWords.remove(userInput, this.setOfWords.get(userInput));

                for(int i = 0; i < this.setOfWordsArray.length; i++)
                {
                    if(this.setOfWordsArray[i].equals(userInput))
                    {
                        System.out.println("This if statement runs");

                        this.setOfWordsArray[i] = userInput.substring(1);

                        break;
                    }
                }
            }
        }

        //Returning true indicates that we passed the minigame!
        return true;
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

            setOfWordsArray = new String[]{"#SET", "#RAT", "#EAR", "#ERA", "#REST",
                                           "#TEAR", "#SEAR", "#RATE", "#STARE", "#TEARS"};
        }
        else if(this.setOfLetters == "LOVES")
        {
            this.setOfWords.put("SOL", 5);
            this.setOfWords.put("VOLE", 5);
            this.setOfWords.put("LOVE", 5);
            this.setOfWords.put("SEL", 5);
            this.setOfWords.put("LOSE", 10);
            this.setOfWords.put("SOLE", 10);
            this.setOfWords.put("VOLE", 10);
            this.setOfWords.put("VOES", 10);
            this.setOfWords.put("LOVES", 20);
            this.setOfWords.put("SOLVE", 20);
        }
        else if(this.setOfLetters == "DRIVE")
        {
            this.setOfWords.put("DIE", 5);
            this.setOfWords.put("RED", 5);
            this.setOfWords.put("RID", 5);
            this.setOfWords.put("IRE", 5);
            this.setOfWords.put("DIRE", 10);
            this.setOfWords.put("RIDE", 10);
            this.setOfWords.put("RIVE", 10);
            this.setOfWords.put("DIVE", 10);
            this.setOfWords.put("DRIVE", 20);
            this.setOfWords.put("DIVER", 20);
        }
        else if(this.setOfLetters == "CATHE")
        {
            this.setOfWords.put("CAT", 5);
            this.setOfWords.put("HAT", 5);
            this.setOfWords.put("ACT", 5);
            this.setOfWords.put("THE", 5);
            this.setOfWords.put("HEAT", 10);
            this.setOfWords.put("ACHE", 10);
            this.setOfWords.put("EACH", 10);
            this.setOfWords.put("TECH", 10);
            this.setOfWords.put("TEACH", 20);
            this.setOfWords.put("CHEAT", 20);
        }
        else if(this.setOfLetters == "PLAYS")
        {
            this.setOfWords.put("LAP", 5);
            this.setOfWords.put("PAL", 5);
            this.setOfWords.put("SAY", 5);
            this.setOfWords.put("SPA", 5);
            this.setOfWords.put("PLAY", 10);
            this.setOfWords.put("SLAP", 10);
            this.setOfWords.put("SPAY", 10);
            this.setOfWords.put("SLAY", 10);
            this.setOfWords.put("PLAYS", 20);
            this.setOfWords.put("SALTY", 20);
        }
    }
}
