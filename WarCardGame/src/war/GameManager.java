package war;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Benson Li, Xavier Faria, Joshua Faria, John Paua
 */

/**
 * This class handles methods the various sections of play (such as battling and war) within the War Card along
 * with starting the game. This class models the Singleton pattern seeing as only one GameManager needs to be created
 * to run and handle the functions of the game.
 */

// Singleton Pattern - We've created a Singleton to allow for global access communication
// between classes. Lazy instantiation allows the class to be accessed directly.
// The game only needs one Manager to handle the gameplay so using the Single pattern
// provides the most benefits to our program.
public class GameManager {

    private static GameManager _instance = null;

    public static GameManager Instance() {
        if (_instance == null)
            _instance = new GameManager();

        return _instance;
    }


    /**
     * Initiate a battle between players where the value of two players' cards (player1's card vs player2's)then
     * returns whether the card compared was higher, even or lower in value than the card compared to.
     *
     * @param player1 - Player1 of the game.
     * @param player2 - Player2 of the game.
     * @return - Returns 1 if the player1's card value is higher, -1 if the card value is lower and 0 if even.
     */
    public int battle(Player player1, Player player2) {
        //Both players play a card from their respective play areas.
        Card p1Card = player1.playCard();
        Card p2Card = player2.playCard();

        //Returns false if a player's hand is empty(no cards to play).
        return p1Card.compareTo(p2Card);
    }

    /**
     * Compare the cards used in the War segment against one another.
     *
     * @param player1 - Player 1 of the game.
     * @param player2 - Player 2 of the game.
     * @return - Returns 1 if the player1's card value is higher, -1 if the card value is lower and 0 if even.
     */
    public int warCompare(Player player1, Player player2) {
        // Create an arrayList of WarCards from each player.
        ArrayList<Card> p1Cards = player1.playWarCards();
        ArrayList<Card> p2Cards = player2.playWarCards();

        // If player1 has no cards...
        if (p1Cards == null) {
            return -1; // player2 wins.
        } else if (p2Cards == null) { // If player2 has no cards...
            return 1; // player1 wins.
        } else
        {

            // Create a card object and assign it to the card selected by player1.
            Card selection = warSelect(p1Cards, player1);
            // Add the selected card to player1's playArea.
            player1.getPlayArea().getFlippedCards().add(selection);

            // Create a card object and assign it to the card selected by player2.
            Card selection2 = warSelect(p2Cards, player2);
            // Add the selected card to player2's playArea.
            player2.getPlayArea().getFlippedCards().add(selection2);

            return selection.compareTo(selection2);
        }
    }

    public void warRun(Player player1, Player player2)
    {
        System.out.println("\nCards are tied. War begins!");
        int warResult = warCompare(player1, player2);
        System.out.printf("%-20s %-20s%n", "War Played: ", "War Played: ");
        System.out.printf("%-20s %-20s%n", player1.getPlayArea(), player2.getPlayArea());
        //war will repeat until one side wins the war
        while (warResult == 0) {
            System.out.println("\nWar tied! Start another war!\n");
            warResult = warCompare(player1, player2);
            System.out.printf("%-20s %-20s%n", "War Played: ", "War Played: ");
            System.out.printf("%-20s %-20s%n", player1.getPlayArea(), player2.getPlayArea());
        }
        //determine who takes all the cards in the play areas, based on winner of the war
        if (warResult == 1) {
            player1.getHand().addCardsToBottom(player1.getPlayArea().removeCardsFromTop(player1.getPlayArea().size()));
            player1.getHand().addCardsToBottom(player2.getPlayArea().removeCardsFromTop(player2.getPlayArea().size()));
            System.out.println("\n" + player1.getName() + " wins the war! \n");
        } else {
            player2.getHand().addCardsToBottom(player1.getPlayArea().removeCardsFromTop(player1.getPlayArea().size()));
            player2.getHand().addCardsToBottom(player2.getPlayArea().removeCardsFromTop(player2.getPlayArea().size()));
            System.out.println("\n" + player2.getName() + " wins the war! \n");
        }
    }
     public Card warSelect(ArrayList<Card> pCards, Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease select a card to flip, " + player.getName() + ": ");
//            System.out.println("1." + p1Cards.get(0) + " 2." + p1Cards.get(1) + " 3." + p1Cards.get(2) + " 4." + p1Cards.get(3));
        System.out.println("1. XX" + " 2. XX" + " 3. XX" + " 4. XX");

        // Assign user selection to a variable.
        int pSelectCard = input.nextInt();
        // Create a card object.
        Card pFlippedCard;
        // Assign the card object to the card selected by the User.
        pFlippedCard = switch (pSelectCard) {
            case 1 -> pCards.get(0);
            case 2 -> pCards.get(1);
            case 3 -> pCards.get(2);
            default -> pCards.get(3);
        };
        // Return the card selected.
        return pFlippedCard;
    }

    public void roundStart(int roundNo,Player player1,Player player2)
    {
        System.out.println("Round " + roundNo + "\n");
        System.out.printf("%-20s %-20s%n", player1.getName(), player2.getName());
        System.out.printf("%-20s  %-20s%n", player1.getHand(), player2.getHand());
    }

    /**
     * Runs the game. Deals out a cards to both players and runs gameplay
     * until one player no longer has any cards to play.
     *
     * @param player1 - Player 1
     * @param player2 - Player 2
     * @param deck - The deck which the cards to the player are dealt from.
     * @param roundNo - The current round number. Incremented after every round.
     * @throws IOException - Throws an error if the user input is invalid.
     */
    public void runGame(Player player1, Player player2, Deck deck, int roundNo) throws IOException {
        //Deal cards from deck to both players
        deck.dealToPlayers(player1, player2);

        boolean continueGame = true;

        //Battle until one of the players runs out of cards
        while (continueGame) {
            //Round Start
            roundStart(roundNo,player1,player2);

            //Create an assign a variable to result of player1's card compared to player2's card.
            int battleResult = battle(player1, player2);

            // Display the cards played by both players.
            System.out.printf("%-20s %-20s%n", "Played: ", "Played: ");
            System.out.printf("%-20s %-20s%n", player1.getPlayArea(), player2.getPlayArea());

            // If player1 won the battle...
            if (battleResult == 1) {
                // Return the card played to the deck while also receiving the card played by player2.
                player1.getHand().addCardToBottom(player1.getPlayArea().removeCardFromTop());
                player1.getHand().addCardToBottom(player2.getPlayArea().removeCardFromTop());
                System.out.println(player1.getName() + " wins the battle! \n");
                System.out.println("Press Enter to Continue!");
                System.in.read();

                // If player2 won the battle...
            } else if (battleResult == -1) {
                // Return the card played to the deck while also receiving the card played by player1.
                player2.getHand().addCardToBottom(player2.getPlayArea().removeCardFromTop());
                player2.getHand().addCardToBottom(player1.getPlayArea().removeCardFromTop());
                System.out.println(player2.getName() + " wins the battle! \n");
                System.out.println("Press Enter to Continue!");
                System.in.read();

                // If both player's cards have equal value...
            } else {
                warRun(player1, player2);
                System.out.println("Press Enter to Continue!");
                System.in.read();
            }

            //play area needs to clear flipped cards, so that the next iteration doesn't display cards that shouldn't be flipped
            player1.getPlayArea().clearFlippedCards();
            player2.getPlayArea().clearFlippedCards();

            if (player1.getHand().size() == 0 || player2.getHand().size() == 0) {
                continueGame = false;
            }
            roundNo++;
        }

        endGame(player1, player2);

    }

    public void startPrompt(Player player1, Player player2) {
        Scanner input = new Scanner(System.in);
        System.out.println("=========== War Card Game v1.0 ===========");
        //TO DO: add error checking for name input
        System.out.print("Enter player 1 name: ");
        player1.setName(input.nextLine());
        System.out.print("Enter player 2 name: ");
        player2.setName(input.nextLine());
        System.out.println("\n Game Begins! \n");
    }

    public void endGame(Player player1, Player player2)
    {
        if (player1.getHand().size() > player2.getHand().size()) {
            System.out.println("\n" + player1.getName() + " wins the game!\n");
        } else if (player2.getHand().size() > player1.getHand().size()) {
            System.out.println("\n" + player2.getName() + " wins the game!\n");
        } else {
            System.out.println("\nNo winner, game is tied!\n");
        }

    }
}
