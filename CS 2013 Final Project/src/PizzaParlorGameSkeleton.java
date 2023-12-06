import Minigames.HungryCustomers;

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
        HungryCustomers minigame1 = new HungryCustomers();
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
            System.out.println("\n--Loop ran--\n");

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
                                       HungryCustomers minigame1, HungryCustomers minigame2,
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
        //TO-DO CODE FOR MD

        /*Notes:
            1) For each ministory, showcase the pizza slice that was made and then the ministory text after.
               Ex) A Cheese pizza slice shows up and then a block of text comes right after

            2) Afterwards, use a scanner for the player to input any letter they want in order for them to have
               enough time to read the text and to let them know to move onto making the next pizza slice.

            3) If its the last iteration (making the last pizza slice, let them know that this was their
               last pizza making session.
        */
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
    public static void oliveizzaSlice()
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

    }
}

