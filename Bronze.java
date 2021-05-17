package ProjectBatman;

import java.awt.image.BufferedImage;

public class Bronze extends Coins 
{	
	public Bronze(int x, int y, BufferedImage image) {
		super(x, y, image);
	}

	@Override
	public int coins() {
		return Constants.BRONZE_POINTS;
	}
}