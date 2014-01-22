import java.io.*;
import java.util.*;

public class Game {
	protected int[][] deck = new int[4][13];
	protected Player user, leftPlayer, rightPlayer, dealer;

    public static void main (String[] args) {
		BlackJackGui gui = new BlackJackGui(this);
    }

    /*
    gives out the cards AKA creates hands and distributes to the players
    calls on gui to add the cards to the gui
    inserts 1 to slots in the deck that have already been dealt
    */
    public void deal(){    	
    }

    /*
    checks if the card is in play
	true if you can use it, false if not
	((MIGHT BE PLACED IN PLAYER, CARD, OR HAND CLASS))
	*/
    public Boolean isNotDealt(int row, int col) {
    	return deck[row][col] == 0;
    }
}