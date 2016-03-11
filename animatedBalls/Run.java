package animatedBalls;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Run extends JFrame
{
	BallPanel bp = new BallPanel();
	
	public static void main(String[] args)
	{
		new Run();
	}
	
	public Run()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 200);
		setBackground(Color.WHITE);
		add(bp);
		pack();
		setVisible(true);
	}
}
