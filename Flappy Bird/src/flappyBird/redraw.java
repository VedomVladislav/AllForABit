package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class redraw extends Thread 
{
	public static void run1(Graphics g)
	{
		g.setColor(Color.cyan);
		g.fillRect(0, 0, FlappyBird.flappyBird.WIDTH, FlappyBird.flappyBird.HEIGHT);
		
		g.setColor(Color.orange);
		g.fillRect(0, FlappyBird.flappyBird.HEIGHT - 120, FlappyBird.flappyBird.WIDTH, 120);
		
		g.setColor(Color.green);
		g.fillRect(0, FlappyBird.flappyBird.HEIGHT - 120, FlappyBird.flappyBird.WIDTH, 20);
		
		g.setColor(Color.red);
		g.fillRect(FlappyBird.flappyBird.bird.x, FlappyBird.flappyBird.bird.y, FlappyBird.flappyBird.bird.width, FlappyBird.flappyBird.bird.height);
		
		for(Rectangle column : FlappyBird.flappyBird.columns)
		{
			paintColumn(g, column);	
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));;
		
		if(!FlappyBird.flappyBird.started)
		{
			g.drawString("Click to start!", 75, FlappyBird.flappyBird.HEIGHT / 2 - 50);
		}
		
		if(FlappyBird.flappyBird.gameOver)
		{
			g.drawString("Game Over", 100, FlappyBird.flappyBird.HEIGHT / 2 - 50);
		}
		
		if(!FlappyBird.flappyBird.gameOver && FlappyBird.flappyBird.started)
		{
			g.drawString(String.valueOf(FlappyBird.flappyBird.score), FlappyBird.flappyBird.WIDTH / 2 - 25, 100);
		}
	}
	public static void paintColumn(Graphics g, Rectangle column)
	{
		g.setColor(Color.green.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}
	
}
