/*////////////////////
Kabilan Sriranjan
Ms. Strelkovska
ICS4U1
08/05/15
Snowflakes
////////////////////*/

import java.awt.*;
import javax.swing.*;

public class Tree{
	
	int x;
	int y;
	int startSize;
	float startStroke;
	int angle1 = -50;
	int angle2 = 30;
	
	public Tree(int x, int y, int startSize, float startStroke){
		this.x = x;
		this.y = y;
		this.startSize = startSize;
		this.startStroke = startStroke;
	}
	
	public void draw(Graphics2D g){
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(startStroke));
		g.drawLine(x, y, x, y-startSize);
		drawTree(x, y-startSize, startSize*2/3, (float)(startStroke*0.5), 90, g);
	}
	
	public void drawTree(int x, int y, int length, float stroke, int angle, Graphics2D g){
		if (length<=2){
			return;
		}
		
		g.setStroke(new BasicStroke(stroke));
		
		int endX1 = x+(int)(length*Math.cos(Math.toRadians(angle1)+Math.toRadians(angle)));
		int endY1 = y-(int)(length*Math.sin(Math.toRadians(angle1)+Math.toRadians(angle)));
		int newAngle1 = (int)Math.toDegrees(Math.atan2(y-endY1, endX1-x));
		g.drawLine(x, y, endX1, endY1);
		drawTree(endX1, endY1, length*3/5, (float)(stroke*0.5), newAngle1, g);
		
		g.setStroke(new BasicStroke(stroke));
		
		int endX2 = x+(int)(length*Math.cos(Math.toRadians(angle2)+Math.toRadians(angle)));
		int endY2 = y-(int)(length*Math.sin(Math.toRadians(angle2)+Math.toRadians(angle)));
		int newAngle2 = (int)Math.toDegrees(Math.atan2(y-endY2, endX2-x));
		g.drawLine(x, y, endX2, endY2);
		drawTree(endX2, endY2, length/2, (float)(stroke*0.5), newAngle2, g);
	}
	
}