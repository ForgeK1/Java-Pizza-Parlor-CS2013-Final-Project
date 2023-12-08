import Minigames.HungryCustomers;
import Minigames.TicTacToe;

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
        //A section to keep our minigame instances
        TicTacToe minigame1 = new TicTacToe();
        HungryCustomers minigame2 = new HungryCustomers();
        HungryCustomers minigame3 = new HungryCustomers();
        HungryCustomers minigame4 = new HungryCustomers();
        HungryCustomers minigame5 = new HungryCustomers();
        HungryCustomers minigame6 = new HungryCustomers();

        //An ASCII art showcasing a pizza parlor kitchen and a person standing next to a pizza-making station
        asciiKitchen();

        System.out.println("\n*Prompt of the game and what the player needs to know*");

        //A for loop to play 6 minigames and showcase each mini-story in sequence
        for(int miniStory = 1; miniStory <= 6; miniStory++)
        {
            //System.out.println("\n--Loop ran--\n");

            /*Every minigame .play() method will return a True or False boolean value. So, we will keep track of
              that value, and we know that the player won the minigame if we receive a True value and vice-versa*/
            boolean minigamePassed = playMinigame(miniStory, minigame1, minigame2, minigame3,
                                                             minigame4, minigame5, minigame6);

            //An if statement that checks if the player passed the minigame
            if(minigamePassed)
            {
                showcaseMiniStory(miniStory);
            }
            else
            {
                //TO-DO CODE FOR MD ISLAM

                /*Notes: Tell the player that they failed the minigame and did not make the intended pizza slice
                         --> They move on to making the next pizza slice. If its the last iteration, let them
                             know that this was their last pizza making session.*/
                System.out.println("\nSadly, you have lost this minigame and didn't make the intended pizza slice :(");

                if(miniStory == 6) {
                    System.out.println("This was the last minigame and therefore was your FINAL" +
                                       " pizza making session! ");
                }
                else {
                    continue;
                }

            }

            /*A method that will congradulate the player on finishing the game, let them know the amount of
              pizza slices made, and ASCII art of a pizza tray showing the pizza slices they made altogether*/
            endOfGame();
        }
    }

    //----HELPER METHODS---- (This section is where helper methods will be stored)

    /*A helper method that contains switch statement to return a boolean value from the intended
      minigame played*/
    public static boolean playMinigame(int miniStory,
                                       TicTacToe minigame1, HungryCustomers minigame2,
                                       HungryCustomers minigame3, HungryCustomers minigame4,
                                       HungryCustomers minigame5, HungryCustomers minigame6)
    {
        //A switch statement to assign a boolean value from the intended minigame
        switch (miniStory)
        {
            case 1:
                return minigame1.play();
            case 2:
                return minigame2.play();
            case 3:
                return minigame3.play();
            case 4:
                return minigame4.play();
            case 5:
                return minigame5.play();
            case 6:
                return minigame6.play();
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
        Scanner input = new Scanner(System.in);
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
            case 1:
                cheesePizzaSlice();
                System.out.println("\n Sarah was a diligent office worker at a big tech company that frequently visited"
                        + " a local pizza parlor owned by Giovanni. \n" +
                        " Compared to her mundane nine-to-five job and not-so-enthusiastic boss," +
                        "\n she's always struck by the warm feel of the restaurant and the welcoming environment that" +
                        " makes her feel at home.\n" +
                        " One busy evening, Sarah notices the lack of workers at Giovanni’s local\n restaurant as he" +
                        " struggles to clear the tables for new customers who would want to enjoy his parlor.\n" +
                        " And so, she offers to help clear tables which led to Giovanni accepting her gesture of" +
                        " kindness.\n" +
                        " Before Sarah left, he gave her a free box of Cheese Pizza as a gratitude of appreciation.\n");

                System.out.print("Enter any letter to continue with the next minigame: ");
                String letter = input.next();
                break;

            case 2:
                meatLoversPizzaSlice();
                System.out.println("\n Since that incident, Sarah always chats with Giovanni from time to time whenever"
                        + " she visits the parlor to grab a slice of pizza after work.\n" +
                        " Through their interactions, she realizes Giovanni's passion for cooking aligns with her own" +
                        " interest in culinary arts.\n" +
                        " She asks him about pizza making, and he's thrilled to share tips and tricks of" +
                        " Italian cuisine" + " and where he’d learned them from.\n" +
                        " They bond over their love for perfecting the art of pizza, and Sarah starts experimenting" +
                        " with" + " recipes at home, occasionally seeking advice from Giovanni.\n");

                System.out.print("Enter any letter to continue with the next minigame: ");
                String letter2 = input.next();
                break;
            case 3:
                mushroomPizzaSlice();
                System.out.println("\n The parlor faced financial strains due to a burst water pipe that led to an" +
                        " overflow of water which damaged the ovens that cooked the pizzas in the kitchen.\n" +
                        " Hearing this bad news from Giovanni, Sarah got the idea to hold a fundraiser night in order"+
                        " to lessen the financial burden on him.\n" +
                        " With her organizational skills and social network with her friends and family," +
                        " she brought in a crowd of people to her\n community-building event to encourage folks to" +
                        " donate" + " funding for Giovanni’s parlor.\n" +
                        " From there, Giovanni had a set of several different Italian pizzas as accommodating food he"+
                        " and Sarah helped cook together at his place beforehand.\n" +
                        " Overall, the event was easily a success that led Giovanni more to a financial gain rather" +
                        " than a financial loss.\n");

                System.out.print("Enter any letter to continue with the next minigame: ");
                String letter3 = input.next();
                break;
            case 4:
                olivePizzaSlice();
                System.out.println("\n While driving back from work and to her home on the highway," +
                        " Sarah would recount the memories that brought her joy in helping\n Giovanni cook pizzas and" +
                        " bring in her friends and family in preparation for that event.\n" +
                        " Such as creating numerous Italian pizzas, having social interactions with different folks" +
                        " she’s never met before,\n" +
                        " and how big of a success the event was that led Giovanni to be more relaxed overall.\n" +
                        " Lost in her thoughts, however, she suddenly got rear-ended by a" +
                        " fast drunk driver from behind" + " who was going ninety miles per hour.\n" +
                        " This sudden hit led to her steering wheel forcefully turning," +
                        " causing her car to spin rapidly" + " to the right and crash into two other cars.\n" +
                        " Seeping into unconsciousness from the impact, she hears the sounds of police sirens as they"+
                        " pass her to catch the drunk driver before passing out.\n");

                System.out.print("Enter any letter to continue with the next minigame: ");
                String letter4 = input.next();
                break;
            case 5:
                pineapplePizzaSlice();
                System.out.println("\n Waking up, Sarah sees herself on a medical bed" +
                        " at a nearby hospital located next" + " to the company she works at.\n" +
                        " To her left was Giovanni who was relieved to see her conscious again.\n" +
                        " To her right was the doctor who had been frequently checking on her for months at a time.\n" +
                        " After Sarah becomes fully conscious, the doctor lets her know that" +
                        " she has fallen" + " into a coma for the past three months\n" +
                        " The doctor further added that she doesn’t have any bone-fracturing" +
                        " injuries as most of the issue lies in the severe\n head injury the brain received from the"+
                        " fatal car crash.\n" + " Knowing that Sarah would be alright," +
                        " she would be out of the hospital" + " in the next two weeks.\n" +
                        " During those two weeks, she makes a funny joke about how Giovanni sees her every single day"+
                        " even though the doctor said that she would be totally fine.\n" +
                        " As they share a laugh, Giovanni reveals a touching truth—he halted his pizza parlor business\n"+
                        " during those long months to ensure he could be there for Sarah revealing" +
                        " his unwavering care and concern for her.\n");

                System.out.print("Enter any letter to continue with the next minigame: ");
                String letter5 = input.next();
                break;
            case 6:
                pepperoniPizzaSlice();
                System.out.println("\n After getting out of the hospital Giovanni offers" +
                        " her to come to his parlor since it would be a nice place to relax" +
                        " after all of the trouble" + " she went through with that crash.\n" +
                        " Entering the door, Sarah is suddenly surprised by her friends and family" +
                        " along with the party decorations all around the parlor.\n" +
                        " Giovanni explains to her that he threw a surprise party through" +
                        " her family to celebrate that she came out of the crash alright.\n" +
                        " After partying for so long, Giovanni offers her a partnership in the pizza parlor" +
                        " business to work together to make it thrive even more.\n" +
                        " After much contemplation, she wholeheartedly accepts to leave her job and work with him.\n" +
                        " They embark on a journey as co-owners, combining their" +
                        " skills to expand the parlor's Italian pizza cuisine.\n" +
                        " Their friendship & love for one another grow stronger as they navigate" +
                        " the challenges and triumphs of running a thriving pizza business together.\n");

                System.out.print("Congratulations! This was the last pizza making sesssion!: ");
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
    public static void endOfGame()
    {
        //TO DO CODE FOR KEYVAN
    }

    //----ASCII METHODS---- (This section is where ASCII methods will be stored)

    //A method that will showcase an ASCII art of the kitchen in the pizza parlor
    public static void asciiKitchen()
    {
        //TO-DO CODE FOR RANA
    }

    //ASCII art of a cheese pizza slice for showcaseMiniStory() method
    public static void cheesePizzaSlice()
    {
        //TO-DO CODE FOR RANA
    }

    //ASCII art of a meat lovers pizza slice for showcaseMiniStory() method
    public static void meatLoversPizzaSlice()
    {
        //TO-DO CODE FOR RANA
    }

    //ASCII art of a mushroom pizza slice for showcaseMiniStory() method
    public static void mushroomPizzaSlice()
    {
        //TO-DO CODE FOR RANA
    }

    //ASCII art of a olive pizza slice for showcaseMiniStory() method
    public static void olivePizzaSlice()
    {
        //TO-DO CODE FOR RANA
    }

    //ASCII art of a pineapple pizza slice for showcaseMiniStory() method
    public static void pineapplePizzaSlice()
    {
        //TO-DO CODE FOR RANA
    }

    //ASCII art of a pepperoni pizza slice for showcaseMiniStory() method
    public static void pepperoniPizzaSlice()
    {
        //TO-DO CODE FOR RANA
    }

    //ASCII art of a pizza tray full of pizza slices for the endOfGame() method
    public void pizzaTray()
    {
        //TO-DO CODE FOR RANA
    }
}

