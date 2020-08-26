// NIM GAME
// Nim is a game of sticks where the  person who
// picks up the last stick in the last pile loses!
// Made By: Tony Lin
import java.util.Scanner;
class Nim {
    public static void main(String[] args) {
        // variables
        boolean noMoreSticks = false;
        int howManyRounds = 0;
        String yourTurn = "";
        String winner = "";
        boolean temp = false;
        int pileNum = 0;
        int numSticks = 0;
        boolean playAgainValue = true;
        int playerOneWins = 0;
        int playerTwoWins = 0;
        String playAgain;
        boolean repeat = true;

        // user input
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name player 1?");
        String name1 = input.nextLine();
        System.out.println("What is your name player 2?");
        String name2 = input.nextLine();

        // loops whole program so it repeats
        while (playAgainValue == true) {
            // randomly generates the stick piles
            int pile1 = (int) (5 * Math.random()) + 4;
            int pile2 = (int) (5 * Math.random()) + 4;
            int pile3 = (int) (5 * Math.random()) + 4;
            int pile4 = (int) (5 * Math.random()) + 4;

            // calling print method
            print(pile1, pile2, pile3, pile4);

            // loops until no more sticks are left
            while (noMoreSticks == false) {

                // determines whos turn it is, winner starts again
                howManyRounds++;
                if (howManyRounds % 2 == 0) {
                    yourTurn = name2;
                } else if (howManyRounds % 2 == 1) {
                    yourTurn = name1;
                }

                // bullet-proofs user input for picking pile number
                while (temp == false) {
                    System.out.println(yourTurn + ", enter a pile number from 1 - 4");
                    pileNum = input.nextInt();
                    if ((pileNum < 5) && (pileNum > 0)) {
                        if (pileNum == 1 && pile1 > 0) {
                            temp = true;
                        } else if (pileNum == 2 && pile2 > 0) {
                            temp = true;
                        } else if (pileNum == 3 && pile3 > 0) {
                            temp = true;
                        } else if (pileNum == 4 && pile4 > 0) {
                            temp = true;
                        } else {
                            System.out.println("Make sure there are enough sticks in pile!");
                        }
                    } else {
                        System.out.println("Enter a correct pile number!");
                    }
                }

                temp = false;

                // bullet-proofing user input for how many sticks
                while (temp == false) {
                    System.out.println(yourTurn + ", how many sticks do you want to remove?");
                    numSticks = input.nextInt();

                    if (((pileNum == 1) && (numSticks <= pile1)) && (numSticks != 0)) {
                        pile1 -= numSticks;
                        temp = true;
                    } else if (((pileNum == 2) && (numSticks <= pile2)) && (numSticks != 0)) {
                        pile2 -= numSticks;
                        temp = true;
                    }

                    else if (((pileNum == 3) && (numSticks <= pile3)) && (numSticks != 0)) {
                        pile3 -= numSticks;
                        temp = true;
                    }

                    else if (((pileNum == 4) && (numSticks <= pile4)) && (numSticks != 0)) {
                        pile4 -= numSticks;
                        temp = true;
                    } else {
                        System.out.println(
                                "Error! Input has to be greater than 0 and there has to be enough sticks left in pile!");
                    }

                }
                // changes condition back to false
                temp = false;

                // prints out the piles
                print(pile1, pile2, pile3, pile4);

                // checks if there are any sticks left
                if ((pile1 + pile2 + pile3 + pile4) == 0) {
                    noMoreSticks = true;
                }
            }
            // counts wins
            if (yourTurn.equals(name1)) {
                playerTwoWins++;
            } else if (yourTurn.equals(name2)) {
                playerOneWins++;
            }

            // finds out the winner
            if (yourTurn.equals(name1)) {
                winner = name2;
            } else if (yourTurn.equals(name2)) {
                winner = name1;
            }
            // prints winner
            System.out.println(winner + " wins!");
            System.out.println("-------------------");

            // play another round?
            while (repeat == true) {
                System.out.println("Do you want to play again?");
                System.out.println("Please type | yes | no |");
                playAgain = input.next();

                // changes input to lowercase
                playAgain = playAgain.toLowerCase();

                // checks if program should repeat
                if (playAgain.equals("yes")) {
                    repeat = false;
                    playAgainValue = true;
                } else if (playAgain.equals("no")) {
                    repeat = false;
                    playAgainValue = false;
                } else {
                    System.out.println("Wrong input! Try again");
                }
            }

            // resets the loop conditions back to default
            noMoreSticks = false;
            temp = false;
            repeat = true;
        }
        // closes scanner
        input.close();
        // prints out how many times each person has won
        System.out.println("Thanks For Playing!");
        System.out.println("---------------------------------------");
        System.out.println(name1 + " won: " + playerOneWins + " time(s)");
        System.out.println(name2 + " won: " + playerTwoWins + " time(s)");
        System.out.println("---------------------------------------");
    }

    // method for printing out the sticks in each pile
    public static void print(int a, int b, int c, int d) {
        System.out.println("----------------------");
        System.out.print("PILE 1  ");
        for (int i = 1; i <= a; i++) {
            System.out.print("| ");
        }

        System.out.println("   ");
        System.out.print("PILE 2  ");
        for (int i = 1; i <= b; i++) {
            System.out.print("| ");
        }

        System.out.println("   ");
        System.out.print("PILE 3  ");
        for (int i = 1; i <= c; i++) {
            System.out.print("| ");
        }
        System.out.println("   ");
        System.out.print("PILE 4  ");
        for (int i = 1; i <= d; i++) {
            System.out.print("| ");
        }
        System.out.println("");
        System.out.println("----------------------");
    }

}
