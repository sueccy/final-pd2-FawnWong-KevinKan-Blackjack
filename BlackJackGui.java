import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;

public class BlackJackGui extends JPanel implements ActionListener{
	protected JFrame frame = new JFrame();
	protected JPanel center = new JPanel();
	protected JPanel dealerCards = new JPanel(new GridBagLayout());
	protected JPanel deckPanel = new JPanel(new GridBagLayout());
	protected JPanel leftPlayerCards = new JPanel(new GridBagLayout());
	protected JPanel rightPlayerCards = new JPanel(new GridBagLayout());
	protected JPanel userCards = new JPanel(new GridBagLayout());
	protected JButton hitButton;
    protected JButton dealButton;
  	protected JButton stayButton;
  	protected BufferedImage deckSpriteSheet, cardBack;
  	protected BufferedImage[][] deck;


	public BlackJackGui() {
		loadImages();

		//builds screen
		Container cPane = frame.getContentPane();
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1; c.weighty = 1;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cPane.setBackground(new Color(52,99,13));
		cPane.setLayout(new GridBagLayout());
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setResizable(false);

		hitButton = new JButton("HIT");
		hitButton.addActionListener(this);
    	dealButton = new JButton("DEAL");
    	dealButton.addActionListener(this);
  		stayButton = new JButton("STAY");
  		stayButton.addActionListener(this);

		dealerCards.add(getRandomCard());
		deckPanel.add(new JLabel(new ImageIcon(cardBack)));
		leftPlayerCards.add(getRandomCard());
		rightPlayerCards.add(getRandomCard());
		userCards.add(getRandomCard());

		/*
		dealerCards.
		deckPanel.
		leftPlayerCards.
		rightPlayerCards.
		userCards.
		*/

		dealerCards.setOpaque(false);
		deckPanel.setOpaque(false);
		leftPlayerCards.setOpaque(false);
		rightPlayerCards.setOpaque(false);
		userCards.setOpaque(false);
		center.setOpaque(false);

        c.anchor = GridBagConstraints.LINE_END;
		c.weightx = 0;
		c.gridx = 1;
        frame.add(dealButton, c);
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.gridx = 2;
		frame.add(dealerCards, c);
        c.gridx = 3; c.gridwidth = 2;
        c.gridy = 0;
        frame.add(deckPanel, c);
        c.gridx = 0; c.gridwidth = 1;
        c.gridy = 1;
        frame.add(leftPlayerCards, c); 
        c.gridx = 1; c.gridwidth = 3;      
        frame.add(center, c);      
        c.gridx = 4; c.gridwidth = 1;
        frame.add(rightPlayerCards, c);
        c.anchor = GridBagConstraints.LINE_END;
		c.weightx = 0;
		c.gridx = 1;
        c.gridy = 2;
        frame.add(hitButton, c);
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.gridx = 2;
        frame.add(userCards, c);
        c.anchor = GridBagConstraints.LINE_START;
		c.weightx = 0;
		c.gridx = 3;
        frame.add(stayButton, c);


	}

	public JLabel getRandomCard() {
		Random r = new Random();
		int row = r.nextInt(4);
		int col = r.nextInt(13);
		return new JLabel(new ImageIcon(deck[row][col]));
	}

	public void loadImages() {
		try {
			deckSpriteSheet = ImageIO.read(new File("deck.png")); 
			cardBack = ImageIO.read(new File("back.png"));
			deck = new BufferedImage[4][13];
			for (int i = 0; i < 4; i++)  {  
	            for (int j = 0; j < 13; j++)  {  
	                deck[i][j] = deckSpriteSheet.getSubimage(j * 155, i * 225, 155, 225);  
	            }  
	        }  
	    }
	    catch (Exception e) {
	    }
	}
	public void actionPerformed(ActionEvent e){ 
	}
}