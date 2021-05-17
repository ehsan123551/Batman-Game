package ProjectBatman;

import java.awt.image.BufferedImage;

public class Silver extends Coins
{	
	public Silver(int x, int y, BufferedImage image) {
		super(x, y, image);
	}

	@Override
	public int coins() {
		return Constants.SILVER_POINTS;
	}
}