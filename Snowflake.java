/*////////////////////
Kabilan Sriranjan
Ms. Strelkovska
ICS4U1
08/05/15
Snowflakes
////////////////////*/

import java.awt.*;
import javax.swing.*;

public class Snowflake{
	
	private int x, y;
	private int startSize;
	private int angle;
	private int numBranches;
	private int divider;
	private Color color;
	
	public Snowflake(int x, int y, int startSize, int numBranches, int divider, Color color){
		this.x = x;
		this.y = y;
		this.startSize = startSize;
		this.numBranches = numBranches;
		this.divider = divider;
		this.color = color;
		angle = 0;
	}
	
	public Snowflake(){
		this.x = (int)(Math.random()*1000)-100;
		this.y = (int)(Math.random()*1000)-1000;
		this.startSize = (int)(Math.random()*30)+50;
		this.numBranches = (int)(Math.random()*5)+4;
		this.divider = (int)(Math.random()*3)+3;
		this.color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
	}
	
	public void rotate(){
		angle+=2;
	}
	
	public void fall(){
		if (y>=800+(int)(1.3*startSize/divider)){
			y=(int)(-1.3*(startSize/divider)-80);
			x=(int)(Math.random()*1000)-100;
		}
		y+=3;
	}
	
	public void slide(int wind){
		x+=wind;
		if (x<-200){
			x = 900;
		} else if (x>1000){
			x=-100;
		}
	}
	
	private void drawStar(int x, int y, int size, Graphics2D g){
			
		if (size<divider){
			return;
		}
		for (int i=0; i<numBranches; i++){
			int endX = x+(int)(size*Math.cos(Math.toRadians((i*360/numBranches)+angle)));
			int endY = y-(int)(size*Math.sin(Math.toRadians((i*360/numBranches)+angle)));
			g.drawLine(x, y, endX, endY);
			drawStar(endX, endY, size/divider, g);
		}
	}
	
	public void draw(Graphics2D g){
		g.setColor(color);
		g.setStroke(new BasicStroke(1));
		drawStar(x, y, startSize, g);
	}
}