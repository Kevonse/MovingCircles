package animatedBalls;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Ball
{
	private Point position;
	private int dx, dy;
	Random rand;
	
	public Ball()
	{
		rand = new Random();
		position = new Point(rand.nextInt(195)+1, rand.nextInt(195)+1);
		dx = rand.nextInt(5)+1;
		dy = rand.nextInt(5)+1;
	}
	
	public void updatePosition()
	{
		position.x += dx;
		position.y += dy;
		if(position.x < 0 || position.x > 195)
		{
			dx = -dx;
		}
		if(position.y < 0 || position.y > 195)
		{
			dy = -dy;
		}
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillOval(position.x, position.y, 10, 10);
		g.drawOval(position.x, position.y, 10, 10);
	}
	
	public Point getPosition()
	{
		return position;
	}
}
