import java.io.*;
import java.util.*;

public class Player {
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

	public void hit() {

	}

	public void stand(){
	}



}