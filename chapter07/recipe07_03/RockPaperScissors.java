package org.java17recipes.chapter07.recipe07_03;


import java.util.Scanner; 

public class RockPaperScissors {
    
    enum Hand { ROCK, PAPER, SCISSORS, INVALID };
    
    private static void getHand(int handVal) {
        Hand hand;
        try {
            hand = Hand.values()[handVal - 1];
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            hand = Hand.INVALID;
        }
        switch (hand) {
            case ROCK:
                System.out.println("Rock");
                break;
            case PAPER:
                System.out.println("Paper");
                break;
            case SCISSORS:
                System.out.println("Scissors");
                break;
            default:
                System.out.println("Invalid");  
        }
    }
    
    private static void playHands(int yourHand, int myHand) {

        // Rock = 1
        // Paper = 2
        // Scissors = 3
        
        // Hand combinations:
        // 1,1; 2,2; 3,3 => Draw
        // 1,2 => sum = 3 => Paper
        // 1,3 => sum = 4 => Rock
        // 2,3 => sum = 5 => Scissors
        //
        switch ((yourHand == myHand) ? 0 : (yourHand + myHand)) {
            case 0:
                System.out.println("Draw!");  
                break;
            case 3:
                System.out.print("Paper beats Rock. ");
                printWinner(yourHand, 2);
                break;
            case 4:
                System.out.print("Rock beats Scissors. ");
                printWinner(yourHand, 1);
                break;
            case 5:
                System.out.print("Scissors beats Paper. ");
                printWinner(yourHand, 3);
                break;
            default:
                System.out.print("You cheated! ");
                printWinner(yourHand, myHand);       
        }
    }

    private static void printWinner(int yourHand, int winningHand) {
        if (yourHand == winningHand) {
            System.out.println("You win!");
        }
        else {
            System.out.println("I win!");
        }
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Let's Play Rock, Paper, Scissors");
        System.out.println("  Enter 1 (Rock)");
        System.out.println("  Enter 2 (Paper)");
        System.out.println("  Enter 3 (Scissors)");
        System.out.print("> ");
        
        int playerHand = input.hasNextInt() ? input.nextInt() : -99;
        int computerHand = (int)(3*Math.random()) + 1;

        System.out.print("Your hand: (" + playerHand + ") ");
        getHand(playerHand);
        System.out.print("My hand: (" + computerHand + ") ");
        getHand(computerHand);
        playHands(playerHand, computerHand);
    }
}

