import java.io.*;
import java.util.*;

public class Player {
	protected String name;
	protected Hand hand;	
	protected int moneyTotal;
	protected int currentBet;
	protected Boolean bust;

	public Player() {
		hand = new Hand();
		moneyTotal = 1000;
		currentBet = 0;
		bust = false;
	}

	public Card hit(Card[][] d) {
		Card c = getRandomCard(d);
		if (hand.cards.size() < 5) {
			c.isDealt = true;
  	//System.out.println("HI PLEASE WORK");
			hand.cards.add(c);
			hand.updatePtTotal();
		}
		else {
			stand();
		}
		if (!(hand.underOrEqual21())){
			stand();
		}
		return c;
	}

	public void play(Card[][] d, Game g) {
	}

	public void stand(){
		bust = true;
	}

    public Card getRandomCard(Card[][] d) {
	Random r = new Random();
	int[] retArr = new int[2];
    	int row, col;
    	row = r.nextInt(4);
    	col = r.nextInt(13);
    	while (d[row][col].isDealt) {
    		row = r.nextInt(4);
    		col = r.nextInt(13);
    	}
    	retArr[0] = row;
    	retArr[1] = col;
    	d[row][col].isDealt = true;
    	return d[row][col];
    }

}
