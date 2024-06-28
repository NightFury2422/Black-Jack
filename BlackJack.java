import java.util.Scanner;
public class BlackJack {
    public static void main(String args[]) throws InterruptedException{
        Deck deck = new Deck();
        Scanner scnr = new Scanner(System.in);
        int playerWins = 0;
        int houseWins = 0;
        int ties = 0;
        int keepPlaying = 1;
        while(keepPlaying == 1){
        int houseTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);
        int playerTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);

        System.out.println("the house is showing: " + houseTotal);
        while (playerTotal <= 21){
            Thread.sleep(1000);
            System.out.println("the player is showing: " + playerTotal);
            Thread.sleep(1000);
            System.out.println("Would you like to hit or stand?\n\tEnter 1 for hit or 0 for stand:");
            Thread.sleep(1000);
            int choice = scnr.nextInt();

            if (choice == 0){
                break;
            }
            else if (choice == 1){
                Card nextCard = deck.drawCard();
                System.out.println("Player draws the " + nextCard.declareCard());
                playerTotal += nextCard.getValue(true);
            }
            else{
                System.out.println("invalid option, try again.");
            }
        }
        if (playerTotal > 21){
            System.out.println("The player is showing " + playerTotal);
            Thread.sleep(1000);
        }
        else{
            System.out.println("\nThe player stands with: " + playerTotal + " points.");
            Thread.sleep(1000);
            System.out.println("The House will play next.");
            Thread.sleep(1000);
            
            while(houseTotal <= 21){
                System.out.println("The House is showing: " + houseTotal);
                Thread.sleep(1000);

                if (houseTotal >= 17 && houseTotal <= 21){
                    System.out.println("The house stands with: " + houseTotal + " points.");
                    Thread.sleep(1000);
                    break;
                }
                else if (houseTotal < 17){
                    Card nextHouseCard = deck.drawCard();
                    System.out.println("House draws the " + nextHouseCard.declareCard());
                    Thread.sleep(1000);
                    houseTotal += nextHouseCard.getValue(true);
                }
            }
            if (houseTotal > 21){
                System.out.println("The house is showing " + houseTotal);
                Thread.sleep(1000);
            }
        }
        System.out.println("\nGAME RESULTS:");
        Thread.sleep(1000);
        if (houseTotal > 21){
            System.out.println("House busted, Player wins!");
            playerWins += 1;
            Thread.sleep(1000);
        }
        else if (playerTotal > 21){
            System.out.println("Player busted, House wins!");
            houseWins += 1;
            Thread.sleep(1000);
        }
        else if (houseTotal > playerTotal){
            System.out.println("House wins!");
            houseWins += 1;
            Thread.sleep(1000);
        }
        else if (houseTotal < playerTotal){
            System.out.println("Player wins!");
            playerWins += 1;
            Thread.sleep(1000);
        }
        else{
            System.out.println("Its a tie!");
            ties += 1;
            Thread.sleep(1000);
        }

        System.out.println("Number of player wins: " + playerWins);
        Thread.sleep(1000);
        System.out.println("Number of House wins: " + houseWins);
        Thread.sleep(1000);
        System.out.println("Number of ties: " + ties);
        Thread.sleep(1000);
        System.out.println("Would you like to play again? pres one for yes 0 for no.");
        keepPlaying = scnr.nextInt();
        }
    scnr.close();
    }
}