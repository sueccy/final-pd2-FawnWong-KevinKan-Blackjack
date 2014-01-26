import java.io.*;
import java.util.*;
import javax.swing.*;

public class Game {
	protected Card[][] deck = new Card[4][13];
	
	protected Player user = new Player(), leftPlayer = new NPC("left"), rightPlayer = new NPC("right"), dealer = new NPC("dealer");
	protected BlackJackGui gui;

	public Game() {
		gui = new BlackJackGui(this);
		deck = newDeck();
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

    public int getBet(String prompt, int min, int max) {
        int result;
        do {
            String strVal = JOptionPane.showInputDialog(null, prompt, "Place your bet!", JOptionPane.PLAIN_MESSAGE);
            result = Integer.parseInt(strVal);
            if (result < min) {
                JOptionPane.showMessageDialog(null,
                 "Starting bet must be at least " + min, "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
            if (result > max) {
                JOptionPane.showMessageDialog(null,
                 "You don't have enough money!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        } while (result < min || result > max);
        
        return result;
    }

	public void startGame() {
    	removeListeners();
    	deal();
		gui.cPane.validate();
		gui.cPane.repaint();
		String s = "You have " + user.moneyTotal + " dollars\nEnter your bet: ";
		int bet = getBet(s, 50, user.moneyTotal);
		user.currentBet = bet;
		message("Left Player's turn!");	
		leftPlayer.play(deck, this);
		message("Your turn!");
		addListeners();
    }

    // gives out the cards AKA creates hands and distributes to the players
    // calls on gui to add the cards to the gui
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

    public void checkBust(){
		if (user.bust) {
			removeListeners();
			message("Right Player's turn!");
			rightPlayer.play(deck, this);
			message("Dealer's turn!");
			dealer.play(deck, this);
			flip();
			int playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?", null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (playAgain == 0) {
				newHandsAndDeck();
				startGame();
			}
			else 
				System.exit(0);
		}
	}

    public void userHit() {
    	Hand h = user.hand;
	    user.hit(deck);
		gui.addCardTo("user", h.cards.get(h.cards.size() - 1));
    }

    public void newHandsAndDeck() {
    	user.hand = new Hand();
		leftPlayer.hand = new Hand();
		rightPlayer.hand = new Hand();
		dealer.hand = new Hand();
		deck = newDeck();
    }

    public void addListeners() {
    	gui.hitButton.addActionListener(gui);
		gui.stayButton.addActionListener(gui);
    }

    public void removeListeners() {
    	gui.hitButton.removeActionListener(gui);
		gui.stayButton.removeActionListener(gui);
    }

    public void flip() {
    	gui.dealerCards.removeAll();
    	for (int i = 0; i < dealer.hand.cards.size(); i ++) {
    		gui.addCardTo("dealer", dealer.hand.cards.get(i));
    	}

    	gui.leftPlayerCards.removeAll();
    	for (int i = 0; i < leftPlayer.hand.cards.size(); i ++) {
    		gui.addCardTo("left", leftPlayer.hand.cards.get(i));
    	}

    	gui.rightPlayerCards.removeAll();
    	for (int i = 0; i < rightPlayer.hand.cards.size(); i ++) {
    		gui.addCardTo("right", rightPlayer.hand.cards.get(i));
    	}

    	Boolean userWin;
    	if (user.hand.ptTotal >= 21 && dealer.hand.ptTotal >= 21) 
    		userWin = false;
    	else 
    		userWin = user.hand.ptTotal <= 21 && dealer.hand.ptTotal < user.hand.ptTotal;

		if (userWin) {
			JOptionPane.showMessageDialog(null, "You win!", null, JOptionPane.PLAIN_MESSAGE);
			user.moneyTotal += user.currentBet;
		}
		else {
			JOptionPane.showMessageDialog(null, "You lose!", null, JOptionPane.PLAIN_MESSAGE);
			user.moneyTotal -= user.currentBet;
		}
    }

	public void message(String s) {
		JOptionPane.showMessageDialog(null, s, null, JOptionPane.PLAIN_MESSAGE);
	}

}
