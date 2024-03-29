import java.io.*;
import java.util.*;
import java.awt.event.*;

public class NPC extends Player {

	public NPC(String n) {
		name = n;
		hand = new Hand();
		moneyTotal = 1000;
		currentBet = 0;
		bust = false;
	}
	public void play(Card[][] d, Game g) {
		while (!bust) {
			pause();
			if (decide()) {	
			    g.gui.addCardTo(name, hit(d));
			}
			else 
				stand();
		}
		stand();
	}
	
	public Boolean decide() {
		if (name == "dealer" && hand.ptTotal < 17) 
			return true;
		else if (hand.ptTotal >= 16) 
			return false;
		else if (hand.ptTotal <= 15) 
			return true;
		return true;
	}

    public void pause() {
		Random r = new Random();
		int i = r.nextInt(3) * 500;
		long ms = (long)i + 500;
		long dieTime = System.currentTimeMillis() + ms;
		while (System.currentTimeMillis() < dieTime) {
		}
    }

}
