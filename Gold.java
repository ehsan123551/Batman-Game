package ProjectBatman;

import java.awt.image.BufferedImage;

public class Gold extends Coins 
{	
	public Gold(int x, int y, BufferedImage image) {
		super(x, y, image);
	}

	@Override
	public int coins() {
		return Constants.GOLD_POINTS;
	}
}
