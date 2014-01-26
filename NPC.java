import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

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
			if (decide()) {	
			    g.gui.addCardTo(name, hit(d));
			}
			else 
				stand();
		}
		stand();
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
	int i = r.nextInt(3) * 500;
	long ms = (long)i;
	long dieTime = System.currentTimeMillis() + ms;
	while (System.currentTimeMillis() < dieTime) {
	}
    }
}
