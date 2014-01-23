import java.io.*;
import java.util.*;

public class NPC extends Player {

	public NPC(String n) {
		name = n;
		hand = new Hand();
		moneyTotal = 1000;
		currentBet = 0;
		bust = false;
	}
	public void play(Card[][] d, Game g) {
		System.out.println("HI");
		while (!bust) {
			if (decide()) {				
				g.gui.addCardTo(name, hit(d));
			}
		}
	}
	
	public Boolean decide() {
		int to21 = 21 - hand.ptTotal;
		Random r = new Random();
		if (to21 == 0) 
			return false;
		else if (to21 >= 10) 
			return true;
		return r.nextInt(9) + 1 <= to21;
	}

    public void pause() {
    	Random r = new Random();
    	int i = r.nextInt(3) + 2;
		try {
		    Thread.sleep(i * 1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}

    }
}
