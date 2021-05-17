package ProjectBatman;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class BatmanSetUp extends SetUp {
	
	private static Random random;
	private static BufferedImage batmanRunOneImage;
	private static BufferedImage batmanRunTwoImage;
	private static BufferedImage batmanJumpImage;
	private static BufferedImage smallBlockImage;
	private static BufferedImage mediumBlockImage;
	private static BufferedImage largeBlockImage;
	private static BufferedImage bronzeImage;
	private static BufferedImage silverImage;
	private static BufferedImage goldImage;
	private static BatmanSetUp instance;
	
	private BatmanSetUp() {
		random = new Random();
	}
	
	public static BatmanSetUp getInstance() {
		if (instance == null) {
			synchronized (BatmanSetUp.class) {
				if (instance == null) {
					instance = new BatmanSetUp();
				}			
			}
		}
		
		return instance;
	}
	
	@Override
	public Batman createBatman(int x, int y) {	
		try {
			if (batmanRunOneImage == null) {
				batmanRunOneImage = ImageIO.read(new File(Constants.BATMAN_RUN_ONE_IMAGE_URL));
			}		
			if (batmanRunTwoImage == null ) {
				batmanRunTwoImage = ImageIO.read(new File(Constants.BATMAN_RUN_TWO_IMAGE_URL));
			}
			if (batmanJumpImage == null) {
				batmanJumpImage = ImageIO.read(new File(Constants.BATMAN_JUMP_IMAGE_URL));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new Batman(x, y, batmanRunOneImage, batmanRunTwoImage, batmanJumpImage);	
	}
	
	@Override
	public BasicBlock createSmallBlock(int x, int y) {
		if (smallBlockImage == null) {
			try {
				smallBlockImage = ImageIO.read(new File(Constants.BLOCK_SMALL_IMAGE_URL));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return new BasicBlock(x, y, smallBlockImage);
	}
	
	@Override
	public BasicBlock createMediumBlock(int x, int y) {
		if (mediumBlockImage == null) {
			try {
				mediumBlockImage = ImageIO.read(new File(Constants.BLOCK_MEDIUM_IMAGE_URL));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return new BasicBlock(x, y, mediumBlockImage);
	}

	@Override
	public BasicBlock createLargeBlock(int x, int y) {
		if (largeBlockImage == null) {
			try {
				largeBlockImage = ImageIO.read(new File(Constants.BLOCK_LARGE_IMAGE_URL));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return new BasicBlock(x, y, largeBlockImage);
	}
	
	@Override
	public BasicBlock createRandomBlock(int x, int y) {
		return createRandomBlock(x, y, 1);
	}
	
	@Override
	public BasicBlock createRandomBlock(int x, int y, int horizontalRandom) {
		switch (random.nextInt(3))
		{
			case 0:
				return createSmallBlock(x + random.nextInt(horizontalRandom), y);
			case 1:
				return createMediumBlock(x + random.nextInt(horizontalRandom), y);
			case 2:
				return createLargeBlock(x + random.nextInt(horizontalRandom), y);
			default:
				return createMediumBlock(x + random.nextInt(horizontalRandom), y);
		}
	}
	
	@Override
	public Coins createBronze(int x, int y) {
		if (bronzeImage == null) {
			try {
				bronzeImage = ImageIO.read(new File(Constants.BRONZE_IMAGE_URL));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return new Bronze(x, y, bronzeImage);
	}
	
	@Override
	public Coins createSilver(int x, int y) {
		if (silverImage == null) {
			try {
				silverImage = ImageIO.read(new File(Constants.SILVER_IMAGE_URL));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return new Silver(x, y, silverImage);
	}
	
	@Override
	public Coins createGold(int x, int y) {
		if (goldImage == null) {
			try {
				goldImage = ImageIO.read(new File(Constants.GOLD_IMAGE_URL));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return new Gold(x, y, goldImage);
	}
	
	@Override
	public Coins createRandomCoin(int x, int y) {
		return createRandomCoin(x, y, 1);
	}
	
	@Override
	public Coins createRandomCoin(int x, int y, int horizontalRandom) {
		
		switch (random.nextInt(3))
		{
			case 0:
				return createBronze(x + random.nextInt(horizontalRandom), y);
			case 1:
				return createSilver(x + random.nextInt(horizontalRandom), y);
			case 2:
				return createGold(x + random.nextInt(horizontalRandom), y);
			default:
				return createBronze(x + random.nextInt(horizontalRandom), y);
		}
	}
}