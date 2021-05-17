package ProjectBatman;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Batman
{	
	private int x;
	private int y;
	private int verticalVelocity;
	private Rectangle box;
	private BatmanState state;
	private BufferedImage runningImageOne;
	private BufferedImage runningImageTwo;
	private BufferedImage jumpingImage;
	
	public Batman(int x, int y, BufferedImage runningImageOne,
			BufferedImage runningImageTwo, BufferedImage jumpingImage) {
		this.x = x;
		this.y = y;
		this.runningImageOne = runningImageOne;
		this.runningImageTwo = runningImageTwo;
		this.jumpingImage = jumpingImage;
		state = BatmanState.Falling;
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
		return getCurrentImageFrame().getWidth();
	}

	public int getHeight() {
		return getCurrentImageFrame().getHeight();
	}

	public int getVerticalVelocity() {
		return verticalVelocity;
	}

	public void setVerticalVelocity(int verticalVelocity) {
		this.verticalVelocity = verticalVelocity;
	}

	public Rectangle getBox() {
		return box;
	}
	
	public void updateHitBox() {
		box = new Rectangle(x, y, getWidth(), getHeight());
	}

	public BatmanState getState() {
		return state;
	}

	public void setState(BatmanState state) {
		this.state = state;
	}

	public BufferedImage getCurrentImageFrame() {
		switch (state) {
			case FirstRun:
			case Falling:
				return runningImageOne;
			case SecondRun:
				return runningImageTwo;
			case FirstJump:
			case SecondJump:
				return jumpingImage;
			default:
				return runningImageOne;
		}
	}
}
