import java.io.*;
import java.util.*;

public class Game {

	protected Card[][] deck = new Card[4][13];
	
	protected Player user = new Player(), leftPlayer = new Player(), rightPlayer = new Player(), dealer = new Player();
	protected BlackJackGui gui;

	public Game() {
		gui = new BlackJackGui(this);
		for (int i = 0; i < 4; i++) {			
			for (int j = 0; j < 13; j++) {
				deck[i][j] = new Card(i,j,false);
			}
		}
	}

    /*
    gives out the cards AKA creates hands and distributes to the players
    calls on gui to add the cards to the gui
    inserts 1 to slots in the deck that have already been dealt
    */
    public void deal(){    
    	Card r;

    	for (int i = 0; i < 2; i++) {
	    	r = getRandomCard();
	    	user.hand.cards.add(r);
	    }
	    gui.userCards.removeAll();
	    gui.addCardTo("user", user.hand.cards.get(0));
	    gui.addCardTo("user", user.hand.cards.get(1));

	    for (int i = 0; i < 2; i++) {
	    	r = getRandomCard();
	    	leftPlayer.hand.cards.add(r);
	    }
	    gui.leftPlayerCards.removeAll();
	    gui.leftPlayerCards.add(gui.backs[9]);
	    gui.addCardTo("left", leftPlayer.hand.cards.get(1));

	    for (int i = 0; i < 2; i++) {
	    	r = getRandomCard();
	    	rightPlayer.hand.cards.add(r);
	    }
	    gui.rightPlayerCards.removeAll();
	    gui.rightPlayerCards.add(gui.backs[8]);
	    gui.addCardTo("right", rightPlayer.hand.cards.get(1));

    	for (int i = 0; i < 2; i++) {
	    	r = getRandomCard();
	    	dealer.hand.cards.add(r);
	    }
	    gui.dealerCards.removeAll();
	    gui.dealerCards.add(gui.backs[7]);
	    gui.addCardTo("dealer", dealer.hand.cards.get(1));

    }

    public Card getRandomCard() {
	Random r = new Random();
	int[] retArr = new int[2];
    	int row, col;
    	row = r.nextInt(4);
    	col = r.nextInt(13);
    	while (deck[row][col].isDealt) {
    		row = r.nextInt(4);
    		col = r.nextInt(13);
    	}
    	retArr[0] = row;
    	retArr[1] = col;
    	deck[row][col].isDealt = true;
    	return deck[row][col];

    }

    public void userHit() {
	Card c = getRandomCard();
    	user.hit(c);
	gui.addCardTo("user", c);
	gui.cPane.validate();
	gui.cPane.repaint();
    }

}
