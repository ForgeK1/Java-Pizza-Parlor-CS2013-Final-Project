package Minigames;

import java.util.*;

/*
    1) Class Name: HungryCustomers

    2) How will this class work?:
        As a pizza parlor co-owner with 4 different trays of Pizzas you are selling to your
        customers. There is a line of hungry customers who tell you to give them a specific
        pizza slice. As such, you have three lives and you must give out all of the pizzas
        in order to beat the minigame. Every time you give out the wrong one you will be
        deducted a life and if you reach 0 lives you will lose the minigame.

    3) Class made by: Keyvan M. Kani

    4) Course: Java 2013 Programming with Data Structures
*/
public class HungryCustomers
{
    //1) Data Fields

    //A variable to keep track of the player's number of lives
    private int numLives;

    //A Stack of every pizza tray in the minigame
    private Stack<Integer> cheesePizzaTray;
    private Stack<Integer> pepperoniPizzaTray;
    private Stack<Integer> mushroomPizzaTray;
    private Stack<Integer> pineapplePizzaTray;

    /*A Queue instance that will keep track of the line of hungry customers
        Cheese Pizza Customer:    1
        Pepperoni Pizza Customer: 2
        Mushroom Pizza Customer:  3
        Pineapple Pizza Customer: 4
    */
    private Queue<Integer> listOfCustomers;

    //2) Constructors

    //Default constructor
    public HungryCustomers()
    {
        this.numLives = 3;

        //Initialize all pizza tray instances
        this.cheesePizzaTray = new Stack<>();
        this.pepperoniPizzaTray = new Stack<>();
        this.mushroomPizzaTray = new Stack<>();
        this.pineapplePizzaTray = new Stack<>();

        //A method where that adds a total amount of 6 pizza slices for every tray of pizza
        initializeTraysWithPizzaSlices();

        //Initialize our list of customers
        this.listOfCustomers = new LinkedList<>();

        //A method to add all of the customers who want pizza
        initializeListOfCustomers();
    }

    //3) Methods

    /*A method to play the minigame. If the player beats the minigame, we will return a
      true boolean value in order to reveal a ministory. However, if they do not then we
      will return a false booleon value instead to indicate that they failed the minigame.*/
    public boolean play()
    {
        //A scanner to allow input for the player
        Scanner input = new Scanner(System.in);

        System.out.println("\n----------------------------------------");
        System.out.println("| Title of Minigame: HUNGRY CUSTOMERS! |");
        System.out.println("----------------------------------------");

        System.out.println("\nYour Pizza Parlor co-owner gave you the task of serving customers for the day. " +
                           "\nIt seems that you have to serve _16 customers_ where each customer requests a cheese " +
                           "\npepperoni, mushroom, or a pineapple pizza slice to go! " +

                           "\n\nMake sure to pick the correct pizza slice from the following four pizza trays as " +
                           "\nrequested by the customer (*Input the following # in the console when choosing a " +
                           "\npizza slice*): " +

                           "\n\nCheese Pizza Tray:    1" +
                           "\nPepperoni Pizza Tray: 2" +
                           "\nMushroom Pizza Tray:  3" +
                           "\nPineapple Pizza Tray: 4" +

                           "\n\nNumber of lives: You have three chances! For every customer that you fail to give " +
                           "\nthe right pizza slice you are downed by one life. Lose all of your lives and you " +
                           "\nare out and cannot serve customers anymore. Good luck! :)");

        while(!this.listOfCustomers.isEmpty())
        {
            //A print statement to indicate the top block of text for the current customer
            System.out.println("\n----------------------------------------------------------------------------------");

            //A variable & a switch statement to find the customer and their requested pizza slice
            int customer = this.listOfCustomers.remove();
            String requestedPizzaSlice = "";

            switch(customer)
            {
                case 1: requestedPizzaSlice = "Cheese Pizza Slice"; break;
                case 2: requestedPizzaSlice = "Pepperoni Pizza Slice"; break;
                case 3: requestedPizzaSlice = "Mushroom Pizza Slice"; break;
                case 4: requestedPizzaSlice = "Pineapple Pizza Slice"; break;
                default: requestedPizzaSlice = "Something went wrong with the switch statement";
            }

            //Shows ASCII art of customer. Note: There will be 4 different ASCII art customers
            asciiCustomer();

            System.out.println("\nCustomer: \"Hi! I would like a " + requestedPizzaSlice + " please!\"");

            //Prompts the player to pick the correct pizza slice for the customer
            System.out.print("Choose the choice of pizza to give this customer: ");

            int chosenPizzaSliceByPlayer = input.nextInt();

            /*if statement --> If the player picks from the correct pizza tray, then the customer is happy and we
                               remove a pizza slice from it's associated tray (Stack)

              else state.  --> If the player chose the wrong pizza tray, then the customer will move to the back of
                               the line (re-added back to the Queue) and the chosen pizza slice is not removed
                               from its associated pizza tray

              Note: The player will never have to give a pizza slice to a customer from an empty tray because
                    there are 6 customers for every 6 slices in each pizza tray*/
            if(chosenPizzaSliceByPlayer == customer)
            {
                System.out.println("\nCustomer: \"Mmmmm delicius! Thank you for this " + requestedPizzaSlice +
                                   "! :P");

                System.out.println("\nNumber of lives: " + this.numLives);

                switch(chosenPizzaSliceByPlayer)
                {
                    case 1: this.cheesePizzaTray.pop(); break;
                    case 2: this.pepperoniPizzaTray.pop(); break;
                    case 3: this.mushroomPizzaTray.pop(); break;
                    case 4: this.pineapplePizzaTray.pop(); break;
                    default: System.out.println("\nSomething went wrong in the chosenPizzaByPlayer switch " +
                                                "statement");
                }
            }
            else
            {
                System.out.println("\nCustomer: \"EWWWW this is not the pizza I wanted! I'm going to the back of " +
                                    "the \nline again. Get me the right pizza slice next time. :'(");

                //Customer moves to the back of the line
                this.listOfCustomers.add(customer);

                //Removes a life count from the player
                this.numLives--;

                System.out.println("\nNumber of lives: " + this.numLives);
            }

            //A print statement to indicate the bottom block of text for the current customer
            System.out.println("----------------------------------------------------------------------------------\n");

            //If the number of lives drops to 0, we return false which means they lose the minigame
            if(numLives == 0)
            {
                System.out.println("\nYour customers were unhappy! You lost all of your lives and now you " +
                                   "you went out \nof business! X_X");

                return false;
            }
        }

        /*If we pass the while loop above, it indicates that the player gave out all of their pizza slices and that
          they won the minigame!*/
        System.out.println("\nAll of your customers are happy! You gave out all of the pizzas you had for the \nday " +
                           "and you recieved maximum customer satisfaction. ^0^");

        //Returning true indicates that we passed the minigame!
        return true;
    }

    //A method to initialize every tray of pizza with it's own representative value.
    public void initializeTraysWithPizzaSlices()
    {
        /*A for loop to assign each stack it's own representative value such that: 
            Cheese Pizza Tray:    1
            Pepperoni Pizza Tray: 2
            Mushroom Pizza Tray:  3
            Pineapple Pizza Tray: 4
        
        Therefore, when a customer comes up to the front, we see which pizza slice they want
        and we pick the correct pizza tray by inputing a number between 1 - 4*/
        for(int i = 0; i < 4; i++)
        {
            this.cheesePizzaTray.push(1);
            this.pepperoniPizzaTray.push(2);
            this.mushroomPizzaTray.push(3);
            this.pineapplePizzaTray.push(4);
        }
    }

    /*A method to initialize the listOfCustomers Queue with values 1, 2, 3, & 4 where each value
      indicates what pizza slice they want*/
    public void initializeListOfCustomers()
    {
        int maxCheeseSlices = 0;
        int maxPepperoniSlices = 0;
        int maxMushroomSlices = 0;
        int maxPineappleSlices = 0;

        Random random = new Random();

        while(maxCheeseSlices != 4 || maxPepperoniSlices != 4 ||
              maxMushroomSlices != 4 || maxPineappleSlices != 4)
        {
            int addRandomCustomer = random.nextInt(1, 5);

            if(addRandomCustomer == 1 && maxCheeseSlices < 4)
            {
                this.listOfCustomers.add(1);
                maxCheeseSlices++;
            }
            else if(addRandomCustomer == 2 && maxPepperoniSlices < 4)
            {
                this.listOfCustomers.add(2);
                maxPepperoniSlices++;
            }
            else if(addRandomCustomer == 3 && maxMushroomSlices < 4)
            {
                this.listOfCustomers.add(3);
                maxMushroomSlices++;
            }
            else if(addRandomCustomer == 4 && maxPineappleSlices < 4)
            {
                this.listOfCustomers.add(4);
                maxPineappleSlices++;
            }
        }
    }

    //A method that will print out a random ASCII art of a customer
    public void asciiCustomer()
    {
        Random random = new Random();

        int pickRandomCustomerAscii = random.nextInt(1, 5);

        //Creates space to print ASCII of customer
        System.out.println();

        if(pickRandomCustomerAscii == 1)
        {
            //Customer 1
            System.out.println("                    _,,,_");
            System.out.println("                  .'     `'.");
            System.out.println("                 /     ____ \\");
            System.out.println("                |    .'_  _\\/");
            System.out.println("                /    ) a  a|");
            System.out.println("               /    (    > |");
            System.out.println("              (      ) ._  /");
            System.out.println("              )    _/-.__.'`\\");
            System.out.println("             (  .-'`-.   \\__ )");
            System.out.println("              `/      `-./  `.");
            System.out.println("               |    \\      \\  \\");
            System.out.println("               |     \\   \\  \\  \\");
            System.out.println("               |\\     `. /  /   \\");
            System.out.println();
        }
        else if(pickRandomCustomerAscii == 2)
        {
            //customer 2
            System.out.println("              ,,,,");
            System.out.println("             /   '");
            System.out.println("            /.. /");
            System.out.println("           ( c  D");
            System.out.println("            \\- '\\_");
            System.out.println("             `-'\\)\\");
            System.out.println("                |_ \\");
            System.out.println("                |U \\\\");
            System.out.println("               (__,//");
            System.out.println("               |. \\/");
            System.out.println("               LL__I");
            System.out.println("                |||");
            System.out.println("                |||");
            System.out.println("             ,,-``'\\ ");
        }
        else if(pickRandomCustomerAscii == 3)
        {
            //customer 3
            System.out.println("                   __");
            System.out.println("                 .'  `'.");
            System.out.println("                /  _    |");
            System.out.println("                #_/.\\==/.\\");
            System.out.println("               (, \\_/ \\\\_/");
            System.out.println("                |    -' |");
            System.out.println("                \\   '=  /");
            System.out.println("                /`-.__.'");
            System.out.println("             .-'`-.___|__");
            System.out.println("            /    \\       `.");
            System.out.println();
        }
        else
        {
            //customer 4
            System.out.println("         |><|~|><|");
            System.out.println("         /(((9)))\\");
            System.out.println("        //) o_o  (\\\\");
            System.out.println("       (((( ._. ))))");
            System.out.println("        ))))---((((");
            System.out.println("       ((((`---'))))");
            System.out.println("      (___|xXxXx|___)");
            System.out.println("        \\ |     | /");
            System.out.println("         / ^ ^ ^ \\");
            System.out.println("        /         \\");
            System.out.println("       (_._._._._._)");
            System.out.println("          \\  |  /");
            System.out.println("           | | |");
            System.out.println("           |-|-|");
            System.out.println("         (__,^.__)");
        }
    }
}
