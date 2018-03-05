/*////////////////////
Kabilan Sriranjan
Ms. Strelkovska
ICS4U1
08/05/15
Snowflakes
////////////////////*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Snowflakes extends JPanel implements ActionListener{
	
	private JFrame frame;
	private Timer tm;
	private Tree tree;
	private Snowflake[] snowflakes;
	private double wind = 0;
	
	public static void main(String[] args){
		Snowflakes panel = new Snowflakes();
	}
	
	public Snowflakes(){
		super();
		frame = new JFrame("delicious");
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		Container c = frame.getContentPane();
		c.setBackground(Color.WHITE);
		setOpaque(false);
		tree = new Tree(320, 800, 350, 30);
		snowflakes = new Snowflake[20];
		for (int i=0; i<snowflakes.length; i++){
			snowflakes[i] = new Snowflake();
		}
		tm = new Timer(1, this);
		tm.start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		
		int width = getSize().width;
		int height = getSize().height;
		int min = Math.min(width, height);
		
		tree.draw(g2);
		for (int i=0; i<snowflakes.length; i++){
			snowflakes[i].draw(g2);
		}
	}
	
	public void actionPerformed(ActionEvent e){
		wind += ((int)(Math.random()*2)*2-1)/10.0;
		for (int i=0; i<snowflakes.length; i++){
			snowflakes[i].rotate();
			snowflakes[i].fall();
			snowflakes[i].slide((int)wind);
		}
		repaint();
	}
}