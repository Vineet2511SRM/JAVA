import java.util.Random;

public class CardDeck {
    
    // Method to initialize the deck of cards
    public static String[] initializeDeck() {
        // Suits and ranks of the cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        // Calculate number of cards in the deck
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        
        int index = 0;
        // Create the deck by combining ranks and suits
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }
        return deck;
    }

    // Method to shuffle the deck
    public static String[] shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            // Generate a random index to swap with
            int randomCardNumber = i + random.nextInt(deck.length - i);
            // Swap the current card with the random card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Method to distribute cards to players
    public static String[][] distributeCards(String[] deck, int numOfCards, int numOfPlayers) {
        if (numOfCards % numOfPlayers != 0) {
            System.out.println("The cards can't be distributed evenly.");
            return new String[0][0];
        }

        // Create a 2D array to store players and their cards
        String[][] players = new String[numOfPlayers][numOfCards / numOfPlayers];
        
        int cardIndex = 0;
        // Distribute cards to players
        for (int i = 0; i < numOfPlayers; i++) {
            for (int j = 0; j < numOfCards / numOfPlayers; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }
        return players;
    }

    // Method to print players and their cards
    public static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (String card : players[i]) {
                System.out.print(card + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Step 1: Initialize the deck
        String[] deck = initializeDeck();

        // Step 2: Shuffle the deck
        deck = shuffleDeck(deck);

        // Step 3: Define the number of cards and players
        int numOfCards = deck.length;
        int numOfPlayers = 4;  // Example: 4 players

        // Step 4: Distribute the cards to players
        String[][] playersCards = distributeCards(deck, numOfCards, numOfPlayers);

        // Step 5: Print the players and their cards
        printPlayersCards(playersCards);
    }
}
