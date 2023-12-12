import Minigames.*;

import java.util.Scanner;

/*
    1) Class Name: PizzaParlorGameSkeleoton

    2) How will this class work?:
        This will be the skeleton (Draft) of our official game that will be use the minigame classes
        we made and the overall sequence of events the player will experience

    3) Class made by: Keyvan M. Kani & MD Islam

    4) Course: Java 2013 Programming with Data Structures
 */
public class PizzaParlorGameSkeleton
{
    //A main class to run our game
    public static void main(String[] args)
    {
        //A scanner variable to use to wait for user input
        Scanner input = new Scanner(System.in);

        //A section to keep our minigame instances
        TicTacToe minigame1 = new TicTacToe(); // Md
        HungryCustomers minigame2 = new HungryCustomers(); // Keyvan
        CardMatch minigame3 = new CardMatch(3, 3); // Md
        WordScramble minigame4 = new WordScramble(); // Keyvan
        SnakeGame minigame5 = new SnakeGame(); //Shambhavi and Rana
        RockPaperScissors minigame6 = new RockPaperScissors(); //Shambhavi and Rana
        NeedleInTheHaystack minigame7 = new NeedleInTheHaystack(); //Jackson

        /*An array to keep track of the number of pizzas created by player. The size of the array will be 6
          and we will initialize all of the slots to 0. If the player completes a minigame for a specific slice,
          then we convert that slot to 1.
            Index 0 --> Cheese Pizza Slice
            Index 1 --> Meat Lovers Pizza Slice
            Index 2 --> Mushroom Pizza Slice
            Index 3 --> Olive Pizza Slice
            Index 4 --> Pineapple Pizza Slice
            Index 5 --> Margherita Pizza Slice (tomato)
            Index 6 --> Pepperoni Pizza Slice
        */
        int[] numPizzaSlicesMade = {0, 0, 0, 0, 0, 0, 0};

        //ASCII art of the title of the game
        asciiTitleOfGame();

        //An ASCII art showcasing a pizza parlor kitchen and a person standing next to a pizza-making station
        asciiKitchen();

        System.out.println("\n__DESCRIPTION OF THE GAME__");
        System.out.println("Welcome to the Pizza Parlor! You've been chosen by your renowned pizza parlor co-owner to " +
                           "embark on a unique \nculinary adventure. Your mission? Craft the ultimate pizza " +
                           "masterpiece comprising six distinct slices, each from a \ntreasured recipe handed down " +
                           "by your co-owner. As you assemble each slice, delve into the intertwined tales that " +
                           "\nunfold with every completed portion. Get ready to savor not just the flavors but the " +
                           "stories behind them. \nAre you ready to begin your delicious journey?");

        System.out.println("\n__HOW TO PLAY__");
        System.out.println("Prepare yourself for a challenge! To create the ultimate pizza, you'll face six unique " +
                           "mini-games, each \nrepresenting a different slice of the pie. Successfully conquering a " +
                           "mini-game means mastering the recipe for \nthat particular pizza slice and unlocking a " +
                           "captivating mini-story. Your ultimate objective? Triumph over all \nsix mini-games to " +
                           "gather and piece together each mini-story, revealing a connected narrative that unfolds " +
                           "as \nyou craft the perfect pizza. Get ready to game, cook, and uncover the tales behind " +
                           "the flavors!");

        //Utilizing a scanner variable for the user to prompt the player to start the game
        System.out.print("\nInput any letter to begin: ");
        input.next().charAt(0);

        //A for loop to play 6 minigames and showcase each mini-story in sequence
        for(int miniStory = 0; miniStory < 7; miniStory++)
        {
            //System.out.println("\n--Loop ran--\n");

            /*Every minigame .play() method will return a True or False boolean value. So, we will keep track of
              that value, and we know that the player won the minigame if we receive a True value and vice-versa*/
            boolean minigamePassed = playMinigame(miniStory, minigame1, minigame2, minigame3,
                                                             minigame4, minigame5, minigame6,
                                                             minigame7);

            //An if statement that checks if the player passed the minigame
            if(minigamePassed)
            {
                showcaseMiniStory(miniStory);

                //Converts pizza slot from 0 to 1 to indicate the pizza slice was created
                numPizzaSlicesMade[miniStory] = 1;
            }
            else
            {
                //TO-DO CODE FOR MD ISLAM

                /*Notes: Tell the player that they failed the minigame and did not make the intended pizza slice
                         --> They move on to making the next pizza slice. If its the last iteration, let them
                             know that this was their last pizza making session.*/
                System.out.println("\nSadly, you have lost this minigame and didn't make the intended pizza " +
                                   "slice :(\n");
            }

            if(miniStory != 6)
            {
                System.out.print("Input any letter to continue: ");
                String userInput = input.next();
            }
        }

        /*A method that will congradulate the player on finishing the game, let them know the amount of
          pizza slices made, and ASCII art of a pizza tray showing the pizza slices they made altogether*/
        endOfGame(numPizzaSlicesMade);
    }

    //----HELPER METHODS---- (This section is where helper methods will be stored)

    /*A helper method that contains switch statement to return a boolean value from the intended
      minigame played*/
    public static boolean playMinigame(int miniStory,
                                       TicTacToe minigame1, HungryCustomers minigame2,
                                       CardMatch minigame3, WordScramble minigame4,
                                       SnakeGame minigame5, RockPaperScissors minigame6,
                                       NeedleInTheHaystack minigame7)
    {
        //A switch statement to assign a boolean value from the intended minigame
        switch(miniStory)
        {
            case 0:
                return minigame1.play();
            case 1:
                return minigame2.play();
            case 2:
                return minigame3.play();
            case 3:
                return minigame4.play();
            case 4:
                return minigame5.play();
            case 5:
                return minigame6.play();
            case 6:
                return minigame7.play();
            default:
                System.out.println("Something went wrong with the mini-story switch statement");
        }

        /*The default print statement will and we will return false if something went wrong with the switch
          statement*/
        return false;
    }

    //A helper method to showcase the ministory for the minigame the player passed
    public static void showcaseMiniStory(int miniStory)
    {
        //TO-DO CODE FOR MD

        /*Notes:
            1) For each ministory, showcase the pizza slice that was made and then the ministory text after.
               Ex) A Cheese pizza slice shows up and then a block of text comes right after

            2) Afterwards, use a scanner for the player to input any letter they want in order for them to have
               enough time to read the text and to let them know to move onto making the next pizza slice.

            3) If its the last iteration (making the last pizza slice, let them know that this was their
               last pizza making session.
        */

        switch (miniStory) {
            case 0:
                System.out.println("\n Mini-Story #" + (miniStory + 1));
                System.out.println("-----------------");
                cheesePizzaSlice();
                System.out.println(" Sarah was a diligent office worker at a big tech company that frequently visited"
                        + " a local pizza\n parlor owned by Giovanni." +
                        " Compared to her mundane nine-to-five job and not-so-enthusiastic boss," +
                        "\n she's always struck by the warm feel of the restaurant and the welcoming environment that" +
                        " makes\n her feel at home." +
                        " One busy evening, Sarah notices the lack of workers at Giovanni’s local\n restaurant as he" +
                        " struggles to clear the tables for new customers who would want to enjoy his parlor.\n" +
                        " And so, she offers to help clear tables which led to Giovanni accepting her gesture of" +
                        " kindness.\n" +
                        " Before Sarah left, he gave her a free box of Cheese Pizza as a gratitude of appreciation.\n");

                break;

            case 1:
                System.out.println("\n Mini-Story #" + (miniStory + 1));
                System.out.println("-----------------");
                meatLoversPizzaSlice();
                System.out.println(" Since that incident, Sarah always chats with Giovanni from time to time whenever"
                        + " she visits the parlor\n to grab a slice of pizza after work." +
                        " Through their interactions, she realizes Giovanni's passion for cooking\n aligns with her own" +
                        " interest in culinary arts." +
                        " She asks him about pizza making, and he's thrilled to share\n tips and tricks of" +
                        " Italian cuisine" + " and where he’d learned them from." +
                        " They bond over their love for perfecting\n the art of pizza, and Sarah starts experimenting" +
                        " with" + " recipes at home, occasionally seeking advice from Giovanni.\n");

                break;
            case 2:
                System.out.println("\n Mini-Story #" + (miniStory + 1));
                System.out.println("-----------------");
                mushroomPizzaSlice();
                System.out.println(" The parlor faced financial strains due to a burst water pipe that led to an" +
                        " overflow of water\n which damaged the ovens that cooked the pizzas in the kitchen." +
                        " Hearing this bad news from Giovanni,\n Sarah got the idea to hold a fundraiser night in order"+
                        " to lessen the financial burden on him.\n" +
                        " With her organizational skills and social network with her friends and family," +
                        " she brought in a crowd\n of people to her community-building event to encourage folks to" +
                        " donate" + " funding for Giovanni’s parlor.\n" +
                        " From there, Giovanni had a set of several different Italian pizzas as accommodating food he"+
                        " and Sarah\n helped cook together at his place beforehand." +
                        " Overall, the event was easily a success that led\n Giovanni more to a financial gain rather" +
                        " than a financial loss.\n");

                break;
            case 3:
                System.out.println("\n Mini-Story #" + (miniStory + 1));
                System.out.println("-----------------");
                olivePizzaSlice();
                System.out.println(" While driving back from work and to her home on the highway," +
                        " Sarah would recount the memories\n that brought her joy in helping Giovanni cook pizzas and" +
                        " bring in her friends and family in\n preparation for that event." +
                        " Such as creating numerous Italian pizzas, having social interactions\n with different folks" +
                        " she’s never met before," +
                        " and how big of a success the event was that led\n Giovanni to be more relaxed overall." +
                        " Lost in her thoughts, however, she suddenly got rear-ended\n by a" +
                        " fast drunk driver from behind" + " who was going ninety miles per hour." +
                        " This sudden hit led to her\n steering wheel forcefully turning," +
                        " causing her car to spin rapidly" + " to the right and crash into two\n other cars." +
                        " Seeping into unconsciousness from the impact, she hears the sounds of police\n sirens as they"+
                        " pass her to catch the drunk driver before passing out.\n");

                break;
            case 4:
                System.out.println("\n Mini-Story #" + (miniStory + 1));
                System.out.println("-----------------");
                pineapplePizzaSlice();
                System.out.println(" Waking up, Sarah sees herself on a medical bed" +
                        " at a nearby hospital located next" + " to the company\n she works at." +
                        " To her left was Giovanni who was relieved to see her conscious again.\n" +
                        " To her right was the doctor who had been frequently checking on her for months at a time.\n" +
                        " After Sarah becomes fully conscious, the doctor lets her know that" +
                        " she has fallen" + " into a coma\n for the past three months." +
                        " The doctor further added that she doesn’t have any bone-fracturing\n" +
                        " injuries as most of the issue lies in the severe head injury the brain received from the"+
                        " fatal car crash.\n" + " Knowing that Sarah would be alright," +
                        " she would be out of the hospital" + " in the next two weeks.\n" +
                        " During those two weeks, she makes a funny joke about how Giovanni sees her every single day"+
                        " even though\n the doctor said that she would be totally fine." +
                        " As they share a laugh, Giovanni reveals a touching\n truth—he halted his pizza parlor business"+
                        " during those long months to ensure he could be there for\n Sarah, revealing" +
                        " his unwavering care and concern for her.\n");

                break;
            case 5:
                System.out.println("\n Mini-Story #" + (miniStory + 1));
                System.out.println("-----------------");
                pepperoniPizzaSlice();
                System.out.println(" After getting out of the hospital Giovanni offers" +
                        " her to come to his parlor since it would be a nice\n place to relax" +
                        " after all of the trouble" + " she went through with that crash." +
                        " Entering the door, Sarah is\n suddenly surprised by her friends and family" +
                        " along with the party decorations all around the parlor.\n" +
                        " Giovanni explains to her that he threw a surprise party through" +
                        " her family to celebrate that she came\n out of the crash alright." +
                        " After partying for so long, Giovanni offers her a partnership in the pizza\n parlor" +
                        " business to work together to make it thrive even more.\n");

                break;
            case 6:
                System.out.println("\n Mini-Story #" + (miniStory + 1));
                System.out.println("-----------------");
                // ASCII ART GOES HERE
                System.out.println("\n After much contemplation, she wholeheartedly accepts to leave her job" +
                        " and work with him.\n" +
                        " They embark on a journey as co-owners, combining their" +
                        " skills to expand the parlor's Italian\n pizza cuisine." +
                        " Their friendship & love for one another grow stronger as they navigate\n" +
                        " the challenges and triumphs of running a thriving pizza business together.\n");

                System.out.print("Congratulations! This was the last pizza making sesssion!\n");
                break;
            default:
                System.out.println("Something went wrong :/ 404 ERROR");
        }
    }

    /*A helper method that:
        1) Showcases an ASCII art of the game where it will show a tray of pizza.

        2) It will also let the player know the amount of pizza slices they made, congratulate them on
           playing the game, and will ask if the player wants to play the game again or exit the game.
    */
    public static void endOfGame(int[] numPizzaSlicesMade)
    {
        pizzaTray();

        System.out.println("\nCongratulations, Champion of Pizza Quest! You've overcome the challenges, conquered " +
                           "the games, and emerged victorious. \nWhether you've mastered a single slice or crafted " +
                           "the full seven-slice masterpiece, your determination and skill have \npropelled you to " +
                           "the pinnacle of this culinary adventure. Your triumph signifies not just beating the " +
                           "game, but the \nresilience and spirit you've shown throughout this flavorful journey. " +
                           "You've savored the victories, relished the \nstories, and truly made this quest your " +
                           "own. Well done, Pizza Maestro!");

        //Debug code to see if the table below works
            //numPizzaSlicesMade = new int[]{1, 1, 1, 1, 1, 1};

        System.out.println("\n______________________________");
        System.out.println("|___PIZZA SLICES COMPLETED___|");
        for(int i = 0; i < 6; i++)
        {
            String pizzaSlice = "";

            if(numPizzaSlicesMade[i] == 1)
            {
                switch(i)
                {
                    case 0: pizzaSlice = (i + 1) + ") Cheese Pizza Slice     "; break;
                    case 1: pizzaSlice = (i + 1) + ") Meat Lovers Pizza Slice"; break;
                    case 2: pizzaSlice = (i + 1) + ") Mushroom Pizza Slice   "; break;
                    case 3: pizzaSlice = (i + 1) + ") Olive Pizza Slice      "; break;
                    case 4: pizzaSlice = (i + 1) + ") Pineapple Pizza Slice  "; break;
                    case 5: pizzaSlice = (i + 1) + ") Pepperoni Pizza Slice  "; break;
                    default: System.out.println("Something went wrong in the endGame() method");
                }

                System.out.println("| " + pizzaSlice + " |");
            }
            else
            {
                pizzaSlice = (i + 1) + ")                        ";

                System.out.println("| " + pizzaSlice + " |");
            }
        }
        System.out.println("|____________________________|");

        System.out.println("\nPlease run this program again if you'd like to replay the game and attain all of the " +
                           "mini-stories! \nThank you for playing :)");

        System.out.println("\nGame Made By: Rana Ashour, Shambhavi Bhandari, Jackson Le, MD Islam, & Keyvan M. Kani");
    }

    //----ASCII METHODS---- (This section is where ASCII methods will be stored)

    //A method that will display the title of the game with that will look cool (～￣▽￣)～
    public static void asciiTitleOfGame()
    {
        System.out.println("      ________  ___  ________  ________  ________  ");
        System.out.println("     |\\   __  \\|\\  \\|\\_____  \\|\\_____  \\|\\   __  \\");
        System.out.println("     \\ \\  \\|\\  \\ \\  \\\\|___/  /|\\|___/  /\\ \\  \\|\\  \\");
        System.out.println("      \\ \\   ____\\ \\  \\   /  / /    /  / /\\ \\   __  \\");
        System.out.println("       \\ \\  \\___|\\ \\  \\ /  /_/__  /  /_/__\\ \\  \\ \\  \\");
        System.out.println("        \\ \\__\\    \\ \\__\\\\________\\\\________\\ \\__\\ \\__\\");
        System.out.println("         \\|__|     \\|__|\\|_______|\\|_______|\\|__|\\|__|");
        System.out.println();
        System.out.println();
        System.out.println("      ________  ________  ________  ___       ________  ________ ");
        System.out.println("     |\\   __  \\|\\   __  \\|\\   __  \\|\\  \\     |\\   __  \\|\\   __  \\");
        System.out.println("     \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\    \\ \\  \\|\\  \\ \\  \\|\\  \\");
        System.out.println("      \\ \\   ____\\ \\   __  \\ \\   _  _/ \\  \\    \\ \\  \\\\\\  \\ \\   _  _\\  ");
        System.out.println("       \\ \\  \\___|\\ \\  \\ \\  \\ \\  \\\\  \\\\ \\  \\____\\ \\  \\\\\\  \\ \\  \\\\  \\|");
        System.out.println("        \\ \\__\\    \\ \\__\\ \\__\\ \\__\\\\ _\\\\ \\_______\\ \\_______\\ \\__\\\\ _\\ ");
        System.out.println("         \\|__|     \\|__|\\|__|\\|__|\\|__|\\|_______|\\|_______|\\|__|\\|__|");
        System.out.println();
        System.out.println();
        System.out.println("            +-+ +-+-+-+-+-+ +-+-+-+-+-+ +-+-+-+-+-+-+-+-+-+-+  ");
        System.out.println("            |A| |s|t|o|r|y| |a|b|o|u|t| |f|r|i|e|n|d|s|h|i|p|");
        System.out.println("            +-+ +-+-+-+-+-+ +-+-+-+-+-+ +-+-+-+-+-+-+-+-+-+-+");
        System.out.println("X---------------------------------------------------------------------------------X");
    }

    //A method that will showcase an ASCII art of the kitchen in the pizza parlor
    public static void asciiKitchen()
    {
        System.out.println("X---------------------------------------------------------------------------------X");
        System.out.println();
        System.out.println("/|    |__I__I__I__I__I__I__I__I__I_|       _-                         |\\");
        System.out.println("  | _- |_I__I__I__I__I__I__I__I__I__|-_                            _-   |");
        System.out.println("  |    |__I__I__I__I__I__I__I__I__I_|                 _--               |");
        System.out.println("  | -  |__I__I__I__I__I__I__I__I__I_|  -_ -                             |");
        System.out.println("  |    |_I__I__I__I__I__I__I__I__I__|                                   |");
        System.out.println("  |-_- /                            \\                        -         |");
        System.out.println("  |   /                              \\    -_                           |");
        System.out.println("  |  /                                \\                            -_  |");
        System.out.println("  | /__________________________________\\                  -            |");
        System.out.println("  | |__________________________________|                                |");
        System.out.println("  |    |   _______________________   |     _-            -              |");
        System.out.println("  |_-  |  |                       |  |                         _-       |");
        System.out.println("  |    |  |                     _ |  |  T  T  T  T  T                   |");
        System.out.println("  | _-_|  |    __.'`'`'`''`;__ /  |  |  |  |  |  |  |        _-     -   |");
        System.out.println("  |    |  | _/U  `'.'.,.,\".'  U   |  |  | (_) |  |  |                  |");
        System.out.println("  |    |  |   |               |   |  | / \\    @ [_]d b    _@_     |    |");
        System.out.println("  |    |  |   |      `', `,   |   |  | |_|    ____         [ ]     |    |");
        System.out.println("  |_-  |  |   |   `') ( )'    |   |  | ______\\__/_________[_]__   |    |");
        System.out.println("  |    |  |   |____(,`)(,(____|   |  |/________________________\\  |    |");
        System.out.println("  |    |  |  /|   `@@(@@)@)'  |\\  |  | ||            _____   ||   |    |");
        System.out.println("  |    |  | //!\\  @@)@@)@@@( /!\\\\ |  | ||   _--      \\   /   ||  /|\\   |");
        System.out.println("  |__lc|__|/_____________________\\|__|_||____________/###\\___||_|||||__|");
        System.out.println(" / -_  _ -      _ -   _-_    -  _ - _ -|| -_    _  - \\___/_- || |||||-_ \\ ");
        System.out.println();
        System.out.println("X---------------------------------------------------------------------------------X");
    }

    //ASCII art of a cheese pizza slice for showcaseMiniStory() method
    public static void cheesePizzaSlice()
    {
        System.out.println("+----------------------------------------------+");
        System.out.println("               Cheese!");
        System.out.println("+----------------------------------------------+");
        System.out.println("        .'o O'-._");
        System.out.println("       / O o_ .-`|");
        System.out.println("      /O_.-'   O |");
        System.out.println("      | o    o .-`");
        System.out.println("      |o  O_.-'");
        System.out.println("      '--`");
        System.out.println("+----------------------------------------------+");
    }

    //ASCII art of a meat lovers pizza slice for showcaseMiniStory() method
    public static void meatLoversPizzaSlice()
    {
        System.out.println("+----------------------------------------------+");
        System.out.println("               Meat Lovers!");
        System.out.println("+----------------------------------------------+");
        System.out.println("    _____  ");
        System.out.println("^..^     \\9");
        System.out.println("(oo)_____/ ");
        System.out.println("   WW  WW   ");
        System.out.println();
        System.out.println("    /\"\"\\      ,");
        System.out.println("   <>^  L____/|");
        System.out.println("    `) /`   , /");
        System.out.println("     \\ `---' /");
        System.out.println("      `'\";\\)`");
        System.out.println("        _/_Y  ");
        System.out.println();
        System.out.println("           __n__n__");
        System.out.println("    .------`-\\00/-'");
        System.out.println("   /  ##  ## (oo)");
        System.out.println("  / \\## __   ./");
        System.out.println("     |//YY \\|/");
        System.out.println("     |||   |||");
        System.out.println("+----------------------------------------------+");
    }

    //ASCII art of a mushroom pizza slice for showcaseMiniStory() method
    public static void mushroomPizzaSlice()
    {
        System.out.println("+----------------------------------------------+");
        System.out.println("               Mushroom!");
        System.out.println("+----------------------------------------------+");
        System.out.println("         ___..._");
        System.out.println("    _,--'       \"`-.\"");
        System.out.println("  ,'.  .            \\");
        System.out.println(",/:. .     .       .'");
        System.out.println("|;..  .      _..--'");
        System.out.println("`--:...-,-'\"\"\\");
        System.out.println("        |:.  `.");
        System.out.println("        l;.   l");
        System.out.println("        `|:.   |");
        System.out.println("        `|:.   |");
        System.out.println("        .l;.    j, ");
        System.out.println("     `. \\`;:.   //,/");
        System.out.println("+----------------------------------------------+");
    }

    //ASCII art of a olive pizza slice for showcaseMiniStory() method
    public static void olivePizzaSlice()
    {
        System.out.println("+----------------------------------------------+");
        System.out.println("               Olives!");
        System.out.println("+----------------------------------------------+");
        System.out.println("          \\  ");
        System.out.println("        (')(')");
        System.out.println("       (')(')(')");
        System.out.println("        (')(')");
        System.out.println("          (')");
        System.out.println("+----------------------------------------------+");
    }

    //ASCII art of a pineapple pizza slice for showcaseMiniStory() method
    public static void pineapplePizzaSlice()
    {
        System.out.println("+----------------------------------------------+");
        System.out.println("               Pineapple!");
        System.out.println("+----------------------------------------------+");
        System.out.println("          \\||/");
        System.out.println("          \\||/");
        System.out.println("        .<><><>.");
        System.out.println("       .<><><><>.");
        System.out.println("       '<><><><>'");
        System.out.println("        '<><><>'");
        System.out.println("+----------------------------------------------+");
    }

    //ASCII art of a pepperoni pizza slice for showcaseMiniStory() method
    public static void pepperoniPizzaSlice()
    {
        System.out.println("+----------------------------------------------+");
        System.out.println("               Pepperoni!");
        System.out.println("+----------------------------------------------+");
        System.out.println("       // \"\"--.._");
        System.out.println("       ||  (_)  _ \"-._");
        System.out.println("       ||    _ (_)    '-.");
        System.out.println("       ||   (_)   __..-'");
        System.out.println("        \\\\__..--\"\"\n");
        System.out.println("+----------------------------------------------+");
    }

    //ASCII art of a pizza tray full of pizza slices for the endOfGame() method
    public static void pizzaTray()
    {

        System.out.println("\n+----------------------------------------------+");
        System.out.println("               Pizza Tray Complete!");
        System.out.println("+----------------------------------------------+");
        System.out.println("             _.:`.--|--.`:._");
        System.out.println("          .: .'\\o  | o /'. '.");
        System.out.println("         // '.  \\ o|  /  o '.\\");
        System.out.println("        //'._o'. \\ |o/ o_.-'o\\\\");
        System.out.println("        || o '-.'.\\|/.-' o   ||");
        System.out.println("        \\\\'._o'. / |o\\ o_.-'o//");
        System.out.println("         \\\\ '.  / o|  \\  o '//");
        System.out.println("          .: .'/o  | o \\'. '.");
        System.out.println("            -:.,.__|__.,.:-");
        System.out.println("+----------------------------------------------+");
    }
}

