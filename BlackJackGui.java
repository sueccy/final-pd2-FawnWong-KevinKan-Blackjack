import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;

public class BlackJackGui implements ActionListener{
	private JFrame frame;

	public BlackJackGui() {
		frame = new JFrame();
		Container c = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setBackground(new Color(52,99,13));
		c.setLayout(new FlowLayout());
		frame.setSize(1100, 800);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
    }
}