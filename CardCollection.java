import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

public class CardCollection {
    private Collection<Card> cards;

    public CardCollection() {
        cards = new ArrayList<>();
    }

    public void addCard(String symbol, String value) {
        cards.add(new Card(symbol, value));
    }

    public List<Card> findCardsBySymbol(String symbol) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                result.add(card);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CardCollection collection = new CardCollection();
        collection.addCard("Hearts", "Ace");
        collection.addCard("Spades", "King");
        collection.addCard("Hearts", "Queen");
        collection.addCard("Diamonds", "Jack");
        collection.addCard("Spades", "10");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the symbol to search for: ");
        String symbol = scanner.nextLine();
        
        List<Card> foundCards = collection.findCardsBySymbol(symbol);
        
        if (foundCards.isEmpty()) {
            System.out.println("No cards found for the given symbol.");
        } else {
            System.out.println("Cards found:");
            for (Card card : foundCards) {
                System.out.println(card);
            }
        }
        scanner.close();
    }
}


// output:
// Enter the symbol to search for: Hearts
// Cards found:
// Ace of Hearts
// Queen of Hearts
