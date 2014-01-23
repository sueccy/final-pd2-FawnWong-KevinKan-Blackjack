import java.io.*;
import java.util.*;

public class Game {
	protected Card[][] deck = new Card[4][13];
	
	protected Player user = new Player(), leftPlayer = new NPC("left"), rightPlayer = new NPC("right"), dealer = new NPC("dealer");
	protected BlackJackGui gui;

	public Game() {
		gui = new BlackJackGui(this);
		deck = newDeck();
	}

    /*
    gives out the cards AKA creates hands and distributes to the players
    calls on gui to add the cards to the gui
    inserts 1 to slots in the deck that have already been dealt
    */
    public void deal(){    
    	Card r;

    	for (int i = 0; i < 2; i++) {
	    	user.hit(deck);

	    }
	    gui.userCards.removeAll();
	    gui.addCardTo("user", user.hand.cards.get(0));
	    gui.addCardTo("user", user.hand.cards.get(1));

	    for (int i = 0; i < 2; i++) {
	    	leftPlayer.hit(deck);

	    }
	    gui.leftPlayerCards.removeAll();
	    gui.leftPlayerCards.add(gui.backs[9]);
	    gui.addCardTo("left", leftPlayer.hand.cards.get(1));

	    for (int i = 0; i < 2; i++) {
	    	rightPlayer.hit(deck);

	    }
	    gui.rightPlayerCards.removeAll();
	    gui.rightPlayerCards.add(gui.backs[8]);
	    gui.addCardTo("right", rightPlayer.hand.cards.get(1));

    	for (int i = 0; i < 2; i++) {
	    	dealer.hit(deck);
	    }
	    gui.dealerCards.removeAll();
	    gui.dealerCards.add(gui.backs[7]);
	    gui.addCardTo("dealer", dealer.hand.cards.get(1));

    }

    public void userHit() {
    	Hand h = user.hand;
	    user.hit(deck);
		gui.addCardTo("user", h.cards.get(h.cards.size() - 1));
		gui.cPane.validate();
		gui.cPane.repaint();
    }

    public void addListeners() {
    	gui.hitButton.addActionListener(gui);
		gui.stayButton.addActionListener(gui);
    }

    public void removeListeners() {
    	gui.hitButton.removeActionListener(gui);
		gui.stayButton.removeActionListener(gui);
    }

    public Card[][] newDeck() {
 		Card[][] deck = new Card[4][13];
    	for (int i = 0; i < 4; i++) {			
			for (int j = 0; j < 13; j++) {
				deck[i][j] = new Card(i,j,false);
			}
		}
		return deck;
    }
}
