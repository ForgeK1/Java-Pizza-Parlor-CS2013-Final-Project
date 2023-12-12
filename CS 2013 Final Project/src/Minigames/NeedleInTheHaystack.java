package Minigames;
import java.util.ArrayList;
import java.util.Scanner;

/*A minigame where you have to find a specific letter
 by putting in which index that letter is
in. After finding several correct letters, you
will spell out a word.
All words to spell out (5 letter words):
"pizza" "bread" "sauce" "bacon"
*/
public class NeedleInTheHaystack {

    private int numTry;
    private final ArrayList<String> words;
    String word = "";

    public NeedleInTheHaystack() {
        this.words = new ArrayList<>();
        this.words.add(0, "pizza");
        this.words.add(1,"bread");
        this.words.add(2,"sauce");
        this.words.add(3,"bacon");

    }

    //grabs a word
    public String getWordRandomizer() {
        int randomNum =(int) ((Math.random() * 4));
        this.word = this.words.get(randomNum);

        return this.word;
    }
    public String getWord() {
        return this.word;
    }

    //sends a set of random letters
    public String letterScrambler(int numLetters, char goldenLetter) {
        String letters = "";
        boolean letterIsGolden = false;

        while(!letterIsGolden) {
            letters = "";
            for (int i = 0; i < numLetters; i++) {
                char letter = (char) ((Math.random() * 26) + 97);
                letters += letter;
                if (goldenLetter == letter) {
                    letterIsGolden = true;
                }
            }
        }

        return letters;
    }

    public int goldenLetterIndex(String scrambledLetters, char goldenLetter) {
//        String lesserScrambledLetters;
        for(int i = 0; i < scrambledLetters.length(); i++) {
//            lesserScrambledLetters = "";
//            for(int j = 1; j < scrambledLetters.length(); j++) {
//                lesserScrambledLetters += scrambledLetters.charAt(j);
//            }

            if(scrambledLetters.charAt(i) == goldenLetter) {
//                goldenLetterIndex(lesserScrambledLetters, goldenLetter);
                return i;
            }
        }

        return -1; //shouldn't return -1
    }



    //boolean
    public boolean play() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n-------------------------- \n" +
                "|"  + "\u001B[34m"  + "Needle in the Haystack" + "\u001B[0m" + "|\n"+
                "--------------------------");

        getWordRandomizer();

        String goldenWord = getWord();
        String scrmblLets = letterScrambler(5, goldenWord.charAt(0) );

        int x = -1;
        int tries = 3;

        while(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(0) ) ) ) {
            System.out.println("Spell out the word: " + "\u001B[36m" + goldenWord + "\u001B[0m" + "\n" +
                    "Tries remaining: " + "\u001B[31m" + tries + "\u001B[0m" + "\n" +
                    "Round one: Find the letter " + "\u001B[33m" + goldenWord.charAt(0) + "\u001b[0m");
            System.out.println("        ~  " + scrmblLets + "  ~");
            System.out.println("Which index does the letter " + "\u001B[33m" + goldenWord.charAt(0) + "\u001b[0m" +
                    " first appear in?");
            x = input.nextInt();

            if(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(0) ) )) {
                System.out.println("Wrong, try again. \n");
                tries--;
            }
            if(tries == 0) {
                System.out.println("\u001B[31m" + "Bwomp, no more tries. GAME OVER!" + "\u001B[0m");
                input.close();
                return false;
            }

        }

        System.out.println("\u001B[35m" + "Great job! Now onto the second round! Each round will become harder." + "\n" +
                "\u001B[0m");

        x = -1;
        scrmblLets = letterScrambler(7, goldenWord.charAt(1) );
        while(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(1) ) ) ) {
            System.out.println("Spell out the word: " + "\u001B[36m" + goldenWord + "\u001B[0m" + "\n" +
                    "Tries remaining: " + "\u001B[31m" + tries + "\u001B[0m" + "\n" +
                    "Round two: Find the letter " + "\u001B[33m" + goldenWord.charAt(1) + "\u001b[0m");
            System.out.println("     ~  " + scrmblLets + "  ~");
            System.out.println("Which index does the letter " + "\u001B[33m" + goldenWord.charAt(1) + "\u001b[0m" +
                    " first appear in?");
            x = input.nextInt();

            if(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(1) ) )) {
                System.out.println("Wrong, try again. \n");
                tries--;
            }
            if(tries == 0) {
                System.out.println("\u001B[31m" + "*Loud wrong buzzer sound effect* Ran out of tries. GAME OVER!" +
                        "\u001B[0m");
                input.close();
                return false;
            }

        }

        System.out.println("\u001B[35m" + "Great job! Third round round get even tougher." + "\n" + "\u001B[0m");

        x = -1;
        scrmblLets = letterScrambler(10, goldenWord.charAt(2) );
        while(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(2) ) ) ) {
            System.out.println("Spell out the word: " + "\u001B[36m" + goldenWord + "\u001B[0m" + "\n" +
                    "Tries remaining: " + "\u001B[31m" + tries + "\u001B[0m" + "\n" +
                    "Round three: Find the letter " + "\u001B[33m" + goldenWord.charAt(2) + "\u001b[0m");
            System.out.println("     ~  " + scrmblLets + "  ~");
            System.out.println("Which index does the letter " + "\u001B[33m" + goldenWord.charAt(2) + "\u001b[0m" +
                    " first appear in?");
            x = input.nextInt();

            if(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(2) ) )) {
                System.out.println("Wrong, try again. \n");
                tries--;
            }
            if(tries == 0) {
                System.out.println("\u001B[31m" + "Oh would you look at your tries. It's all gone. GAME OVER!" +
                        "\u001B[0m");
                input.close();
                return false;
            }

        }

        System.out.println("\u001B[35m" + "Great job! Fourth round won't go easy on you." + "\n" + "\u001B[0m");

        x = -1;
        scrmblLets = letterScrambler(13, goldenWord.charAt(3) );
        while(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(3) ) ) ) {
            System.out.println("Spell out the word: " + "\u001B[36m" + goldenWord + "\u001B[0m" + "\n" +
                    "Tries remaining: " + "\u001B[31m" + tries + "\u001B[0m" + "\n" +
                    "Round four: Find the letter " + "\u001B[33m" + goldenWord.charAt(3) + "\u001b[0m");
            System.out.println(" ~  " + scrmblLets + "  ~");
            System.out.println("Which index does the letter " + "\u001B[33m" + goldenWord.charAt(3) + "\u001b[0m" +
                    " first appear in?");
            x = input.nextInt();

            if(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(3) ) )) {
                System.out.println("Wrong, try again. \n");
                tries--;
            }
            if(tries == 0) {
                System.out.println("\u001B[31m" + "Getting harder to keep your tries huh? GAME OVER!" + "\u001B[0m");
                input.close();
                return false;
            }

        }

        System.out.println("\u001B[35m" + "Great job! Final round! It would be a shame if you messed up now." + "\n" +
                "\u001B[0m");

        x = -1;
        scrmblLets = letterScrambler(15, goldenWord.charAt(4) );
        while(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(4) ) ) ) {
            System.out.println("Spell out the word: " + "\u001B[36m" + goldenWord + "\u001B[0m" + "\n" +
                    "Tries remaining: " + "\u001B[31m" + tries + "\u001B[0m" + "\n" +
                    "Final round: Find the letter " + "\u001B[33m" + goldenWord.charAt(4) + "\u001b[0m");
            System.out.println("~  " + scrmblLets + "  ~");
            System.out.println("Which index does the letter " + "\u001B[33m" + goldenWord.charAt(4) + "\u001b[0m" +
                    " first appear in?");
            x = input.nextInt();

            if(!(x ==  goldenLetterIndex(scrmblLets, goldenWord.charAt(4) ) )) {
                System.out.println("Wrong, try again. \n");
                tries--;
            }
            if(tries == 0) {
                System.out.println("\u001B[31m" + "Lost all your tries right at the end. GAME OVER!" + "\u001B[0m");
                input.close();
                return false;
            }

        }

        if(tries == 3) {
            System.out.println("\u001B[35m" + "PERFECT!");
        }
        System.out.println("\u001B[35m" + "Congratulations, you beat the Needle in the Haystack!" + "\u001B[0m" + "\n");



        input.close();
        return true;
    }











}
