public class Deck {
    public Card drawCard(){
        // rand1 is for card number rand2 is for the suit of the card.
        int rand1 = (int) (Math.random()*13) + 1;
        int rand2 = (int) (Math.random()*4) + 1;
        String suit = null;
        switch(rand2){
            case 1:
                suit = "Spades";
                break;
            case 2:
                suit = "Clubs";
                break;
            case 3:
                suit = "Hearts";
                break;
            case 4:
                suit = "Diamonds";
                break;
        }
        return new Card(rand1, suit);
    }
}
