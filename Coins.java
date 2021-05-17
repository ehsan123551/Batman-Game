package ProjectBatman;

import java.awt.*;
import java.awt.image.*;

public abstract class Coins 
{
	private int x;
	private int y;
	private Rectangle box;
	private BufferedImage image;
	
	public Coins(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.image = image;
		updateBox();
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public int getHeight() {
		return image.getHeight();
	}
	
	public Rectangle getBox() {
		return box;
	}
	
	public void updateBox() {
		box = new Rectangle(x, y, getWidth(), getHeight());
	}
		
	public BufferedImage getImage() {
		return image;
	}
	
	public abstract int coins();
}
