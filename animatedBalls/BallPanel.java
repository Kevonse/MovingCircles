package animatedBalls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BallPanel extends JPanel implements ActionListener
{
	private Vector<Ball> balls;
	private BufferedImage canvas;
	private Graphics2D pen;
	
	public BallPanel()
	{
		balls = new Vector<Ball>();
		canvas = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
		pen = canvas.createGraphics();
		setPreferredSize(new Dimension(200, 200));
		Timer timer = new Timer(20, this);
		timer.start();
		balls.add(new Ball());
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				balls.add(new Ball());
			}
		});
	}
	//The bufferedImage "canvas" is first drawn black.
	//The balls are then draw onto the canvas/image.
	//The canvas/image is then drawn unto the panel.
	public void update(Graphics g)
	{
		//Panel is drawn completely black.
		pen.setPaint(Color.BLACK);
		pen.fillRect(0, 0, getSize().width, getSize().height);
		//the balls are then drawn onto the canvas again.
		for(Ball ball : balls)
		{
			ball.draw(g);
		}
		//The canvas is then laid onto the panel.
		paint(g);
	}
	//The position of the ball(s) is/are updated.
	public void updateBalls()
	{
		for(Ball b : balls)
		{
			b.updatePosition();
		}
	}
	//The timer in the constructor calls this method.
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		updateBalls();//Position of balls are updated.
		update(pen);//Canvas is painted and laid unto the panel.
		repaint();//Panel is repainted/refreshed.
	}
	//Draws the bufferedImage unto the panel.
	//the 0-values are x-y-coordinates of the topleft corner.
	public void paint(Graphics g)
	{
		g.drawImage(canvas, 0, 0, this);
	}
}
