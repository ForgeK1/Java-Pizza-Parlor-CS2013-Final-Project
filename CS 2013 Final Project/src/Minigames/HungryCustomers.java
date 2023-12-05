package Minigames;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/*
    1) Minigame Name: HungryCustomers

    2) How will this mini-game work?:
        As a pizza parlor co-owner with 4 different trays of Pizzas you are selling to your
        customers. There is a line of hungry customers who tell you to give them a specific
        pizza slice. As such, you have three lives and you must give out all of the pizzas
        in order to beat the minigame. Every time you give out the wrong one you will be
        deducted a life and if you reach 0 lives you will lose the minigame.

    3) Minigame made by: Keyvan M. Kani

    4) Course: Java 2013 Data Structures & Algorithms
*/
public class HungryCustomers
{
    //1) Data Fields
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


        //Initialize our Queue of customers
        this.listOfCustomers = new LinkedList<>();
    }

    //3) Methods

    /*A method to play the minigame. If the player beats the minigame, we will return a
      true boolean value in order to reveal a ministory. However, if they do not then we
      will return a false booleon value instead.*/
    public boolean play()
    {
        boolean win = false;

        return win;
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
        for(int i = 0; i < 6; i++)
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

        while(maxCheeseSlices != 6 && maxPepperoniSlices != 6 &&
              maxMushroomSlices != 6 && maxPineappleSlices != 6)
        {
            int addRandomCustomer = random.nextInt(1, 5);
        }
    }
}
